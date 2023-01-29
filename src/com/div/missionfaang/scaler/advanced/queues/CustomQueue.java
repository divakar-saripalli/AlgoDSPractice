package com.div.missionfaang.scaler.advanced.queues;

public class CustomQueue<T>
{

  private ListNode front = null;
  private ListNode rear = null;

  public void add( int val )
  {
    if( rear != null )
    {
      rear.setNext( new ListNode( val ) );
    }
    else
    {
      front = new ListNode( val );
      rear = front;
    }
  }

  public void remove()
  {
    front.setNext( front.getNext() );
  }

  public Object peek()
  {
    return front.getVal();
  }

  public boolean isEmpty()
  {
    return front == rear && front == null;
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

  static void printList( ListNode tail )
  {
    while( tail.next != null )
    {
      System.out.print( tail.val + " --> " );
      tail = tail.next;
    }
    System.out.println( tail.val );
  }

  public int getVal()
  {
    return val;
  }

  public ListNode getNext()
  {
    return next;
  }

  public void setNext( ListNode next_ )
  {
    next = next_;
  }

  @Override
  public String toString()
  {
    return val + "";
  }
}
