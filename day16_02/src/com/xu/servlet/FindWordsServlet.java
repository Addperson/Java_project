package com.xu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xu.dao.WordsDao;
import com.xu.dao.impl.WordsDaoImpl;
import com.xu.domain.WordsBean;

/**
 * Servlet implementation class FindWordsServlet
 */
public class FindWordsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String word=request.getParameter("word");
		
		WordsDao dao=new WordsDaoImpl();
		List<WordsBean> list = dao.findWords(word);
		
		request.setAttribute("list",list);
		request.getRequestDispatcher("list.jsp").forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
