package com.div.missionfaang.scaler.advanced.backtracking;

import com.div.missionfaang.scaler.ArrayUtility;

import java.util.ArrayList;

public class RatInMaze
{

  public static boolean solve( ArrayList<ArrayList<Integer>> maze )
  {
    ArrayList<ArrayList<Boolean>> visited = new ArrayList<>();
    int index = 0;
    for( ArrayList<Integer> row : maze )
    {
      visited.add( new ArrayList<>() );
      for( Integer ignored : row )
      {
        visited.get( index ).add( false );
      }
      index++;
    }
    return canRatReachHouse( maze, visited, 0, 0 );
  }

  public static ArrayList<String> solveMazePath( ArrayList<ArrayList<Integer>> maze )
  {
    ArrayList<ArrayList<Boolean>> visited = new ArrayList<>();
    int index = 0;
    for( ArrayList<Integer> row : maze )
    {
      visited.add( new ArrayList<>() );
      for( Integer ignored : row )
      {
        visited.get( index ).add( false );
      }
      index++;
    }
    ArrayList<String> possiblePaths = new ArrayList<>();
    canRatReachHouse( maze, visited, 0, 0, new StringBuilder(), possiblePaths );
    return possiblePaths;
  }

  public static boolean canRatReachHouse( ArrayList<ArrayList<Integer>> maze, ArrayList<ArrayList<Boolean>> visited, int rowIndex, int colIndex )
  {
    if( rowIndex >= maze.size() || colIndex >= maze.get( 0 ).size() || rowIndex < 0 || colIndex < 0 )
    {
      return false;
    }
    if( maze.get( rowIndex ).get( colIndex ) == 0 )
    {
      return false;
    }
    if( visited.get( rowIndex ).get( colIndex ) )
    {
      return false;
    }
    if( rowIndex == maze.size() - 1 && colIndex == maze.get( 0 ).size() - 1 )
    {
      return true;
    }
    visited.get( rowIndex ).set( colIndex, true );

    if( canRatReachHouse( maze, visited, rowIndex, colIndex + 1 ) )
    {
      return true;
    }
    else if( canRatReachHouse( maze, visited, rowIndex, colIndex - 1 ) )
    {
      return true;
    }
    else if( canRatReachHouse( maze, visited, rowIndex + 1, colIndex ) )
    {
      return true;
    }
    else
    {
      return canRatReachHouse( maze, visited, rowIndex - 1, colIndex );
    }
  }

  public static void canRatReachHouse(
      ArrayList<ArrayList<Integer>> maze,
      ArrayList<ArrayList<Boolean>> visited,
      int rowIndex,
      int colIndex,
      StringBuilder path,
      ArrayList<String> possiblePaths )
  {
    if( rowIndex >= maze.size() || colIndex >= maze.get( 0 ).size() || rowIndex < 0 || colIndex < 0 )
    {
      path.deleteCharAt( path.length() - 1 );
      return;
    }
    if( maze.get( rowIndex ).get( colIndex ) == 0 )
    {
      path.deleteCharAt( path.length() - 1 );
      return;
    }
    if( visited.get( rowIndex ).get( colIndex ) )
    {
      path.deleteCharAt( path.length() - 1 );
      return;
    }
    if( rowIndex == maze.size() - 1 && colIndex == maze.get( 0 ).size() - 1 )
    {
      possiblePaths.add( path.toString() );
      path.deleteCharAt( path.length() - 1 );
      return;
    }
    visited.get( rowIndex ).set( colIndex, true );

    canRatReachHouse( maze, visited, rowIndex, colIndex + 1, path.append( 'R' ), possiblePaths );
    canRatReachHouse( maze, visited, rowIndex + 1, colIndex, path.append( 'D' ), possiblePaths );
    canRatReachHouse( maze, visited, rowIndex, colIndex - 1, path.append( 'L' ), possiblePaths );
    canRatReachHouse( maze, visited, rowIndex - 1, colIndex, path.append( 'U' ), possiblePaths );
    if( !path.isEmpty() )
    {
      path.deleteCharAt( path.length() - 1 );
      visited.get( rowIndex ).set( colIndex, false );
    }
  }

  public static void main( String[] args )
  {
    int[][] arrMaze = new int[][] {
        { 1, 1, 1 },
        { 1, 0, 1 },
        { 1, 1, 1 }
    };

    ArrayList<ArrayList<Integer>> matrixMaze = ArrayUtility.convert2DArrayTo2DList( arrMaze );
    System.out.println( solveMazePath( matrixMaze ) );

    arrMaze = new int[][] {
        { 1, 0 },
        { 1, 0 }
    };
    matrixMaze = ArrayUtility.convert2DArrayTo2DList( arrMaze );
    System.out.println( solveMazePath( matrixMaze ) );

    arrMaze = new int[][] {
        { 1, 0, 0, 0 },
        { 1, 1, 0, 1 },
        { 1, 1, 0, 0 },
        { 0, 1, 1, 1 }
    };
    matrixMaze = ArrayUtility.convert2DArrayTo2DList( arrMaze );
    System.out.println( solveMazePath( matrixMaze ) );
  }
}
