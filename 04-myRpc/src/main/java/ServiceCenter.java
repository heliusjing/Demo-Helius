import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 服务中心的实现类
 * @Author jcf
 * @Create 2020-01-03-22:20
 */
public class ServiceCenter implements Server {
    private static int port;
    private static boolean isRunning = false;
    //这里是简化版，将服务注册进Map中
    private static final HashMap<String, Class> serviceRegistry = new HashMap<>();
    //将服务注册交给线程池去处理
    //线程池的大小设置为处理器的核心数Runtime.getRuntime().availableProcessors()
    private static ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    //构造方法
    public ServiceCenter(int port) {
        ServiceCenter.port = port;
    }

    @Override
    public void stop() {
        isRunning = false;
        executor.shutdown();
    }

    //启动服务器
    @Override
    public void start() throws IOException {
        //1.创建ServerSocket对象
        ServerSocket serverSocket = new ServerSocket();
        //2.绑定本机ip地址+port
        serverSocket.bind(new InetSocketAddress(port));
        System.out.println("start server");
        try {
            while (true) {
                // 3.监听客户端的TCP连接，接到TCP连接后将其封装成task，由线程池执行
                executor.execute(new ServiceTask(serverSocket.accept()));
            }
        } finally {
            serverSocket.close();
        }
    }

    /**
     * 注册服务：放进hashmap中
     *
     * @param serviceInterface
     * @param impl
     */
    @Override
    public void register(Class serviceInterface, Class impl) {
        serviceRegistry.put(serviceInterface.getName(), impl);
    }

    @Override
    public boolean isRunning() {
        return isRunning;
    }

    @Override
    public int getPort() {
        return port;
    }

    //静态内部类
    private static class ServiceTask implements Runnable {
        Socket client = null;
        //传入一个socket连接，构造ServiceTask
        public ServiceTask(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            // 将客户端发送的码流反序列化成对象，反射调用服务实现者，获取执行结果
            try (
                    ObjectInputStream input = new ObjectInputStream(client.getInputStream());
                    ObjectOutputStream output = new ObjectOutputStream(client.getOutputStream())
            ) {
                //调用服务端的实现类：需要客户端传进来：类名+方法名+方法参数+方法参数类型
                //对象流按顺序写入，按顺序写出
                String serviceName = input.readUTF();
                String methodName = input.readUTF();
                Class<?>[] paramterTypes = (Class<?>[]) input.readObject();
                Object[] arguments = (Object[]) input.readObject();
                Class serviceClass = serviceRegistry.get(serviceName);
                if (serviceClass == null) {
                    throw new ClassNotFoundException(serviceName + " not found");
                }
                //反射调用实现类方法
                Method method = serviceClass.getMethod(methodName, paramterTypes);
                Object result = method.invoke(serviceClass.newInstance(), arguments);
                // 将执行结果反序列化,通过socket发送给客户端
                output.writeObject(result);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (client != null) {
                    try {
                        client.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
