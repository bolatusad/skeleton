package com.dreamchain.skeleton.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
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
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import com.dreamchain.skeleton.model.ImageInfo;
import com.dreamchain.skeleton.model.Jgjcxx;
import com.dreamchain.skeleton.model.User;
import com.dreamchain.skeleton.model.ImageInfo;
import com.dreamchain.skeleton.service.ImageInfoService;
import com.dreamchain.skeleton.util.Configuration;
import com.dreamchain.skeleton.util.ImageInfoUpload;
import com.dreamchain.skeleton.util.PageUtil;

@Controller
@RequestMapping("/imageinfo")
public class ImageInfoController {

	@Autowired
	ImageInfoService imageInfoService;
	
	@Autowired
	SessionFactory sessionfactory;

	@RequestMapping("/list.do")
	public ModelAndView list(@RequestParam(value = "pageNum", required = false) String pageNum, ImageInfo imageInfo,
			HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		if ((imageInfo.getG() == null || imageInfo.getG().equals(""))) {

			if (pageNum == null) {
				pageNum = "1";
			}
			int total = imageInfoService.count();
			System.out.println(total);
			String pageCode = new String();
			Configuration.setPageSize(100);
			StringBuffer param = new StringBuffer();
			pageCode = PageUtil.genPaginationNoParam(request.getContextPath() + "/imageinfo/list.do", total,
					Integer.parseInt(pageNum), Configuration.getPageSize());

			List<ImageInfo> imageInfolist;
			if (pageNum == "1") {
				imageInfolist = imageInfoService.find(0, 100);
			} else {
				imageInfolist = imageInfoService.find(Integer.parseInt(pageNum) * 100 - 100, 100);
			}
			mav.addObject("modeName", "图像信息管理");
			mav.addObject("imageinfolist", imageInfolist);
			mav.addObject("mainPage", "imageinfolist.jsp");
			mav.setViewName("main");
			mav.addObject("pageCode", pageCode);
		} else {
			ImageInfo imageInfo1 = imageInfoService.findByName(imageInfo.getG());
			List<ImageInfo> imageInfolist = new ArrayList<ImageInfo>();
			imageInfolist.add(imageInfo1);
			mav.addObject("modeName", "图像信息管理");
			mav.addObject("imageinfolist", imageInfolist);
			mav.addObject("mainPage", "imageinfolist.jsp");
			mav.setViewName("main");
		}
		return mav;
	}

	@RequestMapping("/delete.do")
	public String delete(@RequestParam(value = "id", required = false) Long id, HttpServletResponse response)
			throws Exception {
		ImageInfo imageInfo = imageInfoService.get(id);
		imageInfoService.delete(imageInfo);
		return "redirect:/jgjcxx/list.do";
	}

	@RequestMapping("/saveEdit")
	public ModelAndView saveEdit(@RequestParam(value = "id", required = false) Long id) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("modeName", "图像信息管理");
		mav.setViewName("main");
		if (id != null) {
			mav.addObject("mainPage", "imageinfosave.jsp");
			mav.addObject("actionName", "图像信息修改");
			ImageInfo imageInfo = imageInfoService.get(id);
			System.out.println(imageInfo.toString());
			mav.addObject("imageInfo", imageInfo);
		} else {
			mav.addObject("mainPage", "imageinfoupload.jsp");
			mav.addObject("actionName", "图像信息添加");
		}
		return mav;
//		mav.addObject("actionName", "用户修改");
//		ImageInfo imageInfo = imageInfoService.get(id);
//		mav.addObject("imageinfo", imageInfo);
//		return mav;
	}

	@RequestMapping("/save.do")
	public String save(ImageInfo imageInfo, HttpServletRequest request) {
		//imageInfoService.save(imageInfo);
		Session session = sessionfactory.openSession();
		ImageInfo imageInfo2 = (ImageInfo) session.load(ImageInfo.class, imageInfo.getId());
		imageInfo2.setHard(imageInfo.getHard());
		imageInfo2.setImage_type(imageInfo.getImage_type());
		imageInfo2.setPici(imageInfo.getPici());
		session.flush();
		long id = imageInfo.getId(); 
		Configuration.setPageSize(100);
		int pagesize = Configuration.getPageSize();
		long pageNUm = id%pagesize==0 ? id/pagesize:id/pagesize+1;
		String page = String.valueOf(pageNUm);
		return "redirect:/imageinfo/list.do?pageNum="+page;
	}
	
	
	@RequestMapping("/upload.do")
	public String save(HttpServletRequest request,HttpServletResponse response,@RequestParam("fileText") MultipartFile fileText) throws IOException {
		
		File localFile = null;
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		if (multipartResolver.isMultipart(request)) {
			// 再将request中的数据转化成multipart类型的数据
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			Iterator iter = multiRequest.getFileNames();
			while (iter.hasNext()) {
				MultipartFile file = multiRequest.getFile((String) iter.next());
				if (file != null) {
					String fileName = file.getOriginalFilename();
					String path = request.getSession().getServletContext().getRealPath("WEB-INF")+"/"+fileName;
//					String path = this.getServletContext().getRealPath("WEB-INF") + fileName;
					localFile = new File(path);
					// 写文件到本地
					file.transferTo(localFile);
					
				/*	CommonsMultipartFile cf= (CommonsMultipartFile)file; 
			        DiskFileItem fi = (DiskFileItem)cf.getFileItem(); 
			        File f = fi.getStoreLocation();*/
			        List<ImageInfo> imageInfos = ImageInfoUpload.readFile(path);
			        for (ImageInfo image : imageInfos) {
						 imageInfoService.save(image);
						System.out.println(image.getG());
					}
					
				}
			}
		}
		
//		long id = imageInfo.getId(); 
		Configuration.setPageSize(100);
		int pagesize = Configuration.getPageSize();
		int total = imageInfoService.count();
		System.out.println(total);
		long pageNUm = total%pagesize==0 ? total/pagesize:total/pagesize+1;
		String page = String.valueOf(pageNUm);
		localFile.delete();
		return "redirect:/imageinfo/list.do?pageNum="+page;	
	}
	
}

