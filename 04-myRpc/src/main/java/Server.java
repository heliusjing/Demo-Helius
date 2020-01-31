import java.io.IOException;

/**
 * 服务中心：服务端用来暴露服务，有启动、停止、注册服务
 * 面向接口编程
 * @Author jcf
 * @Create 2020-01-03-22:18
 */
public interface Server {
     //停止服务中心
     void stop();
     // 启动
     void start() throws IOException;
     // 注册服务
     void register(Class serviceInterface,Class impl);
     //是否运行中
     boolean isRunning();
     //端口
     int getPort();
}
