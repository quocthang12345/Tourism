package io.imfast.webrwd.controller.web.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.imfast.webrwd.model.Rent;
import io.imfast.webrwd.model.User;
import io.imfast.webrwd.service.IRentService;
import io.imfast.webrwd.utils.HttpUtil;
import io.imfast.webrwd.utils.SessionUtil;

@WebServlet("/api-rent")
public class RentAPI extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Long id;
	@Inject
	IRentService rentService;
	
	
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper om = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		Rent rent = HttpUtil.of(request.getReader()).toModel(Rent.class); 
		User user = ((User) SessionUtil.getInstance().getValue(request, "USER"));
		if(user != null) {
			rent.setStatus(1);
			rent.setUserID(user.getUserID());
			rent.setCreateBy(user.getUsername());
			rentService.Insert(rent);
		}else {
			rent.setStatus(0);
			rent.setUserID(null);
			rent.setCreateBy(null);
			id = rentService.Insert(rent);
		}
		om.writeValue(response.getOutputStream(), rent);
	}


	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	public static Long getId() {
		return id;
	}


	public static void setId(Long id) {
		RentAPI.id = id;
	}
}
