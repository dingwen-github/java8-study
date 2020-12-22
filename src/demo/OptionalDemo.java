package demo;

import com.google.common.collect.Lists;
import entity.Student;

import java.util.List;
import java.util.Optional;

/**
 * @program:
 * @description: Option demo
 * @author: dingwen
 * @create: 2020/12/21 13:56
 **/
public class OptionalDemo {
    public static void main(String[] args) {
        OptionalDemo optionalDemo = new OptionalDemo();
        List<Student> students = Lists.newArrayList();
//        Student student = new Student("dingwen","男","1605410122");
        Student student = new Student(null,"男","1605410122");
//        Student student = new Student();
//        Student student = null;
//        optionalDemo.printStudentName(student);

//        optionalDemo.filterGender(student);

        optionalDemo.mapAndOrElse(student);
    }


    public void printStudentName(Student student) {
//        System.out.println(student.getName());

        //如果学生对象为null，则什么也不做
        Optional.ofNullable(student).ifPresent(stu -> System.out.println(stu.getName()));
    }

    public void filterGender(Student student){
        Optional.ofNullable(student).filter(stu -> stu.getGender().equals("男")).ifPresent( stu -> System.out.println(stu.getName()));
    }

    public void mapAndOrElse(Student student){
        System.out.println(Optional.ofNullable(student).map(stu -> stu.getName()).orElse("dingwen"));
//        Optional.ofNullable(student).flatMap(u -> Optional.ofNullable(u.getName()));
    }

}
