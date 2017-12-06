package ru.sbt.javacourse.hw06;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by user on 27.10.2017.
 */
public class CountMapImpl <T> implements CountMap <T> {

    private Map<T, Integer> map = new HashMap<T, Integer>();

    @Override
    public void add(T o) {
        Integer count = map.get(o);
        if (count == null) count = 0;
        map.put(o, count + 1);
    }

    @Override
    public int getCount(T o) {
        Integer count = map.get(o);
        return count == null ? 0: count;
    }

    @Override
    public int remove(T o) {
        Integer count = map.remove(o);
        return count == null ? 0: count;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public void addAll(CountMap<? extends T> source) {
        Set<Map.Entry<? super T, Integer>> set = source.toMap().entrySet();
        for (Map.Entry<T, Integer> entry : set) {
            T key = entry.getKey();
            Integer count = map.get(key);
            if (count == null) count = 0;
            map.put(key, count + entry.getValue());
        }
    }

    @Override
    public Map<T, Integer> toMap() {
        return map;
    }

    @Override
    public void toMap(Map<T, Integer> destination) {
        destination.putAll(map);
    }
}
