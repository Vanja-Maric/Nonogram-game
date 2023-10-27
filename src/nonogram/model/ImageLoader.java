package model;

import java.io.File;
import java.util.Arrays;

public class ImageLoader {
  public String[] getLoadImagePaths(String folderPath, String extension) {
    return loadImagePaths(folderPath, extension);
  }

  private String[] loadImagePaths(String folderPath, String extension) {
    File folder = new File(folderPath);
    File[] imageFiles = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(extension));

    if (imageFiles != null && imageFiles.length > 0) {
      return Arrays.stream(imageFiles)
          .map(File::getAbsolutePath)
          .toArray(String[]::new);
    }

    return new String[0]; // Return empty array if no images found
  }
}
