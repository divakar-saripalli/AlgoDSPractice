package com.div.missionfaang.scaler.advanced.stacks;

import java.util.ArrayList;
import java.util.Stack;

public class Stacks1
{

  private static int evaluateExpression( ArrayList<String> A )
  {
    return 1;
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

  public static void main( String[] args )
  {
    System.out.println( Stacks1.doubleCharacterTrouble( "cddfeffe" ) );
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
}
