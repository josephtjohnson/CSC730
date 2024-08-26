class StringProcessor
{
  public static String processStringInput(String str) 
  {
    //Create a new stack
    Stack<string> stack = new Stack<>(str.length + );
    string result;
    
    //add each character onto the stack
    foreach (char c in str)
    {
      //what happens if they start with a backspace?
      if (c == "<" && !stack.empty())
      {
        stack.pop();
      }
      else
      {
        stack.push(c);
      }
      
    }
    for (int i = 0; i < stack.size(); i++)
    {
      result += stack[i];
    }

    return result;
  }

  public static boolean isPalindrome(String str)
  {
    bool isPalindrome = true;

    //Create a new stack
    Stack<string> stack = new Stack<>(str.length + );
    string result;

    int i, mid = str.length / 2;

    for (i = 0; i < mid; i++)  
    {
      stack.push(str[i]);
    }

    if (length % 2 != 0) 
    {
        i++;
    }

    while (i < str.length)
    {
      char c = stack.pop();

      if (c != str[i])
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
    Stack<string> stack = new Stack<>(str.length + );
    int result;
    
    int i;
    while (stack.empty)
    {
      if (str[i] == "0" || str[i] == "1")
      {
        stack.push(str[i]);
      }
      else
      {
        i++;
      }
    }

    if (!stack.empty)
    {
    char firstEncounter = stack.peek();
      for(int j = i + 1; j < str.length; j++)
      {
        if (firstEncounter == "0")
        {
          if (str[j] == "0")
          {
            stack.push(str[j]);
          }
          else if (str[j] == "1")
          {
            stack.pop();
          }
        }
        if (firstEncounter == "1")
        {
          if (str[j] == "1")
          {
            stack.push(str[j]);
          }
          else if (str[j] == "0")
          {
            stack.pop();
          }
        }
      }
      if (stack.empty())
      {
        result = 0
      }
      if (sneak.peek() == "0")
      {
        result = -1
      }
      else if (sneak.peek() == "1")
      {
        result = 1
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
    int quitCode;
    do
    {
      System.out.println("Enter a string (< for backspace or "q" to stop the program): ");
      String userInput = scanner.nextLine();  //Read user input

      if (userInput == "q")
      {
        System.out.println("Thanks for using this program.");
        quitCode = 0;
        break;
      }
      if (userInput is not null or empty)
      {
        //process user input
        string processedUserInput = processStringInput(userInput);

        System.out.println(string.format("After processing backspaces, the string becomes: {0}", processedUserInput));
      
        //check if palindrome
        bool isPalindrome = isPalindrome(processedUserInput);
        if (isPalindrome)
        {
          System.out.println(string.format("{0} is a palindrome",processedUserInput));
        }
        else
        {
          System.out.println(string.format("{0} is not a palindrome",processedUserInput));
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
    } while (quitCode != 0);

  
  }
}
