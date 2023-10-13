import javax.swing.*;

public class appNavigator implements StartGameListener {
  private JFrame gameFrame;

  public appNavigator() {
    gameFrame = new JFrame("Nonogram");
    setGameFrameCharacteristics();
    showStartGamePage();
  }

  private void setGameFrameCharacteristics() {
    gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    gameFrame.setSize(800, 600);
    gameFrame.setVisible(true);
    gameFrame.setLocationRelativeTo(null); // Set JFrame to the middle of the screen
  }

  private void showStartGamePage() {
    StartPage startPageClass = new StartPage();
    startPageClass.setStartGameListener(this);
    JPanel startPage = startPageClass.getStartPage();
    gameFrame.add(startPage);
  }

  @Override
  public void startGameButtonClicked(int numberOfRowsAndCollumns) {
    gameFrame.getContentPane().removeAll();
    System.out.println(numberOfRowsAndCollumns);
    gameFrame.revalidate(); // Refresh layout
    gameFrame.repaint();
  }
}
