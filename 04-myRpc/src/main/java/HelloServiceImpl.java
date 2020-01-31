/**
 *
 * 被调用接口的实现类，
 * 服务端接口实现,即真正的提供者
 * @Author jcf
 * @Create 2020-01-03-22:17
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHi(String name) {
        return "Hi "+name;
    }
}
