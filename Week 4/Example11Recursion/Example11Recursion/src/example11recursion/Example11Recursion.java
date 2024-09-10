/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example11recursion;

/**
 *
 * @author yangm
 */
public class Example11Recursion 
{
    public static void main(String[] args) 
    {
        String s = "abcde";
        System.out.println("Reverse " + s + ": " + MyRecursiveFunctions.reverse(s));
        
        s = "Welcome";
        char c = 'e';
        System.out.println("Remove " + c + " from : " + s + ": " + MyRecursiveFunctions.removeChar(s, c));
        
        System.out.println("abccba is a palindrome: " + MyRecursiveFunctions.isPalindrome1("abccba"));
        System.out.println("abcfa is a palindrome: " + MyRecursiveFunctions.isPalindrome1("abcfa"));
        System.out.println("abccba is a palindrome: " + MyRecursiveFunctions.isPalindrome2("abccba"));
        System.out.println("abcfa is a palindrome: " + MyRecursiveFunctions.isPalindrome2("abcfa"));
    }
}

class MyRecursiveFunctions
{   
    /**
     * 
     * Reverse the order of characters in a given string s  
     */
    static String reverse(String s)
    {
        if (s.length() <= 1)
            return s;
        
        return reverse(s.substring(1)) + s.charAt(0);
    }
    
    /**
     * 
     * Remove a specified character c from a given string s 
     */
    static String removeChar(String s, char c)
    {
        if (s.equals(""))
            return s;

        if (s.charAt(0) == c)
            return removeChar(s.substring(1), c);
        else
            return s.charAt(0) + removeChar(s.substring(1, s.length()), c);
    }
    
    /**
     * 
     * Check if a given string is a palindrome or not 
     * (Without a recursive helper function: create a new string for every recursive call)
     */
    static boolean isPalindrome1(String s)
    {
        int n = s.length();

        if (n <= 1)     
            return true;

        return ((s.charAt(0) == s.charAt(n - 1)) && isPalindrome1(s.substring(1, n - 1)));
    }
    
    /**
     * 
     * Check if a given string is a palindrome or not 
     * (With a recursive helper function)
     */
    static boolean isPalindrome2(String s)
    {
        return isPalindrome2(s, 0, s.length()-1);
    }

    // recursive helper method
    static boolean isPalindrome2(String s, int low, int high)
    {
        if (high <= low)    
            return true;

        return ((s.charAt(low) == s.charAt(high)) && isPalindrome2(s, low+1, high-1));
    }
    
    /**
     * 
     * Practice problem 1:
     * Write a recursive function that computes the sum of the digits in the given integer n
     */
    
    
    /**
     * 
     * Practice problem 2:
     * Implement a recursive approach to counting the occurrences of uppercase letters in a given string s
     * You should define the following two functions, the second of which is a recursive helper function
     *      int countUppercase(String s)
     *      int countUpppercase(String s, int high)
     */
    
}


