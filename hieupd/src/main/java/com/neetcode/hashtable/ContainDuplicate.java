package com.neetcode.hashtable;

import java.util.HashSet;
import java.util.Set;

public class ContainDuplicate {

  public boolean containsDuplicate(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int n : nums) {
      if (!set.add(n)) return false;
    }
    return true;
  }
}
