package com.example.java8;

/**
 * <p></p>
 *
 * @author wangdejian
 * @since 2018/4/7
 */
public class JavaInterfaceImpl implements JavaInterface {

    // JavaInterfaceImpl 实现java8新特性的JavaInterface接口.

    public static void main(String [] args) {
        JavaInterface javaInterface = new JavaInterfaceImpl();
        javaInterface.getDefaultMethod();// 调用default方法
        JavaInterface.staticMethod(); // 调用静态方法.
    }
}
