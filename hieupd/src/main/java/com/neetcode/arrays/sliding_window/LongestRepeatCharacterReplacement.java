package com.neetcode.arrays.sliding_window;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatCharacterReplacement {

  public static int characterReplacement(String s, int k) {
    Map<Character, Integer> mapCount = new HashMap<>();
    int maxLen = 0;
    int left = 0;
    int maxFreq = 0;
    for (int i = 0; i < s.length(); i++) {
      Character c = s.charAt(i);
      int curFreq = mapCount.getOrDefault(c, 0);
      mapCount.put(c, curFreq + 1);
      maxFreq = Math.max(maxFreq, curFreq + 1);
      // check number of replacements = windowLen - max occurrence of a char in map <= k
      // if > k => need to shift the left pointer to the right until the number <= k
      while ((i - left + 1) - maxFreq > k) {
        // remove the char at left position from window
        mapCount.put(s.charAt(left), mapCount.get(s.charAt(left)) - 1);
        left++; // shift to the right to narrow the window
      }
      // recalculate max length
      maxLen = Math.max(maxLen, i - left + 1);
    }
    return maxLen;
  }

  public static int characterReplacement2(String s, int k) {
    int[] chars = new int[26];
    int maxLen = 0, left = 0, maxFreq = 0;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      chars[c - 'A']++;
      maxFreq = Math.max(maxFreq, chars[c - 'A']);

      while ((i - left + 1) - maxFreq > k) {
        chars[s.charAt(left) - 'A']--;
        left++;
      }
      maxLen = Math.max(maxLen, i - left + 1);
    }
    return maxLen;
  }

  public static void main(String[] args) {
    String s = "AABABBA";
    System.out.println(characterReplacement2(s, 1));
  }
}
