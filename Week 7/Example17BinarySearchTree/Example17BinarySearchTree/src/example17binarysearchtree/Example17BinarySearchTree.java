/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example17binarysearchtree;

/**
 *
 * @author Yang
 */

import java.util.Scanner;

public class Example17BinarySearchTree 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);

        BinarySearchTree bst = new BinarySearchTree();

        System.out.print("Enter keys (negative to stop): ");
        int key = input.nextInt();
        while (key >= 0)
        {
            bst.insert(key);
            key = input.nextInt();
        }
        
        int option;
        do
        {
            System.out.println("\nChoose from the follow options:");
            System.out.println("1. Traversal");
            System.out.println("2. Search");
            System.out.println("3. Insert node");
            System.out.println("4. Remove node");
            System.out.println("0. Exit");

            option = input.nextInt();
            switch(option)
            {
                case 1:
                    System.out.print("Traversal (0-preorder, 1-inorder, 2-postorder): ");                    
                    bst.traverse(input.nextInt());
                    System.out.println();
                    break;
                case 2:
                    System.out.print("Enter the key to be searched for: ");
                    System.out.println(bst.search(input.nextInt()));
                    break;
                case 3:
                    System.out.print("Enter the key to be inserted:");
                    bst.insert(input.nextInt());
                    break;
                case 4:
                    System.out.print("Enter the key to be removed: ");
                    bst.remove(input.nextInt());
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        } while (option != 0);
        System.out.println("Thanks for using my program.");

    }
}

/**
 * 
 * Tree node
 */
class TreeNode
{
    int data;               
    TreeNode left, right;

    TreeNode(int d)
    {
        data = d;
        left = right = null;
    }
}

/**
 * 
 * Binary search tree 
 * Assume:
 * 1) data in every node is non-negative
 * 2) all data are distinct
 */
class BinarySearchTree
{
    private TreeNode root;		// reference to the root of the binary search tree

    /**
     * 
     * Create an empty binary search tree
     */
    public BinarySearchTree()
    {
        root = null;
    }
    
    /**
     * 
     * Return true if the binary search tree is empty 
     */
    public boolean isEmpty( )
    {
        return root == null;
    }

    /**
     * 
     * Traverse the binary search tree using depth-first traversal 
     * with different methods: preorder, inorder and postorder 
     * 
     * Parameter flag: 0-preorder	1-inorder	2-postorder
     */
    public void traverse(int flag)	
    {
        switch(flag)
        {
            case 0:
                preorder(root);
                break;
            case 1:
                inorder(root);
                break;
            case 2:
                postorder(root);
                break;
            default:
                System.out.println("Invalid option.");
        }
    }

    /**
     * 
     * Traverse the binary search tree using preoder traversal 
     * Parameter r: root of the subtree to be traversed
     */
    public void preorder(TreeNode r)
    {
	if (r == null)
            return;
		
        System.out.print(r.data + " ");
        preorder(r.left);
        preorder(r.right);
    }

    /**
     * 
     * Traverse the binary search tree using inoder traversal 
     * Parameter r: root of the subtree to be traversed
     */
    public void inorder(TreeNode r)
    {
        if (r == null)
            return;
        
        inorder(r.left);
        System.out.print(r.data + " ");
        inorder(r.right);
    }

    /**
     * 
     * Traverse the binary search tree using postoder traversal 
     * Parameter r: root of the subtree to be traversed
     */
    public void postorder(TreeNode r)
    {
	if (r == null)
            return;
        
        postorder(r.left);
        postorder(r.right);
        System.out.print(r.data + " ");
    }
	
    /**
     * 
     * Insert data d as a new node into the binary search tree
     */
    public void insert(int d)
    {
        root = insert(root, d);
    }

    /**
     * 
     * Recursive helper function
     * Insert data d as a new node into the subtree rooted at r
     */
    public TreeNode insert(TreeNode r, int d)
    {
        if (r == null)
            r = new TreeNode(d);
        else if (d < r.data)
            r.left = insert(r.left, d);
        else
            r.right = insert(r.right, d);

        return r;
    }

    /**
     * 
     * Search for the given key in the binary search tree
     * Return true if the key is found
     */
    public boolean search(int key)
    {
        return search(root, key);
    }

    /**
     * 
     * Recursive helper function
     * Search for the given key in the subtree rooted at r
     */
    public boolean search(TreeNode r, int key)
    {
        if  (r == null)
            return false;
	else if  (key  <  r.data)              // key is less than the root, go left
            return search( r.left , key) ;
       	else if  (key  >  r.data)              // key is greater than the root, go right
            return search( r.right , key  ) ;
        else
            return true;
    }
    
    /**
     * 
     * Remove the given data d from the binary search tree
     */
    public void remove (int d)
    {
        root = remove(d, root);
    }

    /**
     * 
     * Recursive helper function
     * Remove the given data d from the subtree rooted at r
     */
    public TreeNode remove(int d, TreeNode r )
    {
        if( r == null )
        {
            System.out.println(d + " cannot be found in the tree");
            return null;
        }
        if( d < r.data )
            r.left = remove( d, r.left );
        else if( d > r.data )
            r.right = remove( d, r.right );
        else if( r.left != null && r.right != null ) 	// d == r.data and r has two non-empty subtrees
        {
            r.data = findMin(r.right ).data;
            r.right = removeMin(r.right );
        }
        else                                            // d == r.data and r only has one child
            r = ( r.left != null ) ? r.left : r.right;

        return r;
    }

    /**
     * 
     * Find the minimum node in the subtree rooted at r, and return the reference to it 
     */
    private TreeNode findMin(TreeNode r )
    {
        if( r != null )
        {
            while( r.left != null )
                r = r.left;
        }

        return r;
    }
	
    /**
     * 
     * Remove the minimum node from the subtree rooted at r, and 
     * then return the root of the resulting subtree
     */
    private TreeNode removeMin( TreeNode r )
    {
        if( r == null )
            return null;
        else if( r.left != null )
        {
            r.left = removeMin(r.left );
            return r;
        }
        else
            return r.right;
    }
    
    /**
     * 
     * Practice problem:
     * Write a function that displays all data in the binary search tree in decreasing order
     */
    
    
    /**
     * 
     * Practice problem:
     * Write a function that returns the number of nodes in the binary search tree 
     */
    
    
    /**
     * 
     * Practice problem:
     * Write a function that returns height of the binary search tree 
     */
    
}
