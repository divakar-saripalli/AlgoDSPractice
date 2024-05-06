package com.div.missionfaang.scaler.advanced;

import java.util.ArrayList;

public class July16Contest
{
  public int q1( ArrayList<ArrayList<Integer>> A )
  {
    int perimeter = 0;
    for( int i = 0; i < A.size(); i++ )
    {
      for( int j = 0; j < A.get( i ).size(); j++ )
      {
        if( A.get( i ).get( j ) == 0 )
        {
          if( i > 0 )
          {
            perimeter += A.get( i - 1 ).get( j );
          }
          if( j > 0 && A.get( i ).size() > 1 )
          {
            perimeter += A.get( i ).get( j - 1 );
          }
          if( i < A.size() - 1 )
          {
            perimeter += A.get( i + 1 ).get( j );
          }
          if( j < A.get( i ).size() - 1 && A.get( i ).size() > 1 )
          {
            perimeter += A.get( i ).get( j + 1 );
          }
        }
      }
    }
    for( int i = 0; i < A.size(); i++ )
    {
      if( A.get( i ).get( 0 ) == 1 )
      {
        perimeter++;
      }
      if( A.get( i ).get( A.get( i ).size() - 1 ) == 1 )
      {
        perimeter++;
      }
    }
    for( int i = 0; i < A.get( 0 ).size(); i++ )
    {
      if( A.get( 0 ).get( i ) == 1 )
      {
        perimeter++;
      }
      if( A.get( A.size() - 1 ).get( i ) == 1 )
      {
        perimeter++;
      }
    }
    return perimeter;
  }

  public int q5( int A, int B )
  {
    if( B > 0 )
    {
      int a = 1 << (B - 1);
      int b = (1 << A) - 1;
      return a * b * 2;
    }
    return (1 << A) - 1;
  }

  public ArrayList<Integer> q4( String A, ArrayList<ArrayList<Integer>> B )
  {
    int[] maxArray = new int[A.length()];
    boolean[] isVowelArray = new boolean[A.length()];
    int vowelsCount = 0;
    for( int i = 0; i < A.length(); i++ )
    {
      if( A.charAt( i ) == 'a' || A.charAt( i ) == 'e' || A.charAt( i ) == 'i' || A.charAt( i ) == 'o' || A.charAt( i ) == 'u' )
      {
        vowelsCount++;
        isVowelArray[i] = true;
      }
      maxArray[i] = vowelsCount;
    }
    ArrayList<Integer> result = new ArrayList<Integer>();
    for( ArrayList<Integer> integers_ : B )
    {
      int vowels = maxArray[integers_.get( 1 )] - maxArray[integers_.get( 0 )];
      if( isVowelArray[integers_.get( 0 )] )
      {
        vowels++;
      }
      result.add( vowels );
    }
    return result;
  }

  public ArrayList<Integer> q2( ArrayList<Integer> A )
  {

    int sum = 0;
    int max = Integer.MIN_VALUE;
    int startIndex = 0;
    int maxSumstartIndex = 0;
    int length = 0;
    int maxlength = 0;
    for( int i = 0; i < A.size(); i++ )
    {
      sum += A.get( i );
      if( max < sum )
      {
        maxSumstartIndex = startIndex;
        maxlength = length;
      }
    }
    return null;
  }
}
