package controller;

import javax.swing.JPanel;

import model.ImageLoader;
import model.NonogramGrid;
import view.AppFrame;
import view.GamePageView;
import view.SomethingWentWrong;
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
    showStartPage();
    appFrame.showAppFrame();
  }

  private void showGamePage(int gameSize) {
    String[][] nonogramGrid = nonogramGrid(gameSize);
    if (nonogramGrid.length != 0) { 
    GamePageView gamePage = new GamePageView(nonogramGrid(gameSize));
    gamePage.setBackToMainMenuListener(this);
    appFrame.addContentToAppFrame(gamePage.getGamePage());
    appFrame.refreshContent();
    }
  }

  private String[][] nonogramGrid(int gameSize) {
    try {
    ImageLoader imageLoader = new ImageLoader();
    NonogramGrid nonogram = new NonogramGrid(imageLoader);
    return nonogram.getNonogramGrid(gameSize, gameSize);
    } catch (Exception e) {
      appFrame.removeAllContent();
      showSomethingWentWrongPage();
      return new String[0][];
    }
  }

  private void showSomethingWentWrongPage() {
    JPanel somethingWentWrongContainer = new JPanel();
    somethingWentWrongContainer.add(new SomethingWentWrong());
    appFrame.addContentToAppFrame(somethingWentWrongContainer);
  }
  
  private void showStartPage() {
    StartPageView startPageView = new StartPageView();
    startPageView.setStartGameListener(this);
    appFrame.addContentToAppFrame(startPageView.getStartPage());
  }

}
