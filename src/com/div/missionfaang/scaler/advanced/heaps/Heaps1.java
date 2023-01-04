package com.div.missionfaang.scaler.advanced.heaps;

import com.div.missionfaang.scaler.ArrayUtility;

import java.util.ArrayList;
import java.util.Collections;

public class Heaps1
{

  private static int magicianAndChocolates( int A, ArrayList<Integer> B )
  {
    Collections.sort( B );
    Collections.reverse( B );
    int count = 0;
    int loopCount = 0;
    int mod = 1000000007;
    while( loopCount < A )
    {
      count = ((count % mod) + (B.get( 0 ) % mod)) % mod;
      B.add( B.get( 0 ) / 2 );
      B.remove( 0 );
      Heaps1.logHeapify( B, B.size() - 1 );
      loopCount++;
    }
    return count % mod;
  }

  private static void heapify( ArrayList<Integer> B, int i )
  {
    int largest = i; // Initialize largest as root
    int l = 2 * i + 1; // left = 2*i + 1
    int r = 2 * i + 2; // right = 2*i + 2

    // If left child is larger than root
    if( l < B.size() && B.get( l ) > B.get( largest ) )
    {
      largest = l;
    }

    // If right child is larger than largest so far
    if( r < B.size() && B.get( r ) > B.get( largest ) )
    {
      largest = r;
    }

    // If largest is not root
    if( largest != i )
    {
      int swap = B.get( i );
      B.set( i, B.get( largest ) );
      B.set( largest, swap );

      // Recursively heapify the affected sub-tree
      Heaps1.heapify( B, i / 2 );
    }
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

  private static void logHeapify( ArrayList<Integer> B, int index )
  {
    while( index != 0 )
    {
      int parent = (index - 1) / 2;
      if( B.get( parent ) < B.get( index ) )
      {
        int temp = B.get( parent );
        B.set( parent, B.get( index ) );
        B.set( index, temp );
        index = parent;
      }
      else
      {
        break;
      }
    }
  }

  private static ArrayList<Integer> productOf3( ArrayList<Integer> A )
  {
    int[] max3 = new int[3];
    ArrayList<Integer> result = new ArrayList<>();
    result.add( -1 );
    if( A.size() == 1 )
    {
      return result;
    }
    else
    {
      max3[0] = A.get( 0 );
    }
    result.add( -1 );
    if( A.size() == 2 )
    {
      return result;
    }
    else
    {
      max3[1] = A.get( 1 );
    }
    max3[2] = A.get( 2 );
    result.add( max3[1] * max3[0] * max3[2] );
    if( max3[0] > max3[1] )
    {
      int temp = max3[0];
      max3[0] = max3[1];
      max3[1] = temp;
    }

    if( max3[0] > max3[2] )
    {
      int temp = max3[0];
      max3[0] = max3[2];
      max3[2] = temp;
    }
    for( int i = 3; i < A.size(); i++ )
    {
      if( A.get( i ) > max3[0] )
      {
        result.add( (result.get( i - 1 ) / max3[0]) * A.get( i ) );
        max3[0] = A.get( i );
        if( max3[0] > max3[1] )
        {
          int temp = max3[0];
          max3[0] = max3[1];
          max3[1] = temp;
        }

        if( max3[0] > max3[2] )
        {
          int temp = max3[0];
          max3[0] = max3[2];
          max3[2] = temp;
        }
      }
      else
      {
        result.add( result.get( i - 1 ) );
      }
    }
    return result;
  }

  public static void main( String[] args )
  {
    //    int[] arr1 = new int[] { 18, 26, 8, 94, 85, 54, 43, 74, 67, 71, 91, 24, 11, 16, 86, 52, 39, 78, 79, 34, 54, 12, 80, 41, 55, 40, 21, 79, 27, 89, 71, 96, 14,
    //        30, 89, 50, 35, 84, 23, 1, 6, 66 };
    //    int[] arr1 = new int[] { 6, 5 };
    int[] arr1 = new int[] { 2, 4, 6, 8, 10 };
    ArrayList<Integer> array1 = ArrayUtility.convertArrayToList( arr1 );
    System.out.print( Heaps1.magicianAndChocolates( 5, array1 ) );
  }
}
