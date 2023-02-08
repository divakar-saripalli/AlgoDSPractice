package com.div.missionfaang.scaler.advanced.trees;

import java.util.ArrayList;
import java.util.HashMap;

class Trees2
{
  private static ArrayList<Integer> leftView( TreeNode A )
  {
    ArrayList<TreeNode> queue = new ArrayList<>();
    ArrayList<Integer> result = new ArrayList<>();
    if( A != null )
    {
      result.add( A.val );
      queue.add( A.left );
      queue.add( A.right );
      while( !queue.isEmpty() )
      {
        result.add( queue.get( 0 ).val );
        ArrayList<TreeNode> tempQueue = new ArrayList<>();
        int size = queue.size();
        for( int i = 0; i < size; i++ )
        {
          if( queue.get( 0 ) != null )
          {
            tempQueue.add( queue.get( 0 ).left );
            tempQueue.add( queue.get( 0 ).right );
          }
          queue.remove( 0 );
        }
        queue = tempQueue;
      }
    }
    return result;
  }

  private static ArrayList<Integer> rightView( TreeNode A )
  {
    ArrayList<TreeNode> queue = new ArrayList<>();
    ArrayList<Integer> result = new ArrayList<>();
    if( A != null )
    {
      result.add( A.val );
      queue.add( A.left );
      queue.add( A.right );
      int rear = 0;
      if( A.left == null || A.right == null )
      {
        if( A.left == null )
        {
          rear = 1;
        }
      }
      else
      {
        rear = 1;
      }
      while( !queue.isEmpty() )
      {
        TreeNode treeNode = queue.get( rear );
        if( treeNode != null )
        {
          result.add( treeNode.val );
          ArrayList<TreeNode> tempQueue = new ArrayList<>();
          int size = queue.size();
          int uncountedNodes = 0;
          for( int i = 0; i < size; i++ )
          {
            if( queue.get( 0 ) != null )
            {
              TreeNode left = queue.get( 0 ).left;
              if( left != null )
              {
                rear = rear + uncountedNodes + 1;
                uncountedNodes = 0;
              }
              else
              {
                uncountedNodes++;
              }
              tempQueue.add( left );
              TreeNode right = queue.get( 0 ).right;
              if( right != null )
              {
                rear = rear + uncountedNodes + 1;
                uncountedNodes = 0;
              }
              else
              {
                uncountedNodes++;
              }
              tempQueue.add( right );
            }
            queue.remove( 0 );
            rear = Math.max( 0, rear - 1 );
          }
          queue = tempQueue;
        }
        else
        {
          queue.remove( 0 );
          rear = Math.max( 0, rear - 1 );
        }
      }
    }
    return result;
  }

  private static ArrayList<ArrayList<Integer>> zigzagLevelOrder( TreeNode A )
  {
    ArrayList<TreeNode> queue = new ArrayList<>();
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    TreeNode root = null;
    if( A != null )
    {
      ArrayList<Integer> rootLevel = new ArrayList<>();
      rootLevel.add( A.val );
      result.add( rootLevel );
      queue.add( A.left );
      queue.add( A.right );
      boolean r2l = true;
      int rear = 0;
      if( A.left == null || A.right == null )
      {
        if( A.left == null )
        {
          rear = 1;
        }
      }
      else
      {
        rear = 1;
      }
      while( !queue.isEmpty() )
      {
        ArrayList<Integer> level = new ArrayList<>();
        if( r2l )
        {
          ArrayList<TreeNode> tempQueue = new ArrayList<>();
          int size = queue.size();
          for( int i = queue.size() - 1; i > -1; i-- )
          {
            if( queue.get( i ) != null )
            {
              level.add( queue.get( i ).val );
            }
          }
          for( int i = 0; i < size; i++ )
          {
            if( queue.get( 0 ) != null )
            {
              tempQueue.add( queue.get( 0 ).left );
              tempQueue.add( queue.get( 0 ).right );
            }
            queue.remove( 0 );
          }
          queue = tempQueue;
          if( !level.isEmpty() )
          {
            result.add( level );
          }
          r2l = false;
        }
        else
        {
          ArrayList<TreeNode> tempQueue = new ArrayList<>();
          int size = queue.size();
          for( int i = 0; i < size; i++ )
          {
            if( queue.get( 0 ) != null )
            {
              level.add( queue.get( 0 ).val );
              tempQueue.add( queue.get( 0 ).left );
              tempQueue.add( queue.get( 0 ).right );
            }
            queue.remove( 0 );
          }
          queue = tempQueue;
          if( !level.isEmpty() )
          {
            result.add( level );
          }
          r2l = true;
        }
      }
    }
    return result;
  }

  private static int isBalanced( TreeNode A )
  {
    int leftHeight = Trees2.getHeight( A.left );
    int rightHeight = Trees2.getHeight( A.left );
    if( leftHeight < 0 || rightHeight < 0 )
    {
      return 0;
    }
    if( Math.abs( leftHeight - rightHeight ) > 1 )
    {
      return 0;
    }
    return 1;
  }

