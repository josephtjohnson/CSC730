package HW2;

/*
 * Author: Joseph Johnson
 * Date: 09/02/2024
 * Class: CSC 730
 * Assignment: Homework #2
 */

import java.util.Scanner;
import java.util.Stack;

class StringProcessor
{
/*
*This method takes a string from the user keyboard input and processes it.
*/
  public static String processStringInput(String str) 
  {
    //Create a new stack
    Stack<Character> stack = new Stack<>(); //instantiate new stack object
    
    String reverse = ""; 
    String result = "";
    
    //add each character onto the stack
    for (int i = 0; i < str.length(); i++)
    {
      if (str.charAt(i) == '<') //if backspace then pop a character off if the stack isn't empty
      {
        if (!stack.empty())
        {
            stack.pop();
        }
      }
      else //otherwise add the character to the stack
      {
        stack.push(str.charAt(i));
      }
      
    }
    for (int i = 0; !stack.isEmpty(); i++) //loop through stack
    {
      reverse += stack.pop(); //add characters to create a reverse string
    }
    for (int i = reverse.length() - 1; i >= 0; i--) //loop through reverse
    {
        result += reverse.charAt(i); //create the new unreversed string
    }

    return result;
  }

  /*
  *This method takes in a string and determines if it is a palindrome.
  */
  public static boolean isPalindrome(String str)
  {
    Boolean isPalindrome = true;

    Stack<Character> stack = new Stack<>(); //instantiate a new stack object

    int i, mid = str.length() / 2;

    for (i = 0; i < mid; i++)   //loop through string and add characters to stack up to the middle character
    {
      stack.push(str.charAt(i));
    }

    if (str.length() % 2 != 0) 
    {
        i++;
    }

    while (i < str.length()) //pop characters off and compare
    {
      char c = stack.pop();

      if (c != str.charAt(i)) //if the popped character does not match the string of the same element then not a palindrome.
      {
        isPalindrome = false;
        return isPalindrome;
      }
      i++;
    }
    return isPalindrome;
  }

  /*
  *This method is a non-arithmetic way of determining the number of zeros and ones that exist in a string.
  */
  public static int checkZeroOne(String str)
  {

    //Create a new stack
    Stack<Character> stack = new Stack<>(); //instantiate a new stack object
    int result = 0;
    
    int i = 0;
    while(stack.empty() && i < str.length()) 
    {
      if (str.charAt(i) == '0' || str.charAt(i) == '1') //check for ones and zeros and push
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
    char firstEncounter = stack.peek(); //look at first element found
      for(int j = i + 1; j < str.length(); j++)
      {
        if (firstEncounter == '0') //if the first element is a zero
        {
          if (str.charAt(j) == '0') //and the encountered element is a zero
          {
            stack.push(str.charAt(j)); //push to the stack
          }
          else if (str.charAt(j) == '1') //otherwise remove a zero as we encountered a one
          {
            stack.pop();
          }
        }
        if (firstEncounter == '1') //if the first element is a one
        {
          if (str.charAt(j) == '1') //and the encountered element is a one
          {
            stack.push(str.charAt(j)); // push to the stack
          }
          else if (str.charAt(j) == '0') //otherwise remove a one as we encountered a zero
          {
            stack.pop();
          }
        }
      }
      if (stack.empty()) //if we have an empty stack then we have equal ones and zeros
      {
        result = 0;
      }
      else if (stack.peek() == '0') //if we have a zero then more zeros than ones
      {
        result = -1;
      }
      else if (stack.peek() == '1') //if we have a one then more ones than zeros
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

