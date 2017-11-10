package lab5.zad1Matrix;

public class MatrixMain {
    public static void main(String[] args) {
        double[][] a1 = {
                {1, 1, 1},
                {2, 2, 2},
                {3, 3, 3}
        };

        double[][] a2 = {
                {3, 3, 3},
                {0, 0, 1},
                {5, 5, 5}
        };

        double[][] a3 = {
                {3, 3, 3},
                {0, 0, 1},
        };


        try {
            Matrix m1 = new Matrix(a1);
            Matrix m2 = new Matrix(a2);
            Matrix m3 = m1.add(m2);
            m3.print();
            System.out.println();
            Matrix m4 = m1.sub(m2);
            m4.print();

//            throws exception:
//
//            Matrix m5 = new Matrix(a3);
//            Matrix m6 = m1.add(m5);
//            m6.print();
        }
        catch (MatrixDimensionsException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }
}
