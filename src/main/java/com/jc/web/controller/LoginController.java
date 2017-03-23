package com.jc.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.jc.domain.pojo.User;
import com.jc.service.UserService;

/**
 * 多动作处理类：可以处理多个请求
 * 处理登录和注销请求
 */
public class LoginController extends MultiActionController {

	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	//登录验证
	public ModelAndView login(HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		String usercode = request.getParameter("usercode");
		String userpswd = request.getParameter("userpswd");

		User entityUser = userService.checkUser(usercode, userpswd);
		HttpSession session = request.getSession(true);
		session.setAttribute("session_user", entityUser);
		
		return new ModelAndView("success");
	}
	
	//注销
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession(true);
		if(session!=null){
			session.removeAttribute("session_user");
			session.invalidate(); 
		}
		return new ModelAndView("login");
	}
}
