package view;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import controller.GameBoardController;
import model.NonogramCounts;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Color;

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
      JButton nonogramCell = createCell();
      gameCellsInOneRow.add(nonogramCell);
      buttonRowBox.add(nonogramCell);
    }

    gameCells.add(gameCellsInOneRow);
    return buttonRowBox;
  }

  private JButton createCell() {
    JButton gameCell = new JButton();

    setCellButtonColor(gameCell, Color.WHITE);
    setCellButtonSize(gameCell, 20, 20);
    setCellBorder(gameCell, 1, Color.GRAY);
    addClickListener(gameCell);

    return gameCell;
  }

  private void setCellButtonColor(JButton gameCell, Color colorOfCell) {
    gameCell.setOpaque(true);
    gameCell.setFocusPainted(false);
    gameCell.setBackground(colorOfCell);
  }

  private void setCellButtonSize(JButton gameCell, int width, int height) {
    Dimension buttonSize = new Dimension(width, height);
    gameCell.setMaximumSize(buttonSize);
    gameCell.setMinimumSize(buttonSize);
    gameCell.setPreferredSize(buttonSize);
  }

  private void setCellBorder(JButton gameCell, int borderWidth, Color borderColor) {
    gameCell.setBorder(new LineBorder(borderColor, borderWidth));
  }

  private void addClickListener(JButton gameCell) {
    gameCell.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        GameBoardController gameTableController = new GameBoardController();
        gameTableController.changeCellColorAndText(gameCell);
      }
    });
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