package io.imfast.webrwd.controller.web.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.imfast.webrwd.model.Items;
import io.imfast.webrwd.service.IitemsService;
import io.imfast.webrwd.utils.HttpUtil;


@WebServlet("/api-hotel-list")
public class HotelAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private IitemsService itemsService;
	
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper om = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		Items itemHotel = HttpUtil.of(request.getReader()).toModel(Items.class); 
		itemHotel.setResultList(itemsService.FindByNameItem(itemHotel.getNameItem())); 
		om.writeValue(response.getOutputStream(), itemHotel);
	}


	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
