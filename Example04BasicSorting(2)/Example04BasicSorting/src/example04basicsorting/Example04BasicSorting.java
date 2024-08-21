/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example04basicsorting;

/**
 *
 * @author Yang
 */

/**
 * 
 * Implement basic sorting algorithms
 * Assumptions:
 * - All elements in the array are non-negative
 */

import java.util.Scanner;
import java.util.Random;

public class Example04BasicSorting 
{
    public static void main(String[] args)
    {
        int arrSize = 100;                      // size of the array
        MyArray arr = new MyArray(arrSize);
        
        Scanner input = new Scanner(System.in);
        int option;
        do
        {
            System.out.println("Select from:\n1. Read Array\n2. Generate Array\n3. Print Array\n4. Sort\n0. Quit");
            option = input.nextInt();
            switch (option)
            {
                case 1:
                    arr.read();
                    break;
                case 2:
                    arr.randGenerate();
                    break;
                case 3:
                    arr.display();
                    break;
                case 4:
                    sortArray(arr);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid option!  Try again: ");
            }
            
        } while (option != 0);
        
        System.out.println("Thanks for using my program.");
    }
    
    static void sortArray(MyArray ar)
    {
        Scanner input = new Scanner(System.in);
        int sortOption;
        do
        {
            System.out.println("Select from:\n1. Bubble sort\n2. Selection sort\n3. Insertion sort\n0. Quit");
            sortOption = input.nextInt();
            switch (sortOption)
            {
                case 1:
                    ar.bubbleSort();
                    break;
                case 2:
                    ar.selectionSort();
                    break;
                case 3:
                    ar.insertionSort();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid sort option!  Try again: ");
            }
        } while (sortOption != 0);
    }
}

/**
 * 
 * MyArray class that includes basic sorting algorithms implemented
 */
class MyArray
{
    private int a[];            // a: reference to an array
    private int n;              // number of elements that are currently in the array
    
    /**
     *
     * Constructor: create an array with the specified size and 0 element
     */
    public MyArray(int size)
    {
        a = new int[size];
        n = 0;
    }
    
    /**
     * 
     * Read elements from user input into the array until a negative number is entered
     */ 
    public void read()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter elements (negative to end): ");
        
        int i;
        for (i = 0; i < a.length; i++)        // allow at most a.length elements to be stored into the array
        {
            int e = input.nextInt();
            
            if (e >= 0)
                a[i] = e;                   // store a non-negative number into the array 
            else                        
                break;
        }
        n = i;                              // record the total number of elements that have been stored into the array
        
    }
    
    /**
     * 
     * Randomly generate non-negative numbers and store them into the array
     */
    void randGenerate()
    {
        Random rand = new Random();
        
        n = rand.nextInt(a.length + 1);     // number of elements: [0, a.length]
        for (int i = 0; i < n; i++)
            a[i] = rand.nextInt(20);        // random integer: [0,19]
    }
    
    /**
     * 
     * Display all elements that are currently in the array
     */
    public void display()
    {
        for(int i = 0; i < n; i++)
            System.out.print(a[i] + " ");
        
        System.out.println();
    }
    
    /**
     * 
     * Use bubble sort algorithm to sort elements in non-decreasing order
     */
    public void bubbleSort()
    {
        //boolean swapped = false;                // false: no swap happened during the current round
        int min = 0;
        int i,j,k = 0;
        //outer loop controls traversing the array
        for (i = 0; i < n; i++)
        {
            //inner loop #1 controls what the minimum value is
            for (j = i; j < n; j++)
            {
                if (a[j] < a[min])
                {
                    min = a[j];
                }
            }
            // inner loop #2 controls moving the smallest value to the beginning
            for (k = min-1; k > i; k--)
            {
                int temp = a[k];
                a[k] = a[min];
                a[min] = temp;
            }
        }


    }

       /* 
        for (int i = n - 1; i > 1; i --)             
        {   // move the smallest element among a[0] ~ a[i] into a[i] by swapping
            
            for (int j = 0; j < i; j++)         // swap A[j] and A[j+1], if necessary
            {
                if (a[j] > a[j + 1])
                {
                    int t = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = t;
                    swapped = true;
                }
            }
            
            if (!swapped)                       // already sorted
                break;
            
            swapped = false;
        }
        *\
    }
    
    /**
     * 
     * Use selection sort algorithm to sort elements in non-decreasing order
     */
    public void selectionSort()
    {
        for (int i = 0; i < n; i ++)        
        {   // find the smallest element among a[i] ~ a[n-1] and then swap it with a[i]
            
            int idxMin = i;                     // idxMin: index of the minimum element among a[i] ~ a[n-1]
            for (int j = i + 1; j < n; j ++)
            {
                if (a[j] < a[idxMin])           // a smaller element, a[j], is found
                    idxMin = j;
            }
            
            // swap a[i] with a[idxMin]
            int t = a[i];
            a[i] = a[idxMin];
            a[idxMin] = t;
        }
    }
    
    /**
     * 
     * Use insertion sort algorithm to sort elements into non-decreasing order
     */
    public void insertionSort()
    {
        for (int i=1; i < n; i++)           
        {   // insert a[i] into a[0] ~ a[i-1] so that a[0] ~ a[i] become sorted
            
            int t = a[i];
            int j;
            for (j = i - 1; j >= 0; j --)
            {
                if (t < a[j])
                    a[j+1] = a[j];
                else
                    break;
            }
            a[j + 1] = t;
        }
    }
    
    /**
     * 
     * Practice problem 1:
     * Write a function to remove duplicate from the array
     * For example, if the array contains 8 5 12 15 7 3 8 15 30 15
     * After calling the function, the array will become 3 5 7 8 12 15 30
     */
    public void removeDuplicate()
    {
        insertionSort();
        int j,i;
        i = j = 0;
        for (i = 1; i < a.length; i++)
        {
            if (a[j] != a[i])
            {
                j++;
            }
            else
            {
                a[i] = a[i+1];
            }
        }
    }
    
}
