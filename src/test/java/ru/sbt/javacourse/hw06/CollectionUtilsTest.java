package ru.sbt.javacourse.hw06;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static ru.sbt.javacourse.hw06.CollectionUtils.addAll;

public class CollectionUtilsTest {
    @Test
    public void test01_addAllIndex() {
        List<Integer> source = Arrays.asList(1, 3, 5, 8);
        List<Integer> dest = new ArrayList<Integer>();

        CollectionUtils.addAll(source, dest);
        assertEquals(4, dest.size());
        assertEquals(new Integer(1), dest.get(0));
        assertEquals(new Integer(3), dest.get(1));
        assertEquals(new Integer(5), dest.get(2));
        assertEquals(new Integer(8), dest.get(3));
        assertEquals(2, CollectionUtils.indexOf(source, new Integer(5)));
    }

    @Test
    public void test02_addAllIndex2() {
        List<Integer> source = Arrays.asList(1, 3, 5, 8);
        List<Number> dest = new ArrayList<Number>();

        CollectionUtils.addAll(source, dest);
        assertEquals(4, dest.size());
        assertEquals(new Integer(1), dest.get(0));
        assertEquals(new Integer(3), dest.get(1));
        assertEquals(new Integer(5), dest.get(2));
        assertEquals(new Integer(8), dest.get(3));
        assertEquals(2, CollectionUtils.indexOf(source, new Integer(5)));
    }

    @Test
    public void test02_limit() {
        List<Integer> source = Arrays.asList(1, 3, 5, 8);
//        List<Number> dest;
        List<Integer> dest;

        dest = CollectionUtils.limit(source, 3);
        assertEquals(3, dest.size());
        assertEquals(new Integer(1), dest.get(0));
        assertEquals(new Integer(3), dest.get(1));
        assertEquals(new Integer(5), dest.get(2));

        try {
            dest = CollectionUtils.limit(source, 6);
            assertTrue(false);
        } catch (IndexOutOfBoundsException e) {
            assertTrue(true);
        }
    }

    @Test
    public void test03_add() {
        List<Integer> source = new ArrayList<Integer>(Arrays.asList(1, 3));
        CollectionUtils.add(source, new Integer(5));

        assertEquals(3, source.size());
        assertEquals(new Integer(1), source.get(0));
        assertEquals(new Integer(3), source.get(1));
        assertEquals(new Integer(5), source.get(2));
    }

    @Test
    public void test04_add2() {
        List<Number> source = new ArrayList<Number>(Arrays.asList(1, 3));
        CollectionUtils.add(source, new Integer(5));

        assertEquals(3, source.size());
        assertEquals(new Integer(1), source.get(0));
        assertEquals(new Integer(3), source.get(1));
        assertEquals(new Integer(5), source.get(2));
    }

    @Test
    public void test05_removeAll() {
        List<Integer> removeFrom = new ArrayList<Integer>(Arrays.asList(1, 3, 5, 8));
        List<Integer> toRemove = Arrays.asList(3, 5);

        CollectionUtils.removeAll(removeFrom, toRemove);
        assertEquals(2, removeFrom.size());
        assertEquals(new Integer(1), removeFrom.get(0));
        assertEquals(new Integer(8), removeFrom.get(1));

        List<Integer> toRemove2 = Arrays.asList(4, 6);
        CollectionUtils.removeAll(removeFrom, toRemove2);
        assertEquals(2, removeFrom.size());
        assertEquals(new Integer(1), removeFrom.get(0));
        assertEquals(new Integer(8), removeFrom.get(1));
    }

    @Test
    public void test06_removeAll2() {
        List<Number> removeFrom = new ArrayList<Number>(Arrays.asList(1, 3, 5, 8));
        List<Integer> toRemove = Arrays.asList(3, 5, 6);

        CollectionUtils.removeAll(removeFrom, toRemove);
        assertEquals(2, removeFrom.size());
        assertEquals(new Integer(1), removeFrom.get(0));
        assertEquals(new Integer(8), removeFrom.get(1));
    }

    @Test
    public void test07_containsAllContainsAny() {
        List<Integer> c1 = new ArrayList<Integer>(Arrays.asList(1, 3, 5, 8));
        List<Integer> c2 = Arrays.asList(3, 5);
        List<Integer> c3 = Arrays.asList(3, 6);
        List<Integer> c4 = Arrays.asList(3, 6);
        List<Integer> c5 = Arrays.asList(4, 6);

        assertTrue(CollectionUtils.containsAll(c1, c2));
        assertFalse(CollectionUtils.containsAll(c1, c3));
        assertTrue(CollectionUtils.containsAny(c1, c4));
        assertFalse(CollectionUtils.containsAny(c1, c5));
    }

    @Test
    public void test08_containsAllContainsAny2() {
        List<Number> c1 = new ArrayList<Number>(Arrays.asList(1, 3, 5, 8));
        List<Integer> c2 = Arrays.asList(3, 5);
        List<Integer> c3 = Arrays.asList(3, 6);
        List<Integer> c4 = Arrays.asList(3, 6);
        List<Integer> c5 = Arrays.asList(4, 6);

        assertTrue(CollectionUtils.containsAll(c1, c2));
        assertFalse(CollectionUtils.containsAll(c1, c3));
        assertTrue(CollectionUtils.containsAny(c1, c4));
        assertFalse(CollectionUtils.containsAny(c1, c5));
    }

    @Test
    public void test09_range() {
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(1, 3, 5, 8));
        List<Integer> rangedList = null;

        rangedList = CollectionUtils.range(list, 2, 5);
        assertEquals(2, rangedList.size());
        assertEquals(new Integer(3), rangedList.get(0));
        assertEquals(new Integer(5), rangedList.get(1));

//        rangedList = null;
//        rangedList = CollectionUtils.range(list, 2, 5, (c1, c2) -> {return c1.compareTo(c2);});
//        rangedList = CollectionUtils.range(list, 2, 5, );
//        assertEquals(2, rangedList.size());
//        assertEquals(new Integer(3), rangedList.get(0));
//        assertEquals(new Integer(5), rangedList.get(1));
    }
}