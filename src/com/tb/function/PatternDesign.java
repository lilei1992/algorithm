package com.tb.function;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

/**
 * @author: lilei
 * @time: 2020/3/22 17:33
 */
public class PatternDesign {

    public static void main(String[] args) {
        Supplier<Person> personSupplier = Person::new;
        Person person = personSupplier.get();
        System.out.println(person.getName());

        BiConsumer<Person, String> biConsumer = (p, name) -> p.setName(name);
        biConsumer.accept(person, "jhon");
        System.out.println(person.getName());
    }


}
