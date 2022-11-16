package com.div.missionfaang.scaler.advanced.trees;

public class Trees4
{

  //  private static int treeDiameter( TreeNode A, ArrayList<Integer> leftRightMaximums_ )
  //  {
  //    ArrayList<Integer> leftRightMaximums = new ArrayList<>();
  //    leftRightMaximums.add( 0 );
  //    leftRightMaximums.add( 0 );
  //    Trees4.treeDiameter( A, leftRightMaximums );
  //    return leftRightMaximums.get( 0 ) + leftRightMaximums.get( 1 );
  //  }
  //
  //  private static int treeDiameter( TreeNode A, ArrayList<Integer> leftRightMaximums )
  //  {
  //    if(A != null){
  //      if( A.left != null ) {
  //        leftRightMaximums.set( 0,  )
  //        Trees4.treeDiameter( A.left,  );
  //      }
  //    }
  //    rightMax = Math.max( leftMax, Trees4.treeDiameter( A.right, leftMax, rightMax++ ) );
  //  }

  private static int isSameTree( TreeNode A, TreeNode B )
  {
    if( A != null || B != null )
    {
      if( A == null || B == null )
      {
        return 0;
      }
    }
    if( A != null && B != null )
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

  public static void main( String[] args )
  {

  }
}
