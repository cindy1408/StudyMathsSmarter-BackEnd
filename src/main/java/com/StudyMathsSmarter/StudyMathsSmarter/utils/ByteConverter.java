package com.StudyMathsSmarter.StudyMathsSmarter.utils;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ByteConverter {

       public static byte[] imageToBytes(String input) throws IOException {
          File imgPath = new File("src/main/resources/"+input);
          byte[] fileContent = Files.readAllBytes(imgPath.toPath());
          return fileContent;
       }

      public static Image bytesToImage(byte[] bytes) throws IOException {
          ImageIcon image= new ImageIcon(bytes);
          return image.getImage();
       }
}
