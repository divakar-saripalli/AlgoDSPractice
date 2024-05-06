package com.div.missionfaang.scaler.advanced.queues;

import com.div.missionfaang.scaler.ArrayUtility;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Queues2
{
  static Stack<Integer> stack = new Stack<>();
  static Stack<Integer> minStack = new Stack<>();
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

    for( int i = 0; i < B && i < A.size(); i++ )
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

  private static int minMaxSum( ArrayList<Integer> A, int B )
  {
    ArrayList<Integer> maxQueue = new ArrayList<>();
    ArrayList<Integer> minQueue = new ArrayList<>();
    int maxFront = 0;
    int minFront = 0;
    int mod = 1000000007;

    if( A.size() == 1 )
    {
      return A.get( 0 );
    }

    long result = 0;
    if( B == 1 )
    {
      for( Integer integer : A )
      {
        result = result + integer;
      }
      return (int) ((result % mod) * 2) % mod;
    }

    for( int i = 0; i < B && i < A.size(); i++ )
    {
      int maxEnd = maxQueue.size() - 1;
      while( maxEnd > -1 )
      {
        if( A.get( i ) > maxQueue.get( maxEnd ) )
        {
          maxQueue.remove( maxEnd );
          maxEnd--;
        }
        else
        {
          break;
        }
      }
      maxQueue.add( A.get( i ) );

      int minEnd = minQueue.size() - 1;
      while( minEnd > -1 )
      {
        if( A.get( i ) < minQueue.get( minEnd ) )
        {
          minQueue.remove( minEnd );
          minEnd--;
        }
        else
        {
          break;
        }
      }
      minQueue.add( A.get( i ) );
    }

    result = (maxQueue.get( maxFront ) % mod + minQueue.get( minFront ) % mod) % mod;
    if( result < 0 )
    {
      result += mod;
    }
    if( B >= A.size() )
    {
      return (int) result;
    }

    for( int i = B; i < A.size(); i++ )
    {
      int maxEnd = maxQueue.size() - 1;
      while( maxEnd > -1 )
      {
        if( A.get( i ) > maxQueue.get( maxEnd ) )
        {
          maxQueue.remove( maxEnd );
          maxEnd--;
        }
        else
        {
          break;
        }
      }
      maxQueue.add( A.get( i ) );
      if( maxFront >= maxQueue.size() )
      {
        maxFront = maxQueue.size() - 1;
      }
      if( A.get( i - B ).equals( maxQueue.get( maxFront ) ) )
      {
        maxFront++;
      }

      int minEnd = minQueue.size() - 1;
      while( minEnd > -1 )
      {
        if( A.get( i ) < minQueue.get( minEnd ) )
        {
          minQueue.remove( minEnd );
          minEnd--;
        }
        else
        {
          break;
        }
      }
      minQueue.add( A.get( i ) );
      if( minFront >= minQueue.size() )
      {
        minFront = minQueue.size() - 1;
      }
      if( A.get( i - B ).equals( minQueue.get( minFront ) ) )
      {
        minFront++;
      }

      result = (result + (maxQueue.get( maxFront ) % mod + minQueue.get( minFront ) % mod) % mod) % mod;
      if( result < 0 )
      {
        result += mod;
      }
    }
    return (int) result;
  }

  private static void push( int x )
  {
    stack.push( x );
    if( minStack.isEmpty() || minStack.peek() > x )
    {
      minStack.push( x );
    }
  }

  private static void pop()
  {
    if( !stack.isEmpty() )
    {
      int element = stack.pop();
      if( element == minStack.peek() )
      {
        minStack.pop();
      }
    }
    else
    {
      minStack.empty();
    }
  }

  private static int top()
  {
    if( stack.isEmpty() )
    {
      return -1;
    }
    return stack.peek();
  }

  private static int getMin()
  {
    if( minStack.isEmpty() )
    {
      return -1;
    }
    return minStack.peek();
  }

  public static void main( String[] args )
  {
    //    System.out.println( Queues2.firstNonRepeatingCharacter( "abadbadc" ) );
    //    System.out.println( Queues2.firstNonRepeatingCharacter( "gu" ) );
    //    System.out.println( Queues2.firstNonRepeatingCharacter( "milhhvdmahokjggovcldhqlbbsnmutqeefssyxbzyovwpsorvxmdizw" ) );
    //    System.out.println( Queues2.firstNonRepeatingCharacter( "jyhrcwuengcbnuchctluxjgtxqtfvrebveewgasluuwooupcyxwgl" ) );

    int[] arr1 = new int[] { 1 };
    ArrayList<Integer> array = ArrayUtility.convertArrayToList( arr1 );
    //    System.out.println( Queues2.slidingMaximum( array, 1 ) );
    //
    //    arr1 = new int[] { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
    //    array = ArrayUtility.convertArrayToList( arr1 );
    //    System.out.println( Queues2.slidingMaximum( array, 1 ) );
    //
    //    arr1 = new int[] { 648, 614, 490, 138, 657, 544, 745, 582, 738, 229, 775, 665, 876, 448, 4, 81, 807, 578, 712, 951, 867, 328, 308, 440, 542, 178, 637, 446,
    //        882, 760, 354, 523, 935, 277, 158, 698, 536, 165, 892, 327, 574, 516, 36, 705, 900, 482, 558, 937, 207, 368 };
    //    array = ArrayUtility.convertArrayToList( arr1 );
    //    System.out.println( Queues2.slidingMaximum( array, 9 ) );
    //    
    //    arr1 = new int[] { 90, 767, 90, 777, 463, 196, 984, 277, 451, 643, 403, 316, 451, 967, 683, 786, 167, 372, 758, 402, 325, 431, 351, 351, 158, 663, 244, 559,
    //        345, 759, 924, 585, 509, 397, 540, 869, 997, 670, 375, 180, 48, 936, 203, 8, 598, 703, 733, 333, 414, 377, 496, 351, 910, 685, 612, 773, 571, 24, 679,
    //        174, 644, 639, 544, 1, 884, 982, 447, 670, 251, 868, 815, 467, 386, 932, 178, 295, 957, 757, 124, 932, 342, 301, 406, 259, 943, 79, 313, 218 };
    //    array = ArrayUtility.convertArrayToList( arr1 );
    //    System.out.println( Queues2.slidingMaximum( array, 7 ) );

    arr1 = new int[] { 2, 5, -1, 7, -3, -1, -2 };
    array = ArrayUtility.convertArrayToList( arr1 );
    System.out.println( Queues2.minMaxSum( array, 4 ) );
  }
}
