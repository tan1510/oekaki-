package project.oekaki;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Base64;
import javax.imageio.ImageIO;
import project.oekaki.DecodeBase64;
import java.net.URLDecoder;
@WebServlet("project/oekaki/post")
public class UploadServlet extends HttpServlet{

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getParameter("bin"));
        
        String para= request.getParameter("bin");
        String replaced = para.replaceAll(" ", "+");

        String name = request.getParameter("name");

        if(name=="")
            name = "unnamed";
       // String num = request.getParameter("num");
        //System.out.println(str);
        /*
        byte[] imageBinary = Base64.getDecoder().decode(str);
        BinaryToBufferedImage BToBI = new BinaryToBufferedImage();

        BufferedImage bufImage = BToBI.aaa(imageBinary);
        
        OutputStream out=new FileOutputStream("test");
        ImageIO.write(bufImage, "jpg", out);
        */
        /*
    try{
        String file_path = "pic/"+name;
        File file = new File(file_path);
        FileWriter filewriter = new FileWriter(file);
    
        filewriter.write(replaced);
    }catch(IOException e){
        System.out.println(e);
    }
    */

   String cut[] = replaced.split(",");

   DecodeBase64 db = new DecodeBase64();


   try{
   db.tranceform(cut[1], name);
   }catch(FileNotFoundException e){
    //ここにファイルパスが正しくない場合の処理("/"などを含む場合)
   }

    }
}