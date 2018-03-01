package com.example.java8;


import org.junit.Test;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <p>
 * stream学习
 * </p>
 *
 * @author wangdejian
 * @since 2018/2/26
 */
public class StreamTest {
    // stream对集合和数组做一系列流水线的操作。步骤为：1.首先得到一个stream流；2.对流进行一系列操作；3.终止操作，得到最终结果

    /**
     * 第一步：获得stream流的几种方式.
     *
     */
    @Test
    public void getStreamObj() {
        // 要想使用stream必须先得到stream对象,获取stream对象的方法如下
        List<String> list = new ArrayList<>();
        // 1.通过集合提供的stream()方法可以得到一个stream对象
        Stream<String> stream1 = list.stream();
        // 2.通过Stream的静态方法:例如of()，iterate()
        Stream<List<String>> stream2 = Stream.of(list);
        Stream<Integer> stream3 = Stream.iterate(0, (x) -> x + 2);

        Stream<Integer> stream4 = Stream.generate(() -> (int) Math.random());
        //接上面代码对比下java8和之前写法对比。1.普通表现形式
        Stream.generate(new Supplier<Double>() {
            @Override
            public Double get() {
                return Math.random();
            }
        });
        //2.lambda表达式的表现形式
        Stream.generate(() -> Math.random());
        //3.方法引用的表现形式
        Stream.generate(Math::random);

        // 3. 数组转为stream
        String[] str = new String[]{"a", "b", "c"};
        Stream<String> stream5 = Arrays.stream(str);
    }

    /**
     * 上面介绍过初始化流的几种方式，这里进行第二步对流的操作.
     * 筛选与切片filter:接收lambda，从流中筛选出符合条件的信息
     */
    List<Student> studentList = this.getStudentList();
    @Test
    public void optionStreamFilter() {
        /**
         * stream的操作就像一个产品在流水线一样，流水线上可以有多个工人操作，产品最终从流水线上取下来才可用。
         * stream无论做多少中间操作，只要不触发终止操作(产品没有从流水线上取下来)，都不会执行任何处理！
         * 一旦触发了终止操作，会一次性执行完毕所有中间操作。
         */

        Stream<Student> stream = studentList.stream()
                .filter((student) -> student.getAge() > 15);
        //stream.forEach((student) -> System.out.println(student.toString()));
        // 或者使用方法引用
        stream.forEach(System.out::println);
    }

    /**
     *limit:截取stream流
     *
     */
    @Test
    public void optionStreamLimit() {
        studentList.stream().filter((student -> student.getAge() > 15))
                .limit(3).forEach(System.out::println);
    }

    /**
     * skip（n）:跳过n个元素，若流中的元素不足n个,则返回一个空流.
     *
     */
    @Test
    public void optionStreamSkip() {
        studentList.stream().filter((student -> student.getAge() > 15))
                .skip(2)
                .limit(3)
                .forEach(System.out::println);
    }

    /**
     *
     * distinct:去除掉原Stream中重复的元素，生成的新Stream中没有没有重复的元素.通过流生成元素的hashCode()和equals()方法才能达到去重元素.
     */
    @Test
    public void optionStreamDistinct() {
        // 重写Student的equals和hashCode方法才能达到去重目的
        studentList.stream().filter(student -> student.getName().equals("ten"))
                .skip(0)
                .limit(3)
                .distinct()
                .forEach(System.out::println);
        //输出结果:
        //Student{name='ten', age=99, stuNum='00018', address='朝阳'}
        //Student{name='ten', age=9, stuNum='00018', address='朝阳'}
    }

    /**
     *
     * 映射：map和flatMap
     *
     * map() --> 通过Function对元素执行一对一的转换。
     * map是对流对象中间的操作，通过给定的方法，将流中的每一个元素映射成一个新的元素。
     */
    @Test
    public void optionStreamMap() {
        List<String> list = Arrays.asList("aaa", "ccc", "bbb");
        list.stream().map(String::toUpperCase).sorted()
                .forEach(System.out::println);

        studentList.stream().map(Student::getAge).forEach(System.out::println);
        Stream<String> sorted = list.stream().map((x) -> x.toUpperCase()).sorted();

    }

