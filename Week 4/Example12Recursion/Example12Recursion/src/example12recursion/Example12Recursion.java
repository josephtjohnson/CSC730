/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example12recursion;

/**
 *
 * @author Yang
 */
public class Example12Recursion 
{
    public static void main(String[] args) 
    {
        int steps = MyRecursiveFunctions.hanoiTower(3, 'A', 'B', 'C');
        System.out.println("Total number of steps: " + steps);
    }
}

/**
 * 
 * Recursive functions to calculate some math problems
 */
class MyRecursiveFunctions
{
    /**
     * 
     * Towers of Hanoi puzzle 
     * Move n disks from tower p1 to tower p3 (using p2 as the auxiliary tower) without violating restrictions:
     * 1) only one disk can be moved at a time
     * 2) a disk can not be placed on top of a smaller one at any time
     */
    static int hanoiTower(int n, char p1, char p2, char p3)
    {
        int steps = 0;
        if (n > 0)
        {
            steps = hanoiTower(n - 1, p1, p3, p2);

            System.out.println("Move a disk from " + p1 + " to " + p3);
            steps = steps + 1;

            steps = steps + hanoiTower(n - 1, p2, p1, p3);
        }

        return steps;
    }
}