package controller;

import javax.swing.JFrame;

import view.AppFrame;
import view.StartPageView;

public class Game implements StartGameListener {
  private AppFrame appFrame = new AppFrame();

  protected void startGame() {
    JFrame nonogramGameappFrame = appFrame.getAppFrame();

    StartPageView startPageView = new StartPageView();
    startPageView.setStartGameListener(this);
    
    nonogramGameappFrame.add(startPageView.getStartPage());
    appFrame.showAppFrame(nonogramGameappFrame);
  }

  @Override
  public void startGameButtonClicked() {
    appFrame.removeAllContent();
    // ADD CONTENT showGame(getGameSize());
    appFrame.refreshContent();
  }

}