    /**
     * flatMap和map类似，不同的是flatMap把流中的每个值转换成另外一个流，然后把所有的流连接成一个新的流
     *
     */
    @Test
    public void flatMapStream() {
        String [] strs1 = {"a","b","c"};
        String [] strs2 = {"d","e","f"};
        String [] strs3 = {"a","g","h"};
        Stream<String[]> stream = Arrays.asList(strs1, strs2, strs3).stream();
        // 返回值可以看出来flatMap和map的区别
        Stream<String> stringStream = stream.flatMap((String[] x) -> Stream.of(x));
        Stream<Stream<String>> streamStringStream = stream.map((String[] x) -> Stream.of(x));
    }

    /**
     *
     * 排序：sorted
     *
     */
    @Test
    public void sortStream() {
        List<String> list = Arrays.asList("aaa", "ccc", "bbb");
        list.stream().sorted().forEach((t) -> System.out.println(t));

        // 自定义按照年龄排序
        studentList.stream().sorted((s1, s2) -> Integer.valueOf(s1.getAge()).compareTo(Integer.valueOf(s2.getAge())))
                .forEach(System.out::println);
    }

    /**
     * 第三部：终止操作
     *  allMatch---检查是否匹配所有元素
     *  anyMatch----检查是否匹配任意元素
     *  noneMatch---检查是否没有匹配所有元素
     *  以上三种都返回boolean
     *
     *  findFirst--查找第一个元素
     *  findAny--查找当前流中的任意元素
     *  返回Optional
     *
     *  count 统计总数
     *  max 最大值
     *  min 最小值
     * =====================================上面的都比较简单============
     * reduce：聚合操作
     * 返回单个的结果值，并且reduce操作每处理一个元素总是创建一个新的值.
     */
    @Test
    public void optionalReduceStream() {
        // 定义起始值
        int startNum = 0;
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        // T reduce(T identity, BinaryOperator accumulator)
        // 这里reduce 需要两个参数，其中第一个参数表示起始值，BinaryOperator是一个二元运算接口。
        // 下面的意思就是初始值startNum累加集合中的元素. 0 + 1 + 2 + ...，实现一个累加的效果
        Integer reduce = list.stream()
                .reduce(startNum, (x, y) -> x + y);

        // 另一个重载方法Optional<T> reduce(BinaryOperator<T> accumulator);
        // 例如统计出studentList集合中的平均成绩
        Optional<Double> optional = studentList.stream()
                .map((x) -> x.getScore())
                .reduce((s1, s2) -> s1 + s2);
        double avergeScore = optional.get() / studentList.size();
    }

    /**
     * 收集结果 collect
     *
     * 将流转换成其他形式，接收Collector接口实现，用于给Stream总汇总操作
     */
    @Test
    public void collectStream() {
        // 收集studentList集合中所有分数大于60的人数
        Long collect = studentList.stream()
                .filter((x) -> x.getScore() > 60)
                .collect(Collectors.counting());
        // Collectors.toSet
        Set<String> collect1 = studentList.stream()
                .map((x) -> x.getName())
                .collect(Collectors.toSet());

        // toCollection 转成需要的集合
        Set<Student> hashSet = studentList.stream()
                .collect(Collectors.toCollection(() -> new HashSet<>()));
        

    }













    private List<Student> getStudentList() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("张三", 16, "00001", "北京", 87.5));
        studentList.add(new Student("李四", 17, "00002", "上海", 91.0));
        studentList.add(new Student("王五", 19, "00003", "大连", 88.5));
        studentList.add(new Student("马六", 14, "00004", "深圳", 55.0));
        studentList.add(new Student("胜七", 14, "00005", "广东", 81.5));
        studentList.add(new Student("lilei", 19, "00015", "广东", 60.0));
        studentList.add(new Student("ali", 29, "00017", "郑州", 77.5));
        studentList.add(new Student("ten", 99, "00018", "朝阳", 68.0));
        studentList.add(new Student("ten", 9, "00018", "朝阳", 100.0));
        studentList.add(new Student("ten", 9, "00018", "朝阳", 100.0));
        return studentList;
    }

}
