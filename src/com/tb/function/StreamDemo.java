package com.tb.function;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Currency;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @author: lilei
 * @time: 2020/3/22 16:49
 */
public class StreamDemo {

    public static void main(String[] args) {

        // 流中间操作
        Stream<String> stream = Stream.of("benny", "taina", "purnima")
                .map(x -> {
                    System.out.println(x);
                    return x;
                }).filter(x -> x.contains("p"));
        System.out.println(stream.findFirst());

        // 并行流
        Stream streamParallel = Stream.of("benny", "john", "michel", "jane").parallel()
                .filter(x -> x.contains("n"));
        System.out.println(streamParallel.findFirst());

        // 文件流
        try {
            Stream<String> fileStream = Files.lines(Paths.get("D:/workspace/algorithm/src/com/tb/algorithm/function/input.txt"));
            fileStream.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<Currency, Double> exchangeToEur = Map.of(Currency.getInstance(Locale.US), 0.96, Currency.getInstance(Locale.CANADA),
                1.56, Currency.getInstance(Locale.ENGLISH), 2.1);
        System.out.println(exchangeToEur);


    }


}
