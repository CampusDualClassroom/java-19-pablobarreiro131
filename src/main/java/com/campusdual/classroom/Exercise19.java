package com.campusdual.classroom;

public class Exercise19 {

    private static String getTridimensionalString(int[][][] intArrayTri, int[][] flatMatrix) {

        int rows = intArrayTri[0].length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            sb.append(stringFlatMatrixRow(flatMatrix, i));
            sb.append("   →   ");
            sb.append(stringTriMatrixRow(intArrayTri, i));
            sb.append("\n");
        }
        sb.delete(sb.length()-1, sb.length());
        return sb.toString();

    }

    private static String stringTriMatrixRow(int[][][] intArrayTri, int row) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < intArrayTri.length-1; i++){
            sb.append(getUnidimensionalString(intArrayTri[i][row]));
            sb.append("   ");
        }
        sb.append(getUnidimensionalString(intArrayTri[intArrayTri.length-1][row]));

        return sb.toString();
    }

    private static String stringFlatMatrixRow(int[][] flatMatrix, int row) {
        return getUnidimensionalString(flatMatrix[row]);
    }

    public static String getTridimensionalString(int[][][] intArrayTri) {
        int[][] flatMatrix = flatTridimensionalArray(intArrayTri);
        return getTridimensionalString(intArrayTri, flatMatrix);
    }

    //TODO
    public static int[][] flatTridimensionalArray(int[][][] intArrayTri) {
        int [][] array = new int[intArrayTri.length][intArrayTri[0].length];
        for (int i = 0; i<intArrayTri[0][0].length; i++){
            for (int j  = 0; j<intArrayTri[0].length; j++){
                for (int k = 0; k<intArrayTri.length; k++){
                    array[i][j] += intArrayTri[k][i][j];
                }
            }
        }
        return array;
    }


    // TODO
    public static String getBidimensionalString(int[][] intArrayBi) {
        int cont = 0;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i<intArrayBi[0].length; i++){
            builder.append(stringFlatMatrixRow(intArrayBi, i));
            if (i<intArrayBi[0].length-1){
                builder.append("\n");
            }
        }
        return builder.toString();
    }

    // TODO
    public static String getUnidimensionalString(int[] uniArray) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i<uniArray.length; i++){
            if (i < uniArray.length-1){
                builder.append(uniArray[i]).append(" ");
            } else builder.append(uniArray[i]);
        }
        return builder.toString();
    }

    // TODO
    public static int[] createAndPopulateUnidimensionalArray(int columns) {
        int[] array = new int[columns];
        for (int i = 0; i< array.length; i++ ){
            array[i] = i + 1;
        }
        return array;
    }

    // TODO
    public static int[][] createAndPopulateBidimensionalArray(int rows, int columns) {
        int [][] array = new int [rows][columns];
        int cont = 1;
        for (int i = 0; i<rows; i++){
            for (int j = 0; j<columns; j++){
                array[i][j] = cont;
                cont ++;
            }
        }
        return array;
    }

    // TODO
    public static int[][][] createAndPopulateTridimensionalArray(int depth, int rows, int columns) {
        int [][][] array = new int [depth][rows][columns];
        int cont = 1;
        for (int i = 0; i<array.length; i++){
            for (int j = 0; j<array[0].length; j++){
                for (int k = 0; k<array[0][0].length; k++){
                    array[i][j][k] = cont;
                    cont++;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] uniArray = createAndPopulateUnidimensionalArray(5);
        System.out.println(getUnidimensionalString(uniArray));
        System.out.println("===================");
        int[][] intArrayBi = createAndPopulateBidimensionalArray(5, 5);
        System.out.println(getBidimensionalString(intArrayBi));
        System.out.println("===================");
        int[][][] intArrayTri = createAndPopulateTridimensionalArray(3, 3, 3);
        System.out.println(getTridimensionalString(intArrayTri));
    }
}
