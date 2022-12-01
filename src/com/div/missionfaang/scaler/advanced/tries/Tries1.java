package com.div.missionfaang.scaler.advanced.tries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Tries1
{
  private static ArrayList<String> prefix( ArrayList<String> A )
  {
    TrieNode root = new TrieNode();
    for( String string : A )
    {
      TrieNode parent = root;
      for( int i = 0; i < string.length(); i++ )
      {
        if( !parent.children.containsKey( string.charAt( i ) ) )
        {
          parent.children.put( string.charAt( i ), new TrieNode() );
        }
        parent = parent.children.get( string.charAt( i ) );
      }
    }
    ArrayList<String> result = new ArrayList<>();
    for( String string : A )
    {
      TrieNode parent = root;
      StringBuilder prefix = new StringBuilder();
      StringBuilder tempPrefix = new StringBuilder();
      for( int i = 0; i < string.length(); i++ )
      {
        if( parent.children.size() < 2 )
        {
          tempPrefix.append( string.charAt( i ) );
        }
        else
        {
          prefix.append( tempPrefix );
          prefix.append( string.charAt( i ) );
          tempPrefix = new StringBuilder();
        }
        parent = parent.children.get( string.charAt( i ) );
      }
      result.add( prefix.toString() );
    }
    return result;
  }

  private static void prefix( TrieNode root, String prefix, ArrayList<String> result )
  {
    if( root.children.size() > 1 )
    {
      for( Character character : root.children.keySet() )
      {
        Tries1.prefix( root.children.get( character ), prefix + character, result );
      }
    }
    else
    {
      result.add( 0, prefix );
    }
  }

  public static void main( String[] args )
  {
    String[] input = new String[] { "bearcat", "bert" };
    ArrayList<String> inputList = new ArrayList<>( Arrays.asList( input ) );
    System.out.println( Tries1.prefix( inputList ) );
  }
}

class TrieNode
{
  HashMap<Character, TrieNode> children = new HashMap<>();
}