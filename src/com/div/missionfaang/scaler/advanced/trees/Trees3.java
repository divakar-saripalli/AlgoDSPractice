package com.div.missionfaang.scaler.advanced.trees;

import java.util.ArrayList;

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

  public static void main( String[] args )
  {
    TreeNode root = new TreeNode( 14 );
    root.left = new TreeNode( 1 );
    root.right = new TreeNode( 20 );
    System.out.println( Trees3.twoSumBST( root, 21 ) );
  }
}
