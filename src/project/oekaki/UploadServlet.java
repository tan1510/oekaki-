package project.oekaki;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import java.util.Base64;
public class UploadServlet extends HttpServelet{



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getParamater("messeage"));
        byte[] bytes = request.getParamater("messeage");
        System.out.println(bytes);
		
	}
}