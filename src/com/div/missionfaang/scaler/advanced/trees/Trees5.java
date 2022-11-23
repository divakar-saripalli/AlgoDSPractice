package com.div.missionfaang.scaler.advanced.trees;

public class Trees5
{

  private static TreeNode invertTree( TreeNode A )
  {
    if( A != null )
    {
      Trees5.invertTree( A.left );
      Trees5.invertTree( A.right );
      TreeNode temp = A.left;
      A.left = A.right;
      A.right = temp;
    }
    return A;
  }

  public static void main( String[] args )
  {

  }
}
