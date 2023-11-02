package view;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * This class represents the main application frame for the Nonogram game.
 * It contains methods to add content to the frame, remove all content from the
 * frame,
 * refresh the content of the frame, and show the frame. It also creates the
 * JFrame
 * and sets its characteristics such as title, size, and location.
 */
public class AppFrame {
  private JFrame appFrame;

  /**
   * Constructs a new AppFrame object, which represents the main window of the
   * Nonogram game.
   */
  public AppFrame() {
    createAppFrame();
  }

  /**
   * Adds a JPanel to the AppFrame.
   * 
   * @param content the JPanel to be added to the AppFrame
   */
  public void addContentToAppFrame(JPanel content) {
    appFrame.add(content);
  }

  /**
   * Removes all content from the app frame's content pane.
   */
  public void removeAllContent() {
    appFrame.getContentPane().removeAll();
  }

  /**
   * Refreshes the content of the app frame by revalidating and repainting it.
   */
  public void refreshContent() {
    appFrame.revalidate();
    appFrame.repaint();
  }

  /**
   * Displays the application frame.
   */
  public void showAppFrame() {
    appFrame.setVisible(true);
  }

  private void createAppFrame() {
    appFrame = new JFrame("Nonogram");
    setGameFrameCharacteristics();
  }

  private void setGameFrameCharacteristics() {
    appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    appFrame.setSize(1000, 850);
    appFrame.setLocationRelativeTo(null); // Set JFrame to the middle of the screen
  }

}
