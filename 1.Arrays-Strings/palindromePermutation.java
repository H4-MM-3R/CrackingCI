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
   * ***** Map each char to a number *****
   * -------------------------------------
   * Case Insensitive
   * -------------------------------------
   * Non-Letter chars map to -1
   * -------------------------------------
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

  /*
   * ------------------------------------------
   * Count how many times each character appears
   * ------------------------------------------
   */

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

  /*
   * -------- Smaller Incremental Improvements --------
   * Time - O(N) ----> not neccessarily Optimal
   * Space - O(N)
   * -----------------------------------------
   */

  boolean isPermutationOfPalindrome1(String phrase) {
    int countOdd = 0;
    int[] table = new int[Character.getNumericValue('z') - Checker.getNumericValue('a') + 1];

    for (char c : phrase.toCharArray()) {
      int x = getCharNumber(c);
      if (c != -1) {
        table[x]++;
        if (table[x] % 2 == 1) countOdd++;
        else countOdd--;
      }
    }
    return countOdd <= 1;
  }

  /*
   * -------- Bit Vector Map --------
   * Time - O()
   * Space - O()
   * ---------------------------------------------------------------------------
   * You don't to generate all permutations in order to check if its palindrome
   * ---------------------------------------------------------------------------
   */

  boolean isPermutationOfPalindrome2(String phrase) {
    int bitVector = createBitVector(phrase);
    return bitVector == 0 || checkExactlyOneBitSet(bitVector);
  }

  /*
   ******** Create a Bit Vector for the String. ********
   * ----------------------------------------------------
   * For each letter with value i,
   * ----------------------------------------------------
   * Toggle the ith Bit.
   * ----------------------------------------------------
   */

  int createBitVector(String phrase) {
    int bitVector = 0;
    for (char c : phrase.toCharArray()) {
      int x = getCharNum(c);
      bitVector = toggle(bitVector, x);
    }
    return bitVector;
  }

  /*
   * -------------------------------------
   * Toggle the ith Bit in the integer
   * -------------------------------------
   */

  int toggle(int bitVector, int index) {
    if (index < 0) return bitVector;

    int mask = 1 << index;
    if ((bitVector & mask) == 0) bitVector |= mask;
    else bitVector &= ~mask;
    return bitVector;
  }

  /*
   ******** Check that excatly one bit is set ********
   * ----------------------------------------------------
   * Subtract one from the integer
   * ----------------------------------------------------
   * AND gate it with the original integer
   * ----------------------------------------------------
   */

  boolean checkExactlyOneBitSet(int bitVector) {
    return (bitVector & (bitVector - 1)) == 0;
  }
}
