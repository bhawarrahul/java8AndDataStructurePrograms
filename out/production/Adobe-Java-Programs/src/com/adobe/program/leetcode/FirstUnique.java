package com.adobe.program.leetcode;

import java.util.HashSet;
import java.util.LinkedHashSet;

class FirstUnique {
    HashSet<Integer> unique = new LinkedHashSet<>();
    HashSet<Integer> nonUnique = new LinkedHashSet<>();

    public FirstUnique(int[] nums) {
        for (int num : nums) {
            add(num);
        }
    }

    public int showFirstUnique() {
        try {
            return unique.iterator().next();
        } catch (Exception ex) {
            return -1;
        }
    }

    public void add(int value) {
        if (nonUnique.contains(value)) {
            return;
        } else if (unique.contains(value)) {
            unique.remove(value);
            nonUnique.add(value);
            return;
        }
        unique.add(value);
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */