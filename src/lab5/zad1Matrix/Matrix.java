package lab5.zad1Matrix;

import javafx.util.Pair;

import java.util.Vector;

public class Matrix {
    Vector<Vector<Double>> contents;
    int rows;
    int cols;

    public Matrix() {
        rows = 0;
        cols = 0;
    }

    public Matrix(double[][] array) throws Exception {
        contents = new Vector<>();
        contents.setSize(array.length);
        for (int i = 0; i < array.length; i++) {
            contents.set(i, new Vector<>());
            contents.get(i).setSize(array[i].length);
            for (int j = 0; j < array[i].length; j++) {
                contents.get(i).set(j, array[i][j]);
            }
        }
        setMatrixSize();
    }

    private void setMatrixSize() {
        rows = contents.size();
        cols = contents.get(0).size();
    }

    public Matrix add(Matrix m2) throws MatrixDimensionsException{
        if(!(rows == m2.rows && cols == m2.cols))
            throw new MatrixDimensionsException();
        Matrix result = new Matrix();
        result.contents = new Vector<>();
        result.contents.setSize(rows);
        for(int i = 0; i < rows; i++) {
            result.contents.set(i, new Vector<>());
            for(int j = 0; j < cols; j++) {
                double element = contents.get(i).get(j) + m2.contents.get(i).get(j);
                result.contents.get(i).add(element);
            }
        }
        result.setMatrixSize();
        return result;
    }

    public Matrix sub(Matrix m2) throws MatrixDimensionsException{
        if(!(rows == m2.rows && cols == m2.cols))
            throw new MatrixDimensionsException();
        Matrix result = new Matrix();
        result.contents = new Vector<>();
        result.contents.setSize(rows);
        for(int i = 0; i < rows; i++) {
            result.contents.set(i, new Vector<>());
            for(int j = 0; j < cols; j++) {
                double element = contents.get(i).get(j) - m2.contents.get(i).get(j);
                result.contents.get(i).add(element);
            }
        }
        result.setMatrixSize();
        return result;
    }
    
    public void print() {
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                System.out.print(contents.get(i).get(j) + ", ");
            }
            System.out.print("\n");
        }
    }
}
