package model;

import nonogram.NonogramGridCreator;

public class NonogramGrid {

  public String[][] getNonogramGrid(int level, int width, int height) {
    ImageLoader imageLoader = new ImageLoader();
    String[] imagesPath = imageLoader.loadImagePaths("src/images", ".png");
    NonogramGridCreator nonogramGridCreator = new NonogramGridCreator(imagesPath[level - 1], width, height); // TODO: DO
                                                                                                             // NOT
                                                                                                             // HARDCODE
                                                                                                             // THIS
    return nonogramGridCreator.getBlackAndWhiteGrid();
  }

}
