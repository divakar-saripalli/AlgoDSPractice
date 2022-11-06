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
      result.add( 0 );
    }
    for( int i = 1; i < A.size(); i++ )
    {
      Stacks2.buildAdjacentSmallerStack( A, stack, result, i );
    }
    return result;
  }

  private static ArrayList<Integer> nextSmaller( ArrayList<Integer> A )
  {
    Stack<Integer> stack = new Stack<>();
    ArrayList<Integer> result = new ArrayList<>( A.size() );
    for( int i = 0; i < A.size() - 1; i++ )
    {
      result.add( 0 );
    }
    result.add( -1 );
    stack.push( A.get( A.size() - 1 ) );
    for( int i = A.size() - 2; i > -1; i-- )
    {
      Stacks2.buildAdjacentSmallerStack( A, stack, result, i );
    }
    return result;
  }

  private static ArrayList<Integer> nextGreater( ArrayList<Integer> A )
  {
    Stack<Integer> stack = new Stack<>();
    ArrayList<Integer> result = new ArrayList<>( A.size() );
    for( int i = 0; i < A.size() - 1; i++ )
    {
      result.add( 0 );
    }
    result.add( -1 );
    stack.push( A.get( A.size() - 1 ) );
    for( int i = A.size() - 2; i > -1; i-- )
    {
      Stacks2.buildAdjacentGreaterStack( A, stack, result, i );
    }
    return result;
  }

  private static int largestRectangleInHistogram( ArrayList<Integer> A )
  {
    if( A.size() == 1 )
    {
      return A.get( 0 );
    }
    Stack<Integer> leftSmallerStack = new Stack<>();
    Stack<Integer> rightSmallerStack = new Stack<>();
    ArrayList<Integer> leftSmaller = new ArrayList<>( A.size() );
    ArrayList<Integer> rightSmaller = new ArrayList<>( A.size() );
    leftSmaller.add( -1 );
    for( int i = 1; i < A.size(); i++ )
    {
      leftSmaller.add( 0 );
    }
    leftSmallerStack.push( 0 );
    for( int i = 0; i < A.size() - 1; i++ )
    {
      rightSmaller.add( 0 );
    }
    rightSmaller.add( -1 );
    rightSmallerStack.push( A.size() - 1 );
    for( int i = 1, j = A.size() - 2; i < A.size(); i++, j-- )
    {
      Stacks2.buildAdjacentSmallerStackForIndex( A, leftSmallerStack, leftSmaller, i );

      Stacks2.buildAdjacentSmallerStackForIndex( A, rightSmallerStack, rightSmaller, j );
    }
    long maxArea = Integer.MIN_VALUE;
    maxArea = Math.max( maxArea, (long) A.get( 0 ) * (rightSmaller.get( 0 )) );
    maxArea = Math.max( maxArea, (long) A.get( A.size() - 1 ) * (A.size() - leftSmaller.get( A.size() - 1 ) - 1) );
    for( int i = 1; i < A.size() - 1; i++ )
    {
      long currentArea = 0;
      if( rightSmaller.get( i ) == -1 && leftSmaller.get( i ) == -1 )
      {
        currentArea = A.get( i );
      }
      else if( rightSmaller.get( i ) == -1 )
      {
        currentArea = (long) A.get( i ) * (A.size() - leftSmaller.get( i ) - 1);
      }
      else if( leftSmaller.get( i ) == -1 )
      {
        currentArea = (long) A.get( i ) * (rightSmaller.get( i ) - 2);
      }
      else
      {
        currentArea = (long) A.get( i ) * (rightSmaller.get( i ) - leftSmaller.get( i ) - 1);
      }
      maxArea = Math.max( maxArea, currentArea );
    }
    return (int) maxArea;
  }

  private static void buildAdjacentSmallerStackForIndex( ArrayList<Integer> A, Stack<Integer> stack, ArrayList<Integer> adjacentSmallList, int index )
  {
    if( !stack.empty() && A.get( index ) <= A.get( stack.peek() ) )
    {
      while( !stack.empty() && A.get( index ) <= A.get( stack.peek() ) )
      {
        stack.pop();
      }
    }
    if( !stack.empty() )
    {
      adjacentSmallList.set( index, stack.peek() );
    }
    else
    {
      adjacentSmallList.set( index, -1 );
    }
    stack.push( index );
  }

  private static void buildAdjacentSmallerStack( ArrayList<Integer> A, Stack<Integer> stack, ArrayList<Integer> adjacentSmallList, int index )
  {
    if( !stack.empty() && A.get( index ) <= stack.peek() )
    {
      while( !stack.empty() && A.get( index ) <= stack.peek() )
      {
        stack.pop();
      }
    }
    if( !stack.empty() )
    {
      adjacentSmallList.set( index, stack.peek() );
    }
    else
    {
      adjacentSmallList.set( index, -1 );
    }
    stack.push( A.get( index ) );
  }

  private static void buildAdjacentGreaterStack( ArrayList<Integer> A, Stack<Integer> stack, ArrayList<Integer> adjacentSmallList, int index )
  {
    if( !stack.empty() && A.get( index ) >= stack.peek() )
    {
      while( !stack.empty() && A.get( index ) >= stack.peek() )
      {
        stack.pop();
      }
    }
    if( !stack.empty() )
    {
      adjacentSmallList.set( index, stack.peek() );
    }
    else
    {
      adjacentSmallList.set( index, -1 );
    }
    stack.push( A.get( index ) );
  }

  public static void main( String[] args )
  {
    //    int[] a = new int[] { 39, 27, 11, 4, 24, 32, 32, 1 };
    //    int[] a = new int[] { 90, 58, 69, 70, 82, 100, 13, 57, 47, 18 };
    //    int[] a = new int[] { 47, 69, 67, 97, 86, 34, 98, 16, 65, 95, 66, 69, 18, 1, 99, 56, 35, 9, 48, 72, 49, 47, 1, 72, 87, 52, 13, 23, 95, 55, 21, 92, 36, 88,
    //        48, 39, 84, 16, 15, 65, 7, 58, 2, 21, 54, 2, 71, 92, 96, 100, 28, 31, 24, 10, 94, 5, 81, 80, 43, 35, 67, 33, 39, 81, 69, 12, 66, 87, 86, 11, 49, 94, 38,
    //        44, 72, 44, 18, 97, 23, 11, 30, 72, 51, 61, 56, 41, 30, 71, 12, 44, 81, 43, 43, 27 };
    //    int[] a = new int[] { 62, 96, 89, 85, 64, 91, 95, 13, 73, 43, 45, 47, 59, 13, 31, 57, 35, 87, 6, 6, 46, 55, 99, 40, 54, 45, 28, 71, 49, 61, 38, 81, 36, 13,
    //        22, 29, 41, 71, 74, 53, 60, 92, 86 };
    int[] a = new int[] { 2, 13, 60, 48, 18, 10, 36, 80, 24, 32, 83, 68, 60, 7, 44, 61, 43, 40, 26, 79, 77, 57, 78, 54, 38, 37, 61, 99, 84, 6, 25, 99, 38, 85,
        8, 43, 90, 43, 38, 1, 25, 96, 33, 78, 94, 82, 77, 49, 20, 77, 74, 98, 67, 54, 80, 17, 32, 51, 16, 99, 11, 99, 39, 71, 98, 35, 17, 73, 1, 17, 76, 64, 81,
        17, 56, 98, 46, 97, 70, 53, 16, 61, 82, 61, 14, 97, 96, 90, 72, 33, 16, 22, 34, 59, 72, 14 };
    ArrayList<Integer> A = ArrayUtility.convertArrayToList( a );
    //    System.out.println( Stacks2.prevSmaller( A ) );
    //    System.out.println( Stacks2.nextSmaller( A ) );
    System.out.println( Stacks2.largestRectangleInHistogram( A ) );
  }
}
