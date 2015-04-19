package com.epam.khalii.Task2;

import java.util.*;

/**
 * Created by Anhelina_Khalii on 16.04.2015.
 */
public class Matrix {

    public static void printMatrix(int[] matrix, int size){
        System.out.println();
        for(int row = 0; row<size; row++){
            for(int col=0; col<size;col++) {
                System.out.print(matrix[row*size+col]+" ");
            }
            System.out.println();
        }
    }

    //9.Ввести с консоли n-размерность матрицы a [n] [n]. Задать значения элементов матрицы
    //в интервале значений от -n до n с помощью генератора случайных чисел.
    public static void initializeMatrix(int[] matrix, int size){
        Random r = new Random();
        for (int i = 0; i < size*size; i++)
            matrix[i] = r.nextInt(size*2)-size;
    }

    //Упорядочить строки (столбцы) матрицы в порядке возрастания значений.

    public static void sortRows(int[] matrix, int size){
        for(int row = 0; row<size; row++){
            for(int col=1; col<size;col++) {
                int cur = matrix[row*size+col];
                int j;
                for(j=col-1;j>=0&&matrix[row*size+j]>cur;j--)
                    matrix[row*size+j+1]=matrix[row*size+j]; //Insertion sort =)
                matrix[row*size+j+1] = cur;
            }
        }
    }

    public static void sortCols(int[] matrix, int size){
        for(int col = 0; col<size; col++){
            for(int row=1; row<size;row++) {
                int cur = matrix[row*size+col];
                int j;
                for(j=row-1;j>=0&&matrix[j*size+col]<cur;j--)
                    matrix[(j+1)*size+col]=matrix[j*size+col];
                matrix[(j+1)*size+col] = cur;
            }
        }
    }

    //Выполнить циклический сдвиг заданной матрицы на k позиций вправо(влево, вверх, вниз).

    public static void shiftLeft(int[] matrix, int size, int position){
        for (int pos=0;pos<position;pos++) { //count of repeating
            for(int row=0; row<size;row++){ //single shift for every line, like insertSort
                int temp = matrix[row*size]; //save first element in row
                int col;
                for(col=0;col<size-1;col++){
                    matrix[row*size+col] = matrix[row*size+col+1]; //shift columns to the left
                }
                matrix[row*size+col] = temp; //push first element to the end
            }
        }
    }

    public static void shiftUp(int[] matrix, int size, int position){
        for (int pos=0;pos<position;pos++) {
            for(int col=0; col<size;col++){ //single shift for every line, like insertSort
                int temp = matrix[col]; //save first element in column
                int row;
                for(row=0;row<size-1;row++){
                    matrix[row* size + col] = matrix[(row+1)*size+col]; //shift columns to the left
                }
                matrix[row*size+col] = temp; //push first element to the end
            }
        }
    }

    public static void shiftDown(int[] matrix, int size, int position){
        for (int pos=0;pos<position;pos++) {
            for(int col=0; col<size;col++){ //single shift for every line, like insertSort
                int temp = matrix[size*(size-1)+col]; //save last element in column
                int row;
                for(row=size-1;row>0;row--){
                    matrix[row* size + col] = matrix[(row-1)*size+col]; //shift columns to the left
                }
                matrix[col] = temp; //push first element to the end
            }
        }
    }

    //Найти и вывести наибольшее число возрастающих (убывающих) элементов матрицы, идущих подряд.
    public static void progrDown(int[] matrix){
        int lenth=0;
        int localcounter=1;
        Integer[] result = new Integer[0];
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(matrix[0]);
        for (int i=1;i<matrix.length; i++) {
            if(matrix[i]<matrix[i-1]){
                localcounter++;
                temp.add(matrix[i]);
                if(localcounter>lenth){
                    lenth=localcounter;
                    result=temp.toArray(new Integer[temp.size()]);
                }
            }
            else {
                localcounter=1;
                temp.clear();
                temp.add(matrix[i]);
            }
        }
        System.out.print("Largest progression down is "+lenth+" elements: ");
        for(int i = 0; i<result.length;i++) {
            System.out.print(result[i] +" ");
        }
        System.out.println();
    }

