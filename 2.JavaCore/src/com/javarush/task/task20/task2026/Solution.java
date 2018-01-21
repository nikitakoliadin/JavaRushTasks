package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };
        byte[][] a3 = new byte[][]{
                {1, 1, 0, 0, 1, 0},
                {1, 1, 0, 0, 1, 0},
                {1, 1, 0, 0, 0, 0},
                {1, 1, 0, 1, 1, 0}
        };

        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");
        int count3 = getRectangleCount(a3);
        System.out.println("count = " + count3 + ". Должно быть 3");
    }

    public static int getRectangleCount(byte[][] a) {
        int count = 0;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length ; j++) {
                if (a[i][j] == 1) {
                    count++;

                    int iCount = i + 1;
                    int iCountDelete = 1;
                    int jCount = j + 1;
                    int jCountDelete = 1;

                    while (true) {
                        if (!(iCount < a.length)) {
                            break;
                        }
                        if (a[iCount][j] != 1) {
                            break;
                        }
                        iCount++;
                        iCountDelete++;
                    }

                    while (true) {
                        if (!(jCount < a[i].length)) {
                            break;
                        }
                        if (a[i][jCount] != 1) {
                            break;
                        }
                        jCount++;
                        jCountDelete++;
                    }

                    for (int k = i; k < i + iCountDelete; k++) {
                        for (int l = j; l < j + jCountDelete; l++) {
                            a[k][l] = 0;
                        }
                    }
                }
            }
        }
        return count;
    }
}
