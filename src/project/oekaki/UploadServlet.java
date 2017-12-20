package project.oekaki;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Base64;
import javax.imageio.ImageIO;


public class UploadServlet extends HttpServlet{

    @WebServlet("project/oekaki/post")
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String str= request.getParameter("bin");
       // String num = request.getParameter("num");
        //System.out.println(str);
        byte[] imageBinary = Base64.getDecoder().decode(str);
        BinaryToBufferedImage BToBI = new BinaryToBufferedImage();

        BufferedImage bufImage = BToBI.aaa(imageBinary);
        OutputStream out=new FileOutputStream("test");
        ImageIO.write(bufImage, "jpg", out);
        
    try{
        File file = new File("test");
        FileWriter filewriter = new FileWriter(file);
    
        filewriter.write(str);
    }catch(IOException e){
        System.out.println(e);
    }
    }
}