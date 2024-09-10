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
        Scanner input = new Scanner(System.in);
        int key;

        PriorityQueueLinkedList L = new PriorityQueueLinkedList();

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
