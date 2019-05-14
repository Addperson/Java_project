package com.xu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thoughtworks.xstream.XStream;
import com.xu.dao.CityDao;
import com.xu.dao.impl.CityDaoImpl;
import com.xu.domain.CityBean;


public class CityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//获取参数
		int pid=Integer.parseInt(request.getParameter("pid"));
		
		//找出城市
		CityDao dao=new CityDaoImpl();
		List<CityBean> list = dao.findCity(pid);
		
		//返回数据
		XStream xStream=new XStream();
		xStream.alias("city", CityBean.class);
		//xStream.useAttributeFor(CityBean.class, "id");
		String xml=xStream.toXML(list);
		response.setContentType("text/xml;charset=utf-8");
		response.getWriter().write(xml);
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
