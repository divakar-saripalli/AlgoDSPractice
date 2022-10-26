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
}
