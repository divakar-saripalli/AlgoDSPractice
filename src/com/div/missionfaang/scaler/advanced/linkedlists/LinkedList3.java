package com.div.missionfaang.scaler.advanced.linkedlists;

public class LinkedList3
{

  private static ListNode partition( ListNode A, int B )
  {
    ListNode head2 = A;
    ListNode prevHead2 = null;
    ListNode head1 = null;
    ListNode head3 = null;
    ListNode tail = null;

    while( head2 != null )
    {
      if( head2.val < B )
      {
        if( tail == null )
        {
          head1 = head2;
          tail = head2;
          if( prevHead2 != null )
          {
            prevHead2.next = head2.next;
          }
          if( prevHead2 != null )
          {
            head2 = prevHead2.next;
          }
          else
          {
            head2 = head2.next;
          }
        }
        else
        {
          if( prevHead2 != null )
          {
            prevHead2.next = head2.next;
          }
          tail.next = head2;
          tail = tail.next;
          if( prevHead2 != null )
          {
            head2 = prevHead2.next;
          }
          else
          {
            head2 = head2.next;
          }
        }
        tail.next = null;
      }
      else
      {
        prevHead2 = head2;
        if( head3 == null )
        {
          head3 = head2;
        }
        head2 = head2.next;
      }
    }
    if( tail != null )
    {
      if( head3 != null )
      {
        tail.next = head3;
      }
    }
    return head1;
  }

  public static void main( String[] args )
  {
    ListNode head = new ListNode( 593 );
    ListNode tail = head;
    int[] arr = new int[] { 475, 351, 395, 562, 2, 649, 790, 336, 698, 444, 18, 767, 31, 547, 561, 113, 379, 445, 7, 460, 131, 984, 829, 883, 729, 726,
        540, 560, 875, 481, 586, 196, 742, 951, 754, 666, 874, 241, 623, 881, 433, 51, 463, 895, 179, 712, 873 };
    for( int i : arr )
    {
      tail.next = new ListNode( i );
      tail = tail.next;
    }

    ListNode.printList( LinkedList3.partition( head, 79 ) );
  }
}
