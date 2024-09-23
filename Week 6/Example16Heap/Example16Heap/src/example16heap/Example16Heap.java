/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example16heap;

/**
 *
 * @author Yang
 */

import java.util.Scanner;

public class Example16Heap 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);

        Heap myheap = new Heap(100);
        
        // heapsort
        System.out.print("The sorted list: ");
	while (!myheap.isEmpty())		
            System.out.print(myheap.remove() + " ");
        System.out.println();
    }
    
}

/**
 * 
 * Assume all items in the heap are non-negative
 */
class Heap
{
    private int n;
    private int a[];

    public Heap(int size)
    {
        a = new int[size];
	n = 0;                      // initialized with an empty heap
        
        build();                    // build the heap: bottom-up approach
    }

    public void build()
    {
        // Store a set of data items into the array. They will make a heap without any adjustment
        a[0] = 95;
        a[1] = 81;
        a[2] = 72;
        a[3] = 39;
        a[4] = 53;
        a[5] = 71;
        a[6] = 23;
        a[7] = 38;
        a[8] = 34;
        a[9] = 6;
        n = 10;
        
        // In the homework assignment, need to remove the above 11 statements and replace them with your own code that
        // 1) ask the user to enter non-negative intergers (negative to stop)
        // 2) use the entered non-negative integers to build a heap using the algorithm discussed in class
        
    }
    
    public boolean isEmpty()
    {
        return (n == 0);
    }
    
    /**
     * 
     * Remove the root from the heap
     */ 
    public int remove()
    {
        int key = a[0];
        a[0] = a[n-1];
        n --;
        
        downHeap(0);

        return key;
    }

    /**
     * 
     * if node a[i] is smaller than some of its children, 
     * move it down the heap until the heap condition is recovered, or it reaches the leaf 
     */
    public void downHeap(int i)
    {
        int key = a[i];
        
        int ci = maxChild(i);       // index of the larger child of a[i], if exists
        while (ci != -1)            // has not arrived at a leaf node yet
        {
            if (key >= a[ci])       // no less than the bigger child
                break;              // stop down heap adjustment

            a[i] = a[ci];
            i = ci;
            ci = maxChild(i);
        }
        a[i] = key;
    }

    /**
     * 
     * Return the index of the larger child of node a[i]
     * Return -1 if a[i] has no children
     */
    public int maxChild(int i)
    {
        if (2 * i + 1 >= n)                     // no children
            return -1;
        else if (2 * i + 2 >= n)                // no right child
            return 2 * i + 1;
        else if (a[2 * i + 1] >= a[2 * i + 2])	// have two children and left child is larger
            return 2 * i + 1;
        else					// right child is larger
            return 2 * i + 2;
    }
}

