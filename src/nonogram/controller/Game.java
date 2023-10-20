package controller;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.NonogramGrid;
import view.AppFrame;
import view.GamePageView;
import view.StartPageView;


public class Game implements StartGameListener, BackToMainMenuListener {
  private AppFrame appFrame = new AppFrame();
  private int level = 1;

  protected void startGame() {
    JFrame nonogramGameappFrame = appFrame.getAppFrame();
    showStartPage();
    appFrame.showAppFrame(nonogramGameappFrame);
  }

  private void showStartPage() {
    StartPageView startPageView = new StartPageView();
    startPageView.setStartGameListener(this);
    appFrame.addContentToAppFrame(startPageView.getStartPage());
  }

  private void showGamePage(int gameSize) {
    GamePageView gamePage = new GamePageView(nonogramGrid(gameSize));
    gamePage.setBackToMainMenuListener(this);
    appFrame.addContentToAppFrame(gamePage.getGamePage());
  }

  private String[][] nonogramGrid(int gameSize) {
    NonogramGrid nonogram = new NonogramGrid();
    return nonogram.getNonogramGrid(level, gameSize, gameSize);
  }

  @Override
  public void startGameButtonClicked(int gameSize) {
    appFrame.removeAllContent();
    showGamePage(gameSize);
    appFrame.refreshContent();
  }

  @Override
  public void mainMenuButtonClicked() {
    appFrame.removeAllContent();
    showStartPage();
    appFrame.refreshContent();
  }
}
