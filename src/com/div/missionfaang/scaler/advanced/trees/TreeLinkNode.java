package com.div.missionfaang.scaler.advanced.trees;

class TreeLinkNode
{
  final TreeLinkNode left;
  final TreeLinkNode right;
  private final int val;
  TreeLinkNode next;

  TreeLinkNode( int x )
  {
    val = x;
    left = null;
    right = null;
    next = null;
  }
}
