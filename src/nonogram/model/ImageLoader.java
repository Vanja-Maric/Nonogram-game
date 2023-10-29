package model;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * The ImageLoader class is responsible for loading image files from a specified folder path.
 */
public class ImageLoader {
  /**
   * Returns an array of image paths with the specified extension from the given folder path.
   * 
   * @param folderPath the path of the folder containing the images
   * @param extension the file extension of the images to be loaded
   * @return an array of image paths with the specified extension
   * @throws IOException if an I/O error occurs while loading the image paths
   */
  public String[] getImagePaths(String folderPath, String extension) throws IOException{
    return loadImagePaths(folderPath, extension);
  }

  private String[] loadImagePaths(String folderPath, String extension) throws IOException{
    File folder = new File(folderPath);
    checkFolderExists(folder, folderPath);

    File[] imageFiles = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(extension));
    checkDirectoryListing(imageFiles, folderPath);
    checkImageFiles(imageFiles, folderPath);

    return Arrays.stream(imageFiles)
        .map(File::getAbsolutePath)
        .toArray(String[]::new);
  }

  private void checkFolderExists(File folder, String folderPath) throws IOException {
   if (!folder.exists() || !folder.isDirectory()) {
      throw new IOException("Specified folder does not exist or is not a directory: " + folderPath);
    }
  }

  private void checkDirectoryListing(File[] imageFiles, String folderPath) throws IOException {
    if (imageFiles == null) {
      throw new  IOException("Unable to list files in directory: " + folderPath);
    }
  }

  private void checkImageFiles(File[] imageFiles, String folderPath) throws IOException {
    if (imageFiles.length == 0) {
      throw new IOException("No images found in directory: " + folderPath);
    }
  }
}
