// 1.3

import java.io.*;

public class URLify {
  public static void main(String[] args) {
    System.out.println("This is Empty");
  }

  /*
   * -------- Simple Editing --------
   * Time - O(N)
   * Space - O(1)
   * -----------------------------------------
   */

  void replaceSpaces(char[] str, int trueLength) {
    int spaceCount = 0;

    for (int i = 0; i < trueLength; i++) {
      if (str[i] == ' ') {
        spaceCount++;
      }
    }
    int index = trueLength + spaceCount * 2;
    if (trueLength < str.length) str[trueLength] = '\0'; // End Array
    for (int i = trueLength - 1; i >= 0; i--) {
      if (str[i] == ' ') {
        str[index - 1] = '0';
        str[index - 2] = '2';
        str[index - 3] = '%';
      } else {
        str[index - 1] = str[i];
        index--;
      }
    }
  }
}
