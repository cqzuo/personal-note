// postfix.java
// parses postfix arithmetic expressions
// to run this program: C>java PostfixApp
import java.io.*;              // for I/O
////////////////////////////////////////////////////////////////
// 存储数据的栈
class StackX
   {
   private int maxSize;
   private int[] stackArray;
   private int top;
//--------------------------------------------------------------
   public StackX(int size)      // constructor
      {
      maxSize = size;
      stackArray = new int[maxSize];
      top = -1;
      }
//--------------------------------------------------------------
   public void push(int j)     // put item on top of stack
      { stackArray[++top] = j; }
//--------------------------------------------------------------
   public int pop()            // take item from top of stack
      { return stackArray[top--]; }
//--------------------------------------------------------------
   public int peek()           // peek at top of stack
      { return stackArray[top]; }
//--------------------------------------------------------------
   public boolean isEmpty()    // true if stack is empty
      { return (top == -1); }
//--------------------------------------------------------------
   public boolean isFull()     // true if stack is full
      { return (top == maxSize-1); }
//--------------------------------------------------------------
   public int size()           // return size
      { return top+1; }
//--------------------------------------------------------------
   public int peekN(int n)     // peek at index n
      { return stackArray[n]; }
//--------------------------------------------------------------
   public void displayStack(String s)
      {
      System.out.print(s);
      System.out.print("Stack (bottom-->top): ");
      for(int j=0; j<size(); j++)
         {
         System.out.print( peekN(j) );
         System.out.print(' ');
         }
      System.out.println("");
      }
//--------------------------------------------------------------
   }  // end class StackX
////////////////////////////////////////////////////////////////
// 计算表达式值的类
class ParsePost
   {
   private StackX theStack;
   private String input;
//--------------------------------------------------------------
   public ParsePost(String s)
      { input = s; }
//--------------------------------------------------------------
       // 计算表达式的方法
   public int doParse()
      {
      theStack = new StackX(20);             // make new stack
      char ch;
      int j;
      int num1, num2, interAns;

      // 遍历输入字符串的每个字符
      for(j=0; j<input.length(); j++)       // for each char,
         {
         ch = input.charAt(j);              // read from input
         theStack.displayStack(""+ch+" ");  // *diagnostic*
	 // 如果字符是数字,则入栈
         if(ch >= '0' && ch <= '9')         // if it's a number
            theStack.push( (int)(ch-'0') ); //   push it
	 // 否则,取出栈顶的2个元素
         else                               // it's an operator
            {
            num2 = theStack.pop();          // pop operands
            num1 = theStack.pop();
	    // 循环,如果该字符是操作符,则根据操作符计算本步骤的值
            switch(ch)                      // do arithmetic
               {
               case '+':
                  interAns = num1 + num2;
                  break;
               case '-':
                  interAns = num1 - num2;
                  break;
               case '*':
                  interAns = num1 * num2;
                  break;
               case '/':
                  interAns = num1 / num2;
                  break;
               default:
                  interAns = 0;
               }  // end switch
	    // 计算完毕后,将结果入栈
            theStack.push(interAns);        // push result
            }  // end else
         }  // end for
      // 返回栈顶元素作为本步骤计算的结果
      interAns = theStack.pop();            // get answer
      return interAns;
      }  // end doParse()
   }  // end class ParsePost
////////////////////////////////////////////////////////////////
class PostfixApp
   {
   public static void main(String[] args) throws IOException
      {
      String input;
      int output;

      while(true)
         {
         System.out.print("Enter postfix: ");
         System.out.flush();
         input = getString();         // read a string from kbd
         if( input.equals("") )       // quit if [Enter]
            break;
                                      // make a parser
         ParsePost aParser = new ParsePost(input);
         output = aParser.doParse();  // do the evaluation
         System.out.println("Evaluates to " + output);
         }  // end while
      }  // end main()
//--------------------------------------------------------------
   public static String getString() throws IOException
      {
      InputStreamReader isr = new InputStreamReader(System.in);
      BufferedReader br = new BufferedReader(isr);
      String s = br.readLine();
      return s;
      }
//--------------------------------------------------------------
   }  // end class PostfixApp
////////////////////////////////////////////////////////////////
