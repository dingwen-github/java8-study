package demo;

import com.google.common.collect.Lists;
import com.sun.deploy.util.StringUtils;
import entity.Student;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @program:
 * @description: Demo
 * @author: dingwen
 * @create: 2020/12/18 17:44
 **/
public class LambdaDemo {
    public static void main(String[] args) {
        List<Student> students = Lists.newArrayList(
                new Student("dingwen", "男", "1605410122"),
                new Student("maorui", "女", "1605410120"),
                new Student("张三", "男", "1616144"),
                new Student("李四", "女", "2641654"),
                new Student("李四", null, "2641654"),
                new Student("王五", "男", "6946644")
        );
        List<Integer> numbers = Lists.newArrayList(1, 3, 4, 5, 5, null, 96, 200, null);
        LambdaDemo lambdaDemo = new LambdaDemo();
        //计算一个List中值为null的个数并且返回
//        System.out.println(demo.getListNullCount(numbers));

        //获取一个无限长度的正整数集合的Stream，然后取出前面10个打印
//        demo.getPositiveNumberPreviousTen();

//        demo.commonCollection(numbers);

//        System.out.println(demo.numbersNotNull(numbers));


//        System.out.println(lambdaDemo.getTenCumulative());


//        lambdaDemo.getListAttribute(students);

//        lambdaDemo.groupByGender(students);

//        lambdaDemo.singleDistinct();

//        lambdaDemo.lambdaDistinct();
//        System.out.println(lambdaDemo.sort(null));
        lambdaDemo.sort(null);
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
     * 再每个元素乘以2，再每个元素被消费的时候打印自身，再跳过前两个元素
     * ，最后去前四个元素进行加和运算
     */

    public void commonCollection(List<Integer> numbers) {
        System.out.println(numbers.stream().filter(num -> num != null).distinct().mapToInt(num -> num * 2).peek(System.out::println).skip(2).limit(4).sum());
    }

    /*
     *Number数组去空返回Number数组
     * @param []
     * @return java.util.List<java.lang.Number>
     */
    public List<Integer> numbersNotNull(List<Integer> numbers) {
//       return  numbers.stream().filter(num -> num != null).collect(
//                () -> new ArrayList<Integer>(),
//                (list,item) -> list.add(item),
//                (list1,list2) -> list1.addAll(list2)
//        );
        return numbers.stream().filter(num -> num != null).collect(Collectors.toList());
    }

    /*
     *计算1-10的累加并且返回
     * @param []
     * @return java.lang.Integer
     */
    public Integer getTenCumulative() {
        List<Integer> numbers = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        return numbers.stream().reduce((sum, item) -> sum + item).orElseGet(() -> 0);
//        return  numbers.stream().reduce(0, (sum, num) -> sum + num);
    }

    /*
     *获取List中所有对象的某一个属性
     * @param []
     * @return void
     */
    public void getListAttribute(List<Student> students) {
        List<String> ids = students.stream().map(Student::getId).collect(Collectors.toList());
        System.out.println(ids);
    }

    /*
     *根据对象的某一个属性进行分组
     * @param [students]
     * @return void
     */
    public void groupByGender(List<Student> students) {
        //key 为分组属性的值
        Map<String, List<Student>> studentMap = students.stream().filter(student -> student.getGender() != null).collect(Collectors.groupingBy(Student::getGender));
        System.out.println(studentMap);
    }

    /*
     *简单去重
     * @param []
     * @return void
     */
    public void singleDistinct() {
        List<String> numbers = Arrays.asList("1", "2", "2", "3", "3", "4", "4", "5", "6", "7", "8");
        System.out.println(numbers.stream().distinct().collect(Collectors.toList()));
    }

    /*
     *去除重复的元素
     * @param []
     * @return void
     */
    public void lambdaDistinct() {
        List<String> numbers = Arrays.asList("1", "2", "2", "3", "3", "4", "4", "5", "6", "7", "8");
        Map<String, Long> map = numbers.stream().collect(Collectors.groupingBy(num -> num, Collectors.counting()));
        List result = map.entrySet().stream()
                .filter(entry -> entry.getValue() == 1)//过滤出出现次数等于1的entry
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());
        System.out.println(result);
    }

    /*
     *查找重复或者不重复的集合返回
     * @param [list]
     * @return java.util.List<T>
     */
    public <T> List<T> getElements(List<T> list) {
        return list.stream().collect(Collectors.collectingAndThen(Collectors.groupingBy(item -> item, Collectors.counting()), map -> {
            map.values().removeIf(size -> size == 1);//出现次数
            List<T> tempList = new ArrayList<>(map.keySet());// 获得 entry 的键（重复元素/不重复）对应的 Stream
            return tempList;
        }));
    }

    public void ObjectDistinctHandle() {
//        approvalStageList.stream()
//                .filter(ele -> ele.getBusinessKey() != null)
//                .collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(ApprovalStage::getBusinessKey))), ArrayList::new));
    }

    /*
     *对象集合操作
     * @param [list]
     * @return java.util.List<T>
     */
    public List<List<Student>> getElementByObject(List<Student> students) {
        //entrySet()： map 中的每一个键值对表示
//        students.stream().map(Student::getId).distinct().collect(Collectors.toList())  //String
        return students.stream().collect(Collectors.groupingBy(Student::getId)).entrySet().stream()
                .filter(entry -> entry.getValue().size() > 1) // >1 查找重复的集合  ==1 查找不重复的集合
                .map(entry -> entry.getValue())
                .collect(Collectors.toList());
    }


    /*
     *List 排序正序
     * @param [list]
     * @return java.util.List<T>
     */
    public <T> List<T> sort(List<T> list) {
        return list.stream().sorted().collect(Collectors.toList());
    }

    /*
     *List 倒序
     * @param [list]
     * @return java.util.List<java.lang.String>
     */
    public List<String> reversed(List<String> list) {
        return list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    /*
     *根据对象属性，正序
     * @param [students]
     * @return java.util.List<entity.Student>
     */
    public List<Student> sortByAttribute(List<Student> students) {
        return students.stream().sorted(Comparator.comparing(Student::getId)).collect(Collectors.toList());
    }

    /*
     *根据对象属性，倒序
     * @param [students]
     * @return java.util.List<entity.Student>
     */
    public List<Student> reversedByAttribute(List<Student> students) {
        return students.stream()
                .sorted(Comparator.comparing(Student::getId)
                        .reversed())
                .collect(Collectors.toList());
    }

    /*
     *多个属性排序
     * @param [students]
     * @return java.util.List<entity.Student>
     */
    public List<Student> doubleSort(List<Student> students) {
        return students.stream()
                .sorted(Comparator.comparing(Student::getGender).thenComparing(Student::getId)).collect(Collectors.toList());
    }
}



