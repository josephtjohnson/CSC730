/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example01unsortedarray;

/**
 *
 * @author Yang
 */

/**
 *
 * Demonstrate basic operations of an unsorted array
 * Assumption:
 *   - The array is unsorted
 *   - All elements in the array are distinct (no duplicated elements exist)
 */

public class Example01UnsortedArray 
{
    public static void main(String[] args)
    {
        int size = 10;              // size of the array
        int a[] = new int[size];    // make an array with the specified size
        int n = 0;                  // number of elements that are currently in the array
        
        // Sequentially insert 6 elements
        a[0] = 44;
        a[1] = 55;
        a[2] = 22;
        a[3] = 11;
        a[4] = 66;
        a[5] = 33;
        n = 6;
        
        // Display all elements that are currently in the array
        int i;
        for(i = 0; i < n; i ++)
            System.out.print(a[i] + " ");
        System.out.println();
        
        // Search for a given key 66 
        int key = 66;
        for(i = 0; i < n; i++)
            if(a[i] == key) break;    // exit the loop if key is found
        
        if(i == n)                      // key was not found in the array
            System.out.println(key + " cannot be found.");
        else
            System.out.println(key + " is found at index: " + i);
        
        // Search for a given key 18 
        key = 18;
        for(i = 0; i < n; i++)
            if(a[i] == key) break;    // exit the loop if key is found
        
        if(i == n)                      // key was not found in the array
            System.out.println(key + " cannot be found.");
        else
            System.out.println(key + " is found at index: " + i);
        
        // Delete a given key 11
        key = 11;
        for(i = 0; i < n; i++)
            if(a[i] == key)   break;
        
        if(i == n)                      // key was not found in the array
            System.out.println(key + " cannot be found. Deletion failed!");
        else
        {
            // shift a[i+1] ~ a[n-1] left for one position
            for(int j = i+1; j < n; j++)
                a[j-1] = a[j];

            n--;
        }
        
        // Display all elements that are currently in the array
        for(i = 0; i < n; i ++) // display items
            System.out.print(a[i] + " ");
        System.out.println();
        
        /**
         * 
         * Practice problem 1:
         * Write statements to insert 200 as the 6th element in the array
         */
        //verify we won't go beyond the size of the array
        if (n < a.length)
        {
            //insert 200 into position 5 in the array
            //5th index position would be the 6th element in the array due to zero-based indexing
            a[5] = 200; 
            //increment the size of the array
            n++; 
        }
        //print all elements in the array to verify correct insertion
        for(i = 0; i < n; i++)
            System.out.print(a[i] + " ");
        System.out.println();
        
        
        /**
         * 
         * Practice problem 2:
         * Write statements to insert 100 into the array so that it becomes the 1st element
         */
        //verify we won't go beyond the size of the array
        if (n+1 <= a.length)
        {
            //loop through the array beginning at the last element
            for(int j = n; j > 0; j--)
                //move the current element to the right one position
                a[j] = a[j-1];
            //insert 100 into the first position in the array
            a[0] = 100;
            //increment the size of the array
            n++;
        }
        //print all elements in the array to verify correct insertion
        for(i = 0; i < n; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }
}
