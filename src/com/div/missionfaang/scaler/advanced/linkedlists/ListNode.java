package com.div.missionfaang.scaler.advanced.linkedlists;

class ListNode
{
  final int val;
  public ListNode next;

  ListNode( int x )
  {
    val = x;
    next = null;
  }

  @Override
  public String toString()
  {
    return val + "";
  }
}
