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
    for( int i = A.length() - 1; i > -1; i-- )
    {
      if( A.charAt( i ) == '(' )
      {

      }
    }
    return 1;
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

  public static void main( String[] args )
  {
    //    System.out.println( Stacks1.doubleCharacterTrouble( "cddfeffe" ) );
    String[] a = new String[] { "5", "1", "2", "+", "4", "*", "+", "3", "-" };
    ArrayList<String> A = ArrayUtility.convertArrayToList( a );
    System.out.println( Stacks1.evaluateExpression( A ) );
  }
}
