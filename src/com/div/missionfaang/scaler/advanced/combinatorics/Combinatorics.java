package com.div.missionfaang.scaler.advanced.combinatorics;

public class Combinatorics {

    private static int findRank(String A) {
        int sum = 0;
        int mod = 1000003;
        for (int i = 0; i < A.length() - 1; i++) {
          int count = 0;
          for( int j = i + 1; j < A.length(); j++ )
          {
            if( A.charAt( j ) < A.charAt( i ) )
            {
              count++;
            }
          }
          int factorial = 1;
          for( int k = 1; k <= A.length() - i - 1; k++ )
          {
            factorial = ((factorial % mod) * (k % mod)) % mod;
          }
          sum = ((sum % mod) + ((((count % mod) * (factorial % mod)) % mod) % mod)) % mod;
        }
      return (sum + 1) % mod;
    }

  private static long computeNcR( int A, int B, int C )
  {
    //        if( A == B || B == 0 )
    //        {
    //            return 1;
    //        }
    //        if( B == 1 )
    //        {
    //            return A;
    //        }
    //        long nMinus1CRMinus1 = Combinatorics.computeNcR( A - 1, B - 1, C );
    //        long nMinus1CR = (((nMinus1CRMinus1 % C) * ((A - B) % C)) % C) / (B);
    //        return ((nMinus1CR % C) + (nMinus1CRMinus1 % C)) % C;
    return Combinatorics.computeNCR( A, B, C ) % C;
  }

  private static long computeNCR( int A, int B, int C )
  {
    if( A == B || B == 0 )
    {
      return 1;
    }
    if( B == 1 )
    {
      return A;
    }
    long nMinus1CRMinus1 = Math.max( 1, Combinatorics.computeNCR( A - 1, B - 1, C ) );
    long nMinus1CR = Math.max( 1, (((nMinus1CRMinus1) * (A - B)) / (B)) );
    return ((nMinus1CR % C) + (nMinus1CRMinus1 % C)) % C;
  }

  public static void main( String[] args )
  {
    System.out.println( Combinatorics.computeNcR( 96, 21, 123 ) );
  }
}
