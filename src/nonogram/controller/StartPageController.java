package controller;

import javax.swing.ButtonModel;

import view.StartPageView;

public class StartPageController {
  private StartPageView startPageView = new StartPageView();

  public int getGameSize() {
    ButtonModel selectedGameSizeModel = startPageView.getGameSizeButtonGroup().getSelection();
    int selectedGameSize = Integer.parseInt(selectedGameSizeModel.getActionCommand());
    return selectedGameSize;
  }

}
