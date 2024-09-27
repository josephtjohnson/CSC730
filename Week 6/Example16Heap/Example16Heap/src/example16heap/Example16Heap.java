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
	Heap h = new Heap(25);
        Scanner input = new Scanner(System.in);
        int option;
        do
        {
            System.out.println("Select from:\n1. Read items and build heap\n2. Display heap\n3. Insert a node\n4. Remove the largest node\n5. Search for a key\n0. Exit");
            option = input.nextInt();
            switch (option)
            {
                case 1:
                    h.build(); //done I think
                    break;
                case 2:
                    h.print(); //done I think
                    break;
                case 3:
                    h.insert();
                    break;
                case 4:
                    h.remove();
                    break;
	        case 5:
		    h.find();
		    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid option!  Try again: ");
            }
            
        } while (option != 0);
        
        System.out.println("Thanks for using my program.");
                
    }
    
}

/**
 * 
 * Assume all items in the heap are non-negative and distinct
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
        Scanner input = new Scanner(System.in);
        System.out.print("Enter up to 25 elements (negative to end): ");
        
        int i;
        for (i = 0; i < h.length; i++)        // allow at most a.length elements to be stored into the heap
        {
            int e = input.nextInt();
            
            if (e >= 0)
                h[i] = e;                   // store a non-negative number into the array 
            else                        
                break;
        }
        n = i;                              // record the total number of elements that have been stored into the heap

	startIndex = (n / 2) - 1;

	for (int i = startIndex; i >= 0; i--)
	     heapify(startIndex);
    }

    public void heapify(int i)
    {
	int largest = i;
	int left = 2 * i + 1;
	int right = 2 * i + 2;

	if (l < n && h[left] > h[largest])
	     largest = l;
	if (r < n && h[right] > h[largest])
	     largest = r;

    	if (largest != i)
	{
	     int temp = h[i];
	     h[i] = h[largest];
	     h[largest] = swap;

	     heapify(largest);
	}
    }

    public void print()
    {
	System.out.println("Heap:");
	for (int i = 0; i < n; i++)
	{
	     for (int j = 0; j < Math.pow(2,i) && j + Math.pow(2,i) < n; j++)
	     {
	          System.out.print(h[j+(int)Math.pow(2,i)-1];
	     }
	     System.out.println();
	}
    }

    public void insert(int i)
	{
		Scanner input = new Scanner(System.in);
        	System.out.print("Enter a non-negative integer to be inserted (negative to end): ");
		
		if (h.length) < n)
		{
			h[n] = i;
		}
		int i = n;
		while (i > 0)
		{
			int parentIndex = (i-1)/2
			if (h[n] > h[parent])
			{
			
				int temp = h[parent];
				h[parent] - h[n];
				h[n] = temp;
				i = parentIndex;
			}
		}
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

	public void findKey(int k)
	{
		
	}
}

