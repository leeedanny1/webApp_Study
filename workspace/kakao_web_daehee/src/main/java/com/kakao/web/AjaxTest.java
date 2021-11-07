package com.kakao.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.kakao.web.index.model.dto.User;


@WebServlet("/ajaxTest")
public class AjaxTest extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dataOrigin = request.getParameter("dataOrigin");
		System.out.println(dataOrigin);
		
		Gson gson = new Gson();
		
		JsonParser parser = new JsonParser();
		JsonElement element = parser.parse(dataOrigin);
		JsonObject jobj = element.getAsJsonObject();
		
		System.out.println(jobj.get("user_name").getAsString());
		System.out.println(jobj.get("user_phone").getAsString());
		
		
		User user = new User();
		user.setId("admin");
		user.setPassword("1q2w3e4r5t");
		user.setName("관리자");
		user.setPhone("01055555555");
		
		String json = gson.toJson(user);
		System.out.println(json);
		
		
		
		response.setContentType("text/html; charset=UTF-8");
//		response.getWriter().print(name + ", " + phone);
		response.getWriter().print(json);
		
	}

}
