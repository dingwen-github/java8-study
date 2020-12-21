package sam;

/**
 *jdk8函数式接口，SAM类型的接口（Single Abstract Method）
 *  作用：使得以其为参数的方法，可以在调用时，使用一个lambda表达式作为参数
 *  理解：函数作为变量
 * @param
 * @return
 */
@FunctionalInterface
public interface AInterface {
    String getName(String name);
}
