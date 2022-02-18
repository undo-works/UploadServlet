package packages.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/UploadServlet")

//アップロードしたファイルを置くフォルダの指定
@MultipartConfig(location="E:/Java/upload/")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//マルチパート形式で送信される情報を解析・取得
		Part part =request.getPart("uploadfile");
		
		//アップロードされたコンテンツからファイル名部分を示す部分を解析し、取得する。
		String filename = null;
		for(String cd : part.getHeader("Content-Disposition").split(";")) {
			cd = cd.trim();
			log(cd);
			
			if(cd.startsWith(filename)) {
				//ファイル名は=の右側以降の文字列
				//利用環境によってはダブルクォーテーションが含まれているので取り除く
				filename = cd.substring(cd.indexOf("=") + 1).trim().replace("¥", "");
				log("upload file:" + filename);
				break;
			}
		}
		
		//リクエストパラメータのIDを取得
		//String idStr = request.getParameter("id");
		//log("idStr" + idStr);
		//int id = Integer.parseInt(idStr);
		
		//アップロードファイルを書き出す
		String message = null;
		if(filename != null) {
			log(">> file write start.");
			
			//アップロードファイル名の校閲
			filename = filename.replace("¥¥", "/");
			
			int pos = filename.lastIndexOf("/");
			if(pos >= 0) {
				filename = filename.substring(pos+1);
			}
			log("filename : " + filename);
			part.write(filename);
			
			log("    complete!");
			
			message = "[" + filename + "]のアップロードが完了しました。";
		}
		
		request.setAttribute("message", message);
		
		RequestDispatcher rd = request.getRequestDispatcher("/detail?id=");
		rd.forward(request, response);
		
	}

}
