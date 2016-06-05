package com.dreamchain.skeleton.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.hibernate.internal.CriteriaImpl.Subcriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dreamchain.skeleton.model.User;
import com.dreamchain.skeleton.service.UserService;
import com.dreamchain.skeleton.util.Configuration;
import com.dreamchain.skeleton.util.PageUtil;

@Controller
@RequestMapping("/jgbj")
public class JgbjController {

	static final String URL = "/main";

	@Autowired
	UserService userService;

	@RequestMapping("/login.do")
	public String login(User user, HttpServletRequest request) {

		
		User resultUser = userService.findByNameAndPassword(user.getName(), user.getPassword());
		//User resultUser = userService.findByName(user.getName());
		if (resultUser == null) {
			request.setAttribute("user", user);
			request.setAttribute("errorMsg", "用户名或密码错误！");
			return "login";
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("currentUser", resultUser);
			return "/main";
		}
	}


	@RequestMapping("/list.do")
	public ModelAndView list(@RequestParam(value = "pageNum", required = false) String pageNum, User user,
			HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		if (user.getName() == null || user.getName().equals("")) {

			if (pageNum == null) {
				pageNum = "1";
			}

			int total = userService.count();
			String pageCode = new String();
			StringBuffer param = new StringBuffer();
			pageCode = PageUtil.genPaginationNoParam(request.getContextPath() + "/user/list.do", total,
					Integer.parseInt(pageNum), Configuration.getPageSize());

			List<User> userlist;
			if (pageNum == "1") {
				userlist = userService.find(0, 5);
			} else {
				userlist = userService.find(Integer.parseInt(pageNum) * 5 - 5, 5);
			}
			mav.addObject("modeName", "用户管理");
			mav.addObject("userlist", userlist);
			mav.addObject("mainPage", "userlist.jsp");
			mav.setViewName("main");
			mav.addObject("pageCode", pageCode);
		} else {
			User user2 = userService.findByName(user.getName());
			List<User> userlist = new ArrayList<User>();
			userlist.add(user2);
			mav.addObject("modeName", "用户管理");
			mav.addObject("userlist", userlist);
			mav.addObject("mainPage", "userlist.jsp");
			mav.setViewName("main");
		}

		return mav;

	}

	@RequestMapping("/saveEdit")
	public ModelAndView saveEdit(@RequestParam(value = "id", required = false) Long id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("mainPage", "usersave.jsp");
		mav.addObject("modeName", "用户管理");
		mav.setViewName("main");
		if (id != null) {
			mav.addObject("actionName", "用户修改");
			User user = userService.get(id);
			mav.addObject("user", user);
		} else {
			mav.addObject("actionName", "用户添加");
		}
		System.out.println(mav.toString());
		return mav;
	}

	@RequestMapping("/save.do")
	public ModelAndView save(User user, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();

		boolean check = true;
		if (user.getId() == null) {
			mav.addObject("mainPage", "usersave.jsp");
			mav.setViewName("main");
			mav.addObject("modeName", "用户管理");
			UserCommand usc = new UserCommand(user);
			if (userService.findByName(user.getName()) != null) {
				request.setAttribute("errorMsg", "用户名已存在！");
				check = false;
				// return "usersave";
			}
			if (check) {
				userService.save(usc);
			}
		} else {
			mav.addObject("mainPage", "usersave.jsp");
			mav.setViewName("main");
			mav.addObject("modeName", "用户修改");
			User edituser = userService.get(user.getId());
			edituser.setId(user.getId());
			edituser.setAddress(user.getAddress());
			edituser.setUser_id(user.getUser_id());
			edituser.setEmail(user.getEmail());
			edituser.setName(user.getName());
			if (userService.findByName(user.getName()) != null) {
				request.setAttribute("errorMsg", "用户名已存在！");
				check = false;
				// return "usersave";
			}
			edituser.setPassword(user.getPassword());
			edituser.setRole(user.getRole());
			UserCommand editusercommand = new UserCommand(edituser);
			if (check) {
				userService.save(editusercommand);
			}
		}
		if (check) {
			user.setName("");
			mav = list("0", user, request);
			return mav;
		} else {
			return mav;
		}
		// return "redirect:/user/list.do";
		// return "/user/list.do";
	}

	@RequestMapping("/delete.do")
	public String delete(@RequestParam(value = "id", required = false) Long id, HttpServletResponse response)
			throws Exception {
		User user = userService.get(id);
		userService.delete(user);
		return "redirect:/user/list.do";
	}

	@RequestMapping("/search.do")
	public ModelAndView search(String name, HttpServletRequest request) {
		User u = userService.findByName(name);
		ModelAndView mav = new ModelAndView();
		mav.addObject("user", u);
		mav.addObject("mainPage", "search.jsp");
		mav.setViewName("main");
		return mav;
	}

}
