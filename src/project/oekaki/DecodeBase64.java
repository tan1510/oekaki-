package project.oekaki;

import org.apache.commons.codec.binary.Base64;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.prefs.BackingStoreException;
import java.io.FileOutputStream;

import javax.imageio.ImageIO;
public class DecodeBase64{
byte[] binary;
String fileName;

/**
 * ファイルの名前なし
 */
    public void tranceform(String base64) throws IOException{
        
        binary=Base64.decodeBase64(base64);
       
        BufferedImage bufImage = getBufferedImage();
        
        OutputStream out=new FileOutputStream("WebContent/project/oekaki/save/test.png" );
        ImageIO.write(bufImage, "png", out);
    }

    public void tranceform(String base64,String fileName) throws IOException{
        binary=Base64.decodeBase64(base64);
        BufferedImage bufImage = getBufferedImage();
        
        OutputStream out=new FileOutputStream("WebContent/project/oekaki/save/" + fileName +".png" );
        ImageIO.write(bufImage, "png", out);
    }

    private  BufferedImage getBufferedImage() throws IOException{
        BufferedImage img = ImageIO.read(new ByteArrayInputStream(binary));
    //    System.out.println(img);
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


    //シフト演算をする
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