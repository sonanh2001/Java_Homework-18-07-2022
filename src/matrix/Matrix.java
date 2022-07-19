package matrix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

import static util.ScannerUtil.SCANNER;

public class Matrix {
    private int numOfRow;
    private int numOfCol;
    private int[][] matrix;

    public Matrix(int numOfRow, int numOfCol) {
        this.numOfRow = numOfRow;
        this.numOfCol = numOfCol;
        matrix = new int[numOfRow][numOfCol];
    }

    public void enterMatrix() {
        System.out.println("Nhập ma trận:");
        for (int rowIndex = 0; rowIndex < numOfRow; rowIndex++) {
            for (int colIndex = 0; colIndex < numOfCol; colIndex++) {
                matrix[rowIndex][colIndex] = SCANNER.nextInt();
            }
        }
    }

    public void findMaxNumberOfMatrix() {
        int result = matrix[0][0], rowIndexOfResult = 0, colIndexOfResult = 0;
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
        System.out.println("Giá trị lớn nhất là " + result);
        System.out.println(String.format("Vị trí là ở [%d,%d]", rowIndexOfResult + 1, colIndexOfResult + 1));
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

        for (int rowIndex = 0; rowIndex < numOfRow; rowIndex++) {
            for (int colIndex = 0; colIndex < numOfCol; colIndex++) {
                System.out.print(tempMatrix[rowIndex][colIndex] + " ");
            }
            System.out.println();
        }

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

        for (int rowIndex = 0; rowIndex < numOfRow; rowIndex++) {
            for (int colIndex = 0; colIndex < numOfCol; colIndex++) {
                System.out.print(tempMatrix[rowIndex][colIndex] + " ");
            }
            System.out.println();
        }

    }

    private boolean checkPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
