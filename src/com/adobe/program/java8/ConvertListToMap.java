package com.adobe.program.java8;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConvertListToMap {
    public static void main(String[] args) {
        List<Custom> list = new ArrayList<>();
        list.add(new Custom(1, "one"));
        list.add(new Custom(3, "three"));
        list.add(new Custom(2, "two"));
        list.add(new Custom(4, "four"));
        System.out.println(list);

        // Get Result in LinkedHasMap
        Map<Integer, Custom> map = list.stream()
                .collect(Collectors.toMap(cl -> cl.getKey(), cl -> cl, (oldValue, newVal) -> oldValue, LinkedHashMap::new));
        System.out.println(map);

        // Get Result in HashMap
        map = list.stream()
                .collect(Collectors.toMap(cl -> cl.getKey(), cl -> cl));
        System.out.println(map);
    }
}


class Custom {
    private int key;
    private String value;

    public Custom(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Custom{" +
                "key=" + key +
                ", value='" + value + '\'' +
                '}';
    }
}