  private static int getHeight( TreeNode A )
  {
    if( A == null )
    {
      return 0;
    }
    int leftHeight = Trees2.getHeight( A.left );
    int rightHeight = Trees2.getHeight( A.left );
    if( leftHeight < 0 || rightHeight < 0 )
    {
      return Integer.MIN_VALUE;
    }
    if( Math.abs( leftHeight - rightHeight ) > 1 )
    {
      return Integer.MIN_VALUE;
    }
    return Math.max( Trees2.getHeight( A.left ), Trees2.getHeight( A.right ) ) + 1;
  }

  private static int oddEvenDifference( TreeNode A )
  {
    ArrayList<TreeNode> queue = new ArrayList<>();
    TreeNode root = null;
    int oddSum = 0;
    int evenSum = 0;
    int level = 1;
    if( A != null )
    {
      oddSum += A.val;
      queue.add( A.left );
      queue.add( A.right );
      level++;
      while( !queue.isEmpty() )
      {
        ArrayList<TreeNode> tempQueue = new ArrayList<>();
        int size = queue.size();
        int sum = 0;
        for( int i = 0; i < size; i++ )
        {
          if( queue.get( 0 ) != null )
          {
            sum += queue.get( 0 ).val;
            tempQueue.add( queue.get( 0 ).left );
            tempQueue.add( queue.get( 0 ).right );
          }
          queue.remove( 0 );
        }
        if( level % 2 != 0 )
        {
          oddSum += sum;
        }
        else
        {
          evenSum += sum;
        }
        queue = tempQueue;
        level++;
      }
    }
    return oddSum - evenSum;
  }

  private static ArrayList<ArrayList<Integer>> verticalOrderTraversal( TreeNode A )
  {
    HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    ArrayList<Pair<TreeNode, Integer>> queue = new ArrayList<>();
    if( A == null )
    {
      return new ArrayList<>();
    }
    queue.add( new Pair<>( A, 0 ) );
    int front = 0;
    int rear = 0;
    int minLevel = Integer.MAX_VALUE;
    int maxLevel = Integer.MIN_VALUE;
    while( front <= rear )
    {
      TreeNode node = queue.get( front ).getFirst();
      Integer level = queue.get( front ).getSecond();
      minLevel = Math.min( minLevel, level );
      maxLevel = Math.max( maxLevel, level );
      if( map.containsKey( level ) )
      {
        map.get( level ).add( node.val );
      }
      else
      {
        ArrayList<Integer> list = new ArrayList<>();
        map.put( level, list );
        list.add( node.val );
      }
      front++;
      if( node.left != null )
      {
        queue.add( new Pair<>( node.left, level - 1 ) );
        rear++;
      }
      if( node.right != null )
      {
        queue.add( new Pair<>( node.right, level + 1 ) );
        rear++;
      }
    }
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    for( int i = minLevel; i <= maxLevel; i++ )
    {
      result.add( map.get( i ) );
    }
    return result;
  }

  public ArrayList<Integer> solve( TreeNode A )
  {
    HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    ArrayList<Pair<TreeNode, Integer>> queue = new ArrayList<>();
    if( A == null )
    {
      return new ArrayList<>();
    }
    queue.add( new Pair<>( A, 0 ) );
    int front = 0;
    int rear = 0;
    int minLevel = Integer.MAX_VALUE;
    int maxLevel = Integer.MIN_VALUE;
    while( front <= rear )
    {
      TreeNode node = queue.get( front ).getFirst();
      Integer level = queue.get( front ).getSecond();
      minLevel = Math.min( minLevel, level );
      maxLevel = Math.max( maxLevel, level );
      if( map.containsKey( level ) )
      {
        map.get( level ).add( node.val );
      }
      else
      {
        ArrayList<Integer> list = new ArrayList<>();
        map.put( level, list );
        list.add( node.val );
      }
      front++;
      if( node.left != null )
      {
        queue.add( new Pair<>( node.left, level - 1 ) );
        rear++;
      }
      if( node.right != null )
      {
        queue.add( new Pair<>( node.right, level + 1 ) );
        rear++;
      }
    }
    ArrayList<Integer> result = new ArrayList<>();
    for( int i = minLevel; i <= maxLevel; i++ )
    {
      result.add( map.get( i ).get( 0 ) );
    }
    return result;
  }

  public static void main( String[] args )
  {
    TreeNode root = new TreeNode( 1 );
    root.left = new TreeNode( 2 );
    root.right = new TreeNode( 3 );
    root.left.left = new TreeNode( 4 );
    root.left.right = new TreeNode( 5 );
    root.right.left = new TreeNode( 6 );
    root.right.right = new TreeNode( 7 );
    root.left.left.left = new TreeNode( 8 );
    root.left.left.right = new TreeNode( 9 );
    root.left.right.left = new TreeNode( 10 );
    root.left.right.right = new TreeNode( 11 );
    root.right.left.left = new TreeNode( 12 );
    root.right.left.right = new TreeNode( 13 );
    root.right.right.left = new TreeNode( 14 );
    root.right.right.right = new TreeNode( 15 );
    System.out.println( Trees2.zigzagLevelOrder( root ) );
  }
}

class Pair<A, B>
{
  private final A first;
  private final B second;

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

  B getSecond()
  {
    return second;
  }
}