package io.imfast.webrwd.utils;

import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

public class MessageUtil {
	static ResourceBundle resourceBundle = ResourceBundle.getBundle("message");
	public static  void ShowMessage(HttpServletRequest request) {
		String message = request.getParameter("message");
		String alert = request.getParameter("alert");
		if(message != null && alert != null) {
			request.setAttribute("messageResponse", resourceBundle.getString(message));
			request.setAttribute("alert", alert);
		}	
	}
}
