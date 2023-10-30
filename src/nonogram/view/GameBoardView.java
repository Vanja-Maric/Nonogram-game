package view;

import javax.swing.Box;
import javax.swing.JButton;

import java.util.ArrayList;

public class GameBoardView {
  private ArrayList<ArrayList<JButton>> gameCells = new ArrayList<ArrayList<JButton>>();

  public Box getGameBoard(String[][] nonogramGrid) {
    return createGameBoard(nonogramGrid);
  }

  public ArrayList<ArrayList<JButton>> getGameCells() {
    return gameCells;
  }

  private Box createGameBoard(String[][] nonogramGrid) {
    Box gameBoard = Box.createVerticalBox();
    NonogramCountsView nonogramCountsView = new NonogramCountsView(nonogramGrid);
    Box countsInAllColumns = nonogramCountsView.getNonogramColumnsCounts();
    gameBoard.add(countsInAllColumns);

    for (int row = 0; row < nonogramGrid.length; row++) {
      Box oneRowOfGameBoard = Box.createHorizontalBox();
      Box countsInOneRow = nonogramCountsView.getNonogramOneRowCounts(row);

      oneRowOfGameBoard.add(countsInOneRow);
      oneRowOfGameBoard.add(createOneRowOfGameCellsRow(nonogramGrid[row]));

      gameBoard.add(oneRowOfGameBoard);
    }

    return gameBoard;
  }

  private Box createOneRowOfGameCellsRow(String[] oneRowOfNonogramGrid) {
    ArrayList<JButton> gameCellsInOneRow = new ArrayList<JButton>(); 

    for (int cell = 0; cell < oneRowOfNonogramGrid.length; cell++) {
      JButton gameCell = gameCell();
      gameCellsInOneRow.add(gameCell);
    }
    gameCells.add(gameCellsInOneRow);

    return getGameCells(gameCellsInOneRow);
  }

  private Box getGameCells(ArrayList<JButton> gameCellsInOneRow) {
    Box gameCellsOneRowBox = Box.createHorizontalBox();

    for (JButton gameCell : gameCellsInOneRow) {
      gameCellsOneRowBox.add(gameCell);
    }

    return gameCellsOneRowBox;
  }

  private JButton gameCell() {
    JButton gameCell = new GameCell();
    return gameCell;
  }

}
