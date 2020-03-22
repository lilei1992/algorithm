package com.tb.function;

import java.util.Comparator;
import java.util.Date;
import java.util.function.*;

/**
 * lamdba 测试
 *
 * @author: lilei
 * @time: 2020/3/22 16:27
 */
public class LambdaDemo {

    public static void main(String[] args) {


        // 接受两个参数不返回
        BiConsumer<String, String> biConsumer = (x, y) -> System.out.println("x:" + x + "\ny:" + y);
        biConsumer.accept("你好", "再见");

        // 接受两个参数并返回一个结果
        BiFunction<String, String, String> biFunction = (x, y) -> x + " " + y;
        System.out.println(biFunction.apply("hello", "world"));

        // 相同类型,两个同类型参数,返回同类型结果
        BinaryOperator<Integer> binaryOperator = BinaryOperator.maxBy(Comparator.comparing(Function.identity()));
        System.out.println("binaryOperator:" + binaryOperator.apply(1, 3));

        BinaryOperator<String> binaryOperator1 = (x, y) -> x + y;
        System.out.println("binaryOperator:" + binaryOperator1.apply("hello", "world"));

        // 接受一个参数,不反悔
        Consumer<String> consumer = System.out::println;
        consumer.accept("hello world");

        // 一个入参,一个出参
        Function<String, Integer> function = x -> Integer.parseInt(x);
        System.out.println(function.apply("1"));

        // 接受一个入参,返回布尔值
        Predicate<String> predicate = x -> x != null && x.equals("hello");
        System.out.println(predicate.test("hello"));
        System.out.println(predicate.test("not match"));

        // 无参,返回一个结果
        Supplier<String> supplier = () -> new Date().toString();
        System.out.println(supplier.get());

        // 接受个参数,返回一个同类型参数

        UnaryOperator<String> unaryOperator = x -> "prefix_" + x;
        System.out.println(unaryOperator.apply("xx"));

        //
        SingleTon.getIntance().get().doSomething();
    }


}
