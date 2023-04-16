package com.div.missionfaang.scaler.advanced;

import java.util.ArrayList;

public class Feb18Contest
{

  private static int solve( TreeNode A, int B )
  {
    return solve1( A, B, 0, 0, new ArrayList<Integer>() );
  }

  private static int solve1( TreeNode A, int B, int sum, int count, ArrayList<Integer> integers_ )
  {
    if( A != null )
    {
      sum += A.val;
      integers_.add( integers_.isEmpty() ? A.val : integers_.get( integers_.size() - 1 ) + A.val );
      if( sum == B || (sum > B && integers_.contains( sum - B )) || A.val == B )
      {
        count++;
      }
      int leftCount = solve1( A.left, B, sum, count, integers_ );
      int rightCount = solve1( A.right, B, sum, count, integers_ );
      count += leftCount + rightCount;
      return count;
    }
    return 0;
  }

  public static void main( String[] args )
  {
    TreeNode root = new TreeNode( 3 );
    root.left = new TreeNode( 2 );
    root.right = new TreeNode( -2 );
    root.left.left = new TreeNode( -2 );
    root.left.right = new TreeNode( 1 );
    root.right.right = new TreeNode( 1 );
    System.out.println( solve( root, 2 ) );
  }
}
