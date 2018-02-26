package com.example.java8;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * <p>
 *     stream学习
 * </p>
 *
 * @author wangdejian
 * @since 2018/2/26
 */
public class StreamTest {
    // stream对集合和数组做一系列流水线的操作。步骤为：1.首先得到一个stream流；2.对流进行一系列操作；
    // 3.终止操作，得到最终结果

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

        // 3. 数组转为stream
        String [] str = new String[] {"a", "b", "c"};
        Stream<String> stream5 = Arrays.stream(str);

    }

}
