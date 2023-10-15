package view;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class AppFrame {
  private JFrame appFrame;

  public void addContentToAppFrame(JPanel content) {
    appFrame.add(content);
  }

  public void removeAllContent() {
    appFrame.getContentPane().removeAll();
  }

  public void refreshContent() {
    appFrame.revalidate();
    appFrame.repaint();
  }

  public void showAppFrame(JFrame appFrame) {
    appFrame.setVisible(true);
  }

  public JFrame getAppFrame() {
    return createAppFrame();
  }

  private JFrame createAppFrame() {
    appFrame = new JFrame("Nonogram");
    setGameFrameCharacteristics();
    return appFrame;
  }

  private void setGameFrameCharacteristics() {
    appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    appFrame.setSize(800, 600);
    appFrame.setLocationRelativeTo(null); // Set JFrame to the middle of the screen
  }
}
