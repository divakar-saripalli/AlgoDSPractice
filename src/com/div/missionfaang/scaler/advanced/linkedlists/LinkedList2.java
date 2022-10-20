package com.div.missionfaang.scaler.advanced.linkedlists;

public class LinkedList2
{

  private static ListNode mergeTwoSortedLists( ListNode A, ListNode B )
  {
    ListNode newHead = new ListNode( 0 );
    ListNode temp = newHead;
    while( A != null && B != null )
    {
      if( A.val <= B.val )
      {
        temp.next = A;
        A = A.next;
      }
      else
      {
        temp.next = B;
        B = B.next;
      }
      temp = temp.next;
    }
    if( A != null )
    {
      temp.next = A;
    }
    if( B != null )
    {
      temp.next = B;
    }
    return newHead.next;
  }

  public static void main( String[] args )
  {

  }

}
