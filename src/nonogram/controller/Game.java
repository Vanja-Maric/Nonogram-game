package controller;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.NonogramGrid;
import view.AppFrame;
import view.GamePage;
import view.StartPageView;


public class Game implements StartGameListener {
  private AppFrame appFrame = new AppFrame();
  private int level = 1;

  protected void startGame() {
    JFrame nonogramGameappFrame = appFrame.getAppFrame();

    StartPageView startPageView = new StartPageView();
    startPageView.setStartGameListener(this);
    
    nonogramGameappFrame.add(startPageView.getStartPage());
    appFrame.showAppFrame(nonogramGameappFrame);
  }

  private void showGamePage(int gameSize) {
    GamePage gamePage = new GamePage(getNonogramGrid());
    appFrame.addContentToAppFrame(gamePage.getGamePage());
  }

  private String[][] getNonogramGrid() {
    NonogramGrid nonogram = new NonogramGrid();
    return nonogram.getNonogramGrid(level, 15, 15);
  }

  @Override
  public void startGameButtonClicked() {
    appFrame.removeAllContent();
    showGamePage(15);
    appFrame.refreshContent();
  }

}
