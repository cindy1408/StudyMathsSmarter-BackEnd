package com.StudyMathsSmarter.StudyMathsSmarter.utils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ByteConverter {
       private static BufferedImage bufferedImage;

       public static byte[] imageToBytes(String input) throws IOException {
          File imgPath = new File("src/main/resources/"+input);
           bufferedImage = ImageIO.read(imgPath);
           WritableRaster raster = bufferedImage.getRaster();
          DataBufferByte data = (DataBufferByte) raster.getDataBuffer();

          byte[] fileContent = Files.readAllBytes(imgPath.toPath());

          return fileContent;
     }

      public static Image bytesToImage(byte[] bytes) throws IOException {
          ImageIcon image= new ImageIcon(bytes);

           return image.getImage();}
}
