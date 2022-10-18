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
    System.out.println( StringPatternMatching.closestpalindrome( "asdfghjklasdfghjklasdfgqjklasdfghjkllkjhgfdsalkjhgfdsalkjhgfdsalkjhgfdsa" ) );
  }
}
