package com.div.missionfaang.scaler.advanced.combinatorics;

import com.div.missionfaang.scaler.advanced.modulararithmetic.ModularArithmetic;

import java.util.HashMap;

public class Combinatorics
{

  /**
   * Problem Description
   * Given a string A. Find the rank of the string amongst its permutations sorted lexicographically.
   * <p>
   * NOTE: Assume that no characters are repeated.
   * <p>
   * Note: The answer might not fit in an integer, so return your answer % 1000003
   *
   * @param A
   * @return
   */
  private static int findRank( String A )
  {
    int sum = 0;
    int mod = 1000003;
    for( int i = 0; i < A.length() - 1; i++ )
    {
      int count = 0;
      // Finding all the characters which come before the current character in a
      // lexicographically sorted order.
      for( int j = i + 1; j < A.length(); j++ )
      {
        if( A.charAt( j ) < A.charAt( i ) )
        {
          count++;
        }
      }
      int factorial = 1;
      // Finding the total permutations of characters possible at the given index.
      // E.g.: If the input string is "dca", the possible string before "dcab" could be
      // a __ __ __. So the possible string starting with "a" before string "dcab" would be factorial of 3.
      // b __ __ __. Similar case for strings starting with "c" also.
      // c __ __ __. Similar case for strings starting with "c" also.
      // When the string starts with "d", the permutation calculation shifts to remaining characters.
      // d a __ __.  So the possible string starting with "da" before string "dcab" would be factorial of 2.
      // d b __ __.  So the possible string starting with "da" before string "dcab" would be factorial of 2.
      //
      // Hence, calculating the total permutations possible at the given index and multiplying it with number of 
      // characters which could possibly come before the character in the input string for the current index will
      // give the updated rank of the string.
      //
      // Continuing the above process to the last character would give us the final rank.
      for( int k = 1; k <= A.length() - i - 1; k++ )
      {
        factorial = ((factorial % mod) * (k % mod)) % mod;
      }
      sum = ((sum % mod) + ((((count % mod) * (factorial % mod)) % mod) % mod)) % mod;
    }
    return (sum + 1) % mod;
  }

  /**
   * Given a string A, find the rank of the string amongst its permutations sorted lexicographically.
   * Note that the characters might be repeated. If the characters are repeated, we need to look at the rank in unique permutations.
   * Look at the example for more details.
   * <p>
   * NOTE:
   * <p>
   * The answer might not fit in an integer, so return your answer % 1000003 where 1000003 is a prime number.
   * String A can consist of both lowercase and uppercase letters. Characters with lesser ASCII values are considered smaller, i.e., 'a' > 'Z'.
   *
   * @param A
   * @return
   */
  private static int findRankWithDuplicates( String A )
  {
    int sum = 0;
    int mod = 1000003;
    HashMap<Integer, Integer> factorialMap = new HashMap<>();
    //    Enumerating all permutations and matching them with the current one is going to be exponential.
    //
    //    Let’s start by looking at the first character.
    //
    //    If the first character is X, all permutations which had the first character 
    //    less than X would come before this permutation when sorted lexicographically.
    //
    //    The number of permutations with a character 
    //    C as the first character 
    //    = number of permutations possible with remaining N-1 character 
    //    = (N-1)! / (p1! * p2! * p3! ... ) where p1, p2, p3 are the number of occurrences of repeated characters.
    //
    //    For example, number of permutations possible with 3 ‘a’ and 3 ‘b’ is 6! / 3! 3! = 20
    for( int i = 0; i < A.length() - 1; i++ )
    {
      int count = 0;
      // Finding all the characters which come before the current character in a
      // lexicographically sorted order.
      HashMap<Character, Integer> countMap = new HashMap<>();
      for( int j = i + 1; j < A.length(); j++ )
      {
        if( A.charAt( j ) < A.charAt( i ) )
        {
          count++;
          if( countMap.containsKey( A.charAt( j ) ) )
          {
            countMap.put( A.charAt( j ), countMap.get( A.charAt( j ) ) + 1 );
          }
          else
          {
            countMap.put( A.charAt( j ), 1 );
          }
        }
      }
      int factorial = Combinatorics.getFactorial( A.length() - i - 1, mod, factorialMap );
      int denominator = 1;
      for( Character key : countMap.keySet() )
      {
        denominator = ((denominator % mod) * (Combinatorics.getFactorial( countMap.get( key ), mod, factorialMap ) % mod)) % mod;
      }
      factorial = ((factorial % mod) * (Combinatorics.pow( denominator, mod - 2, mod ) % mod)) % mod;
      sum = ((sum % mod) + ((((count % mod) * (factorial % mod)) % mod) % mod)) % mod;
    }
    return (sum + 1) % mod;
  }

  private static int getFactorial( int key, int mod, HashMap<Integer, Integer> factorialMap )
  {
    int factorial = 1;
    if( factorialMap.containsKey( key ) )
    {
      factorial = factorialMap.get( key );
    }
    else
    {
      for( int k = 1; k <= key; k++ )
      {
        factorial = ((factorial % mod) * (k % mod)) % mod;
      }
      factorialMap.put( key, factorial );
    }
    return factorial;
  }

  private static int pow( int A, long B, int C )
  {
    return ModularArithmetic.pow( A, B, C );
  }

  private static int computeNcR( int A, int B, int C )
  {
    long[][] ncrMatrix = new long[A + 1][B + 1];
    ncrMatrix[0][0] = 1;
    ncrMatrix[1][0] = 1;
    ncrMatrix[1][1] = 1;
    if( A < 2 )
    {
      return 1;
    }
    if( B < 2 )
    {
      return A;
    }
    for( int i = 2; i <= A; i++ )
    {
      for( int j = 0; j <= Math.min( i, B ); j++ )
      {
        if( j == 0 || j == i )
        {
          ncrMatrix[i][j] = 1;
        }
        else
        {
          ncrMatrix[i][j] = ((ncrMatrix[i - 1][j] % C) + (ncrMatrix[i - 1][j - 1] % C)) % C;
        }
      }
    }
    for( long[] ncrMatrix_ : ncrMatrix )
    {
      for( long l_ : ncrMatrix_ )
      {
        System.out.print( l_ + "\t" );
      }
      System.out.println();
    }
    return (int) (ncrMatrix[A][B] % C);
  }

  private static int computeNCR( int A, int B, int C )
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
    long nMinus1CR = (long) Math.max( 1, ((((((nMinus1CRMinus1 % C) * (((A % C) - (B % C) + C) % C)) % C) * (((Math.pow( B % C, (C - 2) )) % C) % C)) % C)) );
    return (int) (((nMinus1CR % C) + (nMinus1CRMinus1 % C)) % C);
  }

  public static void main( String[] args )
  {
    //    System.out.println( "Answer :: " + Combinatorics.computeNCR( 30, 24, 56 ) );
    System.out.println( "Answer :: " + Combinatorics.findRankWithDuplicates( "bbbbaaaa" ) );
  }
}
