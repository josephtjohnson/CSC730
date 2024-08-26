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
  // your code comes here ...
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
      
        //check if palindrome
        isPalindrome(processedUserInput);
  
        //check zeros and ones
        checkZeroOne(processedUserInput);
      }
      else
      {
        System.out.println("You must type something! Try again.");
      }
    } while (quitCode != 0);

  
  }
}
