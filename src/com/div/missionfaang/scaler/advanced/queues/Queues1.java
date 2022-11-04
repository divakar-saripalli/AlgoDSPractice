package com.div.missionfaang.scaler.advanced.queues;

import com.div.missionfaang.scaler.ArrayUtility;

import java.util.ArrayList;
import java.util.Stack;

public class Queues1
{

  private static String perfectNumbers( int A )
  {
    ArrayList<String> queue = new ArrayList<>();
    queue.add( "11" );
    queue.add( "22" );
    int count = 2;
    if( A == 1 )
    {
      return "11";
    }
    if( A == 2 )
    {
      return "22";
    }
    while( count < A )
    {
      ArrayList<String> tempQueue = new ArrayList<>();
      for( String string : queue )
      {
        tempQueue.add( "1" + string + "1" );
        count++;
        if( count == A )
        {
          return tempQueue.get( tempQueue.size() - 1 );
        }
      }
      for( String string : queue )
      {
        tempQueue.add( "2" + string + "2" );
        count++;
        if( count == A )
        {
          return tempQueue.get( tempQueue.size() - 1 );
        }
      }
      queue = tempQueue;
    }
    return "";
  }

  private static int taskScheduling( ArrayList<Integer> A, ArrayList<Integer> B )
  {
    if( A.size() == 1 )
    {
      return 1;
    }

    int cyclesCount = 0;
    for( Integer task : B )
    {
      int j = 0;
      ArrayList<Integer> tempQueue = new ArrayList<>();
      while( !A.get( j ).equals( task ) )
      {
        tempQueue.add( A.get( 0 ) );
        A.remove( 0 );
        cyclesCount++;
      }
      A.remove( 0 );
      cyclesCount++;
      A.addAll( tempQueue );
    }
    return cyclesCount;
  }

  private static ArrayList<Integer> nIntegersContaining12And3( int A )
  {
    ArrayList<Integer> queue = new ArrayList<>();
    queue.add( 1 );
    if( A == 1 )
    {
      return queue;
    }
    queue.add( 2 );
    if( A == 2 )
    {
      return queue;
    }
    queue.add( 3 );
    if( A == 3 )
    {
      return queue;
    }
    int count = 3;
    int multiple = 10;
    ArrayList<Integer> result = new ArrayList<>( queue );
    while( count < A )
    {
      ArrayList<Integer> tempQueue = new ArrayList<>();
      for( Integer number : queue )
      {
        tempQueue.add( (multiple) + number );
        count++;
        if( count == A )
        {
          result.addAll( tempQueue );
          return result;
        }
      }
      for( Integer number : queue )
      {
        tempQueue.add( (2 * multiple) + number );
        count++;
        if( count == A )
        {
          result.addAll( tempQueue );
          return result;
        }
      }
      for( Integer number : queue )
      {
        tempQueue.add( (3 * multiple) + number );
        count++;
        if( count == A )
        {
          result.addAll( tempQueue );
          return result;
        }
      }
      result.addAll( tempQueue );
      queue = tempQueue;
      multiple *= 10;
    }
    return result;
  }

  private static ArrayList<Integer> reverseElementsOfQueue( ArrayList<Integer> A, int B )
  {
    Stack<Integer> stack = new Stack<>();
    for( int i = 0; i < B; i++ )
    {
      stack.push( A.get( i ) );
    }

    ArrayList<Integer> result = new ArrayList<>();

    for( int i = 0; i < B; i++ )
    {
      result.add( stack.pop() );
    }

    for( int i = B; i < A.size(); i++ )
    {
      result.add( A.get( i ) );
    }
    return result;
  }

  public static void main( String[] args )
  {
    //    System.out.println( "N Numbers " + Queues1.nIntegersContaining12And3( 15 ) );
    int[] a = new int[] { 39, 27, 11, 4, 24, 32, 32, 1 };
    ArrayList<Integer> A = ArrayUtility.convertArrayToList( a );
    System.out.println( Queues1.reverseElementsOfQueue( A, 6 ) );
  }
}
