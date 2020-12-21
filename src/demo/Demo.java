package demo;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @program:
 * @description: Demo
 * @author: dingwen
 * @create: 2020/12/18 17:44
 **/
public class Demo {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(null);
        numbers.add(null);
        numbers.add(null);
        numbers.add(null);
        numbers.add(13334);
        numbers.add(null);
        numbers.add(100);
        numbers.add(44);
        numbers.add(99);
        numbers.add(null);
        numbers.add(66);
        numbers.add(42345);
        numbers.add(55);
        numbers.add(99);
        Demo demo = new Demo();
        //计算一个List中值为null的个数并且返回
        System.out.println(demo.getListNullCount(numbers));

        //获取一个无限长度的正整数集合的Stream，然后取出前面10个打印
        demo.getPositiveNumberPreviousTen();

        demo.commonCollection();
    }

    /*
     *计算一个List中值为null的个数并且返回
     * @param [numberList]
     * @return int
     */
    public Long getListNullCount(List<Integer> numberList) {
        return (numberList != null && numberList.size() > 0) ? numberList.stream().filter(num -> num != null).count() : 0L;
    }

    /*
     * 获取一个无限长度的正整数集合的Stream，然后取出前面10个打印
     *
     */
    public void getPositiveNumberPreviousTen() {
        Stream.iterate(1, item -> item + 1).limit(10).forEach(System.out::println);
    }

    /*
     *给定一个Integer类型的List，获取其对应的Stream对象，然后进行过滤掉null，再去重，
     * 再每个元素乘以2，再每个元素被消费的时候打印自身，在跳过前两个元素
     * ，最后去前四个元素进行加和运算
     */

    public void commonCollection() {
        List<Integer> numbers = Lists.newArrayList(1, 3, 4, 5, 5, null, 96, 200, null);
        System.out.println(numbers.stream().filter(num -> num != null).distinct().mapToInt(num -> num * 2).peek(System.out::println).skip(2).limit(4).sum());
    }
}

