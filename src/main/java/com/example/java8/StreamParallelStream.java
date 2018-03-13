package com.example.java8;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.stream.LongStream;

/**
 * <p>
 * 并行流
 * </p>
 *
 * @author wangdejian
 * @since 2018/3/5
 */
public class StreamParallelStream {
    /**
     * 什么是并行流？
     *
     *  从字面意思解读，并行就是一起的意思。把一个内容分成多个数据块，每一块都在不同的线程中处理，然后将结果一起输出。
     *  Stream 的并行操作依赖于 Java7 中引入的 Fork/Join 框架（JSR166y）来拆分任务和加速处理过程。流程图参照：src\main\resources\static\img\fork-join.png
     *
     *  java api重要演化历程
     *  1.0-1.4 中的 java.lang.Thread
     *  5.0 中的 java.util.concurrent
     *  6.0 中的 Phasers 等
     *  7.0 中的 Fork/Join 框架
     *  8.0 中的 Lambda
     *
     */
    @Test
    public void  parallelStream() {
        Instant now = Instant.now();
        long res = LongStream.rangeClosed(0, 100000000L)
                .parallel()
                .reduce(0, ((left, right) -> left + right));
        Instant end = Instant.now();
        System.out.println(res + "========" + Duration.between(now, end).toMillis());
    }
}
