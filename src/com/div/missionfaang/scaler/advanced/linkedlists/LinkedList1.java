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
      if( B == 1 )
      {
        A = prev;
      }
    }
    return A;
  }

  private static ListNode deleteMiddleNode( ListNode A )
  {
    if( A == null || A.next == null )
    {
      return null;
    }
    ListNode prev = A;
    ListNode curr = A;
    ListNode fp = A;
    while( fp != null && fp.next != null )
    {
      prev = curr;
      curr = curr.next;
      fp = fp.next.next;
    }
    prev.next = curr.next;
    return A;
  }

  /**
   * Problem Description
   * Given a singly linked list A and an integer B, reverse the nodes of the list B at a time and return the modified linked list.
   * <p>
   * <p>
   * <p>
   * Problem Constraints
   * 1 <= |A| <= 10^3
   * <p>
   * B always divides A
   * <p>
   * Example Input
   * Input 1:
   * <p>
   * A = [1, 2, 3, 4, 5, 6]
   * B = 2
   * Input 2:
   * <p>
   * A = [1, 2, 3, 4, 5, 6]
   * B = 3
   * <p>
   * <p>
   * Example Output
   * Output 1:
   * <p>
   * [2, 1, 4, 3, 6, 5]
   * Output 2:
   * <p>
   * [3, 2, 1, 6, 5, 4]
   *
   * @param A
   * @param B
   * @return
   */
  private static ListNode reverseList( ListNode A, int B )
  {
    ListNode current = A;
    ListNode next = null;
    ListNode prev = null;
    int count = 0;
    while( current != null && count < B )
    {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
      count++;
    }
    if( next != null )
    {
      A.next = LinkedList1.reverseList( next, B );
    }
    return prev;
  }

  /**
   * Problem Description
   * Given a linked list A, remove the B-th node from the end of the list and return its head.
   * <p>
   * For example, Given linked list: 1->2->3->4->5, and B = 2.
   * <p>
   * After removing the second node from the end, the linked list becomes 1->2->3->5.
   * <p>
   * NOTE: If B is greater than the size of the list, remove the first node of the list.
   * <p>
   * NOTE: Try doing it using constant additional space.
   *
   * @param A
   * @param B
   * @return
   */
  private static ListNode removeNthFromEnd( ListNode A, int B )
  {
    ListNode fp = A;
    for( int i = 1; i <= B && fp != null; i++ )
    {
      fp = fp.next;
    }
    if( fp == null )
    {
      return A.next;
    }
    ListNode node = A;
    while( fp.next != null )
    {
      node = node.next;
      fp = fp.next;
    }
    node.next = node.next.next;
    return A;
  }

  public static void main( String[] args )
  {
    ListNode head = new ListNode( 1 );
    head.next = new ListNode( 2 );
    head.next.next = new ListNode( 3 );
    head.next.next.next = new ListNode( 4 );
    head.next.next.next.next = new ListNode( 5 );
    head.next.next.next.next.next = new ListNode( 6 );
    ListNode newHead = LinkedList1.reverseList( head, 3 );
    while( newHead != null )
    {
      System.out.print( newHead );
      if( newHead.next != null )
      {
        System.out.print( "-->" );
      }
      newHead = newHead.next;
    }
    System.out.println();
  }

  public int middleElementOfList( ListNode A )
  {
    if( A.next == null )
    {
      return A.val;
    }
    ListNode curr = A;
    ListNode fp = A;
    while( fp != null && fp.next != null )
    {
      curr = curr.next;
      fp = fp.next.next;
    }
    return curr.val;
  }

  private static ListNode reverseList( ListNode A )
  {
    ListNode curr = A;
    ListNode prev = null;
    if( A.next == null )
    {
      return A;
    }
    while( curr != null )
    {
      ListNode temp = curr.next;
      curr.next = prev;
      prev = curr;
      curr = temp;
    }
    return prev;
  }

  private static ListNode deleteDuplicates( ListNode A )
  {
    ListNode node = A;
    while( node != null )
    {
      if( node.next != null && node.next.val == node.val )
      {
        node.next = node.next.next;
      }
      node = node.next;
    }
    return A;
  }
}

