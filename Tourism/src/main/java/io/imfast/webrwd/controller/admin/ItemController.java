package io.imfast.webrwd.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.imfast.webrwd.model.Items;
import io.imfast.webrwd.paging.PageRequest;
import io.imfast.webrwd.paging.Pagible;
import io.imfast.webrwd.service.IBusinessService;
import io.imfast.webrwd.service.IitemsService;
import io.imfast.webrwd.sorter.Sorter;
import io.imfast.webrwd.utils.FormUtil;
import io.imfast.webrwd.utils.MessageUtil;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/admin-item-list"})
public class ItemController extends HttpServlet {
	
	
	@Inject
	private IitemsService itemService;
	@Inject
	private IBusinessService businessService;
	@SuppressWarnings("unused")
	private static final long seriHttpServletRequestalVersionUID = 2686801510274002166L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Items model = FormUtil.ToModel(Items.class, request); // cach 2 dung library cua maven
		 String PageStr = request.getParameter("page");
		 if(PageStr != null) { model.setPage(Integer.parseInt(PageStr)); } 
		 else { model.setPage(1); } 
		 String view ="";
//		 Items model = new Items();
//		 String MaxPageStr = request.getParameter("maxPage");
//		 if(MaxPageStr != null) { model.setMaxPage(Integer.parseInt(MaxPageStr)); }
//		 String SortNameStr = request.getParameter("sortName"); 
//		 if(SortNameStr != null) { model.setSortName(SortNameStr);} 
//		 String SortByStr = request.getParameter("sortBy"); 
//		 if(SortByStr != null) {model.setSortBy(SortByStr); }// cach 1 de lay param tren ui xong chuyen doi
		 if(model.getType().equals("list")) {
			 	Pagible pagible = new PageRequest(model.getPage(),model.getMaxPage() ,new Sorter(model.getSortName(),model.getSortBy()));
			 	model.setResultList(itemService.FindAll(pagible));
			 	model.setTotalItem(itemService.getTotalItem());
			 	model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getMaxPage()));
			 	model.setItemID(model.getResultList().get(0).getItemID());
			 	view = "/views/admin/item/list.jsp";
		 }
		 else if(model.getType().equals("edit")) {
			 String idStr = request.getParameter("id");
			 if(idStr != null) { model.setItemID(Long.parseLong(idStr));} 
			 if(model.getItemID() != null) {
				 model = itemService.Findone(model.getItemID());
			 }
			 view = "/views/admin/item/edit.jsp";	
			 request.setAttribute("BusinessAreas", businessService.FindAll());
		 }
		 MessageUtil.ShowMessage(request);
		 request.setAttribute("model", model);
		 RequestDispatcher rd = request.getRequestDispatcher(view);
		 rd.forward(request, response);
		 
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
