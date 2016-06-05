package com.dreamchain.skeleton.web;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dreamchain.skeleton.dao.ImageTagDao;
import com.dreamchain.skeleton.model.Display;
import com.dreamchain.skeleton.model.ImageInfo;
import com.dreamchain.skeleton.model.ImageTag;
import com.dreamchain.skeleton.util.Configuration;
import com.dreamchain.skeleton.util.PageUtil;

@Controller
@RequestMapping("/bjxx")
public class BjxxController {
	@Autowired
	ImageTagDao imageTagDao;

	@RequestMapping("/list.do")
	public ModelAndView list(@RequestParam(value = "pageNum", required = false) String pageNum, ImageTag imageTag,
			HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		if (pageNum == null) {
			pageNum = "1";
		}
		int total = imageTagDao.count();
		String pageCode = new String();
		Configuration.setPageSize(100);
		StringBuffer param = new StringBuffer();
		pageCode = PageUtil.genPaginationNoParam(request.getContextPath() + "/bjxx/list.do", total,
				Integer.parseInt(pageNum), Configuration.getPageSize());

		List<ImageTag> imageTaglist;
		List<Display> imageTaglist2 = new ArrayList<Display>();
		if (pageNum == "1") {
			imageTaglist = imageTagDao.find(0, 100);
			for(ImageTag imageTag2 : imageTaglist){
				String image_name = imageTag2.getImg_info().getG();
				String jg_id = imageTag2.getJg_info().getId().toString();
				String username = imageTag2.getUser_id().getName();
				String image_Tagid =imageTag2.getId().toString();
				String phase =imageTag2.getPhase();
				String date =imageTag2.getTag_date().toString();
				Display display = new Display(image_name, jg_id, username, image_Tagid, phase, date);
				imageTaglist2.add(display);
				/*imageTaglist2.add(image_name);
				imageTaglist2.add(jg_id);
				imageTaglist2.add(username);
				imageTaglist2.add(image_Tagid);
				imageTaglist2.add(phase);
				imageTaglist2.add(date);*/
			}
		} else {
			imageTaglist = imageTagDao.find(Integer.parseInt(pageNum) * 100 - 100, 100);
			for(ImageTag imageTag2 : imageTaglist){
				String image_name = imageTag2.getImg_info().getG();
				String jg_id = imageTag2.getJg_info().getId().toString();
				String username = imageTag2.getUser_id().getName();
				String image_Tagid =imageTag2.getId().toString();
				String phase =imageTag2.getPhase();
				String date =imageTag2.getTag_date().toString();
				Display display = new Display(image_name, jg_id, username, image_Tagid, phase, date);
				imageTaglist2.add(display);
			}
		}
		mav.addObject("modeName", "图像信息管理");
		mav.addObject("imageTaglist", imageTaglist2);
		mav.addObject("mainPage", "bjxxlist.jsp");
		mav.setViewName("main");
		mav.addObject("pageCode", pageCode);
		return mav;

	}
}
