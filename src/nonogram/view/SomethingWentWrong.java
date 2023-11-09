package view;

import javax.swing.JLabel;

/**
 * SomethingWentWrong is a JLabel that is displayed when an error occurs.
 * It is used to display an error message to the user.
 */
public class SomethingWentWrong extends JLabel{

  /**
   * Constructor for SomethingWentWrong.
   * Sets the text of the JLabel to "Something went wrong. Please try again."
   */
  public SomethingWentWrong() {
    super("Something went wrong. Please try again.");
  }
}
