package com.div.missionfaang.scaler.advanced.dynamicprogramming;

public class DynamicProgramming5
{
  private static int solve( String A, String B )
  {
    int[][] dp = new int[A.length() + 1][B.length() + 1];
    for( int i = 0; i < B.length(); i++ )
    {
      dp[0][i] = 0;
    }
    for( int i = 0; i < A.length(); i++ )
    {
      dp[i][0] = 0;
    }
    for( int i = 0; i < A.length(); i++ )
    {
      for( int j = 0; j < B.length(); j++ )
      {
        if( A.charAt( i ) == B.charAt( j ) )
        {
          dp[i + 1][j + 1] = 1 + dp[i][j];
        }
        else
        {
          dp[i + 1][j + 1] = Math.max( dp[i][j + 1], dp[i + 1][j] );
        }
      }
    }
    return dp[A.length()][A.length()];
  }

  public static void main( String[] args )
  {

  }
}
