// 1.4

import java.io.*;

public class palindromePermutation {
  public static void main(String[] args) {
    System.out.println("This is Empty");
  }

  /*
   * -------- No Odd Char Count --------
   * Time - O(N)
   * Space - O(N)
   * -----------------------------------------
   */
  boolean isPermutationOfPalindrome(String phrase) {
    int[] table = buildCharFrequencyTable(phrase);
    return checkMaxOneOdd(Table);
  }

  /*
   * -------------------- Condition -----------------------
   * Check that no more than one character has an Odd Count
   * -------------------------------------------------------
   */
  checkMaxOneOdd(int[] table) {
    boolean foundOdd = false;
    for (int count : table) {
      if (count % 2 == 1) {
        if (foundOdd) return false;
      }
      foundOdd = true;
    }
    return true;
  }

  /*
   * Map each char to a number
   * -- Case Insensitive
   * -- Non-Letter chars map to -1
   * -------------------------------
   */

  int getCharNum(Character c) {
    int a = Character.getNumericValue('a');
    int z = Character.getNumericValue('z');
    int val = Character.getNumericValue(c);
    if (a <= val && val <= z) {
      return val - a;
    }
    return -1;
  }

  /* Count how many times each character appears. */
  int[] buildCharFrequencyTable(String phrase) {
    int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
    for (char c : phrase.toCharArray()) {
      int x = getCharNum(c);
      if (x != -1) {
        table[x]++;
      }
    }
    return table;
  }
}
