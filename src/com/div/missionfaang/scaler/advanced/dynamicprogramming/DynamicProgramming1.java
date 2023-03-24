package com.div.missionfaang.scaler.advanced.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class DynamicProgramming1
{
  private static int fibonacciNumber( int n )
  {
    int first = 0;
    int second = 1;
    for( int i = 2; i <= n; i++ )
    {
      int temp = first + second;
      first = second;
      second = temp;
    }
    return second;
  }

  private static int climbStairs( int A )
  {
    if( A == 1 )
    {
      return 1;
    }
    int mod = 1000000007;
    int first = 1;
    int second = 2;
    for( int i = 3; i <= A; i++ )
    {
      int temp = ((first % mod) + (second % mod)) % mod;
      first = second;
      second = temp;
    }
    return second;
  }

  private static int countMinSquares( int A )
  {
    int[] dp = new int[A + 1];
    for( int i = 1; i <= A; i++ )
    {
      dp[i] = i;
    }
    int count = 1;
    while( count <= A )
    {
      for( int i = 1; (i * i) <= count; i++ )
      {
        dp[count] = Math.min( dp[count], dp[count - (i * i)] + 1 );
      }
      count++;
    }
    return dp[A];
  }

  private static int adjacent( ArrayList<ArrayList<Integer>> A )
  {
    ArrayList<Integer> dp = new ArrayList<>();
    dp.add( 0 );
    for( int i = 0; i < A.get( 0 ).size(); i++ )
    {
      dp.add( Math.max( A.get( 0 ).get( i ), A.get( 1 ).get( i ) ) );
    }
    for( int i = 2; i < dp.size(); i++ )
    {
      dp.set( i, Math.max( dp.get( i - 1 ), dp.get( i - 2 ) + dp.get( i ) ) );
    }
    return dp.get( A.get( 0 ).size() );
  }

  private static int numDecodings( String A )
  {
    int[] dp = new int[A.length() + 1];
    if( A.charAt( 0 ) == '0' )
    {
      return 0;
    }
    if( A.length() == 1 )
    {
      return 1;
    }
    dp[0] = 1;
    dp[1] = 1;
    int mod = 1000000007;
    for( int i = 2; i <= A.length(); i++ )
    {
      int currentInt = Integer.parseInt( String.valueOf( A.charAt( i - 1 ) ) );
      int prevInt = Integer.parseInt( String.valueOf( A.charAt( i - 2 ) ) );
      if( (prevInt > 2 || prevInt == 0) && currentInt == 0 )
      {
        return 0;
      }
      dp[i] = dp[i - 1];
      if( prevInt > 0 && prevInt < 3 && currentInt == 0 )
      {
        dp[i] = dp[i - 2];
      }
      if( (prevInt == 1 && currentInt > 0) || (prevInt == 2 && currentInt > 0 && currentInt < 7) )
      {
        dp[i] = ((dp[i - 2] % mod) + (dp[i] % mod)) % mod;
      }
    }
    return dp[A.length()];
  }

  private static int maxProduct( List<Integer> A )
  {
    ArrayList<Integer> minDP = new ArrayList<>();
    ArrayList<Integer> maxDP = new ArrayList<>();
    minDP.add( A.get( 0 ) );
    maxDP.add( A.get( 0 ) );
    for( int i = 1; i < A.size(); i++ )
    {
      minDP.add( Math.min( A.get( i ), Math.min( A.get( i ) * minDP.get( i - 1 ), A.get( i ) * maxDP.get( i - 1 ) ) ) );
      maxDP.add( Math.max( A.get( i ), Math.max( A.get( i ) * minDP.get( i - 1 ), A.get( i ) * maxDP.get( i - 1 ) ) ) );
    }
    return maxDP.get( maxDP.size() - 1 );
  }

  public static void main( String[] args )
  {
    //    System.out.println( DynamicProgramming1.fibonacciNumber( 5 ) );
    //    System.out.println( DynamicProgramming1.climbStairs( 55007 ) );
    //    System.out.println( DynamicProgramming1.countMinSquares( 12 ) );
    //    int[] arr1 = new int[] { 74, 37, 82, 1 };
    //    ArrayList<Integer> array1 = ArrayUtility.convertArrayToList( arr1 );
    //    ArrayList<ArrayList<Integer>> twoDimensionArray = new ArrayList<>();
    //    twoDimensionArray.add( array1 );
    //    arr1 = new int[] { 66, 38, 16, 1 };
    //    array1 = ArrayUtility.convertArrayToList( arr1 );
    //    twoDimensionArray.add( array1 );
    //    System.out.println( DynamicProgramming1.adjacent( twoDimensionArray ) );
    //    System.out.println( DynamicProgramming1.numDecodings( "10" ) );
    System.out.println( DynamicProgramming1.numDecodings( "2611055971756562" ) );
    //    System.out.println( DynamicProgramming1.numDecodings(
    //        "5163490394499093221199401898020270545859326357520618953580237168826696965537789565062429676962877038781708385575876312877941367557410101383684194057405018861234394660905712238428675120866930196204792703765204322329401298924190" ) );
    //    System.out.println( DynamicProgramming1.numDecodings( "8" ) );
    System.out.println( DynamicProgramming1.numDecodings( "875361268549483279131" ) );
  }
}
 