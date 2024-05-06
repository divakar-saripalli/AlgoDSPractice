package com.div.missionfaang.scaler.advanced.trees;

import com.div.missionfaang.scaler.ArrayUtility;
import com.div.missionfaang.scaler.advanced.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Trees3
{
  private static int twoSumBST( TreeNode A, int B )
  {
    // Find the lowest common ancestor
    TreeNode lca = A;
    while( lca.val > B )
    {
      lca = lca.left;
    }
    if( lca.val == B )
    {
      // Check if a node with magnitude 0 exists.
      while( lca != null )
      {
        if( lca.val == 0 )
        {
          return 1;
        }
        if( lca.val < 0 )
        {
          lca = lca.right;
        }
        else
        {
          lca = lca.left;
        }
      }
      return 0;
    }
    ArrayList<Integer> leftTree = new ArrayList<>();
    Trees3.inorderTraversal( lca, leftTree );
    ArrayList<Integer> result = new ArrayList<>();
    HashSet<Integer> rightTree = new HashSet<>( Trees3.inorderTraversal( lca.right, result ) );
    for( Integer integer_ : leftTree )
    {
      if( rightTree.contains( B - integer_ ) )
      {
        return 1;
      }
    }
    return 0;
  }

  private static ArrayList<Integer> inorderTraversal( TreeNode A, ArrayList<Integer> result )
  {
    if( A == null )
    {
      return result;
    }
    result = Trees3.inorderTraversal( A.left, result );
    result.add( A.val );
    result = Trees3.inorderTraversal( A.right, result );
    return result;
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

  private static int isValidBST( TreeNode A )
  {
    return Trees3.isValidBST( A, Integer.MIN_VALUE, Integer.MAX_VALUE );
  }

  private static int isValidBST( TreeNode A, int min, int max )
  {
    if( A != null )
    {
      if( A.val > min && A.val < max )
      {
        return Math.min( Trees3.isValidBST( A.left, min, A.val ), Trees3.isValidBST( A.right, A.val, max ) );
      }
      return 0;
    }
    return 1;
  }

  private static String checkForBSTWithOneChild( ArrayList<Integer> A )
  {
    if( A.size() == 1 )
    {
      return "YES";
    }
    boolean leftDirection = A.get( 0 ) > A.get( 1 );
    int min = Integer.MIN_VALUE;
    int max = Integer.MAX_VALUE;
    if( leftDirection )
    {
      max = A.get( 0 );
    }
    else
    {
      min = A.get( 0 );
    }
    int lastNumber = A.get( 0 );
    for( int i = 1; i < A.size(); i++ )
    {
      if( A.get( i ) > min && A.get( i ) < max )
      {
        if( A.get( i ) <= lastNumber )
        {
          max = lastNumber;
        }
        else
        {
          min = lastNumber;
        }
        lastNumber = A.get( i );
      }
      else
      {
        return "NO";
      }
    }
    return "YES";
  }

  private static int largestBSTSubtree( TreeNode A )
  {
    int height = Trees3.largestBSTSubtree( A, Integer.MIN_VALUE, Integer.MAX_VALUE, 0 );
    return Math.max( height, 0 );
  }

  private static int largestBSTSubtree( TreeNode A, int min, int max, int height )
  {
    if( A == null )
    {
      return -1;
    }
    if( A.left != null && A.left.val >= A.val )
    {
      return height;
    }

    if( A.right != null && A.right.val <= A.val )
    {
      return height;
    }
    int maxHeight = Math.max( Trees3.largestBSTSubtree( A.left, min, A.val, height ), Trees3.largestBSTSubtree( A.right, A.val, max, height ) );
    return maxHeight >= 0 ? maxHeight + 1 : 0;
  }

  private static int bstNodesInRange( TreeNode A, int B, int C )
  {
    if( A == null )
    {
      return 0;
    }
    if( A.val > C )
    {
      return Trees3.bstNodesInRange( A.left, B, C );
    }
    if( A.val < B )
    {
      return Trees3.bstNodesInRange( A.right, B, C );
    }
    return Trees3.bstNodesInRange( A.left, B, C ) + Trees3.bstNodesInRange( A.right, B, C ) + 1;
  }

  public static void main( String[] args )
  {
    //    TreeNode root = new TreeNode( 14 );
    //    root.left = new TreeNode( 1 );
    //    root.right = new TreeNode( 20 );
    //    System.out.println( Trees3.twoSumBST( root, 21 ) );

    int[] arr1 = new int[] { 12, 1, 9, 6, 2 };
    ArrayList<Integer> array1 = ArrayUtility.convertArrayToList( arr1 );
    System.out.println( Trees3.checkForBSTWithOneChild( array1 ) );
    arr1 = new int[] { 4, 10, 5, 8 };
    array1 = ArrayUtility.convertArrayToList( arr1 );
    System.out.println( Trees3.checkForBSTWithOneChild( array1 ) );
    arr1 = new int[] { 49, 44, 42, 25, 2 };
    array1 = ArrayUtility.convertArrayToList( arr1 );
    System.out.println( Trees3.checkForBSTWithOneChild( array1 ) );
  }
}
