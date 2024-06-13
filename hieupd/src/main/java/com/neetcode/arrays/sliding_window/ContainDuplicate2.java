package com.neetcode.arrays.sliding_window;

import java.util.HashMap;
import java.util.Map;

public class ContainDuplicate2 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (map.containsKey(n) && Math.abs(map.get(n) - n) <= k) return true;
            map.put(n, i);
        }
        return false;
    }
}
