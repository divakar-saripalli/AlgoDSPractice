package com.div.missionfaang.googlequestions;

import java.util.HashMap;
import java.util.List;

/*
Google is building a video game with colonies (A, B, C) that can be allied.
If A and B are allied and B and C are allied, A and C are not allied, but we
call them associates.

Allies:
A + B
B + C
C + D

Associates:
A + C
A + D
B + D

Implement the following class:
*/

public class AlliesAndAssociates
{
  HashMap<String, String> map = new HashMap<>();

  public AlliesAndAssociates( List<Alliance> allies )
  {
    for( Alliance ally : allies )
    {
      if( map.containsKey( ally.colony1 ) && !map.get( ally.colony1 ).contains( ally.colony2 ) )
      {
        map.put( ally.colony1, map.get( ally.colony1 ) + ally.colony2 );
      }
      else if( !map.containsKey( ally.colony1 ) )
      {
        map.put( ally.colony1, ally.colony2 );
      }

      if( map.containsKey( ally.colony2 ) && !map.get( ally.colony2 ).contains( ally.colony1 ) )
      {
        map.put( ally.colony2, map.get( ally.colony2 ) + ally.colony1 );
      }
      else if( !map.containsKey( ally.colony2 ) )
      {
        map.put( ally.colony2, ally.colony1 );
      }
    }
  }

  public boolean areAllies( String colony1, String colony2 )
  {
    boolean result = false;
    if( map.get( colony1 ) != null )
    {
      result = map.get( colony1 ).contains( colony2 );
    }

    if( map.get( colony2 ) != null )
    {
      result = result || map.get( colony2 ).contains( colony1 );
    }
    return result;
  }

  public boolean areAssociates( String colony1, String colony2 )
  {
    String processedColonies = "";
    return checkAssociates( colony1, colony2, processedColonies );
  }

  public boolean checkAssociates( String colony1, String colony2, String processedColonies )
  {
    if( !processedColonies.contains( colony1 ) )
    {
      String allies = map.get( colony1 );
      for( int i = 0; i < allies.length(); i++ )
      {
        String suballies = map.get( allies.charAt( i ) + "" );
        if( suballies.contains( colony2 ) )
        {
          return true;
        }
        else
        {
          processedColonies = processedColonies + allies.charAt( i );
          if( checkAssociates( String.valueOf( allies.charAt( i ) ), colony2, processedColonies ) )
          {
            return true;
          }
        }
      }
    }
    return false;
  }

  static class Alliance
  {
    String colony1;
    String colony2;
  }
}
