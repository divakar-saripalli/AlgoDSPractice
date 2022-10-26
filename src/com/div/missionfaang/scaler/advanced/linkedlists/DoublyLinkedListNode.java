package com.div.missionfaang.scaler.advanced.linkedlists;

class DoublyLinkedListNode
{
  public DoublyLinkedListNode next;
  int val;
  int key;
  DoublyLinkedListNode prev;

  DoublyLinkedListNode( int k, int value )
  {
    key = k;
    val = value;
    next = null;
    prev = null;
  }

  @Override
  public String toString()
  {
    return "Key :: " + key + " Value :: " + val;
  }

  static void printList( DoublyLinkedListNode head )
  {
    DoublyLinkedListNode start = head;
    while( start != null )
    {
      System.out.print( "( " + start.key + " , " + start.val + " )" );
      if( start.next != null )
      {
        System.out.print( " --> " );
      }
      start = start.next;
    }
    System.out.println();
  }
}
