/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package HW3;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * Author: Joseph Johnson
 * Date: 11SEP2024
 * Class: CSC 730
 * Assignment: Homework 3
 */
public class HW3 
{
    public static void main(String[] args) 
    {
        ArrayList<Integer> a = new ArrayList<>();    // to store the user input or the generated keys
        PriorityQueueLinkedList L = new PriorityQueueLinkedList();    // new priority queue for organizing the keys
        Scanner input = new Scanner(System.in);
        int option;
        do
        {
            System.out.println("Select from:\n1. Read keys\n2. Generate keys\n3. Sort\n0. Quit");
            option = input.nextInt();
            int i = 0;
            switch (option)
            {
                case 1:     // allow the user to input the desired keys
                    input = new Scanner(System.in);
                    System.out.print("Enter elements (negative to end): ");
                    int e = 0;
                    e = input.nextInt();
                    
                    while (e != -1)     // loop through the user input until we reach -1
                    {
                        a.add(e);
                        e = input.nextInt();
                    }                        
                    break;
                case 2:    // system will generate the keys
                    input = new Scanner(System.in);
                    System.out.print("Enter the number of keys to generate: ");
                    int n = input.nextInt();
                    Random rand = new Random();
                    for (i = 0; i < n; i++)
                        a.add(rand.nextInt(50));    // random integer: [0,49]
                    break;
                case 3:     // sort the keys into a priority queue
                    if (a.isEmpty()) // the user did not type keys or ask the system to generate them
                    {
                        System.out.println("Nothing to sort. Please read or generate keys and try again.");
                    }
                    else
                    {
                        i = 0;
                        while (i < a.size())
                        {
                            L.enqueue(a.remove(i));    // while there are still keys to process, add them to the priority queue
                        }
                        while(!L.isEmpty())
                        {
                            System.out.print(L.dequeue() + " ");    // once the priority queue is created and sorted, then dequeue the elements and print them
                        }
                        System.out.println();
                    }
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
 * Node in linked list
 */
class Node
{
    int     key;   // key in the node
    Node    next;   // reference to the next node in linked list

    /**
     * 
     * Constructor: create a node with k as its key
     */
    public Node(int k)     
    {
        key = k;
        next = null;        
    }

    /**
    *
    * Return the key from the current node object
    */
    public int getKey()
    {
        return key;
    }

    /**
    *
    * Return the next node for the current node object
    */
    public Node getNext()
    {
        return next;
    }

    /**
    *
    * Set the key for the current node object
    */
    public void setKey(int k)
    {
        key = k;
    }

    /**
    *
    * Associate the current node object with the next node
    */
    public void setNext(Node n)
    {
        next = n;
    }
}

/**
 * 
 * Priority queue linked list: nodes are sorted in non-increasing order
 * Assume: 
 * - Duplicated keys are allowed
 * - All keys are non-negative
 */
class PriorityQueueLinkedList        
{
    private Node head;    // reference to the first node

    /**
     * 
     * Constructor: create an empty priority queue linked list
     */ 
    PriorityQueueLinkedList()
    {
        head = null;
    }
    
    /**
     *
     * This function checks if the priority queue is empty
     */
    public boolean isEmpty()
    {
        return head == null; 
    }

    /**
     * 
     * This function will insert a new key in the priority queue in the correct non-increasing position.
     */
    public void enqueue(int k)
    {
        Node start  = head;
        Node newNode = new Node(k);
        
        if (isEmpty())    // if the queue is empty then make the new node the head
        {
            head = newNode;
        }
        else if (peekFront() < k) // if the new node key is smaller than the current head then set then make the new node the head
        {
            newNode.next = head;
            head = newNode;

        }
        else
        {
            while (start.next != null && start.next.key >= k)    // loop through the nodes until we find the end or the correct location to insert
            {
                start = start.next;
            }
            
            newNode.next = start.next;    // inser the new node in the correct location and adjust links
            start.next = newNode;
        }        
    }

    /**
     * 
     * This function will remove the highest priority item in the queue and return it.
     */
    public int dequeue()
    {
        if (!isEmpty())    // if the priority queue is not empty
        {
            int item = head.key;    // get the key for the head
            if (head.next != null)    //if there is more than one item in the queue
            {
                head = head.next;    // set the head to the next item in the queue
            }
            else
            {
                head = null;    // if there is a single element in the queue then set the head to null
            }
            return item;    // return the key of the highest priority element
        }
        else 
        {
            return -1;    // queue is empty so we return the error code -1
        }
    }
    
    /**
     *
     * This function will return the key for the first element is in the priority queue.
     */
    public int peekFront()
    {
        if (isEmpty())
        {
            return -1;    // queue is empty so we return the error code -1
        }
        return head.key;    // return the key of the head element
    }
    
}
