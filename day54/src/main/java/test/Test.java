package test;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class Test
 */
@WebServlet("/test.do")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String path="D:\\06007LIM\\workspace\\day54\\src\\main\\webapp\\images";
		int maxSize=100000000; // 바이트 단위
		MultipartRequest mr=new MultipartRequest(request,path,maxSize,"UTF-8",new DefaultFileRenamePolicy());
		
		/*
		String mid=request.getParameter("mid");
		String fileName=request.getParameter("fileName");
		System.out.println("로그1 ["+mid+"]");
		System.out.println("로그2 ["+fileName+"]");
		*/
		
		String mid=mr.getParameter("mid");
		System.out.println("로그1 ["+mid+"]");
		
		Enumeration<?> file=mr.getFileNames();
		if(file.hasMoreElements()) {
			String paramName=(String)file.nextElement();
			System.out.println("파라미터명 ["+paramName+"]");
			
			String serverFileName=mr.getFilesystemName(paramName);
			System.out.println("서버에 업로드된 파일명 ["+serverFileName+"]");
			request.getSession().setAttribute("img", serverFileName);

			String clientFileName=mr.getOriginalFileName(paramName);
			System.out.println("사용자가 업로드한 파일명 ["+clientFileName+"]");
			
			String fileType=mr.getContentType(paramName);
			System.out.println("파일의 타입 ["+fileType+"]");
			
			long length=mr.getFile(paramName).length();
			System.out.println("파일의 크기 ["+length+"]"); // 바이트 단위
		}
		
		response.sendRedirect("NewFile.jsp");
	}

}
