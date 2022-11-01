package com.div.missionfaang.scaler.advanced.stacks;

import com.div.missionfaang.scaler.ArrayUtility;

import java.util.ArrayList;
import java.util.Stack;

public class Stacks2
{
  private static ArrayList<Integer> prevSmaller( ArrayList<Integer> A )
  {
    Stack<Integer> stack = new Stack<>();
    ArrayList<Integer> result = new ArrayList<>();
    result.add( -1 );
    stack.push( A.get( 0 ) );
    for( int i = 1; i < A.size(); i++ )
    {
      if( !stack.empty() && A.get( i ) <= stack.peek() )
      {
        while( !stack.empty() && A.get( i ) <= stack.peek() )
        {
          stack.pop();
        }
      }
      if( !stack.empty() )
      {
        result.add( stack.peek() );
      }
      else
      {
        result.add( -1 );
      }
      stack.push( A.get( i ) );
    }
    return result;
  }

  public static void main( String[] args )
  {
    int[] a = new int[] { 39, 27, 11, 4, 24, 32, 32, 1 };
    ArrayList<Integer> A = ArrayUtility.convertArrayToList( a );
    System.out.println( Stacks2.prevSmaller( A ) );
  }
}
