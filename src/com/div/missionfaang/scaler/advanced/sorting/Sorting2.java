package com.div.missionfaang.scaler.advanced.sorting;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sorting2
{
  private static String largestNumber( final List<Integer> A )
  {
    StringBuilder result = new StringBuilder();
    A.sort( new NumberComparator() );
    Collections.reverse( A );
    for( int i = A.size() - 1; i > -1; i-- )
    {
      result.append( A.get( i ) );
    }
    return result.toString();
  }

  public static void main( String[] args )
  {

  }
}

class NumberComparator implements Comparator<Integer>
{

  private static int reverseNumber( Integer o1 )
  {
    int rev_num = 0;
    while( o1 > 0 )
    {
      rev_num = rev_num * 10 + o1 % 10;
      o1 = o1 / 10;
    }
    return rev_num;
  }

  @Override
  public int compare( Integer number1, Integer number2 )
  {
    number1 = reverseNumber( number1 );
    number2 = reverseNumber( number2 );
    while( number1 != 0 && number2 != 0 )
    {
      if( number1 % 10 == number2 % 10 )
      {
        number1 /= 10;
        number2 /= 10;
      }
      else
      {
        return number1 % 10 - number2 % 10;
      }
    }
    return number1 % 10 - number2 % 10;
  }
}
