package com.dreamchain.skeleton.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.dreamchain.skeleton.dao.JgjcxxDao;
import com.dreamchain.skeleton.model.Jgjcxx;
import com.dreamchain.skeleton.model.User;
import com.dreamchain.skeleton.service.JgjcxxService;
import com.dreamchain.skeleton.util.Configuration;
import com.dreamchain.skeleton.util.PageUtil;

@Controller
@RequestMapping("/jgjcxx")
public class JgjcxxController {

	@Autowired
	private JgjcxxService jgjcxxService;

	@RequestMapping("/list.do")
	public ModelAndView list(@RequestParam(value = "pageNum", required = false) String pageNum, Jgjcxx jgjcxx,
			HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		if ((jgjcxx.getJg_yw() == null || jgjcxx.getJg_yw().equals(""))) {

			if (pageNum == null) {
				pageNum = "1";
			}
			int total = jgjcxxService.count();
			String pageCode = new String();
			StringBuffer param = new StringBuffer();
			pageCode = PageUtil.genPaginationNoParam(request.getContextPath() + "/jgjcxx/list.do", total,
					Integer.parseInt(pageNum), Configuration.getPageSize());

			List<Jgjcxx> jgjcxxlist;
			List<Jgjcxx> jgjcxxlist2 = new ArrayList<Jgjcxx>();
			if (pageNum == "1") {
				jgjcxxlist = jgjcxxService.find(0, 5);
				jgjcxxlist2 = change(jgjcxxlist);
			} else {
				jgjcxxlist = jgjcxxService.find(Integer.parseInt(pageNum) * 5 - 5, 5);
				jgjcxxlist2 = change(jgjcxxlist);
			}
			mav.addObject("modeName", "极光类型管理");
			mav.addObject("jgjcxxlist", jgjcxxlist2);
			mav.addObject("mainPage", "jgjcxxlist.jsp");
			mav.setViewName("main");
			mav.addObject("pageCode", pageCode);
		} else {
			List<Jgjcxx> jgjcxxlist2 = new ArrayList<Jgjcxx>();
			List<Jgjcxx> jgjcxxlist = jgjcxxService.findByName(jgjcxx.getJg_yw());
			jgjcxxlist2 = change(jgjcxxlist);
			mav.addObject("modeName", "极光类型管理");
			mav.addObject("jgjcxxlist", jgjcxxlist2);
			mav.addObject("mainPage", "jgjcxxlist.jsp");
			mav.setViewName("main");
		}

		return mav;

	}
	
	@RequestMapping("/saveEdit")
	public ModelAndView saveEdit(@RequestParam(value = "id", required = false) Long id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("mainPage", "jgjcxxsave.jsp");
		mav.addObject("modeName", "极光类型管理");
		mav.setViewName("main");
		if (id != null) {
			mav.addObject("actionName", "激光类型修改");
			Jgjcxx jgjcxx = jgjcxxService.get(id);
			mav.addObject("jgjcxx", jgjcxx);
		} else {
			mav.addObject("actionName", "激光类型添加");
		}
		return mav;
	}
	
	@RequestMapping("/save.do")
	public String save(Jgjcxx jgjcxx, HttpServletRequest request) {
		JgjcxxCommand jgjcxxCommand;
		if(jgjcxx.getId() == null){
			
			if(jgjcxx.getJg_hm().equals("")){
				jgjcxx.setJg_hm("-1");
			} 
			if(jgjcxx.getJg_msfl().equals("")){
				jgjcxx.setJg_msfl("-1");;
			}
			if(jgjcxx.getJg_mz().equals("")){
				jgjcxx.setJg_mz("-1");;
			}
			if(jgjcxx.getJg_yw().equals("")){
				jgjcxx.setJg_yw("-1");
			}
			jgjcxxCommand = new JgjcxxCommand(jgjcxx);
			
			jgjcxxService.save(jgjcxxCommand);
		}else{
			Jgjcxx jgjcxx2 = jgjcxxService.get(jgjcxx.getId());
			if(jgjcxx.getJg_hm().equals("")){
				jgjcxx2.setJg_hm("-1");
			} else{
				jgjcxx2.setJg_hm(jgjcxx.getJg_hm());
			}
			if(jgjcxx.getJg_msfl().equals("")){
				jgjcxx2.setJg_msfl("-1");;
			}else{
				jgjcxx2.setJg_msfl(jgjcxx.getJg_msfl());
			}
			if(jgjcxx.getJg_mz().equals("")){
				jgjcxx2.setJg_mz("-1");;
			}else{
				jgjcxx2.setJg_mz(jgjcxx.getJg_mz());
			}
			if(jgjcxx.getJg_yw().equals("")){
				jgjcxx2.setJg_yw("-1");
			}else{
				jgjcxx2.setJg_yw(jgjcxx.getJg_yw());
			}
			jgjcxx2.setId(jgjcxx.getId());
			jgjcxxCommand = new JgjcxxCommand(jgjcxx2);
			jgjcxxService.save(jgjcxxCommand);
		}
		 return "redirect:/jgjcxx/list.do";
	}
	
	@RequestMapping("/delete.do")
	public String delete(@RequestParam(value = "id", required = false) Long id, HttpServletResponse response)
			throws Exception {
		Jgjcxx jgjcxx = jgjcxxService.get(id);
		jgjcxxService.delete(jgjcxx);
		return "redirect:/jgjcxx/list.do";
	}
	
	public List<Jgjcxx> change(List<Jgjcxx> jgjcxxlist){
		List<Jgjcxx> jgjcxxlist2 = new ArrayList<Jgjcxx>();
		for(Jgjcxx jgjcxx2: jgjcxxlist){
			if(jgjcxx2.getJg_hm().equals("0")){
				jgjcxx2.setJg_hm("弧状");
			}else if(jgjcxx2.getJg_hm().equals("1")){
				jgjcxx2.setJg_hm("冕状");
			}
			if(jgjcxx2.getJg_msfl().equals("0")){
				jgjcxx2.setJg_msfl("弥散极光");
			}else if(jgjcxx2.getJg_msfl().equals("1")){
				jgjcxx2.setJg_msfl("分离极光");
			}
			if(jgjcxx2.getJg_mz().equals("0")){
				jgjcxx2.setJg_mz("帷幔");
			}else if(jgjcxx2.getJg_mz().equals("1")){
				jgjcxx2.setJg_mz("极光热点");
			}
			if(jgjcxx2.getJg_yw().equals("0")){
				jgjcxx2.setJg_yw("无");
			}else if(jgjcxx2.getJg_yw().equals("1")){
				jgjcxx2.setJg_yw("有");
			}
		jgjcxxlist2.add(jgjcxx2);
		}
		return jgjcxxlist2;
	}

}
