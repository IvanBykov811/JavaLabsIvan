package edu.ntu.bykov.lr1;

import java.util.Scanner;
import java.util.Random;

public class Main {

    private static final int MAX_ROWS = 20;
    private static final int MAX_COLS = 20;

    private static final int RANDOM_MIN = 1;
    private static final int RANDOM_MAX = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Лабораторна робота №2");
        System.out.println("1 - вводити матрицю вручну");
        System.out.println("2 - згенерувати матрицю випадково");
        int mode = readIntInRange(scanner, "Ваш вибір (1/2): ", 1, 2);

        int rows = readIntInRange(scanner, "Кількість рядків (1..20): ", 1, MAX_ROWS);
        int cols = readIntInRange(scanner, "Кількість стовпців (1..20): ", 1, MAX_COLS);

        int[][] matrix;
        if (mode == 1) {
            matrix = createMatrixManual(scanner, rows, cols);
        } else {
            matrix = createMatrixRandom(rows, cols);
        }

        System.out.println("\nМатриця:");
        printMatrix(matrix);

        int min = findMin(matrix);
        int max = findMax(matrix);
        double arithmeticMean = calcArithmeticMean(matrix);

        System.out.println("\nРезультати:");
        System.out.println("Мінімальний елемент: " + min);
        System.out.println("Максимальний елемент: " + max);
        System.out.printf("Середнє арифметичне: %.4f%n", arithmeticMean);

        scanner.close();
    }

    private static int readIntInRange(Scanner scanner, String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                if (value >= min && value <= max) return value;
                System.out.println("Введіть число від " + min + " до " + max + ".");
            } else {
                System.out.println("Помилка: введіть число.");
                scanner.next();
            }
        }
    }

    private static int[][] createMatrixManual(Scanner scanner, int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        System.out.println("\nВведіть елементи матриці:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = readInt(scanner, "a[" + i + "][" + j + "] = ");
            }
        }
        return matrix;
    }

    private static int readInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) return scanner.nextInt();
            System.out.println("Помилка: введіть число.");
            scanner.next();
        }
    }

    private static int[][] createMatrixRandom(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = RANDOM_MIN + random.nextInt(RANDOM_MAX - RANDOM_MIN + 1);
            }
        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.printf("%5d", value);
            }
            System.out.println();
        }
    }

    private static int findMin(int[][] matrix) {
        int min = matrix[0][0];
        for (int[] row : matrix) {
            for (int value : row) {
                if (value < min) min = value;
            }
        }
        return min;
    }

    private static int findMax(int[][] matrix) {
        int max = matrix[0][0];
        for (int[] row : matrix) {
            for (int value : row) {
                if (value > max) max = value;
            }
        }
        return max;
    }

    private static double calcArithmeticMean(int[][] matrix) {
        long sum = 0;
        int count = 0;
        for (int[] row : matrix) {
            for (int value : row) {
                sum += value;
                count++;
            }
        }
        return (double) sum / count;
    }
}
