package project.oekaki;

import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;


public class BinaryBufferedImage{

public static BufferedImage aaa(byte[] imageBinary) throws IOException {
    BufferedImage img = ImageIO.read(new ByteArrayInputStream(imageBinary));

    int width = img.getWidth();
    int height = img.getHeight();
    BufferedImage bufImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    for(int y=0;y<height;y++){
        for(int x=0;x<width;x++){
            int c = img.getRGB(x, y);
            int r = r(c);
            int g = g(c);
            int b = b(c);
            int rgb = rgb(r,g,b);
            bufImage.setRGB(x,y,rgb);
        }
    }

    return bufImage;
}

//以下、シフト演算ビット演算のメソッド
public static int a(int c){
    return c>>>24;
}
public static int r(int c){
    return c>>16&0xff;
}
public static int g(int c){
    return c>>8&0xff;
}
public static int b(int c){
    return c&0xff;
}
public static int rgb
(int r,int g,int b){
    return 0xff000000 | r <<16 | g <<8 | b;
}
public static int argb
(int a,int r,int g,int b){
    return a<<24 | r <<16 | g <<8 | b;
}
}