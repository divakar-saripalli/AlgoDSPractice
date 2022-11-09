package com.div.missionfaang.scaler.advanced.trees;

import java.util.ArrayList;

class Trees1
{
  private static ArrayList<Integer> inorderTraversal( TreeNode A )
  {
    ArrayList<Integer> result = new ArrayList<>();
    return Trees1.inorderTraversal( A, result );
  }

  private static ArrayList<Integer> preorderTraversal( TreeNode A )
  {
    ArrayList<Integer> result = new ArrayList<>();
    return Trees1.preorderTraversal( A, result );
  }

  private static ArrayList<Integer> postorderTraversal( TreeNode A )
  {
    ArrayList<Integer> result = new ArrayList<>();
    return Trees1.postorderTraversal( A, result );
  }

  private static ArrayList<Integer> inorderTraversal( TreeNode A, ArrayList<Integer> result )
  {
    if( A == null )
    {
      return result;
    }
    result = Trees1.inorderTraversal( A.left, result );
    result.add( A.val );
    result = Trees1.inorderTraversal( A.right, result );
    return result;
  }

  private static ArrayList<Integer> preorderTraversal( TreeNode A, ArrayList<Integer> result )
  {
    if( A == null )
    {
      return result;
    }
    result.add( A.val );
    result = Trees1.preorderTraversal( A.left, result );
    result = Trees1.preorderTraversal( A.right, result );
    return result;
  }

  private static ArrayList<Integer> postorderTraversal( TreeNode A, ArrayList<Integer> result )
  {
    if( A == null )
    {
      return result;
    }
    result = Trees1.postorderTraversal( A.left, result );
    result = Trees1.postorderTraversal( A.right, result );
    result.add( A.val );
    return result;
  }

  private static ArrayList<ArrayList<Integer>> levelOrder( TreeNode A )
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
          queue.remove( 0 );
        }
        queue = tempQueue;
        if( !level.isEmpty() )
        {
          result.add( level );
        }
      }
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
    System.out.println( Trees1.inorderTraversal( root ) );
    System.out.println( Trees1.preorderTraversal( root ) );
    System.out.println( Trees1.postorderTraversal( root ) );
  }

  public TreeNode deserializeBinaryTree( ArrayList<Integer> A )
  {
    TreeNode root = null;
    //    if( A.get( 0 ) != -1 )
    //    {
    //      front = new ListNode( A.get( 0 ) );
    //      tail
    //      for( int i = 0; i < A.size(); i++ )
    //      {
    //
    //      }
    //    }
    return root;
  }
}
