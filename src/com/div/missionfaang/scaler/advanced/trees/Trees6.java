package com.div.missionfaang.scaler.advanced.trees;

import com.div.missionfaang.scaler.ArrayUtility;
import com.div.missionfaang.scaler.advanced.TreeNode;

import java.util.ArrayList;

public class Trees6
{
  private static int oddEvenLevels( TreeNode A )
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

  static TreeNode deserializeBinaryTree( ArrayList<Integer> A )
  {
    TreeNode root = new TreeNode( A.get( 0 ) );
    ArrayList<TreeNode> queue = new ArrayList<>();
    queue.add( root );
    for( int i = 0; i < A.size() / 2; i++ )
    {
      if( A.get( (i * 2) + 1 ) != -1 && queue.get( i ) != null )
      {
        TreeNode left = new TreeNode( A.get( (i * 2) + 1 ) );
        queue.get( i ).left = left;
        queue.add( left );
      }
      if( i + 1 < A.size() && A.get( (i * 2) + 2 ) != -1 && queue.get( i ) != null )
      {
        TreeNode right = new TreeNode( A.get( (i * 2) + 2 ) );
        queue.get( i ).right = right;
        queue.add( right );
      }
    }
    return root;
  }

  public static void main( String[] args )
  {
    int[] arr1 = new int[] { 1, 2, 4, -1, 3, -1, 5, 7, -1, -1, 6, -1, 8, -1, -1, -1, -1 };
    ArrayList<Integer> array1 = ArrayUtility.convertArrayToList( arr1 );
    System.out.println( Trees1.preorderTraversal( Trees6.deserializeBinaryTree( array1 ) ) );
  }

  public ArrayList<Integer> serializeBinaryTree( TreeNode A )
  {
    ArrayList<TreeNode> queue = new ArrayList<>();
    ArrayList<Integer> result = new ArrayList<>();
    TreeNode root = null;
    if( A != null )
    {
      ArrayList<Integer> rootLevel = new ArrayList<>();
      rootLevel.add( A.val );
      result.add( A.val );
      queue.add( A.left );
      queue.add( A.right );
      while( !queue.isEmpty() )
      {
        ArrayList<Integer> level = new ArrayList<>();
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
          else
          {
            level.add( -1 );
          }
          queue.remove( 0 );
        }
        queue = tempQueue;
        if( !level.isEmpty() )
        {
          result.addAll( level );
        }
      }
    }
    return result;
  }

  public int hasPathSum( TreeNode A, int B )
  {
    if( A.left == null && A.right == null )
    {
      return (A.val == B) ? 1 : 0;
    }
    return hasPathSum( A, B, 0, null ) ? 1 : 0;
  }

  private boolean hasPathSum( TreeNode A, int B, int currentSum, TreeNode parent )
  {
    if( A == null )
    {
      return currentSum == B && parent != null && parent.left == null && parent.right == null;
    }
    return hasPathSum( A.left, B, currentSum + A.val, A ) || hasPathSum( A.right, B, currentSum + A.val, A );
  }

  public void connect( TreeLinkNode root )
  {
    TreeLinkNode leftMost = root;
    while( leftMost != null )
    {
      TreeLinkNode current = leftMost;
      while( current != null )
      {
        if( current.left != null )
        {
          current.left.next = current.right;
        }
        if( current.next != null && current.right != null )
        {
          current.right.next = current.next.left;
        }
        current = current.next;
      }
      leftMost = leftMost.left;
    }
  }
}
