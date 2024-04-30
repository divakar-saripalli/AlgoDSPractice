package com.div.missionfaang.scaler.advanced.trees;

import com.div.missionfaang.scaler.ArrayUtility;
import com.div.missionfaang.scaler.advanced.TreeNode;

import java.util.ArrayList;

public class Trees4
{

  private static int treeDiameter( TreeNode A )
  {
    ArrayList<Integer> leftRightMax = new ArrayList<>( 2 );
    leftRightMax.add( 0 );
    leftRightMax.add( 0 );
    //    Trees4.treeDiameter( A, leftRightMax, 0 );
    return leftRightMax.get( 1 ) - leftRightMax.get( 0 );
  }

  private static void height( TreeNode A, ArrayList<Integer> leftRightMax, int index )
  {
    if( A != null )
    {
      leftRightMax.set( 0, Math.min( leftRightMax.get( 0 ), index ) );
      leftRightMax.set( 1, Math.max( leftRightMax.get( 1 ), index ) );
      //      Trees4.treeDiameter( A.left, leftRightMax, index - 1 );
      //      Trees4.treeDiameter( A.right, leftRightMax, index + 1 );
    }
  }

  private static int lca( TreeNode A, int B, int C )
  {
    ArrayList<Integer> pathToB = Trees4.pathToNode( A, B );
    ArrayList<Integer> pathToC = Trees4.pathToNode( A, C );
    int i = pathToB.size() - 1;
    int j = pathToC.size() - 1;
    for( ; i > -1 && j > -1; i--, j-- )
    {
      if( !pathToB.get( i ).equals( pathToC.get( j ) ) )
      {
        return pathToB.get( i + 1 );
      }
    }
    if( j == -1 && !pathToC.isEmpty() )
    {
      return pathToC.get( 0 );
    }

    if( i == -1 && !pathToB.isEmpty() )
    {
      return pathToB.get( 0 );
    }
    return -1;
  }

  private static ArrayList<Integer> pathToNode( TreeNode A, int targetNodeValue )
  {
    if( A != null )
    {
      if( A.val == targetNodeValue )
      {
        ArrayList<Integer> traversal = new ArrayList<>();
        traversal.add( A.val );
        return traversal;
      }
      else
      {
        ArrayList<Integer> lpath = Trees4.pathToNode( A.left, targetNodeValue );
        if( !lpath.isEmpty() )
        {
          lpath.add( A.val );
          return lpath;
        }
        ArrayList<Integer> rpath = Trees4.pathToNode( A.right, targetNodeValue );
        if( !rpath.isEmpty() )
        {
          rpath.add( A.val );
          return rpath;
        }
        return new ArrayList<>();
      }
    }
    return new ArrayList<>();
  }

  private static ArrayList<Integer> recoverTree( TreeNode A )
  {
    TreeNode prev = A;
    TreeNode first = null;
    TreeNode second = null;

    while( A != null && (first == null || second == null) )
    {
      if( A.left != null )
      {
        TreeNode temp = A;
        TreeNode predecessor = A.left;
        while( predecessor.right != null && predecessor.right != temp )
        {
          predecessor = predecessor.right;
        }
        if( predecessor.right == null )
        {
          predecessor.right = temp;
          A = A.left;
        }
        else
        {
          predecessor.right = null;
          if( first == null && prev.val > A.val )
          {
            first = prev;
          }
          else if( first != null && prev.val > A.val )
          {
            second = prev;
          }
          prev = A;
          A = A.right;
        }
      }
      else
      {
        if( first == null && prev.val > A.val )
        {
          first = prev;
        }
        else if( first != null && prev.val > A.val )
        {
          second = prev;
        }
        prev = A;
        A = A.right;
      }
    }
    ArrayList<Integer> ret = new ArrayList<>();
    assert first != null;
    ret.add( first.val );
    assert second != null;
    ret.add( second.val );
    return ret;
  }

  private static int isSameTree( TreeNode A, TreeNode B )
  {
    if( A != null || B != null )
    {
      if( A == null || B == null )
      {
        return 0;
      }
    }
    if( A != null )
    {
      if( A.val == B.val )
      {
        int left = Trees4.isSameTree( A.left, B.left );
        if( left != 0 )
        {
          return Trees4.isSameTree( A.right, B.right );
        }
        else
        {
          return 0;
        }
      }
      else
      {
        return 0;
      }
    }
    return 1;
  }

  private static ArrayList<Integer> morrisAlgorithm( TreeNode A )
  {
    ArrayList<Integer> result = new ArrayList<>();
    while( A != null )
    {
      if( A.left != null )
      {
        TreeNode temp = A;
        TreeNode predecessor = A.left;
        while( predecessor.right != null && predecessor.right != temp )
        {
          predecessor = predecessor.right;
        }
        if( predecessor.right == null )
        {
          predecessor.right = temp;
          A = A.left;
        }
        else
        {
          predecessor.right = null;
          result.add( A.val );
          A = A.right;
        }
      }
      else
      {
        result.add( A.val );
        A = A.right;
      }
    }
    return result;
  }

  public static void main( String[] args )
  {
    //    TreeNode root = new TreeNode( 4 );
    //    root.left = new TreeNode( 2 );
    //    root.right = new TreeNode( 6 );
    //    root.left.left = new TreeNode( 1 );
    //    root.left.right = new TreeNode( 3 );
    //    root.right.left = new TreeNode( 5 );
    //    root.right.right = new TreeNode( 7 );
    int[] arr1 = new int[] { 13, 18, 14, 20, 10, 27, 25, -1, -1, -1, -1, -1, -1, -1 };
    ArrayList<Integer> array1 = ArrayUtility.convertArrayToList( arr1 );
    System.out.println( Trees4.treeDiameter( Trees1.deserializeBinaryTree( array1 ) ) );
    //    System.out.println( Trees4.recoverTree( root ) );
    //    System.out.println( Trees1.inorderTraversal( root ) );
  }
}
