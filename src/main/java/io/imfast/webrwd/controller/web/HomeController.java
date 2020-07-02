package io.imfast.webrwd.controller.web;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.imfast.webrwd.model.Items;
import io.imfast.webrwd.model.Rent;
import io.imfast.webrwd.model.User;
import io.imfast.webrwd.paging.PageRequest;
import io.imfast.webrwd.paging.Pagible;
import io.imfast.webrwd.service.IBusinessService;
import io.imfast.webrwd.service.IUserService;
import io.imfast.webrwd.service.IitemsService;
import io.imfast.webrwd.service.impl.itemsService;
import io.imfast.webrwd.sorter.Sorter;
import io.imfast.webrwd.utils.FormUtil;
import io.imfast.webrwd.utils.SessionUtil;

@WebServlet(urlPatterns = { "/trang-chu", "/dang-nhap", "/thoat", "/dang-ky", "/dia-diem" , "/khach-san", "/thue-muon" })
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 2686801510274002166L;
	@Inject
	private IUserService UserService;
	@Inject
	private IitemsService ItemService;
	@Inject
	private IBusinessService businessService;
	ResourceBundle resourceBundle = ResourceBundle.getBundle("message");
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action != null && action.equals("login")) {
			String message = request.getParameter("message");
			String alert = request.getParameter("alert");
			if (message != null && alert != null) {
				request.setAttribute("message", resourceBundle.getString(message));
				request.setAttribute("alert", alert);
			}
			RequestDispatcher rd = request.getRequestDispatcher("/views/login/login.jsp");
			rd.forward(request, response);
		} else if (action != null && action.equals("logout")) {
			SessionUtil.getInstance().rmValue(request, "USER");
			response.sendRedirect(request.getContextPath() + "/trang-chu");
		}else if (action != null && action.equals("register")) {
			RequestDispatcher rd = request.getRequestDispatcher("/views/register/register.jsp");
			rd.forward(request, response);
		}
		else if (action != null && action.equals("khachsan")){
			 Items itemHotel = FormUtil.ToModel(Items.class, request); // cach 2 dung library cua maven
			 String PageStr = request.getParameter("page");
			 if(PageStr != null) { itemHotel.setPage(Integer.parseInt(PageStr)); } 
			 else {itemHotel.setPage(1); } 
			 String BusinessStr = request.getParameter("BusinessID");
			 if(BusinessStr != null && !BusinessStr.equals("")) {itemHotel.setBusinessID(Long.parseLong(BusinessStr));}
			 String TypeStr = request.getParameter("type");
			 if(TypeStr != null && !TypeStr.equals("")) { itemHotel.setType(TypeStr);} 
			 Pagible pagible = new PageRequest(itemHotel.getPage(),itemHotel.getMaxPage() ,new Sorter(itemHotel.getSortName(),itemHotel.getSortBy()));
			 if(itemHotel.getType().equals("")) {
				 if(itemHotel.getBusinessID() != null) {
					 itemHotel.setResultList(ItemService.FindByBusinessID(itemHotel.getBusinessID()));
					 itemHotel.setTotalItem(ItemService.getTotalItemSortByBusinessID(itemHotel.getBusinessID()));
					 itemHotel.setTotalPage((int) Math.ceil((double) itemHotel.getTotalItem() / itemHotel.getMaxPage()));
					 itemHotel.setItemID(itemHotel.getResultList().get(0).getItemID());
					 request.setAttribute("itemHotel", itemHotel);
					 request.setAttribute("BusinessAreas", businessService.FindAll());
					 RequestDispatcher rd = request.getRequestDispatcher("/views/hotel/hotel.jsp");
					 rd.forward(request, response);
				 }else if(itemHotel.getBusinessID() == null || itemHotel.getBusinessID() == 0) {
					 itemHotel.setResultList(ItemService.FindAll(pagible));
					 itemHotel.setTotalItem(ItemService.getTotalItem());
					 itemHotel.setTotalPage((int) Math.ceil((double) itemHotel.getTotalItem() / itemHotel.getMaxPage()));
					 itemHotel.setItemID(itemHotel.getResultList().get(0).getItemID());
					 request.setAttribute("itemHotel", itemHotel);
					 request.setAttribute("BusinessAreas", businessService.FindAll());
					 RequestDispatcher rd = request.getRequestDispatcher("/views/hotel/hotel.jsp");
					 rd.forward(request, response);
				 }
			 }
			 else if(itemHotel.getType().equals("find")) {
				 String NameItemStr = request.getParameter("find");
				 if(NameItemStr != null) { itemHotel.setNameItem(NameItemStr);} 
				 itemHotel.setResultList(ItemService.FindByNameItem(itemHotel.getNameItem())); 
				 itemHotel.setTotalPage(1);
				/* itemHotel.setItemID(itemHotel.getResultList().get(0).getItemID()); */
				 if(!itemHotel.getResultList().isEmpty() ) {
					 request.setAttribute("itemHotel", itemHotel);
					 RequestDispatcher rd = request.getRequestDispatcher("/views/hotel/hotel.jsp");
					 rd.forward(request, response);
				 }else {
					 String message = request.getParameter("message");
					 String alert = request.getParameter("alert");
					 if (message != null && alert != null) {
							request.setAttribute("message", resourceBundle.getString(message));
							request.setAttribute("alert", alert);
						} 
					RequestDispatcher rd = request.getRequestDispatcher("/views/hotel/hotel.jsp");
					rd.forward(request, response);
				 }
			 }
		}
		else if (action != null && action.equals("diadiem")){
			RequestDispatcher rd = request.getRequestDispatcher("/views/place/place.jsp");
			rd.forward(request, response);
	    }else if (action != null && action.equals("rent")){
	    	Items item = new Items();
	    	String idStr = request.getParameter("id");
	    	if(idStr != null) {item.setItemID(Long.valueOf(idStr));}
	    	item = ItemService.Findone(item.getItemID());
	    	request.setAttribute("itemRent", item);
	    	
			RequestDispatcher rd = request.getRequestDispatcher("/views/rent/rent.jsp");
			rd.forward(request, response);
	    }
		else {
			Items itemHotel = new Items();
			itemHotel.setResultList(ItemService.FindByBusinessID(1L));
			request.setAttribute("item", itemHotel);
			Items itemVilla = new Items();
			itemVilla.setResultList(ItemService.FindByBusinessID(4L));
			request.setAttribute("itemVilla", itemVilla);
			RequestDispatcher rd = request.getRequestDispatcher("/views/web/home.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action != null && action.equals("login")) {
			/* User model = FormUtil.ToModel(User.class, request); */	
			  User model = new User(); 
			  String UserStr = request.getParameter("Username");
			  if(UserStr != null) model.setUsername(UserStr); 
			  String PassStr = request.getParameter("Password"); 
			  if(PassStr != null) model.setPassword(PassStr);
			model = UserService.FindByUsernamePassStatus(model.getUsername(), model.getPassword(), 1);
			if(model != null) {
				SessionUtil.getInstance().putValue(request, "USER", model);
				if(model.getRole().getCode().equals("USER")) {
					response.sendRedirect(request.getContextPath() + "/trang-chu");
				}else if(model.getRole().getCode().equals("ADMIN")) {
					response.sendRedirect(request.getContextPath() + "/admin-home");
				}
			}else {
				response.sendRedirect(request.getContextPath() + "/dang-nhap?action=login&message=user_pass_invalid&alert=danger");
			}
		}else if(action != null && action.equals("register")) {
			User user = new User(); 
			request.setCharacterEncoding("UTF-8");
			String UserStr = request.getParameter("Username");
			if(UserStr != null) user.setUsername(UserStr); 
			String PassStr = request.getParameter("Password"); 
			if(PassStr != null) user.setPassword(PassStr);
			String AddressStr = request.getParameter("Address"); 
			if(AddressStr != null) user.setAddress(AddressStr);
			String EmailStr = request.getParameter("Email"); 
			if(EmailStr != null) user.setEmail(EmailStr);
			String TelephoneStr = request.getParameter("Telephone"); 
			if(TelephoneStr != null) user.setTelephone(Integer.parseInt(TelephoneStr));
			String BirthStr = request.getParameter("Birthday"); 
			if(BirthStr != null) user.setBirthday(BirthStr);
			User model = UserService.FindByUsernamePassStatus(user.getUsername(), user.getPassword(), 1);
			if(model == null) {
				Long id = UserService.Insert(user);
				response.sendRedirect(request.getContextPath() + "/dang-nhap?action=login");
				if(action != null && action.equals("login")) {
					model = FormUtil.ToModel(User.class, request); 	
					user = UserService.FindByUsernamePassStatus(user.getUsername(), user.getPassword(), 1);
					if(user != null) {
						SessionUtil.getInstance().putValue(request, "USER", user);
						if(user.getRole().getCode().equals("USER")) {
							response.sendRedirect(request.getContextPath() + "/trang-chu");
						}else if(user.getRole().getCode().equals("ADMIN")) {
							response.sendRedirect(request.getContextPath() + "/admin-home");
						}
					}
			}
			
		}
	}
	}
}