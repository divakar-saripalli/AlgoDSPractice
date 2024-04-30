package com.div.missionfaang.scaler.advanced.stacks;

import com.div.missionfaang.scaler.ArrayUtility;

import java.util.ArrayList;
import java.util.Stack;

public class Stacks1
{

  private static int evaluateExpression( ArrayList<String> A )
  {
    Stack<String> stack = new Stack<>();
    for( int i = A.size() - 1; i >= 0; i-- )
    {
      boolean evaluateExpression = !(A.get( i ).equals( "+" ) ||
          A.get( i ).equals( "-" ) ||
          A.get( i ).equals( "*" ) ||
          A.get( i ).equals( "/" ))
          && stack.size() > 1
          && !(stack.peek().equals( "+" ) ||
          stack.peek().equals( "-" ) ||
          stack.peek().equals( "*" ) ||
          stack.peek().equals( "/" ));

      stack.push( A.get( i ) );
      if( evaluateExpression )
      {
        while( evaluateExpression )
        {
          int operand1 = Integer.parseInt( stack.pop() );
          int operand2 = Integer.parseInt( stack.pop() );
          String operator = stack.pop();
          evaluateExpression = stack.size() > 1 && !(stack.peek().equals( "+" ) ||
              stack.peek().equals( "-" ) ||
              stack.peek().equals( "*" ) ||
              stack.peek().equals( "/" ));
          switch( operator )
          {
            case "+":
              stack.push( String.valueOf( operand1 + operand2 ) );
              break;
            case "-":
              stack.push( String.valueOf( operand1 - operand2 ) );
              break;
            case "*":
              stack.push( String.valueOf( operand1 * operand2 ) );
              break;
            case "/":
              stack.push( String.valueOf( operand1 / operand2 ) );
              break;
          }
        }
      }
    }
    return Integer.parseInt( stack.peek() );
  }

  private static int braces( String A )
  {
    Stack<Character> stack = new Stack<>();
    boolean includesOperator = false;
    for( int i = A.length() - 1; i > -1; i-- )
    {
      if( !includesOperator && (A.charAt( i ) == '+' ||
          A.charAt( i ) == '-' ||
          A.charAt( i ) == '*' ||
          A.charAt( i ) == '/') )
      {
        includesOperator = true;
      }
      if( A.charAt( i ) == '(' )
      {
        if( stack.peek() == ')' )
        {
          return 1;
        }
        else
        {
          boolean includesOperator1 = false;
          while( !stack.empty() && stack.peek() != ')' )
          {
            if( !includesOperator1 && (stack.peek() == '+' ||
                stack.peek() == '-' ||
                stack.peek() == '*' ||
                stack.peek() == '/') )
            {
              includesOperator1 = true;
            }
            stack.pop();
          }
          if( stack.empty() )
          {
            return 0;
          }
          else
          {
            stack.pop();
          }
          if( !includesOperator1 )
          {
            return 1;
          }
        }
      }
      else
      {
        stack.push( A.charAt( i ) );
      }
    }
    return (stack.empty()) ? (includesOperator) ? 0 : 1 : 0;
  }

  private static String doubleCharacterTrouble( String A )
  {
    Stack<Character> stack = new Stack<>();
    for( int i = A.length() - 1; i > -1; i-- )
    {
      if( !stack.empty() && stack.peek() == A.charAt( i ) )
      {
        while( !stack.empty() && stack.peek() == A.charAt( i ) )
        {
          stack.pop();
        }
      }
      else
      {
        stack.push( A.charAt( i ) );
      }
    }
    StringBuilder str = new StringBuilder();
    while( !stack.empty() )
    {
      str.append( stack.pop() );
    }
    return str.toString();
  }

  public int balancedParantheses( String A )
  {
    Stack<Character> stack = new Stack<>();
    for( int i = A.length() - 1; i > -1; i-- )
    {
      if( A.charAt( i ) == '(' || A.charAt( i ) == '[' || A.charAt( i ) == '{' )
      {
        switch( A.charAt( i ) )
        {
          case '(':
            if( stack.empty() || stack.peek() != ')' )
            {
              return 0;
            }
            else
            {
              stack.pop();
            }
            break;
          case '[':
            if( stack.empty() || stack.peek() != ']' )
            {
              return 0;
            }
            else
            {
              stack.pop();
            }
            break;
          case '{':
            if( stack.empty() || stack.peek() != '}' )
            {
              return 0;
            }
            else
            {
              stack.pop();
            }
            break;
        }
      }

      if( A.charAt( i ) == ')' || A.charAt( i ) == ']' || A.charAt( i ) == '}' )
      {
        stack.push( A.charAt( i ) );
      }
    }
    return stack.empty() ? 1 : 0;
  }

