package controller;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.ImageLoader;
import view.AppFrame;
import view.GameTableView;
import view.StartPageView;

import nonogram.NonogramGridCreator;

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

  private void showGame(int gameSize) {
    GameTableView gameView = new GameTableView();
    JPanel testJPanel = new JPanel();
    testJPanel.add(gameView.createNonogramCellsGrid(getNonogramGrid())); // TODO: REMOVE THIS AFTER TEST
    appFrame.addContentToAppFrame(testJPanel);
  }

  private String[][] getNonogramGrid() {
    ImageLoader  imageLoader = new ImageLoader();
    String[] imagesPath = imageLoader.loadImagePaths("src/images", ".png");
    NonogramGridCreator nonogramGridCreator = new NonogramGridCreator(imagesPath[level - 1], 15, 15); // TODO: DO NOT HARDCODE THIS
    return nonogramGridCreator.getBlackAndWhiteGrid();
  }

  @Override
  public void startGameButtonClicked() {
    appFrame.removeAllContent();
    showGame(15);
    appFrame.refreshContent();
  }

}
