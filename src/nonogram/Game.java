import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Color;

import nonogram.BlackWhiteNonogramCellCounts;

public class Game {
  String[][] nonogramGrid;

  public Game(String[][] nonogramGrid) {
    setNonogramGrid(nonogramGrid);
  }

  public Box getGame() {
    Box gameContainer = Box.createVerticalBox();
    BlackWhiteNonogramCellCounts bwCellCounts = new BlackWhiteNonogramCellCounts(nonogramGrid);
    gameContainer.add(getNonogramColumnsCountsCells(bwCellCounts.getBlackCellCountsInAllColumns()));
    gameContainer.add(createNonogramCellsGrid());
    return gameContainer;
  }

  private Box createNonogramCellsGrid() { // TODO: NAME
    BlackWhiteNonogramCellCounts bWhiteNonogramCellCounts = new BlackWhiteNonogramCellCounts(nonogramGrid); // TODO: DO not add this here
    ArrayList<ArrayList<Integer>> rowCo = bWhiteNonogramCellCounts.getBlackCellCountsInAllRows(); // TODO: REMOVE
    Box verticalBoxforButtonRows = Box.createVerticalBox();
    for (int row = 0; row < nonogramGrid.length; row++) {
      Box buttonRowBox = getNonogramOneRowCounts(rowCo, row); // TODO: REMOVE
      buttonRowBox.add(getOneNonogramRow(nonogramGrid[row]));
      verticalBoxforButtonRows.add(buttonRowBox);
    }
    return verticalBoxforButtonRows;
  }

  private Box getOneNonogramRow(String[] oneRowOfNonogramGrid) { // DONEEEEEEEEEEEEEEEEEEE
    Box buttonRowBox = Box.createHorizontalBox();
    for (int cell = 0; cell < oneRowOfNonogramGrid.length; cell++) {
      JButton nonogramCell = createCell();
      nonogramCell.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          changeCellValue(nonogramCell);
        }
      });
      buttonRowBox.add(nonogramCell);
    }
    return buttonRowBox;
  }

  private JButton createCell() { // DONEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE
    JButton button = new JButton();
    // Color cellColor = setCellColor(gridCellColor);
    button.setBackground(Color.WHITE);

    Dimension buttonSize = new Dimension(20, 20);
    button.setMaximumSize(buttonSize);
    button.setMinimumSize(buttonSize);
    button.setPreferredSize(buttonSize);
    button.setOpaque(true);
    button.setFocusPainted(false);
    int borderWidth = 1;
    Color borderColor = Color.GRAY;
    button.setBorder(new LineBorder(borderColor, borderWidth));
    return button;
  }

  private void changeCellValue(JButton targetCell) { // DONEEEEEEEEEEEEEEEEEEEEEEEEE
    Color currentCellColor = targetCell.getBackground();

    if (currentCellColor == Color.WHITE) {
      targetCell.setBackground(Color.BLACK);
      targetCell.setText("");
    } else if (currentCellColor == Color.BLACK) {
      targetCell.setBackground(Color.LIGHT_GRAY);
      targetCell.setText("X");
    } else {
      targetCell.setBackground(Color.WHITE);
      targetCell.setText("");
    }
  }

  private Box getNonogramColumnsCountsCells(ArrayList<ArrayList<Integer>> collumnCounts) {
    Box allCollumnCounts = Box.createHorizontalBox();
    int highestSizeOfCountsInAllRows = getHighestSizeOfCountsInRowsOrColumns(collumnCounts);

    int highestNumberOfColumnCounts = 3; // TODO: DO NOT HARD CODE THIS
    for (int i = 0; i < highestNumberOfColumnCounts; i++) { // TODO: THINK ABOUT THIS AND CHANGE NEXT 8 ROWS
      Box verticalBox = Box.createVerticalBox();
      for (int j = 0; j < highestSizeOfCountsInAllRows; j++) {
        JButton emptyButton = createCell();
        emptyButton.setBackground(Color.YELLOW);
        verticalBox.add(emptyButton);
      }
      allCollumnCounts.add(verticalBox);
    }

    for (ArrayList<Integer> countsInOneColumn : collumnCounts) {
      Box oneColumnCounts = Box.createVerticalBox();

      for (int i = 0; i < highestSizeOfCountsInAllRows; i++) {
        JButton buttonForCounts = createCell();
        buttonForCounts.setBackground(Color.YELLOW);
        if (countsInOneColumn.size() > i) {
          buttonForCounts.setText(countsInOneColumn.get(i).toString());
        }
        oneColumnCounts.add(buttonForCounts);
      }
      allCollumnCounts.add(oneColumnCounts);
    }

    // allCollumnCounts.add(emptyButtonsOverVerticalCounts);
    return allCollumnCounts;
  }

  private Box getNonogramOneRowCounts(ArrayList<ArrayList<Integer>> allRowsCounts, int targetRowNumber) {
    int highestSizeOfCountsInAllRows = getHighestSizeOfCountsInRowsOrColumns(allRowsCounts);
    ArrayList<Integer> targetRowCounts = allRowsCounts.get(targetRowNumber);
    Box oneRowCountsCells = Box.createHorizontalBox();

    for (int i = 0; i < highestSizeOfCountsInAllRows; i++) {
      JButton buttonForCounts = createCell();
      buttonForCounts.setBackground(Color.YELLOW);
      if (targetRowCounts.size() > i) {
        buttonForCounts.setText(targetRowCounts.get(i).toString());
      }
      oneRowCountsCells.add(buttonForCounts);
    }

    return oneRowCountsCells;
  }

  private int getHighestSizeOfCountsInRowsOrColumns(ArrayList<ArrayList<Integer>> rowOrColumnCounts) {
    int highestSizeOfCounts = 0;

    for (ArrayList<Integer> countsInOneColumn : rowOrColumnCounts) {
      if (countsInOneColumn.size() > highestSizeOfCounts) {
        highestSizeOfCounts = countsInOneColumn.size();
      }
    }

    return highestSizeOfCounts;
  }

  private void setNonogramGrid(String[][] nonogramGrid) {
    // TODO: Validate
    this.nonogramGrid = nonogramGrid;
  }
}
