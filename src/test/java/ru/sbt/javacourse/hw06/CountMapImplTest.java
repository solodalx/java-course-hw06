package ru.sbt.javacourse.hw06;

import org.junit.Test;

import static org.junit.Assert.*;

public class CountMapImplTest {

    @Test
    public void test01() {
        CountMap<Integer> cm1 = new CountMapImpl<Integer>();
        CountMap<String> cm2 = new CountMapImpl<String>();

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

        assertEquals(4, cm1.getCount(1));
        assertEquals(1, cm1.getCount(2));
        assertEquals(0, cm1.getCount(3));
        assertEquals(3, cm2.getCount("hi"));
        assertEquals(2, cm2.getCount("hello"));
        assertEquals(0, cm2.getCount(""));

//        System.out.println(cm1.getCount(1));
//        System.out.println(cm1.getCount(2));
//        System.out.println(cm2.getCount("hi"));
//        System.out.println(cm2.getCount("hello"));
    }
}