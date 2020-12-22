package demo;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * @program:
 * @description: ForEach Demo
 * @author: dingwen
 * @create: 2020/12/22 11:03
 **/
public class ForEachDemo {
    public static void main(String[] args) {
//        List<String> names = Arrays.asList("james", "reflect", "Alex");
//        Consumer<String> toUppercase = (name) -> {
//            System.out.println(name.toUpperCase());
//        };
//        names.forEach(toUppercase);

        Map<String,String> namesMap = new HashMap<>();
        namesMap.put("j","james");
        namesMap.put("r","reflect");
        namesMap.put("a","Alex");


//        BiConsumer<String,String> action = (k,v) -> System.out.println(k +" "+ v);
//        namesMap.forEach(action);

        Consumer<Map.Entry<String,String>> action =  System.out::println;
        namesMap.entrySet().forEach(action);

        Consumer<String> actionKeys = System.out::println;
        namesMap.keySet().forEach(actionKeys);

        Consumer<String> actionValues = System.out::println;
        namesMap.values().forEach(actionValues);
    }
}
