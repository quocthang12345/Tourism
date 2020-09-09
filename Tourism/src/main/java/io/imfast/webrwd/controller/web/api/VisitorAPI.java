package io.imfast.webrwd.controller.web.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.imfast.webrwd.model.Visitor;
import io.imfast.webrwd.service.IVisitorService;
import io.imfast.webrwd.utils.HttpUtil;

@WebServlet("/api-visitor")
public class VisitorAPI extends HttpServlet {
	@Inject
	IVisitorService visitorService;
	private static final long serialVersionUID = 1L;
	
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper om = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		Visitor visitor = HttpUtil.of(request.getReader()).toModel(Visitor.class);
		visitor.setRentID(RentAPI.getId());
		visitorService.Insert(visitor);
		om.writeValue(response.getOutputStream(), visitor);
	}


	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
