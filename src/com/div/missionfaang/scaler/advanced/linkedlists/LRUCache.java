package com.div.missionfaang.scaler.advanced.linkedlists;

import java.util.HashMap;

public class LRUCache
{
  private final HashMap<Integer, DoublyLinkedListNode> lruMap = new HashMap<>();
  private DoublyLinkedListNode lruHead = null;
  private DoublyLinkedListNode lruTail = null;
  private int lruCacheCapacity = 0;

  private LRUCache( int capacity )
  {
    lruCacheCapacity = capacity;
  }

  public static void main( String[] args )
  {
    LRUCache lruCache = new LRUCache( 11 );
    lruCache.set( 1, 1 );
    lruCache.get( 11 );
    lruCache.get( 11 );
    lruCache.set( 3, 10 );
    lruCache.get( 10 );
    lruCache.set( 3, 12 );
    lruCache.set( 1, 15 );
    lruCache.set( 4, 12 );
    lruCache.get( 15 );
    lruCache.set( 8, 6 );
    lruCache.set( 5, 3 );
    lruCache.get( 2 );
    lruCache.get( 12 );
    lruCache.get( 10 );
    lruCache.set( 11, 5 );
    lruCache.get( 7 );
    lruCache.set( 5, 1 );
    lruCache.set( 15, 5 );
    lruCache.get( 2 );
    lruCache.set( 13, 8 );
    lruCache.get( 3 );
    lruCache.set( 14, 2 );
    lruCache.set( 12, 11 );
    lruCache.set( 7, 10 );
    lruCache.set( 5, 4 );
    lruCache.get( 9 );
    lruCache.get( 2 );
    lruCache.set( 13, 5 );
    lruCache.set( 10, 14 );
    lruCache.set( 9, 11 );
    lruCache.get( 5 );
    lruCache.set( 13, 11 );
    lruCache.set( 8, 12 );
    lruCache.get( 10 );
    lruCache.set( 5, 12 );
    lruCache.get( 8 );
    lruCache.get( 11 );
    lruCache.get( 8 );
    lruCache.set( 9, 11 );
    lruCache.set( 10, 6 );
    lruCache.set( 7, 12 );
    lruCache.set( 1, 7 );
    lruCache.get( 10 );
    lruCache.get( 9 );
    lruCache.get( 15 );
  }

  public int get( int key )
  {
    // List is not empty and get the first element
    if( lruHead == null )
    {
      return -1;
    }
    if( lruHead.key == key )
    {
      if( lruMap.size() != 1 )
      {
        DoublyLinkedListNode node = lruHead;
        lruHead = lruHead.next;
        lruHead.prev = null;
        node.prev = lruTail;
        lruTail.next = node;
        node.next = null;
        lruTail = node;
        return lruTail.val;
      }
      else
      {
        return lruHead.val;
      }
    }
    else if( lruTail != null && lruTail.key == key )
    {
      return lruTail.val;
    }
    if( lruMap.containsKey( key ) )
    {
      DoublyLinkedListNode node = lruMap.get( key );
      int returnVal = node.val;
      if( lruMap.size() != 1 )
      {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = lruTail;
        lruTail.next = node;
        node.next = null;
        lruTail = node;
      }
      return returnVal;
    }
    return -1;
  }

  public void set( int key, int value )
  {
    DoublyLinkedListNode node;
    if( !lruMap.containsKey( key ) )
    {
      node = new DoublyLinkedListNode( key, value );
    }
    else
    {
      node = lruMap.get( key );
      node.val = value;
    }
    if( lruHead == null )
    {
      lruHead = node;
      lruTail = node;
      lruMap.put( key, node );
    }
    else if( lruMap.keySet().size() < lruCacheCapacity )
    {
      if( lruMap.containsKey( key ) )
      {
        if( lruHead.key == key )
        {
          lruHead = lruHead.next;
          if( lruHead != null )
          {
            lruHead.prev = null;
            node.prev = lruTail;
            node.next = null;
            lruTail.next = node;
            lruTail = node;
          }
          else
          {
            lruHead = lruTail = node;
          }
        }
        else if( lruTail.key != key )
        {
          node.prev.next = node.next;
          node.next.prev = node.prev;
          node.prev = lruTail;
          node.next = null;
          lruTail.next = node;
          lruTail = node;
        }
      }
      else
      {
        node.prev = lruTail;
        lruTail.next = node;
        lruTail = node;
        node.next = null;
        lruMap.put( key, node );
      }
    }
    else
    {
      if( lruMap.size() != 1 )
      {
        if( !lruMap.containsKey( key ) )
        {
          lruMap.remove( lruHead.key );
          lruHead = lruHead.next;
          if( lruHead != null )
          {
            lruHead.prev = null;
            node.prev = lruTail;
            lruTail.next = node;
            node.next = null;
          }
          else
          {
            lruHead = node;
          }
          lruTail = node;
          lruMap.put( key, node );
        }
        else
        {
          if( lruHead.key == key )
          {
            lruHead = lruHead.next;
            lruHead.prev = null;
            node.prev = lruTail;
            lruTail.next = node;
            node.next = null;
            lruTail = node;
          }
          else if( lruTail.key != key )
          {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = lruTail;
            node.next = null;
            lruTail.next = node;
            lruTail = node;
          }
        }
      }
      else
      {
        lruHead = lruTail = node;
        lruMap.clear();
        lruMap.put( key, node );
      }
    }
    DoublyLinkedListNode.printList( lruHead );
  }
}

