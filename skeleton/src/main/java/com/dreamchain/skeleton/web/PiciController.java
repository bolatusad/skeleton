package com.dreamchain.skeleton.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.dreamchain.skeleton.model.ImageInfo;
import com.dreamchain.skeleton.model.Jgjcxx;
import com.dreamchain.skeleton.model.Pici;
import com.dreamchain.skeleton.model.User;
import com.dreamchain.skeleton.model.ImageInfo;
import com.dreamchain.skeleton.service.ImageInfoService;
import com.dreamchain.skeleton.service.PiciService;
import com.dreamchain.skeleton.util.Configuration;
import com.dreamchain.skeleton.util.ImageInfoUpload;
import com.dreamchain.skeleton.util.PageUtil;

@Controller
@RequestMapping("/pici")
public class PiciController {

	@Autowired
	ImageInfoService imageInfoService;
	
	@Autowired
	PiciService piciService;
	
	@Autowired
	SessionFactory sessionfactory;

	@RequestMapping("/list.do")
	public ModelAndView list(@RequestParam(value = "pageNum", required = false) String pageNum, Pici pici,
			HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		

			if (pageNum == null) {
				pageNum = "1";
			}
			int total = piciService.count();
			System.out.println(total);
			String pageCode = new String();
			Configuration.setPageSize(100);
			StringBuffer param = new StringBuffer();
			pageCode = PageUtil.genPaginationNoParam(request.getContextPath() + "/pici/list.do", total,
					Integer.parseInt(pageNum), Configuration.getPageSize());

			List<Pici> picilist;
			if (pageNum == "1") {
				picilist = piciService.find(0, 100);
			} else {
				picilist = piciService.find(Integer.parseInt(pageNum) * 100 - 100, 100);
			}
			mav.addObject("modeName", "图像批次管理");
			mav.addObject("picilist", picilist);
			mav.addObject("mainPage", "picilist.jsp");
			mav.setViewName("main");
			mav.addObject("pageCode", pageCode);
		return mav;
	}

//	@RequestMapping("/delete.do")
//	public String delete(@RequestParam(value = "id", required = false) Long id, HttpServletResponse response)
//			throws Exception {
//		ImageInfo imageInfo = imageInfoService.get(id);
//		imageInfoService.delete(imageInfo);
//		return "redirect:/jgjcxx/list.do";
//	}

	@RequestMapping("/saveEdit")
	public ModelAndView saveEdit(@RequestParam(value = "id", required = false) Long id) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("modeName", "图像批次管理");
		mav.setViewName("main");
			mav.addObject("mainPage", "picisave.jsp");
			mav.addObject("actionName", "图像批次添加");
		return mav;
	}

	@RequestMapping("/save.do")
	public String save(Pici pici, HttpServletRequest request) {
		
		Session session = sessionfactory.openSession();
		session.save(pici);
		session.flush();
		System.out.println(pici);
		String start = pici.getStart().replaceAll("-", "");
		String end = pici.getEnd().replaceAll("-", "");
		imageInfoService.findImages(start, end, pici.getNum(),pici.getId());
		
		long id = pici.getId(); 
		Configuration.setPageSize(100);
		int pagesize = Configuration.getPageSize();
		long pageNUm = id%pagesize==0 ? id/pagesize:id/pagesize+1;
		String page = String.valueOf(pageNUm);
		return "redirect:/pici/list.do?pageNum="+page;
	}
	
	
	
}

