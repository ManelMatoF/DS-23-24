package e2;

import java.util.Arrays;

public class ImmutableMatrix {
    private final int[][] matrix;

    public ImmutableMatrix(int[][] arr) {
        int rows = arr.length;
        int[][] copy = new int[rows][];
        int columns = arr[0].length;

        for (int[] ints : arr) {
            if (ints.length != columns)
                throw new IllegalArgumentException("Array is irregular.");
        }

        for (int i = 0; i < rows; i++) {
            copy[i] = Arrays.copyOf(arr[i], arr[i].length);
        }

        matrix = copy;
    }

    public ImmutableMatrix(int rows, int columns) {
        if (rows <= 0 || columns <= 0)
            throw new IllegalArgumentException("Filas y columnas deben ser mayores a 0");

        matrix = new int[rows][columns];

        int val = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                this.matrix[i][j] = val++;
            }
        }
    }

    public int rowCount() {
        return matrix.length;
    }

    public int columnCount() {
        return matrix[0].length;
    }

    public String toString() {
        StringBuilder string_aux = new StringBuilder();

        for (int i = 0; i < rowCount(); i++) {
            string_aux.append("[");
            for (int j = 0; j < columnCount(); j++) {
                string_aux.append(matrix[i][j]);

                if (j < matrix[i].length - 1)
                    string_aux.append(", ");
            }
            if (i < matrix.length - 1)
                string_aux.append("]\n");
        }
        string_aux.append("]\n");
        return string_aux.toString();
    }

    public int at(int row, int column) {
        if (row < 0 || column < 0 || row > rowCount() || column > columnCount())
            throw new IllegalArgumentException("Las coordenadas no son validas");

        return matrix[row][column];
    }

    public int[][] toArray2D() {//PARAMETROS?
        int[][] array2D = new int[rowCount()][columnCount()];

        for (int i = 0; i < rowCount(); i++) {
            for (int j = 0; j < columnCount(); j++) {
                array2D[i][j] = matrix[i][j];
            }
        }
        return array2D;
    }

    public ImmutableMatrix reverse() {
        int[][] reverseMatrix = new int[rowCount()][columnCount()];
        for (int i = 0; i < rowCount(); i++) {
            for (int j = 0; j < columnCount(); j++) {
                reverseMatrix[i][j] = matrix[i][columnCount() - j - 1];
            }
        }
        return new ImmutableMatrix(reverseMatrix);
    }

    public ImmutableMatrix transpose() {
        int[][] transposeMatrix = new int[columnCount()][rowCount()];
        for (int i = 0; i < rowCount(); i++) {
            for (int j = 0; j < columnCount(); j++) {
                transposeMatrix[j][i] = matrix[i][j];
            }
        }
        return new ImmutableMatrix(transposeMatrix);
    }

    public ImmutableMatrix reshape(int newColums) {
        int numElements = rowCount() * columnCount();
        if (numElements % newColums != 0)
            throw new IllegalArgumentException("El numero de columnas no es valido");

        int newRows = numElements / newColums;
        int[][] reshapeMatrix = new int[newRows][newColums];
        for (int i = 0; i < numElements; i++) {
            reshapeMatrix[i / newColums][i % newColums] = matrix[i / columnCount()][i % columnCount()];
        }
        return new ImmutableMatrix(reshapeMatrix);
    }

}


