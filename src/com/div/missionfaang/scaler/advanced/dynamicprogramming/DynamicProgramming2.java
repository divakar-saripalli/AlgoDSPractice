package com.div.missionfaang.scaler.advanced.dynamicprogramming;

import java.util.ArrayList;
import java.util.Collections;

public class DynamicProgramming2
{
  private static int uniquePathsWithObstacles( ArrayList<ArrayList<Integer>> A )
  {
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    ArrayList<Integer> firstRow = new ArrayList<>();
    firstRow.add( 1 );
    int finalResult = 0;
    for( int i = 1; i <= A.get( 0 ).size(); i++ )
    {
      if( A.get( 0 ).get( i - 1 ).equals( 0 ) )
      {
        finalResult = firstRow.get( i - 1 );
      }
      else
      {
        finalResult = 0;
      }
      firstRow.add( finalResult );
    }
    result.add( firstRow );

    for( int i = 1; i < A.size(); i++ )
    {
      ArrayList<Integer> row = new ArrayList<>();
      row.add( 0 );
      for( int j = 1; j <= A.get( i ).size(); j++ )
      {
        finalResult = 0;
        if( A.get( i ).get( j - 1 ) == 0 )
        {
          finalResult = row.get( j - 1 ) + result.get( i - 1 ).get( j );
        }
        row.add( finalResult );
      }
      result.add( row );
    }
    return finalResult;
  }

  private static int minimumTotal( ArrayList<ArrayList<Integer>> a )
  {
    if( a.size() == 0 )
    {
      return 0;
    }
    ArrayList<ArrayList<Integer>> result = new ArrayList<>( Collections.singleton( a.get( 0 ) ) );
    for( int i = 1; i < a.size(); i++ )
    {
      ArrayList<Integer> row = new ArrayList<>();
      for( int j = 0; j < a.get( i ).size(); j++ )
      {
        if( j > 0 )
        {
          if( a.get( i - 1 ).size() > j )
          {
            row.add( a.get( i ).get( j ) + Math.min( result.get( i - 1 ).get( j - 1 ), result.get( i - 1 ).get( j ) ) );
          }
          else
          {
            row.add( a.get( i ).get( j ) + result.get( i - 1 ).get( j - 1 ) );
          }
        }
        else
        {
          row.add( a.get( i ).get( j ) + result.get( i - 1 ).get( j ) );
        }
      }
      result.add( row );
    }
    int min = Integer.MAX_VALUE;
    for( int i = 0; i < result.get( result.size() - 1 ).size(); i++ )
    {
      min = Math.min( min, result.get( result.size() - 1 ).get( i ) );
    }
    return min;
  }

  public static void main( String[] args )
  {
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    ArrayList<Integer> row = new ArrayList<>();
    row.add( 9 );
    result.add( row );

    row = new ArrayList<>();
    row.add( 3 );
    row.add( 8 );
    result.add( row );

    row = new ArrayList<>();
    row.add( 0 );
    row.add( 2 );
    row.add( 4 );
    result.add( row );

    row = new ArrayList<>();
    row.add( 8 );
    row.add( 3 );
    row.add( 9 );
    row.add( 0 );
    result.add( row );

    row = new ArrayList<>();
    row.add( 5 );
    row.add( 2 );
    row.add( 2 );
    row.add( 7 );
    row.add( 3 );
    result.add( row );

    row = new ArrayList<>();
    row.add( 7 );
    row.add( 9 );
    row.add( 0 );
    row.add( 2 );
    row.add( 3 );
    row.add( 9 );
    result.add( row );

    row = new ArrayList<>();
    row.add( 9 );
    row.add( 7 );
    row.add( 0 );
    row.add( 3 );
    row.add( 9 );
    row.add( 8 );
    row.add( 6 );
    result.add( row );

    row = new ArrayList<>();
    row.add( 5 );
    row.add( 7 );
    row.add( 6 );
    row.add( 2 );
    row.add( 7 );
    row.add( 0 );
    row.add( 3 );
    row.add( 9 );
    result.add( row );

    System.out.println( DynamicProgramming2.minimumTotal( result ) );
  }
}
