package ru.sbt.javacourse.hw06;

import org.junit.Test;

import static org.junit.Assert.*;

public class CountMapImplTest {

    @Test
    public void test01() {
        CountMap<Integer> cm1 = new CountMapImpl();
        CountMap<String> cm2 = new CountMapImpl();

        cm1.add(1);
        cm1.add(2);
        cm1.add(1);
        cm1.add(1);
        cm1.add(1);
        cm2.add("hi");
        cm2.add("hi");
        cm2.add("hi");
        cm2.add("hello");
        cm2.add("hello");

        System.out.println(cm1.getCount(1));
        System.out.println(cm1.getCount(2));
        System.out.println(cm2.getCount("hi"));
        System.out.println(cm2.getCount("hello"));


    }
}