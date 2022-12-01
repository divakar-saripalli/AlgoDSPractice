package com.div.missionfaang.scaler.advanced.heaps;

import com.div.missionfaang.scaler.ArrayUtility;

import java.util.ArrayList;

public class Heaps1
{

  private static int magicianAndChocolates( int A, ArrayList<Integer> B )
  {
    Heaps1.heapify( B );
    int count = 0;
    int loopCount = 0;
    int mod = 1000000007;
    while( loopCount < A )
    {
      count = ((count % mod) + (B.get( 0 ) % mod)) % mod;
      B.set( 0, B.get( 0 ) / 2 );
      Heaps1.logHeapify( B );
      loopCount++;
    }
    return count % mod;
  }

  private static void heapify( ArrayList<Integer> B )
  {
    for( int i = B.size() / 2; i > -1; i-- )
    {
      int temp = B.get( i );
      if( B.size() > ((i * 2) + 1) && B.get( i ) < B.get( (i * 2) + 1 ) )
      {
        B.set( i, B.get( (i * 2) + 1 ) );
        B.set( ((i * 2) + 1), temp );
      }
      temp = B.get( i );
      if( B.size() > ((i * 2) + 2) && B.get( i ) < B.get( (i * 2) + 2 ) )
      {
        B.set( i, B.get( (i * 2) + 2 ) );
        B.set( ((i * 2) + 2), temp );
      }
    }
  }

  private static void logHeapify( ArrayList<Integer> B )
  {
    if( B.size() > 2 )
    {
      for( int i = B.size() / 2; i > 1; i = i / 2 )
      {
        int temp = B.get( i );
        if( B.size() > ((i * 2) + 1) && B.get( i ) < B.get( (i * 2) + 1 ) )
        {
          B.set( i, B.get( (i * 2) + 1 ) );
          B.set( ((i * 2) + 1), temp );
        }
        temp = B.get( i );
        if( B.size() > ((i * 2) + 2) && B.get( i ) < B.get( (i * 2) + 2 ) )
        {
          B.set( i, B.get( (i * 2) + 2 ) );
          B.set( ((i * 2) + 2), temp );
        }
      }
    }
    else
    {
      if( B.size() == 2 )
      {
        if( B.get( 0 ) < B.get( 1 ) )
        {
          int temp = B.get( 0 );
          B.set( 0, B.get( 1 ) );
          B.set( 1, temp );
        }
      }
    }
  }

  public static void main( String[] args )
  {
    //    int[] arr1 = new int[] { 18, 26, 8, 94, 85, 54, 43, 74, 67, 71, 91, 24, 11, 16, 86, 52, 39, 78, 79, 34, 54, 12, 80, 41, 55, 40, 21, 79, 27, 89, 71, 96, 14,
    //        30, 89, 50, 35, 84, 23, 1, 6, 66 };
    int[] arr1 = new int[] { 6, 5 };
    ArrayList<Integer> array1 = ArrayUtility.convertArrayToList( arr1 );
    System.out.print( Heaps1.magicianAndChocolates( 3, array1 ) );
  }
}
