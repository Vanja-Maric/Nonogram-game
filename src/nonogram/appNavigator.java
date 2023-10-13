import javax.swing.*;
import nonogram.NonogramGridCreator;

public class appNavigator implements StartGameListener {
  private JFrame appFrame;

  public appNavigator() {
    appFrame = new JFrame("Nonogram");
    setGameFrameCharacteristics();
    showStartGamePage();
  }

  private void setGameFrameCharacteristics() {
    appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    appFrame.setSize(800, 600);
    appFrame.setVisible(true);
    appFrame.setLocationRelativeTo(null); // Set JFrame to the middle of the screen
  }

  private void showStartGamePage() {
    StartPage startPageClass = new StartPage();
    startPageClass.setStartGameListener(this);
    JPanel startPage = startPageClass.getStartPage();
    appFrame.add(startPage);
  }

  @Override
  public void startGameButtonClicked(int numberOfRowsAndCollumns) {
    appFrame.getContentPane().removeAll();
    showGame(numberOfRowsAndCollumns);
    appFrame.revalidate(); // Refresh layout
    appFrame.repaint();
  }

  private void showGame(int numberOfRowsAndCollumns ) {
    NonogramGridCreator nGridCreator = new NonogramGridCreator("src/images/flower.png", numberOfRowsAndCollumns, numberOfRowsAndCollumns); // TODO: JUST HARD CODED IMAGES NOW

    Game nonogrmGame = new Game(nGridCreator.getBlackAndWhiteGrid());
    // TODO: ADD METHOD THAT I AM GOING TO CREATE NEXT IN GAME
    appFrame.add(nonogrmGame.getGame());
  }

}
