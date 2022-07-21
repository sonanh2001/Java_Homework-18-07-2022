package org.aibles.homework.matrix;

import static org.aibles.homework.util.ScannerUtil.SCANNER;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

public class Matrix {
  private static final int EVEN_PRIME = 2;
  private static final int REMAINDER_OF_DIVISIBILITY = 0;
  private static final int FIRST_ROW_INDEX = 0;
  private static final int FIRST_COLUMN_INDEX = 0;
  private final int numOfRow;
  private final int numOfCol;
  private final int[][] matrix;

  public Matrix(int numOfRow, int numOfCol) {
    this.numOfRow = numOfRow;
    this.numOfCol = numOfCol;
    matrix = new int[numOfRow][numOfCol];
  }

  public void enterMatrix() {
    System.out.println("Enter the matrix:");
    for (int rowIndex = 0; rowIndex < numOfRow; rowIndex++) {
      for (int colIndex = 0; colIndex < numOfCol; colIndex++) {
        matrix[rowIndex][colIndex] = SCANNER.nextInt();
      }
    }
  }

  public void findMaxNumberOfMatrix() {
    int rowIndexOfResult = FIRST_ROW_INDEX,
        colIndexOfResult = FIRST_COLUMN_INDEX,
        result = matrix[FIRST_ROW_INDEX][FIRST_COLUMN_INDEX];
    for (int rowIndex = 0; rowIndex < numOfRow; rowIndex++) {
      for (int colIndex = 0; colIndex < numOfCol; colIndex++) {
        int value = matrix[rowIndex][colIndex];
        if (value > result) {
          result = value;
          rowIndexOfResult = rowIndex;
          colIndexOfResult = colIndex;
        }
      }
    }
    System.out.println("Biggest value in matrix is " + result);
    System.out.printf("Position at [%d,%d]%n", rowIndexOfResult + 1, colIndexOfResult + 1);
  }

  public void printPrimeValue() {
    for (int rowIndex = 0; rowIndex < numOfRow; rowIndex++) {
      for (int colIndex = 0; colIndex < numOfCol; colIndex++) {
        int value = matrix[rowIndex][colIndex];
        if (checkPrime(value)) {
          System.out.print(value + " ");
        } else {
          System.out.print(0 + " ");
        }
      }
      System.out.println();
    }
  }

  public void printSortColumnBySum() {
    TreeMap<Integer, ArrayList<Integer>> columnMap = new TreeMap<>();
    for (int rowIndex = 0; rowIndex < numOfRow; rowIndex++) {
      ArrayList<Integer> column = new ArrayList<>();
      int sumOfColumn = 0;
      for (int colIndex = 0; colIndex < numOfCol; colIndex++) {
        column.add(matrix[colIndex][rowIndex]);
        sumOfColumn += matrix[colIndex][rowIndex];
      }
      columnMap.put(sumOfColumn, column);
    }
    int[][] tempMatrix = new int[numOfRow][numOfCol];
    int colCount = 0;
    for (ArrayList<Integer> column : columnMap.values()) {
      for (int rowIndex = 0; rowIndex < numOfRow; rowIndex++) {
        tempMatrix[rowIndex][colCount] = column.get(rowIndex);
      }
      colCount++;
    }

    printMatrix(tempMatrix);
  }

  public void printSortColumnAscendingOrder() {
    ArrayList<ArrayList<Integer>> columnsOfMatrix = new ArrayList<>();
    for (int rowIndex = 0; rowIndex < numOfRow; rowIndex++) {
      ArrayList<Integer> column = new ArrayList<>();
      for (int colIndex = 0; colIndex < numOfCol; colIndex++) {
        column.add(matrix[colIndex][rowIndex]);
      }
      Collections.sort(column);
      columnsOfMatrix.add(column);
    }

    int[][] tempMatrix = new int[numOfRow][numOfCol];
    int colCount = 0;
    for (ArrayList<Integer> column : columnsOfMatrix) {
      for (int rowIndex = 0; rowIndex < numOfRow; rowIndex++) {
        tempMatrix[rowIndex][colCount] = column.get(rowIndex);
      }
      colCount++;
    }

    printMatrix(tempMatrix);
  }

  private void printMatrix(int[][] matrix) {
    for (int rowIndex = 0; rowIndex < numOfRow; rowIndex++) {
      for (int colIndex = 0; colIndex < numOfCol; colIndex++) {
        System.out.print(matrix[rowIndex][colIndex] + " ");
      }
      System.out.println();
    }
  }

  private boolean checkPrime(int num) {
    if (num < EVEN_PRIME) {
      return false;
    }
    for (int i = EVEN_PRIME; i * i <= num; i++) {
      if (num % i == REMAINDER_OF_DIVISIBILITY) {
        return false;
      }
    }
    return true;
  }
}
