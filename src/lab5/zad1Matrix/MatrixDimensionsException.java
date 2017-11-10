package lab5.zad1Matrix;

public class MatrixDimensionsException extends Exception {
    public MatrixDimensionsException() {
        super("Matrix dimensions do not match");
    }
}
