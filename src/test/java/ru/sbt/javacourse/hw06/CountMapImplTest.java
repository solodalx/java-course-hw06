package ru.sbt.javacourse.hw06;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class CountMapImplTest {

    @Test
    public void test01_addGetCountSizeRemove() {
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
        assertEquals(2, cm1.size());
        assertEquals(2, cm2.size());

        int removed = cm1.remove(1);
        assertEquals(4, removed);
        assertEquals(1, cm1.size());
        assertEquals(0, cm1.getCount(1));

//        System.out.println(cm1.getCount(1));
//        System.out.println(cm1.getCount(2));
//        System.out.println(cm2.getCount("hi"));
//        System.out.println(cm2.getCount("hello"));
    }

    @Test
    public void test02_addAll() {
        CountMap<Integer> cm1 = new CountMapImpl<Integer>();
        CountMap<Integer> cm2 = new CountMapImpl<Integer>();

        cm1.add(1);
        cm1.add(2);
        cm1.add(1);
        cm1.add(1);
        cm1.add(1);

        cm2.add(3);
        cm2.add(2);
        cm2.add(1);
        cm2.add(1);

        cm1.addAll(cm2);
        assertEquals(3, cm1.size());
        assertEquals(6, cm1.getCount(1));
        assertEquals(2, cm1.getCount(2));
        assertEquals(1, cm1.getCount(3));
    }

    @Test
    public void test03_toMap() {
        CountMap<Integer> cm1 = new CountMapImpl<Integer>();
        cm1.add(1);
        cm1.add(2);
        cm1.add(1);
        cm1.add(1);
        cm1.add(3);

        Map<Integer, Integer> map = cm1.toMap();
        assertEquals(3, map.size());
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            Integer count1 = cm1.getCount(entry.getKey());
            assertEquals(count1, entry.getValue());
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    @Test
    public void test04_toMap2() {
        CountMap<Integer> cm1 = new CountMapImpl<Integer>();
        cm1.add(1);
        cm1.add(2);
        cm1.add(1);
        cm1.add(1);
        cm1.add(3);

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        cm1.toMap(map);
        assertEquals(3, map.size());
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            Integer count1 = cm1.getCount(entry.getKey());
            assertEquals(count1, entry.getValue());
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    @Test
    public void test05_toMap3() {
        CountMap<Integer> cm1 = new CountMapImpl<Integer>();
        cm1.add(1);
        cm1.add(2);
        cm1.add(1);
        cm1.add(1);
        cm1.add(3);

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(1, 5);
        map.put(5, 0);
        cm1.toMap(map);
        assertEquals(4, map.size());
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            Integer count1 = cm1.getCount(entry.getKey());
            assertEquals(count1, entry.getValue());
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}