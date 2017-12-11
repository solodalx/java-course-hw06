package ru.sbt.javacourse.hw06;

import java.util.*;

public class CollectionUtils {
    public static<T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    public static<T> List<T> newArrayList() {
        return new ArrayList<T>();
    }

    public static<T> int indexOf(List<? extends T> source, Object o) {
        return source.indexOf(o);
    }

    public static<T> List<T> limit(List<? extends T> source, int size) {
//        List<T> result = source.subList(0, size);
        if (size > source.size())
            throw new IndexOutOfBoundsException();

        List<T> result = new ArrayList<T>();
        for (int i = 0; i < size /*&& i < source.size()*/; i++) {
            result.add(source.get(i));
        }
        return result;
    }

    public static<T> void add(List<? super T> source, T o) {
        source.add(o);
    }

    public static<T> void removeAll(List<? super T> removeFrom, List<? extends T> c2) {
        removeFrom.removeAll(c2);
    }

    public static<T> boolean containsAll(List<? super T> c1, List<? extends T> c2) {
        return c1.containsAll(c2);
    }

    public static<T> boolean containsAny(List<? super T> c1, List<? extends T> c2) {
        for (T t: c2) {
            if (c1.contains(t))
                return true;
        }
        return false;
    }

    public static<T extends Comparable> List<T> range(List<? extends T> list, T min, T max) {
        List<T> result = new ArrayList<T>();
        for (T t: list) {
            if (t.compareTo(min) >= 0 && t.compareTo(max) <=0) {
                result.add(t);
            }
        }
        Collections.sort(result);
        return result;
    }

    public static<T> List<T> range(List<? extends T> list, T min, T max, Comparator<? super T> comparator) {
        List<T> result = new ArrayList<T>();
        for (T t: list) {
            if (comparator.compare(t, min) >= 0
                    && comparator.compare(t, max) <= 0) {
                result.add(t);
            }
        }
        Collections.sort(result, comparator);
        return result;
    }
}
