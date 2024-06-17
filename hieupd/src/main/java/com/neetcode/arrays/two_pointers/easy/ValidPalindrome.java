package com.neetcode.arrays.two_pointers.easy;

public class ValidPalindrome {

  public static boolean isPalindrome(String s) {
    int i = 0, j = s.length() - 1;

    while (i < j) {
      // verify and bypass the non-alphanumeric characters from the beginning and the end
      while (i < j && !Character.isLetterOrDigit(s.charAt(i))) i++;
      while (i < j && !Character.isLetterOrDigit(s.charAt(j))) j--;

      // after removing all non-alphanumeric, we compare them
      if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) return false;
      i++;
      j--;
    }
    return true;
  }

  public static void main(String[] args) {
    String s = "A man, a plan, a canal: Panama";
    String s2 = "race a car";
    System.out.println(isPalindrome(s));
    System.out.println(isPalindrome(s2));
  }
}
