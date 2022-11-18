package com.div.missionfaang.scaler.advanced.trees;

import com.div.missionfaang.scaler.ArrayUtility;

import java.util.ArrayList;
import java.util.List;

class Trees3
{
  private static int twoSumBST( TreeNode A, int B )
  {
    ArrayList<TreeNode> queue = new ArrayList<>();
    TreeNode root = null;
    if( A != null )
    {
      boolean found = Trees3.searchInBST( A, B - A.val );
      if( !found )
      {
        queue.add( A.left );
        queue.add( A.right );
        while( !queue.isEmpty() && !found )
        {
          ArrayList<TreeNode> tempQueue = new ArrayList<>();
          int size = queue.size();
          for( int i = 0; i < size && !found; i++ )
          {
            if( queue.get( 0 ) != null )
            {
              found = Trees3.searchInBST( A, B - queue.get( 0 ).val );
              if( !found )
              {
                found = Trees3.searchInBST( A, B - queue.get( 0 ).val );
              }
              if( !found )
              {
                tempQueue.add( queue.get( 0 ).left );
                tempQueue.add( queue.get( 0 ).right );
              }
            }
            queue.remove( 0 );
          }
          queue = tempQueue;
        }
      }
      return (found) ? 1 : 0;
    }
    return 0;
  }

  private static boolean searchInBST( TreeNode A, int B )
  {
    if( A == null )
    {
      return false;
    }
    if( A.val < B )
    {
      return Trees3.searchInBST( A.right, B );
    }
    else if( A.val > B )
    {
      return Trees3.searchInBST( A.left, B );
    }
    else
    {
      return true;
    }
  }

  private static TreeNode sortedArrayToBST( List<Integer> A )
  {
    return Trees3.sortedArrayToBST( A, 0, A.size() - 1 );
  }

  private static TreeNode sortedArrayToBST( List<Integer> A, int start, int end )
  {
    if( start > end )
    {
      return null;
    }
    int mid = (start + end) / 2;
    TreeNode root = new TreeNode( A.get( mid ) );
    if( start != end )
    {
      root.left = Trees3.sortedArrayToBST( A, start, mid - 1 );
      root.right = Trees3.sortedArrayToBST( A, mid + 1, end );
    }
    return root;
  }

  public static void main( String[] args )
  {
    //    TreeNode root = new TreeNode( 14 );
    //    root.left = new TreeNode( 1 );
    //    root.right = new TreeNode( 20 );
    //    System.out.println( Trees3.twoSumBST( root, 21 ) );

    int[] arr1 = new int[] { 1, 2, 3, 4, 5 };
    ArrayList<Integer> array1 = ArrayUtility.convertArrayToList( arr1 );
    System.out.println( Trees1.preorderTraversal( Trees3.sortedArrayToBST( array1 ) ) );
    System.out.println( Trees1.inorderTraversal( Trees3.sortedArrayToBST( array1 ) ) );
    System.out.println( Trees1.postorderTraversal( Trees3.sortedArrayToBST( array1 ) ) );
  }
}
