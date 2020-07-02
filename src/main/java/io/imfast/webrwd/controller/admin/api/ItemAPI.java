package io.imfast.webrwd.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.imfast.webrwd.model.Items;
import io.imfast.webrwd.model.User;
import io.imfast.webrwd.service.IitemsService;
import io.imfast.webrwd.utils.HttpUtil;
import io.imfast.webrwd.utils.SessionUtil;


@WebServlet(urlPatterns = {"/api-admin-item"})
public class ItemAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private IitemsService itemsService;

//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		 TODO Auto-generated method stub
//		
//	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper om = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		Items item = HttpUtil.of(request.getReader()).toModel(Items.class);
		User user = ((User) SessionUtil.getInstance().getValue(request, "USER"));
		item.setCreateBy(user.getUsername());
		item = itemsService.Insert(item);
		om.writeValue(response.getOutputStream(), item);
	}


	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper om = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		Items item = HttpUtil.of(request.getReader()).toModel(Items.class);
		User user = ((User) SessionUtil.getInstance().getValue(request, "USER"));
		item.setModifyBy(user.getUsername());
	    itemsService.Update(item);
		om.writeValue(response.getOutputStream(), item);
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper om = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		Items item = HttpUtil.of(request.getReader()).toModel(Items.class);
	    itemsService.Delete(item.getIds());
		om.writeValue(response.getOutputStream(), "Deleted");
	}

}
