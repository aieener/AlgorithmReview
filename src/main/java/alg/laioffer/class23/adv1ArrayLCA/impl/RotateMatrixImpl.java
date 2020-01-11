package alg.laioffer.class23.adv1ArrayLCA.impl;

import alg.laioffer.class23.adv1ArrayLCA.RotateMatrix;

import java.util.function.Consumer;

public class RotateMatrixImpl implements RotateMatrix {
    static class Point {
        int row, col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    @Override
    public void rotate(int[][] matrix) {
        if (matrix == null) return;
        rotate(matrix, matrix.length);
    }

    private void rotate(int[][] matrix, int level) {
        if (level <= 1) return;
        int curLen = level - 1;
        int leftTop = (matrix.length - level) / 2;
        for (int delta = 0; delta < curLen; delta++) {
            int min = leftTop;
            int max = leftTop + curLen;
            Point first = new Point(min, min + delta); // row fix, col++
            Point second = new Point(min + delta, max); // col fix, row++
            Point third = new Point(max, max - delta); // row fix, col--
            Point forth = new Point(max - delta, min); // col fix, row--

            int buf = matrix[first.row][first.col];
            matrix[first.row][first.col] = matrix[forth.row][forth.col];
            matrix[forth.row][forth.col] = matrix[third.row][third.col];
            matrix[third.row][third.col] = matrix[second.row][second.col];
            matrix[second.row][second.col] = buf;
        }
        rotate(matrix, level - 2);
    }

    public static void main(String[] args) {

        Consumer<String> consumer1 = (arg) -> {
            System.out.println(arg + "OK");
        };
        consumer1.accept("TestConsumerAccept - ");
        Consumer<String> consumer2 = (x) -> {
            System.out.println(x + "OK!!!");
        };
        consumer1.andThen(consumer2).accept("TestConsumerAfterThen - ");

    }
}
