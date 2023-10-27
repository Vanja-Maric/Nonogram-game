package model;

import nonogram.NonogramGridCreator;

public class NonogramGrid {

  public String[][] getNonogramGrid(int width, int height) {
    ImageLoader imageLoader = new ImageLoader();
    String[] imagesPath = imageLoader.getLoadImagePaths("src/images", ".png");
    int randomImageIndex = (int) (Math.random() * imagesPath.length);
    NonogramGridCreator nonogramGridCreator = new NonogramGridCreator(imagesPath[randomImageIndex], width, height); 
    return nonogramGridCreator.getBlackAndWhiteGrid();
  }
}
