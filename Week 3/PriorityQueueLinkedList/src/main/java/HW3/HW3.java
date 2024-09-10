/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package HW3;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Johns
 */
public class HW3 
{
    public static void main(String[] args) 
    {
        ArrayList<Integer> a = new ArrayList<>();
        PriorityQueueLinkedList L = new PriorityQueueLinkedList();
        Scanner input = new Scanner(System.in);
        int option;
        do
        {
            System.out.println("Select from:\n1. Read keys\n2. Generate keys\n3. Sort\n0. Quit");
            option = input.nextInt();
            int i = 0;
            switch (option)
            {
                case 1:
                    input = new Scanner(System.in);
                    System.out.print("Enter elements (negative to end): ");
                    int e = 0;
                    e = input.nextInt();
                    
                    while (e != -1)
                    {
                        a.add(e);
                        e = input.nextInt();
                    }                        
                    break;
                case 2:
                    input = new Scanner(System.in);
                    System.out.print("Enter the number of keys to generate: ");
                    int n = input.nextInt();
                    Random rand = new Random();
                    //n = rand.nextInt(a.size() + 1);     // number of elements: [0, a.length]
                    for (i = 0; i < n; i++)
                        a.add(rand.nextInt(50));        // random integer: [0,19]
                    break;
                case 3:
                    if (a.isEmpty())
                    {
                        System.out.println("Nothing to sort. Please read or generate keys and try again.");
                    }
                    else
                    {
                        i = 0;
                        while (i < a.size())
                        {
                            L.enqueue(a.remove(i));                
                        }
                        while(!L.isEmpty())
                        {
                            System.out.print(L.dequeue() + " ");                
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
     * This function checks if the priority queue is empty
     */
    public boolean isEmpty()        //complete
    {
        return head == null; 
    }

    /**
     * 
     * This function will insert a new key in the priority queue in the correct non-increasing position.
     */
    public void enqueue(int k)      //complete - I think?
    {
        Node start  = head;
        Node newNode = new Node(k);
        
        if (isEmpty())
        {
            head = newNode;
        }
        else if (peekFront() < k)
        {
            newNode.next = head;
            head = newNode;
            //should we set head.next equal to null here?
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
     * This function will remove the highest priority item in the queue and return it.
     */
    public int dequeue()       //complete - I think?
    {
        if (!isEmpty())
        {
            int item = head.key;
            if (head.next != null)
            {
                head = head.next;
            }
            else
            {
                head = null;                
            }
            return item;
        }
        else 
        {
            return -1;
        }
    }
    
    /**
     * This function will return what the first element is in the priority queue.
     */
    public int peekFront()
    {
        if (isEmpty())
        {
            return -1;        
        }
        return head.key;
    }
    
}
