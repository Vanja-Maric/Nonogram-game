package view;

import javax.swing.Box;
import javax.swing.JButton;

import model.NonogramCounts;

import java.util.ArrayList;

public class GameBoardView {
  private NonogramCounts nonogramCounts;
  private ArrayList<ArrayList<JButton>> gameCells = new ArrayList<ArrayList<JButton>>();

  public Box getGameBoard(String[][] nonogramGrid) {
    nonogramCounts = new NonogramCounts(nonogramGrid);
    return createGameBoard(nonogramGrid);
  }

  public ArrayList<ArrayList<JButton>> getGameCells() {
    return gameCells;
  }

  private Box createGameBoard(String[][] nonogramGrid) {
    Box gameBoard = Box.createVerticalBox();
    gameBoard.add(columnCounts());

    for (int row = 0; row < nonogramGrid.length; row++) {
      Box oneRowOfGameBoard = Box.createHorizontalBox();
      oneRowOfGameBoard.add(oneRowCounts(row));
      oneRowOfGameBoard.add(getOneNonogramRow(nonogramGrid[row]));
      gameBoard.add(oneRowOfGameBoard);
    }

    return gameBoard;
  }

  private Box getOneNonogramRow(String[] oneRowOfNonogramGrid) {
    Box buttonRowBox = Box.createHorizontalBox();
    ArrayList<JButton> gameCellsInOneRow = new ArrayList<JButton>();

    for (int cell = 0; cell < oneRowOfNonogramGrid.length; cell++) {
      JButton nonogramCell = gameCell();
      gameCellsInOneRow.add(nonogramCell);
      buttonRowBox.add(nonogramCell);
    }

    gameCells.add(gameCellsInOneRow);
    return buttonRowBox;
  }

  private JButton gameCell() {
    JButton gameCell = new GameCell();
    return gameCell;
  }

  private Box columnCounts() {
    NonogramCountsView nonogramCountsView = new NonogramCountsView();

    Box columnCounts = nonogramCountsView.getNonogramColumnsCounts(nonogramCounts.getNonogramColumnCounts(),
        nonogramCounts.getHighestSizeOfCountsInColumns(), nonogramCounts.getHighestSizeOfCountsInRows());

    return columnCounts;
  }

  private Box oneRowCounts(int row) {
    NonogramCountsView nonogramCountsView = new NonogramCountsView();

    Box oneRowCounts = nonogramCountsView.getNonogramOneRowCounts(nonogramCounts.getNonogramRowCounts().get(row),
        nonogramCounts.getHighestSizeOfCountsInRows());

    return oneRowCounts;
  }

}
