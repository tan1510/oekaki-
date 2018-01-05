package project.oekaki;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.File;
import java.io.FileWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletContext;
import java.util.Base64;
import java.util.Arrays;
import java.util.Iterator;
import java.io.PrintWriter;
import javax.imageio.ImageIO;
@WebServlet("project/oekaki/load")
public class DownloadServlet extends HttpServlet{

    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException{
        //saveフォルダへのパス
        ServletContext context = getServletContext();
        String realpath = context.getRealPath("project/oekaki/save");
        //画像名のリスト作成
        File file = new File(realpath);
        String[] list = file.list();
        String joint ="";
        Iterator iterator =   Arrays.asList(list).iterator();
        while(iterator.hasNext()){
         joint+=   iterator.next();
            if(iterator.hasNext())
                joint+=",";
        }

        StringBuilder builder = new StringBuilder();
		builder.append('{');
		builder.append("\"namelist\":\"").append(joint).append("\"");
		
		builder.append('}');
        String json = builder.toString();
        response.setContentType("application/json");
        PrintWriter writer = response.getWriter();
		writer.append(json);
		writer.flush();
	}
}