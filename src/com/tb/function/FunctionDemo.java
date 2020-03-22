package com.tb.function;

import com.tb.algorithm.Tuple;

import java.util.*;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author: lilei
 * @time: 2020/3/22 15:03
 */
public class FunctionDemo {

    public static void main(String[] args) {

        // 高阶函数
        OptionalDouble optionalDouble = IntStream.of(23, 42, 45, 56, 99).map(x -> (x - 32) * 5 / 9).average();
        print("optionalDouble", optionalDouble.getAsDouble() + "");

        IntUnaryOperator convF2C = x -> (x - 32) * 5 / 9;
        optionalDouble = IntStream.of(23, 42, 45, 56, 99).map(convF2C).average();
        print("optionalDouble", optionalDouble.toString());
        int xx = convF2C.applyAsInt(80);
        print("xx", xx + "");


        // 组合

        IntUnaryOperator intUnaryOperator = ((IntUnaryOperator) (x -> x - 32)).andThen(x -> x * 5).andThen(x -> x / 9);
        int resultInt = intUnaryOperator.applyAsInt(85);
        print("resultInt", resultInt + "");
        // 柯里化   将n元函数转换为一系列一元函数
        Function<Integer, Function<Integer, Integer>> function = x -> y -> x * x + y * y;
        List<Integer> squares = Arrays.asList(new Tuple<>(1, 2), new Tuple<>(1, 5)).stream().map(s -> function.apply(s.a).apply(s.b)).collect(Collectors.toList());
        System.out.println(squares.toString());

        // 闭包

        Integer a = 100;

        Function<Integer, Integer> add100 = y -> y + a;

        int resultAdd100 = add100.apply(123);
        print("resultAdd100", resultAdd100 + "");

        //函子
        Optional<Integer> optionalInteger = Optional.of(12);
        System.out.println(optionalInteger);

        Optional<Double> optionalFloat = optionalInteger.map(x -> (x * 0.95d));
        System.out.println(optionalFloat);

        // 加强版函子
        Optional<String> optionalS = Optional.of("Hello applicatvice");
        Optional<Function<String, String>> upper = Optional.of(x -> x.toUpperCase());
        String applicativeStr = optionalS.map(x -> upper.get().apply(x)).get();
        print("applicativeStr", applicativeStr);

        // 加强  test failure
        Optional<Function<String, String>> identity = Optional.of(Function.identity());
        Optional<Function<String, String>> uppers = Optional.empty();
        // optionalS.map(x -> upper.orElse(() -> identity).get().apply(x));

        // 单子 monad jdk9
        //  Map<Integer,String> codesMapping = Map.of


    }

    public static void print(String desc, String result) {
        System.out.println(desc + "->" + result);
    }

}
