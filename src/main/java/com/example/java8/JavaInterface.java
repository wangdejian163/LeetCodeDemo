package com.example.java8;

/**
 * <p>java8新特性接口</p>
 *
 * @author wangdejian
 * @since 2018/4/7
 */
public interface JavaInterface {
    /**
     * 在java8以前的版本中，定义一个接口时，所有的方法必须是抽象方法，不能有具体实现，这是java语法规定的。但是在java8中定义一个接口时，
     * 在满足特定的前提下，可以有方法的具体实现。这样一个接口中可以有属性，可以有抽象方法，也可以有具体的方法
     *
     * @return
     */
    // 接口中定义具体的方法实现是有限制的，它不能像我们在一个普通类那样随便定义方法实现，它只能定义default
    // 和static类型的方法

    /**
     * java8 接口增强也是为了解决子类重复问题。
     *
     * @return
     */
    default String getDefaultMethod() {
        return "default实现";
    }

    static void staticMethod() {
        System.out.println("static 方法");
    }


}
