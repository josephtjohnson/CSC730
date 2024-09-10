/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package HW3;

import java.util.Scanner;

/**
 *
 * @author Johns
 */
public class HW3 
{
    public static void main(String[] args) 
    {

        PriorityQueueLinkedList L = new PriorityQueueLinkedList();
        Scanner input = new Scanner(System.in);
        int option;
        do
        {
            System.out.println("Select from:\n1. Read keys\n2. Generate keys\n3. Sort\n0. Quit");
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
                    arr.sort();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid option!  Try again: ");
            }
            
        } while (option != 0);
        
        System.out.println("Thanks for using my program.");
    }
    
    static void sort()
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
    
}

/**
 * 
 * Node in linked list
 */
class Node
{
    int     key;   // key in the node
    Node    next;   // reference to the next node in linked list

    /**
     * 
     * Constructor: create a node with k as its key, and d as its data 
     */
    public Node(int k)     
    {
        key = k;
        next = null;        
    }

    public int getKey()
    {
        return key;
    }

    public Node getNext()
    {
        return next;
    }

    public void setKey(int k)
    {
        key = k;
    }

    public void setNext(Node n)
    {
        next = n;
    }
}

/**
 * 
 * Linked list: nodes are sorted in increasing order of keys
 * Assume: 
 * - No duplicated keys in linked list
 * - All keys are non-negative
 */
class PriorityQueueLinkedList        
{
    private Node head;          // reference to the first node

    /**
     * 
     * Constructor: create an empty linked list
     */ 
    PriorityQueueLinkedList()        //complete
    {
        head = null;
    }
    
    /**
     * check if the priority queue linked list is empty
     */
    public boolean isEmpty()        //complete
    {
        return head == null; 
    }

    /**
     * 
     * Insert
     */
    public void enqueue(int k)      //complete - I think?
    {
        Node start  = head;
        Node newNode = new Node(k);
        
        if (head == null)
        {
            head = newNode;
        }
        else if (head.key > k)
        {
            newNode.next = head;
            head = newNode;
        }
        else
        {
            while (start.next != null && start.next.key >= k)
            {
                start = start.next;
            }
            
            newNode.next = start.next;
            start.next = newNode;
        }        
    }

    /**
     * 
     * Delete
     */
    public int dequeue(int k)       //complete - I think?
    {
        if (!isEmpty)
        {
            int item = head.key;
            head = head.next;
            return item;
        }
        else 
        {
            return -1;
        }
    }
    
    /**
     * return what the first element is in the priority queue linked list
     */
    public int peekFront()
    {
        return head.key;
    }
    
}
