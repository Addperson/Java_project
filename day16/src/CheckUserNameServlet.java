

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xu.dao.UserDao;
import com.xu.dao.impl.UserDaoImpl;


public class CheckUserNameServlet extends HttpServlet {
	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//检测是否存在
		String name = request.getParameter("name");
		System.out.println(name);
		UserDao dao=new UserDaoImpl();
		boolean isExist=dao.checkUserName(name);
		//通知页面是否有用户
		if (isExist) {
			response.getWriter().println(1);
		} else {
			response.getWriter().println(2);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
