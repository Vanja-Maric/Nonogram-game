package controller;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JButton;

public class GamePageController {
  private static final String BLACK = "black";
  private static final String WHITE = "white";

  public boolean isSolutionCorrect(String[][] nonogramGrid, ArrayList<ArrayList<JButton>> userGrid) {
    return gridsAreEqual(nonogramGrid, userGrid);
  }

  public void applySolutionToBoard(String[][] nonogramGrid, ArrayList<ArrayList<JButton>> gameBoardCells) {
    for (int i = 0; i < nonogramGrid.length; i++) {
      for (int j = 0; j < nonogramGrid[i].length; j++) {
        applyColorToCell(gameBoardCells.get(i).get(j), nonogramGrid[i][j]);
      }
    }
  }

  private void applyColorToCell(JButton cell, String color) {
    if (BLACK.equalsIgnoreCase(color)) {
      cell.setBackground(Color.BLACK);
    } else {
      cell.setBackground(Color.WHITE);
    }
  }

  private boolean gridsAreEqual(String[][] nonogramGrid, ArrayList<ArrayList<JButton>> userGrid) {
    for (int i = 0; i < nonogramGrid.length; i++) {
      for (int j = 0; j < nonogramGrid[0].length; j++) {
        String currentCellColor = getColorFromTheCell(userGrid.get(i).get(j));

        if (!nonogramGrid[i][j].equalsIgnoreCase(currentCellColor)) {
          return false;
        }

      }
    }
    return true;
  }

  // Convert the cell background color to its string representation
  // If the cell is not black, then it is white. We convert the grey cells to
  // white cells.
  private String getColorFromTheCell(JButton currentCell) {
    if (currentCell.getBackground().equals(Color.BLACK)) {
      return BLACK;
    }
    return WHITE;
  }

}
