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
    int count = 0;
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

    if( A.indexOf( '(' ) == -1 && B.indexOf( '(' ) != -1 )
    {
      String temp = A;
      A = B;
      B = temp;
    }

    StringBuilder str = new StringBuilder();
    for( int i = 0; i < A.length(); i++ )
    {
      if( A.charAt( i ) != '(' )
      {
        str.append( A.charAt( i ) );
      }
      else
      {
        i++;
        boolean invert = (str.length() > 0 && str.charAt( str.length() - 1 ) == '-');
        while( i < A.length() && A.charAt( i ) != ')' )
        {
          if( A.charAt( i ) == '+' && invert )
          {
            str.append( '-' );
          }
          else if( A.charAt( i ) == '-' && invert )
          {
            str.append( '+' );
          }
          else
          {
            str.append( A.charAt( i ) );
          }
          i++;
        }
      }
    }
    return (str.toString().equals( B )) ? 1 : 0;
  }

  public static void main( String[] args )
  {
    //    System.out.println( Stacks1.doubleCharacterTrouble( "cddfeffe" ) );
    String[] a = new String[] { "5", "1", "2", "+", "4", "*", "+", "3", "-" };
    ArrayList<String> A = ArrayUtility.convertArrayToList( a );
    //    System.out.println( Stacks1.evaluateExpression( A ) );
    //    System.out.println( Stacks1.braces( "(a+(a))" ) );
    System.out.println( Stacks1.checkTwoBracketExpression( "(a+b-c-d+e-f+g+h+i)", "a+b-c-d+e-f+g+h+i" ) );
  }
}
