package com.div.missionfaang.scaler.advanced.linkedlists;

public class LinkedList1
{

  private static ListNode reverseBetween( ListNode A, int B, int C )
  {
    if( A == null || A.next == null )
    {
      return A;
    }
    ListNode start1 = A;
    ListNode start2 = A;
    for( int i = 1; i < B && start2 != null; i++ )
    {
      start1 = start2;
      start2 = start2.next;
    }

    if( start2 != null )
    {
      ListNode prev = start2;
      ListNode curr = start2.next;
      for( int i = B; i < C && curr != null; i++ )
      {
        ListNode temp = curr.next;
        curr.next = prev;
        prev = curr;
        curr = temp;
      }
      start1.next = prev;
      start2.next = curr;
    }
    return (B == 1) ? start1 : A;
  }

  public static void main( String[] args )
  {
    ListNode head = new ListNode( 1 );
    head.next = new ListNode( 2 );
    head.next.next = new ListNode( 3 );
    ListNode newHead = LinkedList1.reverseBetween( head, 1, 2 );

  }
}

class ListNode
{
  private final int val;
  public ListNode next;

  ListNode( int x )
  {
    val = x;
    next = null;
  }
}
