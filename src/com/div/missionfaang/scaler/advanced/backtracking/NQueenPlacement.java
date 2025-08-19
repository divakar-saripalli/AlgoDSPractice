package com.div.missionfaang.scaler.advanced.backtracking;

import java.util.ArrayList;

public class NQueenPlacement
{
  public static void solve(
      int rowIndex,
      ArrayList<Integer> availableColumnsList,
      ArrayList<Integer> availableDiagnolList,
      ArrayList<Integer> availableAntiDiagnolList,
      ArrayList<Integer> queensPlacementList )
  {
    if( rowIndex < availableColumnsList.size() )
    {
      int columnIndex = 0;
      int columnMarked = -1;
      int diagnolMarked = -1;
      int antiDiagnolMarked = -1;
      for( ; columnIndex < availableColumnsList.size(); columnIndex++ )
      {
        if( availableColumnsList.get( columnIndex ) == 0 && (
            availableDiagnolList.get( availableColumnsList.size() + rowIndex - columnIndex - 1 ) == 0) && (
            availableAntiDiagnolList.get( columnIndex + rowIndex ) == 0) )
        {
          columnMarked = columnIndex;
          diagnolMarked = availableColumnsList.size() + rowIndex - columnIndex - 1;
          antiDiagnolMarked = columnIndex + rowIndex;
          availableColumnsList.set( columnIndex, 1 );
          availableDiagnolList.set( diagnolMarked, 1 );
          availableAntiDiagnolList.set( antiDiagnolMarked, 1 );
          queensPlacementList.add( columnIndex );
          solve( rowIndex + 1, availableColumnsList, availableDiagnolList, availableAntiDiagnolList, queensPlacementList );
        }
      }
//      if(!queensPlacementList.isEmpty() && columnMarked > -1)
//      {
//        queensPlacementList.remove( queensPlacementList.size() - 1 );
//      }
      if(columnMarked > -1)
      {
        availableColumnsList.set( columnMarked, 0 );
      }
      if(diagnolMarked > -1)
      {
        availableDiagnolList.set( diagnolMarked, 0 );
      }
      if(antiDiagnolMarked > -1)
      {
        availableAntiDiagnolList.set( antiDiagnolMarked, 0 );
      }
    }
    else
    {
      System.out.println( queensPlacementList );
    }
  }

  public static void main( String[] args )
  {
    int N = 4;
    ArrayList<Integer> columnList = new ArrayList<>();
    ArrayList<Integer> diagnolList = new ArrayList<>();
    ArrayList<Integer> antiDiagnolList = new ArrayList<>();
    ArrayList<Integer> queensPlacementList = new ArrayList<>();

    for( int i = 0; i < N; i++ )
    {
      columnList.add( 0 );
    }
    for( int i = 0; i < 2*N - 2; i++ )
    {
      diagnolList.add( 0 );
      antiDiagnolList.add( 0 );
    }
//    columnList.set( 0, 1 );
//    diagnolList.set( N, 1 );
//    antiDiagnolList.set( 0, 1 );
//    queensPlacementList.add( 0 );
    solve( 0, columnList, diagnolList, antiDiagnolList, queensPlacementList );
    System.out.println( queensPlacementList );
  }
}
