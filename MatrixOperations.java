import java.util.Random;  

public class MatrixOperations {  

    public static void main(String[] args) {  
        int rowsA = 2, colsA = 2, rowsB = 2, colsB = 2;  
        int[][] A = createRandomMatrix(rowsA, colsA);  
        int[][] B = createRandomMatrix(rowsB, colsB);  
        
        System.out.println("Matrix A:");  
        displayMatrix(A);  
        
        System.out.println("Matrix B:");  
        displayMatrix(B);  
        
        System.out.println("A + B:");  
        displayMatrix(addMatrices(A, B));  
        
        System.out.println("A - B:");  
        displayMatrix(subtractMatrices(A, B));  
        
        System.out.println("A * B:");  
        displayMatrix(multiplyMatrices(A, B));  
        
        System.out.println("Transpose of A:");  
        displayMatrix(transposeMatrix(A));  
        
        System.out.println("Determinant of A:");  
        System.out.println(determinant2x2(A));  
        
        System.out.println("Determinant of B:");  
        System.out.println(determinant2x2(B));  
        
        int[][] C = createRandomMatrix(3, 3);  
        System.out.println("Matrix C:");  
        displayMatrix(C);  
        System.out.println("Determinant of C:");  
        System.out.println(determinant3x3(C));  

        System.out.println("Inverse of A:");  
        displayMatrix(inverse2x2(A));  
        
        System.out.println("Inverse of C:");  
        displayMatrix(inverse3x3(C));  
    }  

    public static int[][] createRandomMatrix(int rows, int cols) {  
        Random rand = new Random();  
        int[][] matrix = new int[rows][cols];  
        for (int i = 0; i < rows; i++) {  
            for (int j = 0; j < cols; j++) {  
                matrix[i][j] = rand.nextInt(10);  
            }  
        }  
        return matrix;  
    }  

    public static int[][] addMatrices(int[][] A, int[][] B) {  
        int[][] result = new int[A.length][A[0].length];  
        for (int i = 0; i < A.length; i++) {  
            for (int j = 0; j < A[0].length; j++) {  
                result[i][j] = A[i][j] + B[i][j];  
            }  
        }  
        return result;  
    }  

    public static int[][] subtractMatrices(int[][] A, int[][] B) {  
        int[][] result = new int[A.length][A[0].length];  
        for (int i = 0; i < A.length; i++) {  
            for (int j = 0; j < A[0].length; j++) {  
                result[i][j] = A[i][j] - B[i][j];  
            }  
        }  
        return result;  
    }  

    public static int[][] multiplyMatrices(int[][] A, int[][] B) {  
        int[][] result = new int[A.length][B[0].length];  
        for (int i = 0; i < A.length; i++) {  
            for (int j = 0; j < B[0].length; j++) {  
                for (int k = 0; k < A[0].length; k++) {  
                    result[i][j] += A[i][k] * B[k][j];  
                }  
            }  
        }  
        return result;  
    }  

    public static int[][] transposeMatrix(int[][] M) {  
        int[][] result = new int[M[0].length][M.length];  
        for (int i = 0; i < M.length; i++) {  
            for (int j = 0; j < M[0].length; j++) {  
                result[j][i] = M[i][j];  
            }  
        }  
        return result;  
    }  

    public static int determinant2x2(int[][] M) {  
        return M[0][0] * M[1][1] - M[0][1] * M[1][0];  
    }  

    public static int determinant3x3(int[][] M) {  
        return M[0][0] * (M[1][1] * M[2][2] - M[1][2] * M[2][1])   
            - M[0][1] * (M[1][0] * M[2][2] - M[1][2] * M[2][0])   
            + M[0][2] * (M[1][0] * M[2][1] - M[1][1] * M[2][0]);  
    }  

    public static int[][] inverse2x2(int[][] M) {  
        int det = determinant2x2(M);  
        if (det == 0) return null;  
        return new int[][]{{M[1][1] / det, -M[0][1] / det}, {-M[1][0] / det, M[0][0] / det}};  
    }  

    public static int[][] inverse3x3(int[][] M) {  
        int det = determinant3x3(M);  
        if (det == 0) return null;  
        return new int[][] {  
            {(M[1][1] * M[2][2] - M[1][2] * M[2][1]) / det,  
             (M[0][2] * M[2][1] - M[0][1] * M[2][2]) / det,  
             (M[0][1] * M[1][2] - M[0][2] * M[1][1]) / det},  
             
            {(M[1][2] * M[2][0] - M[1][0] * M[2][2]) / det,  
             (M[0][0] * M[2][2] - M[0][2] * M[2][0]) / det,  
             (M[0][2] * M[1][0] - M[0][0] * M[1][2]) / det},  
             
            {(M[1][0] * M[2][1] - M[1][1] * M[2][0]) / det,  
             (M[0][1] * M[2][0] - M[0][0] * M[2][1]) / det,  
             (M[0][0] * M[1][1] - M[0][1] * M[1][0]) / det}  
        };  
    }  

    public static void displayMatrix(int[][] M) {  
        for (int[] row : M) {  
            for (int val : row) {  
                System.out.print(val + " ");  
            }  
            System.out.println();  
        }  
    }  
}
