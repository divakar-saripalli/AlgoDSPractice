package com.div.missionfaang.scaler.advanced.trees;

import com.div.missionfaang.scaler.advanced.TreeNode;

import java.util.ArrayList;

public class Trees5
{

  private static void invertTree( TreeNode A )
  {
    if( A != null )
    {
      Trees5.invertTree( A.left );
      Trees5.invertTree( A.right );
      TreeNode temp = A.left;
      A.left = A.right;
      A.right = temp;
    }
  }

  private static int kthsmallest( TreeNode A, int B )
  {
    return Trees5.inorderTraversal( A, B, new ArrayList<>() );
  }

  private static int inorderTraversal( TreeNode A, int kthSmallest, ArrayList<Integer> list )
  {
    if( A != null )
    {
      if( list.size() == kthSmallest )
      {
        return list.get( kthSmallest - 1 );
      }
      int value = Trees5.inorderTraversal( A.left, kthSmallest, list );
      if( value != Integer.MIN_VALUE )
      {
        return value;
      }
      list.add( A.val );
      return Trees5.inorderTraversal( A.right, kthSmallest, list );
    }
    return (list.size() == kthSmallest) ? list.get( kthSmallest - 1 ) : Integer.MIN_VALUE;
  }

  public static void main( String[] args )
  {

  }
}
