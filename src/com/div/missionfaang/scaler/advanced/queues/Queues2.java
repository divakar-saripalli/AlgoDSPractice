package com.div.missionfaang.scaler.advanced.queues;

import com.div.missionfaang.scaler.ArrayUtility;

import java.util.ArrayList;
import java.util.List;

public class Queues2
{
  private static String firstNonRepeatingCharacter( String A )
  {
    StringBuilder result = new StringBuilder();
    boolean[] repeatedCharacter = new boolean[26];
    char[] nonRepeatedCharacter = new char[A.length()];
    for( int i = 0; i < A.length(); i++ )
    {
      nonRepeatedCharacter[i] = '#';
    }
    int front = 0;
    int rear = 0;

    if( A.length() > 0 )
    {
      nonRepeatedCharacter[0] = A.charAt( 0 );
      repeatedCharacter[A.charAt( 0 ) - 'a'] = true;
      result.append( A.charAt( 0 ) );
    }

    for( int i = 1; i < A.length(); i++ )
    {
      if( !repeatedCharacter[A.charAt( i ) - 'a'] )
      {
        if( nonRepeatedCharacter[front] != '#' )
        {
          result.append( nonRepeatedCharacter[front] );
        }
        else
        {
          result.append( A.charAt( i ) );
          front = rear + 1;
        }
        rear++;
        nonRepeatedCharacter[rear] = A.charAt( i );
        repeatedCharacter[A.charAt( i ) - 'a'] = true;
      }
      else
      {
        if( nonRepeatedCharacter[front] == A.charAt( i ) )
        {
          front++;
          while( front < rear && nonRepeatedCharacter[front] == '#' )
          {
            front++;
          }
        }
        else
        {
          int start = front;
          while( start <= rear && nonRepeatedCharacter[start] != A.charAt( i ) )
          {
            start++;
          }
          if( start < nonRepeatedCharacter.length )
          {
            nonRepeatedCharacter[start] = '#';
          }
        }
        result.append( nonRepeatedCharacter[front] );
      }
    }
    return result.toString();
  }

  private static ArrayList<Integer> slidingMaximum( List<Integer> A, int B )
  {
    ArrayList<Integer> queue = new ArrayList<>();
    int front = 0;

    int max = Integer.MIN_VALUE;
    for( int i = 0; i < B && i < A.size(); i++ )
    {
      int end = queue.size() - 1;
      while( end > -1 )
      {
        max = Math.max( max, queue.get( end ) );
        if( A.get( i ) > queue.get( end ) )
        {
          queue.remove( end );
          end--;
        }
        else
        {
          break;
        }
      }
      queue.add( A.get( i ) );
    }

    if( B == 1 || A.size() == 1 )
    {
      return new ArrayList<>( A );
    }

    if( B >= A.size() )
    {
      ArrayList<Integer> result = new ArrayList<>();
      result.add( queue.get( front ) );
      return result;
    }

    ArrayList<Integer> result = new ArrayList<>();
    result.add( queue.get( front ) );

    for( int i = B; i < A.size(); i++ )
    {
      int end = queue.size() - 1;
      while( end > -1 )
      {
        if( A.get( i ) > queue.get( end ) )
        {
          queue.remove( end );
          end--;
        }
        else
        {
          break;
        }
      }
      queue.add( A.get( i ) );
      if( front >= queue.size() )
      {
        front = queue.size() - 1;
      }
      if( A.get( i - B ).equals( queue.get( front ) ) )
      {
        front++;
      }
      result.add( queue.get( front ) );
    }
    return result;

  }

  public static void main( String[] args )
  {
    //    System.out.println( Queues2.firstNonRepeatingCharacter( "abadbadc" ) );
    //    System.out.println( Queues2.firstNonRepeatingCharacter( "gu" ) );
    //    System.out.println( Queues2.firstNonRepeatingCharacter( "milhhvdmahokjggovcldhqlbbsnmutqeefssyxbzyovwpsorvxmdizw" ) );
    //    System.out.println( Queues2.firstNonRepeatingCharacter( "jyhrcwuengcbnuchctluxjgtxqtfvrebveewgasluuwooupcyxwgl" ) );

    int[] arr1 = new int[] { 1 };
    arr1 = new int[] { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
    arr1 = new int[] { 648, 614, 490, 138, 657, 544, 745, 582, 738, 229, 775, 665, 876, 448, 4, 81, 807, 578, 712, 951, 867, 328, 308, 440, 542, 178, 637, 446,
        882, 760, 354, 523, 935, 277, 158, 698, 536, 165, 892, 327, 574, 516, 36, 705, 900, 482, 558, 937, 207, 368 };
    arr1 = new int[] { 90, 767, 90, 777, 463, 196, 984, 277, 451, 643, 403, 316, 451, 967, 683, 786, 167, 372, 758, 402, 325, 431, 351, 351, 158, 663, 244, 559,
        345, 759, 924, 585, 509, 397, 540, 869, 997, 670, 375, 180, 48, 936, 203, 8, 598, 703, 733, 333, 414, 377, 496, 351, 910, 685, 612, 773, 571, 24, 679,
        174, 644, 639, 544, 1, 884, 982, 447, 670, 251, 868, 815, 467, 386, 932, 178, 295, 957, 757, 124, 932, 342, 301, 406, 259, 943, 79, 313, 218 };
    ArrayList<Integer> array = ArrayUtility.convertArrayToList( arr1 );
    //    System.out.println( Queues2.slidingMaximum( array, 1 ) );
    System.out.println( Queues2.slidingMaximum( array, 7 ) );
  }
}
