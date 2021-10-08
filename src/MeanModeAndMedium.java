import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MeanModeAndMedium {
    static int[][] sortArray(int array [][]){
        int [] temp;
        temp = new int[2];
        for (int i = 0; i < array.length; i++){
            for (int i2 = i + 1; i2 < array.length; i2++)
            if (array[i][1] < array[i2][1]){
               temp = array[i2];
               array[i2] = array[i];
               array[i] = temp;
            }
        }
        return array;
    }
     public static void main(String [] args) {
        // set up the variables
        Scanner keybd = new Scanner(System.in);
        Random number = new Random();
        int[] array1;
        int[] sortArray;
        int[][] twoDArray;
        int size, min = 0, max = 10, arrayHold = 0;
        double total = 0, middleTotal, mean, median;

        // Prompt the user for the array size
        System.out.print("Enter the size of your array: ");
        size = keybd.nextInt();

        // Create the array and a copy to sort
        array1 = new int[size];
        sortArray = new int[size];

        // assign random numbers to the array between 0 and 10
        for (int i = 0; i < size; i++) {
            array1[i] = number.nextInt((max - min) + 1) + min;
        }

        // copy the array
        System.arraycopy(array1, 0, sortArray, 0, array1.length);

        // sort sortArray;
        Arrays.sort(sortArray);

        // Since sortArray is in order, the medium is easier to calculate

        if ((sortArray.length % 2) == 0) {
            middleTotal = (sortArray[(sortArray.length / 2) - 1] +
                    sortArray[(sortArray.length / 2)]);
            median = middleTotal / 2;
        } else {
            median = (sortArray[sortArray.length / 2]);
        }

        // print out the array for testing
        // /*
        for (int array : sortArray){
            System.out.printf("%d ", array);
        }
        System.out.println();
        // */

         // Create a 2d array with the number of times the cell occurs
         // move the first cell to the first element
         twoDArray = new int[size][2];
         twoDArray[arrayHold][0] = sortArray[0];
         twoDArray[arrayHold][1] = 1;
         arrayHold = 1;
         // since the array is starting at 1, add the array[0] to total
         total += sortArray[0];
         for (int i = 1; i < sortArray.length; i++) {
            total += sortArray[i];
            if (sortArray[i] == twoDArray[arrayHold-1][0]){
                twoDArray[arrayHold-1][1] += 1;
            } else {
                twoDArray[arrayHold][0] = sortArray[i];
                twoDArray[arrayHold][1] = 1;
                arrayHold ++;
            }
        }

         // Print 2D array for testing;
         /*
         sortArray(twoDArray);
         for (int i = 0; i < twoDArray.length; i++){
            for (int i2 = 0; i2 < 2; i2++){
                System.out.printf("%d  ", twoDArray[i][i2]);
            }
         }
         System.out.println();
         */
         // mode = 0;

         mean = total / size;
         System.out.printf("Mean: %.2f  Mode(s): ", mean);
         System.out.printf("%d", twoDArray[0][0]);
         for (int i = 1; i < sortArray.length; i++){
             if (twoDArray[i][1] == twoDArray[i-1][1] )
                 System.out.printf(" and %d", twoDArray[i][0]);
              else
                 i = sortArray.length;
         }
         System.out.printf(" Median: %.1f\n", median);
    }
}
