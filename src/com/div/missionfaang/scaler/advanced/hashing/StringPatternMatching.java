package com.div.missionfaang.scaler.advanced.hashing;

public class StringPatternMatching
{

  private static String closestpalindrome( String A )
  {
    if( A.length() == 1 )
    {
      return "YES";
    }
    int count = 0;
    for( int i = 0, j = A.length() - 1; i < j; i++, j-- )
    {
      if( A.charAt( i ) != A.charAt( j ) )
      {
        count++;
      }
      if( count > 1 )
      {
        return "NO";
      }
    }
    return "YES";
  }

  private static int makeStringPalindrome( String A )
  {
    int forwardHash = 0;
    int backwardHash = 0;
    int HASH_CONSTANT = 26;
    int mod = 1000000007;
    for( int i = 0; i < A.length(); i++ )
    {
      forwardHash = ((forwardHash * HASH_CONSTANT) + (A.charAt( i ) - 'a' + 1));
      backwardHash = (int) ((backwardHash + ((A.charAt( i ) - 'a' + 1) * Math.pow( HASH_CONSTANT, A.length() - i - 1 ))));
    }

    for( int i = A.length() - 1; i > 0; i-- )
    {
      forwardHash = (int) (forwardHash - ((A.charAt( i ) - 'a' + 1) * Math.pow( HASH_CONSTANT, A.length() - i - 1 )));
      backwardHash = (backwardHash - (A.charAt( i ) - 'a' + 1));
      if( forwardHash == backwardHash )
      {
        return A.length() - i - 1;
      }
    }
    return A.length() - 1;
  }

  private static int countA( String A )
  {
    int count = 0;
    for( int i = 0; i < A.length(); i++ )
    {
      if( A.charAt( i ) == 'a' )
      {
        count++;
      }
    }
    return count + (((count - 1) * (count)) / 2);
  }

  public static void main( String[] args )
  {
    //    System.out.println( StringPatternMatching.closestpalindrome( "asdfghjklasdfghjklasdfgqjklasdfghjkllkjhgfdsalkjhgfdsalkjhgfdsalkjhgfdsa" ) );
    System.out.println( StringPatternMatching.makeStringPalindrome( "abc" ) );
  }
}