  private static int checkTwoBracketExpression( String A, String B )
  {
    if( A.indexOf( '(' ) == -1 && B.indexOf( '(' ) == -1 )
    {
      return (A.equals( B )) ? 1 : 0;
    }

    A = Stacks1.getFinalStringExpression( A );
    B = Stacks1.getFinalStringExpression( B );
    boolean[] operandSign = new boolean[26];
    for( int i = A.length() - 1; i >= 0; )
    {
      int index = A.charAt( i ) - 'a';
      operandSign[index] = A.charAt( i - 1 ) == '+';
      i = i - 2;
    }
    for( int i = B.length() - 1; i >= 0; )
    {
      int index = B.charAt( i ) - 'a';
      if( operandSign[index] )
      {
        if( B.charAt( i - 1 ) != '+' )
        {
          return 0;
        }
      }
      else
      {
        if( B.charAt( i - 1 ) != '-' )
        {
          return 0;
        }
      }
      i = i - 2;
    }
    return 1;
  }

  private static String getFinalStringExpression( String A )
  {
    Stack<Character> stack = new Stack<>();
    for( int i = 0; i < A.length(); i++ )
    {
      if( A.charAt( i ) == ')' )
      {
        Stack<Character> tempStack = new Stack<>();
        while( !stack.isEmpty() && stack.peek() != '(' )
        {
          tempStack.push( stack.pop() );
        }
        if( !stack.isEmpty() )
        {
          stack.pop();
          boolean invertSymbol = false;
          if( !stack.isEmpty() )
          {
            invertSymbol = (stack.peek() == '-');
            if( (stack.peek() == '-' || stack.peek() == '+') &&
                (tempStack.peek() == '-' || tempStack.peek() == '+') )
            {
              stack.pop();
            }
          }
          while( !tempStack.isEmpty() )
          {
            Character pop = tempStack.pop();
            if( invertSymbol && pop == '-' )
            {
              stack.push( '+' );
            }
            else if( invertSymbol && pop == '+' )
            {
              stack.push( '-' );
            }
            else
            {
              stack.push( pop );
            }
          }
        }
      }
      else
      {
        stack.push( A.charAt( i ) );
      }
    }
    Stack<Character> tempStack = new Stack<>();
    while( !stack.isEmpty() )
    {
      Character pop = stack.pop();
      if( !stack.isEmpty() || pop != '+' )
      {
        tempStack.push( pop );
      }
      if( stack.isEmpty() && tempStack.peek() != '-' )
      {
        tempStack.push( '+' );
      }
    }
    StringBuilder str = new StringBuilder();
    while( !tempStack.isEmpty() )
    {
      str.append( tempStack.pop() );
    }
    return str.toString();
  }

  public static void main( String[] args )
  {
    //    System.out.println( Stacks1.doubleCharacterTrouble( "cddfeffe" ) );
    String[] a = new String[] { "5", "1", "2", "+", "4", "*", "+", "3", "-" };
    ArrayList<String> A = ArrayUtility.convertArrayToList( a );
    //    System.out.println( Stacks1.evaluateExpression( A ) );
    //    System.out.println( Stacks1.braces( "(a+(a))" ) );
    //    System.out.println( Stacks1.checkTwoBracketExpression( "-(-(-(-a+b)-d+c)-q)", "a-b-d+c+q" ) );
    System.out.println( Stacks1.checkTwoBracketExpression( "-(a+((b-c)-(d+e)))", "-(a+b-c-d-e)" ) );
    System.out.println( Stacks1.checkTwoBracketExpression( "-(-(-(-a+b)-d+c)-q)", "-(-(a-b-d+c+q))" ) );
    System.out.println( Stacks1.checkTwoBracketExpression( "-(a-(-z-(b-(c+t)-x)+l)-q)", "-a+l-b-(z-(c+t)-x-q)" ) );
  }
}