    public static void progrUp(int[] matrix){
        int lenth=0;
        int localcounter=1;
        Integer[] result = new Integer[0];
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(matrix[0]);
        for (int i=1;i<matrix.length; i++) {
            if(matrix[i]>matrix[i-1]){
                localcounter++;
                temp.add(matrix[i]);
                if(localcounter>lenth){
                    lenth=localcounter;
                    result=temp.toArray(new Integer[temp.size()]);
                }
            }
            else {
                localcounter=1;
                temp.clear();
                temp.add(matrix[i]);
            }
        }
        System.out.print("Largest progression up is "+lenth+" elements: ");
        for(int i = 0; i<result.length;i++) {
            System.out.print(result[i] +" ");
        }
        System.out.println();
    }

    //Найти сумму элементов матрицы, расположенных между первым и вторым положительными
    // элементами каждой строки.

    public static void sumBetween(int[] matrix, int size){
        int sum=0;
        for(int row=0;row<size;row++){
            int localsum=0;
            int start=-1, end=-1;
            for(int col=0;col<size;col++){
                if(matrix[row*size+col]>0) {
                    if (start == -1) {
                        start = row * size + col;
                    } else if (end == -1){
                        end=row * size + col;
                    } else {
                        break;
                    }
                }
            }
            if(start!=-1&&end!=-1&&end>start){
                for(int iter = start+1; iter<end;iter++){
                    localsum+=matrix[iter];
             //       System.out.println("element "+matrix[iter] +" in row "+row);
                }
            }
            sum+=localsum;
        }
        System.out.println("Sum of elements between positive in every row is " + sum);
    }

    //9.5. Повернуть матрицу на 90 (180, 270) градусов против часовой стрелки.

    public static int[] rotate90(int[] matrix, int size){
        int[] result = new int[size*size];
        for(int col=0;col<size;col++){
            for (int row=0;row<size;row++){
                result[row*size+col]=matrix[size*(size-col-1)+row];
            }
        }
        return result;
    }

    public static int[] rotate180(int[] matrix, int size){
        int[] result = new int[size*size];
        for(int col=0;col<size;col++){
            for (int row=0;row<size;row++){
                result[row*size+col]=matrix[size*(size-row-1)+(size-col-1)];
            }
        }
        return result;
    }

    public static int[] rotate270(int[] matrix, int size){
        int[] result = new int[size*size];
        for(int col=0;col<size;col++){
            for (int row=0;row<size;row++){
                result[row*size+col]=matrix[size*(col)+(size-row-1)];
            }
        }
        return result;
    }

    //Построить матрицу, вычитая из элементов каждой строки матрицы ее среднее арифметическое.
    public static int[] subArithm(int[] matrix, int size){
        int[] result = new int[size*size];
        for(int col=0;col<size;col++){
            int aver=0;
            for (int row=0;row<size;row++){
                aver+=matrix[row*size+col];
            }
            aver/=size;
            for (int row=0;row<size;row++){
                result[row*size+col] = matrix[row*size+col]/aver;
            }
        }
        return result;
    }


    private static boolean isRowNull(int [] matrix, int rowsize, int colsize, int row){
        for(int col=0;col<colsize;col++)
            if(matrix[row*colsize+col]!=0) return false;
        return true;
    }

    private static boolean isColNull(int [] matrix, int rowsize, int colsize, int col){
        for(int row=0;row<rowsize;row++)
            if(matrix[row*colsize+col]!=0) return false;
        return true;
    }

    //9.7. Уплотнить матрицу, удаляя из нее строки и столбцы, заполненные нулями.

