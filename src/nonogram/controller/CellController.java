package controller;

import javax.swing.JButton;

import java.awt.Color;

/**
 * The GameBoardController class is responsible for controlling the game board - modifying the cells color and text.
 */
public class CellController {
  private final Color WHITE_COLOR = Color.WHITE;
  private final Color BLACK_COLOR = Color.BLACK;
  private final Color GRAY_COLOR = Color.LIGHT_GRAY;
  private final String EMPTY_TEXT = "";
  private final String CROSS_TEXT = "X";

  /**
   * Changes the color and text of the given JButton to the next color and text in the sequence.
   * 
   * @param targetCell the JButton to modify
   */
  public void changeCellColorAndText(JButton targetCell) {
    Color nextColor = getNextColor(targetCell.getBackground());
    String nextText = getNextText(nextColor);

    targetCell.setBackground(nextColor);
    targetCell.setText(nextText);
  }

  private Color getNextColor(Color currentColor) {
    if (WHITE_COLOR.equals(currentColor)) {
      return BLACK_COLOR;
    } else if (BLACK_COLOR.equals(currentColor)) {
      return GRAY_COLOR;
    } else {
      return WHITE_COLOR;
    }
  }

  private String getNextText(Color nextColor) {
    if (GRAY_COLOR.equals(nextColor)) {
      return CROSS_TEXT;
    } else {
      return EMPTY_TEXT;
    }
  }
  
}
