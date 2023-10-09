// 1.1

import java.io.*;

public class isUnique {
  public static void main(String[] args) {
    System.out.println("This is Empty");
  }

  /*
   * -------- Boolean Array hashtable --------
   * Time - O(N)
   * Space - O(1)
   * -----------------------------------------
   */

  boolean isUniqueChars(String str) {
    if (str.length() > 128) return false;

    boolean[] char_set = new boolean[128];
    for (int i = 0; i < str.length(); i++) {
      int val = str.charAt(i);
      if (char_set[val]) return false;
      char_set[val] = true;
    }
    return true;
  }

  /*
   * -------- Bit Vector hashtable --------
   * Time - O(N^2)
   * Space - O(1) ----> LESS MEMORY THAN ABOVE
   * -----------------------------------------
   */

  boolean isUniqueChars2(String str) {
    int checker = 0;
    for (int i = 0; i < str.length(); i++) {
      int val = str.charAt(i) - 'a';

      if ((checker & (1 << val)) > 0) {
        return false;
      }
      checker /= (1 << val);
    }
    return true;
  }

  /*
   * -------- *Condition* ( Can't Use Additional Data Structures ) --------
   * Compare every Char to every other Char { O(N^2) } time and { O(1) } space
   * -----------------------------------------
   */

  /*
   * -------- *Condition* ( Allowed to modify input string ) --------
   * Sort the string { O(N Log N) } time
   * -----------------------------------------
   */

}