    public static int[][] compactRows(int[] matrix, int rowsize, int colsize){
        int[][] result = new int[3][];
        result[1][0] = rowsize;
        result[2][0] = colsize;
        int[] temp = new int[rowsize*colsize];
        for (int row =0; row<rowsize;row++){
            for(int col =0; col<colsize;col++){
                temp[row*colsize+col] = matrix[row*colsize+col];
            }
        }
        for (int row=0; row<result[1][0];row++){
            if(isRowNull(temp, result[1][0], result[2][0], row)){
                for(int i = row; i<rowsize-1;i++){
                    for(int col=0;col<result[2][0];col++) {
                    temp[i*colsize+col]=temp[(i+1)*colsize+col];
                    }
                }
                result[1][0]--;
            }
        }
        result[0] = new int[result[1][0]*result[2][0]];
        for(int r = 0; r<result[1][0]; r++){
            for(int c = 0; c<result[2][0];c++){
                result[0][r*result[2][0]+c] = temp[r*result[2][0]+c];
            }
        }
        return result;
    }

    public static int[][] compactCols(int[] matrix, int rowsize, int colsize){
        int[][] result = new int[3][];
        result[1][0] = rowsize;
        result[2][0] = colsize;
        int[] temp = new int[rowsize*colsize];
        for (int row =0; row<rowsize;row++){
            for(int col =0; col<colsize;col++){
                temp[row*colsize+col] = matrix[row*colsize+col];
            }
        }
        for (int col=0; col<result[2][0];col++){
            if(isColNull(temp, result[1][0], result[2][0], col)){
                for(int j = col; j<colsize-1;j++){
                    for(int row=0;row<result[1][0];row++) {
                        temp[row*colsize+j]=temp[row*colsize+j+1];
                    }
                }
                result[2][0]--;
            }
        }
        result[0] = new int[result[1][0]*result[2][0]];
        for(int r = 0; r<result[1][0]; r++){
            for(int c = 0; c<result[2][0];c++){
                result[0][r*result[2][0]+c] = temp[r*colsize+c];
            }
        }
        return result;

    }

    //9.8. Преобразовать строки матрицы таким образом, чтобы элементы, равные нулю,
    //располагались после всех остальных.

    public static void zeroInRow(int[] matrix, int size){
        for(int row = 0; row<size; row++){
            for(int col=0; col<size;col++) {
                if(matrix[row*size+col]==0){
                    int j;
                    for(j=col;j<size-1;j++)
                        matrix[row*size+j]=matrix[row*size+j+1];
                    matrix[row*size+j] = 0;
                }
            }
        }
    }

    public static void entryPoint() {
        int size=0;
        System.out.println("Please, tap matrix size");
        Scanner sc = new Scanner(System.in);
        if(sc.hasNextInt()) {
            size = sc.nextInt();
            int[] matrix = new int[size * size];
            initializeMatrix(matrix, size);
            printMatrix(matrix, size);
            progrDown(matrix);
            sumBetween(matrix, size);
            zeroInRow(matrix, size);
            printMatrix(matrix, size);

            int[] result = rotate90(matrix, size);
            printMatrix(result, size);
            result = rotate180(matrix, size);
            printMatrix(result, size);
            result = rotate270(matrix, size);
            printMatrix(result, size);

            printMatrix(matrix, size);
            sortRows(matrix, size);
            printMatrix(matrix, size);
            sortCols(matrix, size);
            printMatrix(matrix, size);
        }
    }
}

/**
 * 9.Ввести с консоли n-размерность матрицы a [n] [n]. Задать значения элементов матрицы
 в интервале значений от -n до n с помощью датчика случайных чисел.
 9.1. Упорядочить строки (столбцы) матрицы в порядке возрастания значений.
 9.2. Выполнить циклический сдвиг заданной матрицы на k позиций вправо(влево, вверх, вниз).
 9.3. Найти и вывести наибольшее число возрастающих (убывающих) элементов матрицы, идущих
 подряд.
 9.4. Найти сумму элементов матрицы, расположенных между первым и вторым положительными
 элементами каждой строки.
 9.5. Повернуть матрицу на 90 (180, 270) градусов против часовой стрелки.
 9.6 Построить матрицу, вычитая из элементов каждой строки матрицы ее среднее арифметическое.
 9.7. Уплотнить матрицу, удаляя из нее строки и столбцы, заполненные нулями.
 9.8. Преобразовать строки матрицы таким образом, чтобы элементы, равные нулю,
 располагались после всех остальных.
 */