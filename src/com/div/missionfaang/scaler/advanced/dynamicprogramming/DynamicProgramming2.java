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

  private static int calculateMinimumHP( ArrayList<ArrayList<Integer>> A )
  {
    ArrayList<ArrayList<Pair<Integer, Integer>>> result = new ArrayList<>();
    ArrayList<Pair<Integer, Integer>> firstRow = new ArrayList<>();
    firstRow.add( A.get( 0 ).get( 0 ) > -1 ? new Pair<>( 1, A.get( 0 ).get( 0 ) + 1 ) : new Pair<>( 1, A.get( 0 ).get( 0 ) * -1 + 1 ) );
    int finalResult = 0;
    for( int i = 1; i < A.get( 0 ).size(); i++ )
    {
      if( A.get( 0 ).get( i ) > -1 )
      {
        firstRow.add( new Pair<>( firstRow.get( i - 1 ).getFirst() + A.get( 0 ).get( i ), firstRow.get( i - 1 ).getSecond() + A.get( 0 ).get( i ) ) );
      }
      else
      {
        firstRow.add( new Pair<>( firstRow.get( i - 1 ).getFirst() - A.get( 0 ).get( i ), firstRow.get( i - 1 ).getSecond() - A.get( 0 ).get( i ) ) );
      }
    }
    result.add( firstRow );

    for( int i = 1; i < A.size(); i++ )
    {
      ArrayList<Pair<Integer, Integer>> row = new ArrayList<>();
      //      row.add( A.get( i ).get( 0 ) > -1 ? result.get( i - 1 ).get( 0 ) + A.get( i ).get( 0 ) : result.get( i - 1 ).get( 0 ) - A.get( i ).get( 0 ) );
      for( int j = 1; j < A.get( i ).size(); j++ )
      {
        //        finalResult = Math.min( row.get( j - 1 ), result.get( i - 1 ).get( j ) );
        if( A.get( i ).get( j ) < 0 )
        {
          finalResult -= A.get( i ).get( j );
        }
        else
        {
          finalResult += A.get( i ).get( j );
        }
        //        row.add( finalResult );
      }
      result.add( row );
    }
    return result.get( A.size() - 1 ).get( A.get( 0 ).size() - 1 ).getSecond();
  }

  /**
   * Problem Description
   * <p>
   * In Dance land, one person can party either alone or can pair up with another person.
   * Can you find in how many ways they can party if there are A people in Dance land?
   * <p>
   * Note: Return your answer modulo 10003, as the answer can be large.
   *
   * @param A
   * @return
   */
  private static int letsParty( int A )
  {
    if( A < 3 )
    {
      return A;
    }
    int first = 1;
    int second = 2;
    int mod = 10003;
    int count = 3;
    while( count <= A )
    {
      int temp = ((second + (first * (count - 1)) % mod) % mod);
      first = second;
      second = temp;
      count++;
    }
    return second;
  }

  private static int minPathSum( ArrayList<ArrayList<Integer>> A )
  {
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    ArrayList<Integer> firstRow = new ArrayList<>();
    firstRow.add( A.get( 0 ).get( 0 ) );
    int finalResult = 0;
    for( int i = 1; i < A.get( 0 ).size(); i++ )
    {
      firstRow.add( firstRow.get( i - 1 ) + A.get( 0 ).get( i ) );
    }
    result.add( firstRow );

    for( int i = 1; i < A.size(); i++ )
    {
      ArrayList<Integer> row = new ArrayList<>();
      row.add( result.get( 0 ).get( 0 ) + A.get( i ).get( 0 ) );
      for( int j = 1; j < A.get( i ).size(); j++ )
      {
        finalResult = Math.min( row.get( j - 1 ), result.get( 0 ).get( j ) );
        finalResult += A.get( i ).get( j );
        row.add( finalResult );
      }
      result.add( row );
      result.remove( 0 );
    }
    return result.get( 0 ).get( A.get( 0 ).size() - 1 );
  }

  private static int uniquePathsWithObstacles( int[][] A )
  {
    int[][] result = new int[A.length + 1][A[0].length + 1];
    for( int i = 1; i <= A.length; i++ )
    {
      for( int j = 1; j <= A[i - 1].length; j++ )
      {
        result[i][j] = (A[i - 1][j - 1] == 0) ?
            ((result[i][j - 1] > 0 && result[i - 1][j] > 0) ?
                Math.max( result[i][j - 1], result[i - 1][j] ) + 1 :
                Math.max( result[i][j - 1], result[i - 1][j] )) :
            0;
      }
    }
    return result[A.length][A[0].length];
  }

  public static void main( String[] args )
  {
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    ArrayList<Integer> row = new ArrayList<>();
    //    row.add( -2 );
    //    row.add( -3 );
    //    row.add( 3 );
    //    result.add( row );
    //
    //    row = new ArrayList<>();
    //    row.add( -5 );
    //    row.add( -10 );
    //    row.add( 1 );
    //    result.add( row );
    //
    //    row = new ArrayList<>();
    //    row.add( 10 );
    //    row.add( 30 );
    //    row.add( -5 );
    //    result.add( row );

    //    row = new ArrayList<>();
    //    row.add( 8 );
    //    row.add( 3 );
    //    row.add( 9 );
    //    row.add( 0 );
    //    result.add( row );
    //
    //    row = new ArrayList<>();
    //    row.add( 5 );
    //    row.add( 2 );
    //    row.add( 2 );
    //    row.add( 7 );
    //    row.add( 3 );
    //    result.add( row );
    //
    //    row = new ArrayList<>();
    //    row.add( 7 );
    //    row.add( 9 );
    //    row.add( 0 );
    //    row.add( 2 );
    //    row.add( 3 );
    //    row.add( 9 );
    //    result.add( row );
    //
    //    row = new ArrayList<>();
    //    row.add( 9 );
    //    row.add( 7 );
    //    row.add( 0 );
    //    row.add( 3 );
    //    row.add( 9 );
    //    row.add( 8 );
    //    row.add( 6 );
    //    result.add( row );
    //
    //    row = new ArrayList<>();
    //    row.add( 5 );
    //    row.add( 7 );
    //    row.add( 6 );
    //    row.add( 2 );
    //    row.add( 7 );
    //    row.add( 0 );
    //    row.add( 3 );
    //    row.add( 9 );
    //    result.add( row );

    //    System.out.println( DynamicProgramming2.calculateMinimumHP( result ) );

    result = new ArrayList<>();
    row = new ArrayList<>();
    row.add( 1 );
    row.add( -3 );
    row.add( 2 );
    result.add( row );

    row = new ArrayList<>();
    row.add( 2 );
    row.add( 5 );
    row.add( 10 );
    result.add( row );

    row = new ArrayList<>();
    row.add( 5 );
    row.add( -5 );
    row.add( 1 );
    result.add( row );

    //    System.out.println( DynamicProgramming2.minPathSum( result ) );
    int[][] A = new int[1][1];
    A[0][0] = 0;
    //    A[0][1] = 0;
    System.out.println( uniquePathsWithObstacles( A ) );
  }
}

class Pair<A, B>
{
  private A first;
  private B second;

  Pair( A first, B second )
  {
    super();
    this.first = first;
    this.second = second;
  }

  @Override
  public int hashCode()
  {
    int hashFirst = first != null ? first.hashCode() : 0;
    int hashSecond = second != null ? second.hashCode() : 0;

    return (hashFirst + hashSecond) * hashSecond + hashFirst;
  }

  @Override
  public boolean equals( Object other )
  {
    if( other instanceof Pair )
    {
      Pair otherPair = (Pair) other;
      return
          ((first == otherPair.first ||
              (first != null && otherPair.first != null &&
                  first.equals( otherPair.first ))) &&
              (second == otherPair.second ||
                  (second != null && otherPair.second != null &&
                      second.equals( otherPair.second ))));
    }

    return false;
  }

  @Override
  public String toString()
  {
    return "(" + first + ", " + second + ")";
  }

  public A getFirst()
  {
    return first;
  }

  public void setFirst( A first )
  {
    this.first = first;
  }

  B getSecond()
  {
    return second;
  }

  public void setSecond( B second )
  {
    this.second = second;
  }
}