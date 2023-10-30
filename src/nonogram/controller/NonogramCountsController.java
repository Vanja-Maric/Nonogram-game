package controller;

import java.awt.Color;

import javax.swing.JButton;

/**
 * The NonogramCountsController class is responsible for controlling the count cells of the Nonogram game.
 * It provides a method to toggle the background color of a given count cell between active(Yellow) and inactive(Gray) colors.
 */
public class NonogramCountsController {
  
  private final Color ACTIVE_COLOR = Color.YELLOW;
  private final Color INACTIVE_COLOR = Color.GRAY;

  /**
   * Toggles the background color of the given count cell between active and inactive colors.
   * 
   * @param targetCountCell The cell whose color needs to be toggled.
   */
  public void applyToggleCountCellColor(JButton targetCountCell) {
    toggleCountCellColor(targetCountCell);
  }

  private void toggleCountCellColor (JButton targetCountCell) {
    Color targetColor = targetCountCell.getBackground();
    
    if (ACTIVE_COLOR.equals(targetColor)) {
      targetCountCell.setBackground(INACTIVE_COLOR);
    } else {
      targetCountCell.setBackground(ACTIVE_COLOR);
    }
  }
  
}
