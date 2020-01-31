/**
 * 面向接口编程
 * 客户端、服务端都有对接口的引用，应作为jar包共享
 * @Author jcf
 * @Create 2020-01-03-22:16
 */
public interface HelloService {
    String sayHi(String name);
}
