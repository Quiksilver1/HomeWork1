package ru.geekbrains.HomeWork.Lesson4;

import java.util.Random;
import java.util.Scanner;

public class Lesson4 {

    private static final int SIZE = 5;
    private static final char[][] map = new char[SIZE][SIZE];
    private static final char DOT_EMPTY = '•';
    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';
    public static final Scanner SCANNER;
    public static final int HOW_MACH_TO_WIN = 4;


    public static void main(String[] args) {
        initializeGame();
        printMap();

        do {
            humanTurn();
            printMap();
            if (checkEndGame('X')) {
                break;
            }

            computerTurn();
            printMap();
        } while (!checkEndGame('O'));

    }

    private static boolean checkEndGame(char symbol) {
        if (checkWin(symbol)) {
            System.out.println(isHumanTurn(symbol) ? "Человек победил!" : "Машина победила!");
            return true;
        } else if (isMapFull()) {
            System.out.println("Ничья!");
            return true;
        } else {
            return false;
        }
    }

    private static boolean isMapFull() {
        char[][] var0 = map;
        int var1 = var0.length;

        for (int var2 = 0; var2 < var1; ++var2) {
            char[] row = var0[var2];
            char[] var4 = row;
            int var5 = row.length;

            for (int var6 = 0; var6 < var5; ++var6) {
                char cellValue = var4[var6];
                if (cellValue == 8226) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean checkLineRow(char symbol) {
        for (int rowIndex = 0; rowIndex < SIZE; rowIndex++) {
            int sumIndexRow = 0;
            for (int colIndex = 1; colIndex < SIZE; colIndex++) {
                if (map[rowIndex][colIndex] == symbol && map[rowIndex][colIndex] == map[rowIndex][colIndex - 1]) {
                    sumIndexRow += 1;
                }
                if (sumIndexRow == HOW_MACH_TO_WIN - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkLineCol(char symbol) {
        for (int colIndex = 0; colIndex < SIZE; colIndex++) {
            int sumIndexCol = 0;
            for (int rowIndex = 1; rowIndex < SIZE; rowIndex++) {
                if (map[rowIndex][colIndex] == symbol && map[rowIndex][colIndex] == map[rowIndex - 1][colIndex]) {
                    sumIndexCol += 1;
                }
                if (sumIndexCol == (HOW_MACH_TO_WIN - 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkDiag(char symbol) {
        int sumIndexDiag = 0;
        for (int rowIndex = 1; rowIndex < SIZE; rowIndex++) {
            for (int colIndex = 1; colIndex < SIZE; colIndex++) {
                if (map[rowIndex][colIndex] == symbol && (map[rowIndex][colIndex] == map[rowIndex - 1][colIndex - 1])) {
                    sumIndexDiag += 1;
                }
                if (sumIndexDiag == (HOW_MACH_TO_WIN - 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkRevDiag(char symbol) {
        int sumIndexRevDiag = 0;
        for (int rowIndex = 1; rowIndex < SIZE; rowIndex++) {
            for (int colIndex = 0; colIndex < SIZE - 1; colIndex++) {
                if (map[rowIndex][colIndex] == symbol && ((rowIndex + colIndex) == (SIZE - 1) || (rowIndex + colIndex) == SIZE || (rowIndex + colIndex) == (SIZE - 2)) && (map[rowIndex][colIndex] == map[rowIndex - 1][colIndex + 1])) {
                    sumIndexRevDiag += 1;
                }
                if (sumIndexRevDiag == (HOW_MACH_TO_WIN - 1)) {
                    return true;
                }
            }
        }
        return false;
    }


    private static boolean checkWin(char symbol) {

        if (checkLineRow(symbol) || checkDiag(symbol) || checkRevDiag(symbol) || checkLineCol(symbol)) {
            return true;
        }
        return false;
    }

    private static void humanTurn() {
        int rowIndex = -1;
        int colIndex = -1;

        do {
            System.out.print("Введите номер строки: ");
            if (!SCANNER.hasNextInt()) {
                SCANNER.nextLine();
                System.out.println("Введите число!");
            } else {
                rowIndex = SCANNER.nextInt() - 1;
                System.out.print("Введите номер столбца: ");
                if (!SCANNER.hasNextInt()) {
                    SCANNER.nextLine();
                    System.out.println("Введите число!");
                } else {
                    colIndex = SCANNER.nextInt() - 1;
                }
            }
        } while (!isCellValid(rowIndex, colIndex, 'X'));

        map[rowIndex][colIndex] = 'X';
    }

    private static boolean AI() {

        for (int rowIndex = 0; rowIndex < SIZE; rowIndex++) {
            for (int colIndex = 0; colIndex < SIZE; colIndex++) {
                if (isCellValid(rowIndex, colIndex, 'O') || isCellValid(rowIndex, colIndex, 'X')) {
                    char dummy = map[rowIndex][colIndex];
                    map[rowIndex][colIndex] = 'X';
                    if (checkWin('X')) {
                        map[rowIndex][colIndex] = 'O';
                        return true;
                    }
                    map[rowIndex][colIndex] = 'O';
                    if (checkWin('O')) {
                        map[rowIndex][colIndex] = 'O';
                        return true;
                    }
                    map[rowIndex][colIndex] = dummy;
                }
            }
        }
        return false;
    }

    private static void computerTurn() {
        int rowIndex = -1;
        int colIndex = -1;
        Random rand = new Random();

        if (AI()) {

        } else {
            do {

                rowIndex = rand.nextInt(SIZE);
                colIndex = rand.nextInt(SIZE);
            } while (!isCellValid(rowIndex, colIndex, 'O'));
            map[rowIndex][colIndex] = 'O';
        }
    }


    private static boolean isCellValid(int rowIndex, int colIndex, char symbol) {
        if (isArrayIndexValid(rowIndex) && isArrayIndexValid(colIndex)) {
            if (map[rowIndex][colIndex] != 8226) {
                if (isHumanTurn(symbol)) {
                    System.out.println("Данная ячейка уже занята!");
                }

                return false;
            } else {
                return true;
            }
        } else {
            System.out.println("Индексы строки и колонки должны быть в диапазоне от 0 до " + SIZE);
            return false;
        }
    }

    private static boolean isHumanTurn(char symbol) {
        return symbol == 'X';
    }

    private static boolean isArrayIndexValid(int index) {
        return index >= 0 && index < SIZE;
    }

    private static void printMap() {
        printHeader();
        printMapState();
        System.out.println();
    }

    private static void printMapState() {
        for (int rowIndex = 0; rowIndex < SIZE; ++rowIndex) {
            System.out.print(rowIndex + 1 + " ");

            for (int colIndex = 0; colIndex < SIZE; ++colIndex) {
                System.out.print(map[rowIndex][colIndex] + " ");
            }

            System.out.println();
        }

    }

    private static void printHeader() {
        for (int i = 0; i <= SIZE; ++i) {
            System.out.print(i + " ");
        }

        System.out.println();
    }

    private static void initializeGame() {
        for (int rowIndex = 0; rowIndex < SIZE; ++rowIndex) {
            for (int colIndex = 0; colIndex < SIZE; ++colIndex) {
                map[rowIndex][colIndex] = 8226;
            }
        }

    }

    static {
        SCANNER = new Scanner(System.in);
    }
}


