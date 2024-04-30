package com.div.missionfaang.scaler.advanced.trees;

import com.div.missionfaang.scaler.ArrayUtility;
import com.div.missionfaang.scaler.advanced.TreeNode;

import java.util.ArrayList;

class Trees1
{
  static ArrayList<Integer> inorderTraversal( TreeNode A )
  {
    ArrayList<Integer> result = new ArrayList<>();
    return Trees1.inorderTraversal( A, result );
  }

  static ArrayList<Integer> preorderTraversal( TreeNode A )
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

  private static TreeNode buildTreeFromInorderAndPostorder( ArrayList<Integer> A, ArrayList<Integer> B )
  {
    return Trees1.buildTreeFromInorderAndPostorder( A, B, 0, A.size() - 1, 0, B.size() - 1 );
  }

  private static TreeNode buildTreeFromInorderAndPostorder( ArrayList<Integer> A, ArrayList<Integer> B, int ins, int ine, int pos, int poe )
  {
    if( ins > ine || poe < 0 )
    {
      return null;
    }
    TreeNode root = new TreeNode( B.get( poe ) );
    if( ins == ine )
    {
      return root;
    }
    int index = 0;
    for( int i = ins; i <= ine; i++ )
    {
      if( A.get( i ).equals( B.get( poe ) ) )
      {
        index = i;
        break;
      }
    }
    root.left = Trees1.buildTreeFromInorderAndPostorder( A, B, ins, index - 1, pos, pos - ins + index - 1 );
    root.right = Trees1.buildTreeFromInorderAndPostorder( A, B, index + 1, ine, poe - ine + index, poe - 1 );
    return root;
  }

  private static TreeNode buildTreeFromInorderAndPreorder( ArrayList<Integer> A, ArrayList<Integer> B )
  {
    return Trees1.buildTreeFromInorderAndPreorder( A, B, 0, A.size() - 1, 0, B.size() - 1 );
  }

  private static TreeNode buildTreeFromInorderAndPreorder( ArrayList<Integer> preOrder, ArrayList<Integer> inOrder, int ins, int ine, int prs, int pre )
  {
    if( prs > pre || ins > ine )
    {
      return null;
    }
    TreeNode root = new TreeNode( preOrder.get( prs ) );
    //    if( ins == ine )
    //    {
    //      return root;
    //    }
    int index = -1;
    for( int i = ins; i <= ine; i++ )
    {
      if( inOrder.get( i ).equals( preOrder.get( prs ) ) )
      {
        index = i;
        break;
      }
    }
    int length = index - ins;
    root.left = Trees1.buildTreeFromInorderAndPreorder( preOrder, inOrder, ins, index - 1, prs + 1, prs + length );
    root.right = Trees1.buildTreeFromInorderAndPreorder( preOrder, inOrder, index + 1, ine, prs + length + 1, pre );
    return root;
  }

  static TreeNode deserializeBinaryTree( ArrayList<Integer> A )
  {
    TreeNode root = new TreeNode( A.get( 0 ) );
    int front = 0;
    ArrayList<TreeNode> queue = new ArrayList<>();
    queue.add( root );
    for( int i = 1; i < A.size(); )
    {
      TreeNode node = queue.get( front );
      front++;
      if( A.get( i ) != -1 )
      {
        node.left = new TreeNode( A.get( i ) );
        queue.add( node.left );
      }
      i++;
      if( i < A.size() && A.get( i ) != -1 )
      {
        node.right = new TreeNode( A.get( i ) );
        queue.add( node.right );
      }
      i++;
    }
    return root;
  }

  private static ArrayList<Integer> serializeBinaryTree( TreeNode A )
  {
    int front = 0;
    ArrayList<Integer> result = new ArrayList<>();
    ArrayList<TreeNode> queue = new ArrayList<>();
    queue.add( A );
    while( front < queue.size() )
    {
      TreeNode node = queue.get( front );
      if( node != null )
      {
        result.add( node.val );
        queue.add( node.left );
        queue.add( node.right );
      }
      else
      {
        result.add( -1 );
      }
      front++;
    }
    return result;
  }

  public static void main( String[] args )
  {
    int[] arr1 = new int[] { 1, 2, 3, 4, 5 };
    int[] arr2 = new int[] { 3, 2, 4, 1, 5 };
    ArrayList<Integer> array1 = ArrayUtility.convertArrayToList( arr1 );
    ArrayList<Integer> array2 = ArrayUtility.convertArrayToList( arr2 );
    System.out.println( Trees1.postorderTraversal( Trees1.buildTreeFromInorderAndPreorder( array1, array2 ) ) );
  }
}
