/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HW2;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Johns
 */
class StringProcessor
{
  public static String processStringInput(String str) 
  {
    //Create a new stack
    Stack<Character> stack = new Stack<>();
    
    String reverse = "";
    String result = "";
    
    //add each character onto the stack
    for (int i = 0; i < str.length(); i++)
    {
      if (str.charAt(i) == '<')
      {
        if (!stack.empty())
        {
            stack.pop();
        }
      }
      else
      {
        stack.push(str.charAt(i));
      }
      
    }
    for (int i = 0; !stack.isEmpty(); i++)
    {
      reverse += stack.pop();
    }
    for (int i = reverse.length() - 1; i >= 0; i--)
    {
        result += reverse.charAt(i);
    }

    return result;
  }

  public static boolean isPalindrome(String str)
  {
    Boolean isPalindrome = true;

    //Create a new stack
    Stack<Character> stack = new Stack<>();

    int i, mid = str.length() / 2;

    for (i = 0; i < mid; i++)  
    {
      stack.push(str.charAt(i));
    }

    if (str.length() % 2 != 0) 
    {
        i++;
    }

    while (i < str.length())
    {
      char c = stack.pop();

      if (c != str.charAt(i))
      {
        isPalindrome = false;
        return isPalindrome;
      }
      i++;
    }
    return isPalindrome;
  }

  public static int checkZeroOne(String str)
  {

    //Create a new stack
    Stack<Character> stack = new Stack<>();
    int result = 0;
    
    int i;
    for (i = 0; i < str.length() - 1; i++) //what happens if the input has no zeros or ones?
    {
      if (str.charAt(i) == '0' || str.charAt(i) == '1')
      {
        stack.push(str.charAt(i));
      }
      else
      {
        i++;
      }
    }

    if (!stack.empty())
    {
    char firstEncounter = stack.peek();
      for(int j = i + 1; j < str.length(); j++)
      {
        if (firstEncounter == '0')
        {
          if (str.charAt(j) == '0')
          {
            stack.push(str.charAt(j));
          }
          else if (str.charAt(j) == '1')
          {
            stack.pop();
          }
        }
        if (firstEncounter == '1')
        {
          if (str.charAt(j) == '1')
          {
            stack.push(str.charAt(j));
          }
          else if (str.charAt(j) == '0')
          {
            stack.pop();
          }
        }
      }
      if (stack.empty())
      {
        result = 0;
      }
      if (stack.peek() == '0')
      {
        result = -1;
      }
      else if (stack.peek() == '1')
      {
        result = 1;
      }
    }
    else
    {
      result = 0;
    }
    return result;
  }

  public static void main(String[] args) 
  {
    Scanner scanner = new Scanner(System.in);  //Create a Scanner object
    do
    {
      System.out.println("Enter a string (< for backspace or 'q' to stop the program): ");
      String userInput = scanner.nextLine();  //Read user input

      if ("q".equals(userInput))
      {
        System.out.println("Thanks for using this program.");
        break;
      }
      if (userInput != null && !userInput.isEmpty() && !userInput.isBlank())
      {
        //process user input
        String processedUserInput = processStringInput(userInput);

        System.out.println("After processing backspaces, the string becomes: " + processedUserInput);
      
        //check if palindrome
        Boolean isPalindrome = isPalindrome(processedUserInput);
        if (isPalindrome)
        {
          System.out.println(processedUserInput + " is a palindrome");
        }
        else
        {
          System.out.println(processedUserInput + " is not a palindrome");
        }
  
        //check zeros and ones
        int checkZeroOneResult = checkZeroOne(processedUserInput);
        if (checkZeroOneResult == -1)
        {
          System.out.println("More 0s than 1s");
        }
        if (checkZeroOneResult == 0)
        {
          System.out.println("Number of 0s is equal to number of 1s");
        }
        if (checkZeroOneResult == 1)
        {
          System.out.println("More 1s than 0s");
        }
      }
      else
      {
        System.out.println("You must type something! Try again.");
      }
    } while (true);
  }
}
