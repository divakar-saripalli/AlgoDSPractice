package com.div.missionfaang.scaler.advanced.linkedlists;

public class LinkedList2
{

  private static ListNode findMiddleNode( ListNode A )
  {
    ListNode curr = A;
    ListNode fp = A.next;
    while( fp != null && fp.next != null )
    {
      curr = curr.next;
      fp = fp.next.next;
    }
    return curr;
  }

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

  private static ListNode sortLinkedList( ListNode A )
  {
    if( A == null || A.next == null )
    {
      return A;
    }
    ListNode middleNode = LinkedList2.findMiddleNode( A );
    ListNode head2 = middleNode.next;
    middleNode.next = null;
    ListNode sortedListHead1 = LinkedList2.sortLinkedList( A );
    ListNode sortedListHead2 = LinkedList2.sortLinkedList( head2 );
    A = LinkedList2.mergeTwoSortedLists( sortedListHead1, sortedListHead2 );
    return A;
  }

  private static ListNode detectCycle( ListNode a )
  {
    if( a == null )
    {
      return null;
    }
    ListNode sp = a;
    ListNode fp = a;
    while( fp != null && sp != null )
    {
      fp = fp.next;
      if( fp != null )
      {
        fp = fp.next;
      }
      sp = sp.next;
      if( fp == sp )
      {
        break;
      }
    }
    if( fp == null || fp.next == null )
    {
      return null;
    }
    sp = a;
    while( sp != fp )
    {
      sp = sp.next;
      fp = fp.next;
    }
    return fp;
  }

  private static ListNode reorderList( ListNode A )
  {
    if( A == null || A.next == null )
    {
      return A;
    }
    ListNode fp = A;
    ListNode sp = A;
    ListNode spPrev = A;
    while( fp != null )
    {
      spPrev = sp;
      sp = sp.next;
      fp = fp.next;
      if( fp != null )
      {
        fp = fp.next;
      }
    }
    ListNode tail = sp;
    ListNode prev = null;
    spPrev.next = null;
    while( tail != null )
    {
      ListNode temp = tail.next;
      tail.next = prev;
      prev = tail;
      tail = temp;
    }

    //intervene both the lists
    ListNode head1 = A;
    ListNode head2 = prev;
    while( head2 != null )
    {
      ListNode temp = head2;
      head2 = head2.next;
      temp.next = head1.next;
      head1.next = temp;
      head1 = temp.next;
    }
    return A;
  }

  public static void main( String[] args )
  {
    ListNode head = new ListNode( 1 );
    ListNode tail = head;
    int[] array = new int[] {
        2, 3, 4, 5, 6
    };

    for( int i : array )
    {
      tail.next = new ListNode( i );
      tail = tail.next;
    }
    head = LinkedList2.reorderList( head );
    ListNode.printList( head );
  }

  public ListNode removeLoop( ListNode A )
  {
    if( A == null )
    {
      return A;
    }
    ListNode sp = A;
    ListNode fp = A;

    while( fp != null && sp != null )
    {
      fp = fp.next;
      if( fp != null )
      {
        fp = fp.next;
      }
      sp = sp.next;
      if( fp == sp )
      {
        break;
      }
    }

    if( fp == null || fp.next == null )
    {
      return A;
    }

    sp = A;
    ListNode lastNode = null;

    while( sp.next != fp.next )
    {
      sp = sp.next;
      lastNode = fp;
      fp = fp.next;
    }

    lastNode.next = null;

    return A;
  }

}
