package org.aibles.homework.binary_string;

public class BinaryString {
  private final int length;
  private final int[] binaryString;

  public BinaryString(int length) {
    this.length = length;
    this.binaryString = new int[length];
  }

  private void printBinaryString() {
    for (int i = 0; i < length; i++) {
      System.out.print(binaryString[i]);
    }
    System.out.println();
  }

  public void solve(int index) {
    //iterate over the values considered in the recursion
    for (int i = 0; i <= 1; i++) {
      if (index == length) {
        printBinaryString();
        return;
      }
      binaryString[index] = i;
      solve(index + 1);
    }
  }
}
