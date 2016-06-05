package com.dreamchain.skeleton.web;

import java.io.IOException;
import java.io.Writer;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.dreamchain.skeleton.dao.ImageInfoDao;
import com.dreamchain.skeleton.dao.ImageTagDao;
import com.dreamchain.skeleton.dao.JgjcxxDao;
import com.dreamchain.skeleton.model.ImageInfo;
import com.dreamchain.skeleton.model.ImageTag;
import com.dreamchain.skeleton.model.Jgjcxx;
import com.dreamchain.skeleton.model.User;
import com.dreamchain.skeleton.util.ImageTagInfo;
@Controller
@RequestMapping("/picture")
public class PictureController {
	@Autowired 
	private ImageInfoDao imageInfoDao;
	@Autowired
	private ImageTagDao image_tagDao;
	@Autowired
	private JgjcxxDao jgjcxxDao;
	
	@RequestMapping("/list.do")
	public ModelAndView list(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
        mav.addObject("mainPage", "imagetag.jsp");
		mav.setViewName("main");
		return mav;
	}
	
	@RequestMapping("/getData.do")
	public void getImageInfo(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException{
		String next = (String)session.getAttribute("next");
		if("method2".equals(next)){
			String test_data = generateTestData2();
			response.setCharacterEncoding("utf-8");
			Writer writer = response.getWriter();
			writer.append(test_data);
			writer.flush();
			writer.close();
		}else{
			String test_data = generateTestData();
			response.setCharacterEncoding("utf-8");
			Writer writer = response.getWriter();
			writer.append(test_data);
			writer.flush();
			writer.close();
		}
		
	}
	
	@Transactional
	@RequestMapping("/mark.do")
	public ModelAndView  mark(HttpServletRequest request, HttpServletResponse response,HttpSession session, String currentImg, String resultType) throws IOException, ServletException, ParseException{
		request.setCharacterEncoding("utf-8");		
		response.setCharacterEncoding("utf-8");
		Date date =new Date();
		ImageInfo nImage = imageInfoDao.findByName(currentImg+".bmp");
		Jgjcxx jgxx = jgjcxxDao.get(Long.valueOf(resultType));
		User user = (User)session.getAttribute("currentUser");
		
		ImageTag imgtag = new ImageTag();
		imgtag.setImg_info(nImage);
		imgtag.setJg_info(jgxx);
		imgtag.setPhase("train");
		imgtag.setUser_id(user);
		imgtag.setTag_date(date);
		image_tagDao.add(imgtag);
		
		session.setAttribute("pici", "1");
		session.setAttribute("next", "method2");
		ModelAndView mav = new ModelAndView();
        mav.addObject("mainPage", "imagetag.jsp");
		mav.setViewName("main");
		return mav;
	}
	
	private String generateTestData(){
		Map<String, List<ImageTagInfo>> maps = new HashMap<String, List<ImageTagInfo>>();
		List<ImageTagInfo> lists = new ArrayList<ImageTagInfo>();
		ImageTagInfo img1 = new ImageTagInfo();
		ImageTagInfo img2 = new ImageTagInfo();
		ImageTagInfo img3 = new ImageTagInfo();
		ImageTagInfo img4 = new ImageTagInfo();
		
		img1.setImage_id("N20040118G105922");
		img1.setImage_url("../aurora/N20040118G105922.bmp");
		img1.setName("N20040118G105922");
		img1.setType("1");
		img1.setRound("23");
		img1.setAccuracy_rate("0.7");
		img1.setCount_trained("15");
		
		img2.setImage_id("N20040118G105932");
		img2.setImage_url("../aurora/N20040118G105932.bmp");
		img2.setName("N20040118G105932");
		img2.setType("1");
		img2.setRound("23");
		img2.setAccuracy_rate("0.7");
		img2.setCount_trained("15");
		
		img3.setImage_id("N20040118G105942");
		img3.setImage_url("../aurora/N20040118G105942.bmp");
		img3.setName("N20040118G105942");
		img3.setType("1");
		img3.setRound("23");
		img3.setAccuracy_rate("0.7");
		img3.setCount_trained("15");
		
		img4.setImage_id("N20040118G105922");
		img4.setImage_url("../aurora/N20040118G105922.bmp");
		img4.setName("N20040118G105922");
		img4.setType("1");
		img4.setRound("23");
		img4.setAccuracy_rate("0.7");
		img4.setCount_trained("15");
	
		lists.add(img1);
		lists.add(img2);
		lists.add(img3);
		lists.add(img4);
		
		maps.put("images", lists);
		return JSON.toJSONString(maps);
	}
	
	private String generateTestData2(){
		Map<String, List<ImageTagInfo>> maps = new HashMap<String, List<ImageTagInfo>>();
		List<ImageTagInfo> lists = new ArrayList<ImageTagInfo>();
		ImageTagInfo img1 = new ImageTagInfo();
		ImageTagInfo img2 = new ImageTagInfo();
		ImageTagInfo img3 = new ImageTagInfo();
		ImageTagInfo img4 = new ImageTagInfo();
		
		img1.setImage_id("N20040118G110222");
		img1.setImage_url("../aurora/N20040118G110222.bmp");
		img1.setName("N20040118G110222");
		img1.setType("1");
		img1.setRound("23");
		img1.setAccuracy_rate("0.7");
		img1.setCount_trained("15");
		
		img2.setImage_id("N20040118G110232");
		img2.setImage_url("../aurora/N20040118G110232.bmp");
		img2.setName("N20040118G110232");
		img2.setType("1");
		img2.setRound("23");
		img2.setAccuracy_rate("0.7");
		img2.setCount_trained("15");
		
		img3.setImage_id("N20040118G110242");
		img3.setImage_url("../aurora/N20040118G110242.bmp");
		img3.setName("N20040118G110242");
		img3.setType("1");
		img3.setRound("23");
		img3.setAccuracy_rate("0.7");
		img3.setCount_trained("15");
		
		img4.setImage_id("N20040118G110222");
		img4.setImage_url("../aurora/N20040118G110222.bmp");
		img4.setName("N20040118G110222");
		img4.setType("1");
		img4.setRound("23");
		img4.setAccuracy_rate("0.7");
		img4.setCount_trained("15");
	
		lists.add(img1);
		lists.add(img2);
		lists.add(img3);
		lists.add(img4);
		
		maps.put("images", lists);
		return JSON.toJSONString(maps);
	}
}
