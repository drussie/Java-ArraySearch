package Assignment1;

/* Problem #3, Assignment 1.
Purpose/Description: A sub-linear running time complexity method
that determines whether a given integer is in an array.

Panther ID: 

Certification: I hereby certify that this work is my own,
 and none of it is the work of any other person.
 */

import java.util.Scanner;

public class ArraySearch {
    public static boolean arraySearch(int[] array, int maxIndex, int searchInt) {
       int low = 0, highLeft = maxIndex, highRight = array.length - 1;
// if integer you're looking for is the largest Value
        if (array[maxIndex] == searchInt) {
            return true;
        }

        // run binary search on the left side of the array
        else {
            while (low <= highLeft) {
                int mid = (low + highLeft) /2;
                if (array[mid] < searchInt) {
                    low = mid + 1;
                }
                else if (array[mid] > searchInt) {
                    highLeft = mid - 1;
                }
                else {
                    return true;
                }
            }

            // run binary search on the right side of the array
            while (highLeft <= highRight) {
                int mid = (highLeft + highRight) / 2;
                if (array[mid] > searchInt) {
                    highLeft = mid + 1;
                }
                else if (array[mid] < searchInt) {
                    highRight = mid - 1;
                }
                else {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int maxIndex = 0;
        int maxNumber = 0;
        Scanner scnr = new Scanner(System.in);

        int[] array = { 1, 3, 4, 5, 7, 14, 11, 7, 2, -4, -8};
        System.out.print("Array 1 = {");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
            if (array[i] > maxNumber) {
                maxIndex = i;
                maxNumber = array[i];
            }
        }
        System.out.println("}");
        System.out.println("What number would you like to search for in Array 1:");
        int searchInt = scnr.nextInt();
        System.out.print("Your searched number exists in the Array: ");
        System.out.print(arraySearch(array, maxIndex, searchInt));

        System.out.println("\n**********************************");

        scnr.nextLine();

        int[] array2 = { -9, -3, 1, 5, 11, 21, 11, 5, 2, -4, -8};
        System.out.print("Array 2 = {");
        for (int i = 0; i < array2.length; i++) {
            System.out.print(array2[i] + ", ");
            if (array[i] > maxNumber) {
                maxIndex = i;
                maxNumber = array2[i];
            }
        }
        System.out.println("}");
        System.out.println("What number would you like to search for in Array 2;");
        searchInt = scnr.nextInt();
        System.out.print("Your searched number exists in the Array: ");
        System.out.print(arraySearch(array2, maxIndex, searchInt));
    }
}
