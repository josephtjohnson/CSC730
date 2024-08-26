class StringProcessor
{
  public static String processStringInput(String str) 
  {
    string result;
    //Create a new stack
    Stack<string> stack = new Stack<>();
    
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
    while (!stack.empty()
    {
      
    }

    return result;
  }

  public static boolean isPalindrome(String str)
  {
    bool isPalindrome = false;

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
