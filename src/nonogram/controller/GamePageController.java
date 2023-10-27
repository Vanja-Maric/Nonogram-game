package controller;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JButton;

public class GamePageController {
  public boolean checkSolution(String[][] nonogramGrid, ArrayList<ArrayList<JButton>> userGrid) {
    return compareGrids(nonogramGrid, userGrid);
  }

  public void solution(String[][] nonogramGrid, ArrayList<ArrayList<JButton>> gameBoardCells) {
    for (int i = 0; i < nonogramGrid.length; i++) {
      for (int j = 0; j < nonogramGrid[0].length; j++) {
        Color color = nonogramGrid[i][j].equalsIgnoreCase("black") ? Color.BLACK : Color.WHITE;
        gameBoardCells.get(i).get(j).setBackground(color);
      }
    }
  }

  private boolean compareGrids(String[][] nonogramGrid, ArrayList<ArrayList<JButton>> userGrid) {
    for (int i = 0; i < nonogramGrid.length; i++) {
      for (int j = 0; j < nonogramGrid[0].length; j++) {
        String currentCellColor = "white";
        if (userGrid.get(i).get(j).getBackground().equals(Color.BLACK)) {
          currentCellColor = "black";
        }
        if (!nonogramGrid[i][j].equalsIgnoreCase(currentCellColor)) {
          return false;
        }
      }
    }
    return true;
  }

}
