package view;

import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

/**
 * The AppButton class represents a custom button used in the Nonogram game
 * application.
 */
public class AppButton extends JButton {
  private final int BUTTON_WIDTH = 120;
  private final int BUTTON_HEIGHT = 30;
  private final Color BUTTON_BACKGROUND_COLOR = java.awt.Color.YELLOW;
  private final Color BUTTON_BORDER_COLOR = Color.BLACK;
  private final int BUTTON_BORDER_WIDTH = 1;

  /**
   * Constructs a new AppButton with the specified text and action listener.
   * 
   * @param buttonText     the text to display on the button
   * @param actionListener the action listener to be notified when the button is
   *                       clicked
   */
  public AppButton(String buttonText, ActionListener actionListener) {
    super(buttonText);
    setButtonSize();
    setButtonColor();
    setButtonBorder();
    this.addActionListener(actionListener);
  }

  private void setButtonSize() {
    Dimension buttonSize = new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT);
    setMinimumSize(buttonSize);
    setMaximumSize(buttonSize);
    setPreferredSize(buttonSize);
  }

  private void setButtonColor() {
    setBackground(BUTTON_BACKGROUND_COLOR);
  }

  private void setButtonBorder() {
    Border border = new LineBorder(BUTTON_BORDER_COLOR, BUTTON_BORDER_WIDTH);
    setBorder(border);
  }
}
