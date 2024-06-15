package com.neetcode.arrays.sliding_window;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatCharacter {

  public static int lengthOfLongestSubstring(String s) {
    if (s.length() <= 1) return s.length();
    int maxLen = 0;
    int startIdx = 0;
    for (int i = 0; i < s.length(); i++) {
      char curChar = s.charAt(i);
      // find and eliminate the first duplicate from startIdx to curChar
      for (int j = startIdx; j < i; j++) {
        if (s.charAt(j) == curChar) {
          startIdx = j + 1;
          break; // break after remove the first duplicate because there is only one duplicate
        }
      }
      // recalculate max
      maxLen = Math.max(maxLen, i - startIdx + 1);
    }
    return maxLen;
  }

  public static void main(String[] args) {
    String s1 = "abcabcbb";
    System.out.println(lengthOfLongestSubstring(s1));

    String s2 = "bbbbb";
    System.out.println(lengthOfLongestSubstring(s2));

    String s3 = "dvdf";
    System.out.println(lengthOfLongestSubstring(s3));
  }
}
