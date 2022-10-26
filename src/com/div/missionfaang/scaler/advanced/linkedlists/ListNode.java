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

  static void printList( ListNode tail )
  {
    while( tail.next != null )
    {
      System.out.print( tail.val + " -->" );
      tail = tail.next;
    }
    System.out.println( tail.val );
  }

  @Override
  public String toString()
  {
    return val + "";
  }
}
