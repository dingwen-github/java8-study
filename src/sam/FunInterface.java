package sam;

/**
 * @program:
 * @description: 从SAM原则上讲，在这个接口中只能有一个函数需要被实现，以下例外：
 * 1.默认方法和静态方法不影响函数式接口的契约，可以任意使用，函数式接口中可以有静态方法
 * 一个或者多个静态方法不会影响SAM接口成为函数式接口，并且静态方法可以提供方法实现可
 * 以由 default 修饰的默认方法方法，这个关键字是Java8中新增的，为的目的就是使得某
 * 一些接口，原则上只有一个方法被实现，但是由于历史原因得不加入一些方法来兼容整个
 * JDK中的API，所以就需要使用default关键字来定义这样的方法
 * 2.可以有 Object 中覆盖的方法，也就是 equals，toString，hashcode等方法
 * @author: dingwen
 * @create: 2020/12/18 16:49
 **/
public class FunInterface {

    public static void testFun(AInterface aInterface) {
        System.out.println(aInterface.getName("AAA"));
    }

    public static void main(String[] args) {
        //新方法
        AInterface aInterface1 = (name) -> "hello" + name;
        System.out.println("a" + aInterface1.getName("world"));

        //老方法
        AInterface aInterface2 = new AInterface() {
            @Override
            public String getName(String name) {
                return "hello" + name;
            }
        };
        System.out.println("b" + aInterface2.getName("world"));

        testFun(val -> "hello=" + val);
    }
}
