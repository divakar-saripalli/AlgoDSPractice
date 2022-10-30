package com.div.missionfaang.scaler.advanced.hashing;

import com.div.missionfaang.scaler.ArrayUtility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Hashing1
{
  private static int longestConsecutive( List<Integer> A )
  {
    if( A.size() < 2 )
    {
      return A.size();
    }
    Collections.sort( A );
    int count = 1;
    int maxCount = 0;
    int prev = A.get( 0 );
    for( int i = 1; i < A.size(); i++ )
    {
      if( A.get( i ) == (prev + 1) || A.get( i ) == prev )
      {
        if( A.get( i ) == (prev + 1) )
        {
          count++;
        }
      }
      else
      {
        maxCount = Math.max( maxCount, count );
        count = 1;
      }
      prev = A.get( i );
    }
    maxCount = Math.max( maxCount, count );
    return maxCount;
  }

  private static int shaggyDistances( ArrayList<Integer> A )
  {
    HashMap<Integer, Integer> valueIndexMap = new HashMap<>();
    int minDistance = Integer.MAX_VALUE;
    for( int i = 0; i < A.size(); i++ )
    {
      if( valueIndexMap.containsKey( A.get( i ) ) )
      {
        minDistance = Math.min( minDistance, (i - valueIndexMap.get( A.get( i ) )) );
      }
      valueIndexMap.put( A.get( i ), i );
    }
    return minDistance;
  }

  private static ArrayList<Integer> distinctNumbersInWindow( ArrayList<Integer> A, int B )
  {
    ArrayList<Integer> result = new ArrayList<>();
    if( B > A.size() )
    {
      return result;
    }
    if( B == 1 )
    {
      for( Integer integer : A )
      {
        result.add( 1 );
      }
      return result;
    }
    HashMap<Integer, Integer> numbersCount = new HashMap<>();
    for( int i = 0; i < B; i++ )
    {
      if( numbersCount.containsKey( A.get( i ) ) )
      {
        numbersCount.put( A.get( i ), numbersCount.get( A.get( i ) ) + 1 );
      }
      else
      {
        numbersCount.put( A.get( i ), 1 );
      }
    }
    result.add( numbersCount.size() );
    for( int i = B; i < A.size(); i++ )
    {
      if( numbersCount.get( A.get( i - B ) ) == 1 )
      {
        numbersCount.remove( A.get( i - B ) );
      }
      else
      {
        numbersCount.put( A.get( i - B ), numbersCount.get( A.get( i - B ) ) - 1 );
      }

      if( numbersCount.containsKey( A.get( i ) ) )
      {
        numbersCount.put( A.get( i ), numbersCount.get( A.get( i ) ) + 1 );
      }
      else
      {
        numbersCount.put( A.get( i ), 1 );
      }
      result.add( numbersCount.size() );
    }
    return result;
  }

  public static void main( String[] args )
  {
    //    int[] a = new int[] { 97, 86, 67, 19, 107, 9, 8, 49, 23, 46, -4, 22, 72, 4, 57, 111, 20, 52, 99, 2, 113, 81, 7, 5, 21, 0, 47, 54, 76, 117, -2, 102, 34, 12,
    //        103, 69, 36, 51, 105, -3, 33, 91, 37, 11, 48, 106, 109, 45, 58, 77, 104, 60, 75, 90, 3, 62, 16, 119, 85, 63, 87, 43, 74, 13, 95, 94, 56, 28, 55, 66, 92,
    //        79, 27, 42, 70 };
    int[] a = new int[] { 1, 2, 1, 3, 4, 3 };
    ArrayList<Integer> A = ArrayUtility.convertArrayToList( a );
    System.out.println( Hashing1.distinctNumbersInWindow( A, 3 ) );
  }
}
