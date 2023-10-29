package controller;

import javax.swing.JFrame;

import model.NonogramGrid;
import view.AppFrame;
import view.GamePageView;
import view.StartPageView;


/**
 * The App class is responsible for starting the Nonogram game application and switching between the start page and the game page.
 * It implements the StartGameListener and BackToMainMenuListener interfaces to handle user interactions.
 */
public class App implements StartGameListener, BackToMainMenuListener {
  private AppFrame appFrame = new AppFrame();

  /**
   * This method is called when the start game button is clicked. It removes all content from the app frame,
   * shows the game page with the specified game size, and refreshes the content of the app frame.
   *
   * @param gameSize the size of the game to be started
   */
  @Override
  public void startGameButtonClicked(int gameSize) {
    appFrame.removeAllContent();
    showGamePage(gameSize);
    appFrame.refreshContent();
  }

  /**
   * This method is called when the main menu button is clicked. It removes all content from the app frame,
   * shows the start page, and refreshes the content of the app frame.
   */
  @Override
  public void mainMenuButtonClicked() {
    appFrame.removeAllContent();
    showStartPage();
    appFrame.refreshContent();
  }

  /**
   * Starts the Nonogram game application and shows the start page and the main application frame.
   */
  protected void startGame() {
    JFrame nonogramGameappFrame = appFrame.getAppFrame();
    showStartPage();
    appFrame.showAppFrame(nonogramGameappFrame);
  }

  private void showGamePage(int gameSize) {
    GamePageView gamePage = new GamePageView(nonogramGrid(gameSize));
    gamePage.setBackToMainMenuListener(this);
    appFrame.addContentToAppFrame(gamePage.getGamePage());
  }

  private String[][] nonogramGrid(int gameSize) {
    NonogramGrid nonogram = new NonogramGrid();
    return nonogram.getNonogramGrid(gameSize, gameSize);
  }
  
  private void showStartPage() {
    StartPageView startPageView = new StartPageView();
    startPageView.setStartGameListener(this);
    appFrame.addContentToAppFrame(startPageView.getStartPage());
  }

}
