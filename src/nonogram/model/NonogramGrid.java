package model;

import java.io.IOException;

import nonogram.NonogramGridCreator;

/**
 * The NonogramGrid class represents a nonogram grid that can be generated with a random image from a specified folder.
 * The grid is represented as a 2D array of strings, where each string represents a cell in the grid.
 * The class uses an ImageLoader object to load images from the specified folder.
 */
public class NonogramGrid {
  private final String IMAGE_FOLDER_PATH = "src/images";
  private final String IMAGE_EXTENSION = ".png";

  private final ImageLoader imageLoader;

  public NonogramGrid(ImageLoader imageLoader) {
    this.imageLoader = imageLoader;
  }

  /**
   * Returns a 2D array of strings representing a nonogram grid with the specified width and height.
   * The grid is created using a random image path and the NonogramGridCreator class.
   * @param width the width of the nonogram grid
   * @param height the height of the nonogram grid
   * @return a 2D array of strings representing the black and white nonogram grid
   * @throws IOException if there is an error reading the image file
   */
  public String[][] getNonogramGrid(int width, int height) throws IOException {
  try {
      NonogramGridCreator nonogramGridCreator = new NonogramGridCreator(getRandomImagePath(), width, height);
    return nonogramGridCreator.getBlackAndWhiteGrid();
  } catch (Exception e) {
    throw new IOException("Error creating Nonogram grid.");
  }
  }

  private String getRandomImagePath() throws IOException{
    try {
      String[] imagesPath = imageLoader.getImagePaths(IMAGE_FOLDER_PATH, IMAGE_EXTENSION);
      int randomImageIndex = (int) (Math.random() * imagesPath.length);
      return imagesPath[randomImageIndex];
    } catch (Exception e) {
      throw new IOException("No images found for Nonogram generation.");
    }
  }
}
