package com.dreamchain.skeleton.util;


/**
 * 分页工具类
 * @author Administrator
 *
 */
public class PageUtil {

	/**
	 * 生成分页代码
	 * @param targetUrl 目标地址
	 * @param totalNum 总记录数
	 * @param currentPage 当前页
	 * @param pageSize 每页大小
	 * @return
	 */
	public static String genPagination(String targetUrl,int totalNum,int currentPage,int pageSize,String param){
		int totalPage=totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1;
		if(totalPage==0){
			return "<font color='red'>未查到数据</font>";
		}else{
			StringBuffer pageCode=new StringBuffer();
			pageCode.append("<li><a href='"+targetUrl+"?pageNum=1&"+param+"'>首页</a></li>");
			if(currentPage==1){
				pageCode.append("<li class='disabled'><a href='#'>上一页</a></li>");
			}else{
				pageCode.append("<li><a href='"+targetUrl+"?pageNum="+(currentPage-1)+"&"+param+"'>上一页</a></li>");			
			}
			for(int i=currentPage-2;i<=currentPage+2;i++){
				if(i<1||i>totalPage){
					continue;
				}
				if(i==currentPage){
					pageCode.append("<li class='active'><a href='#'>"+ i +"</a></li>");
				}else{
					pageCode.append("<li><a href='"+targetUrl+"?pageNum="+i+"&"+param+"'>"+i+"</a></li>");	
				}
			}
			if(currentPage==totalPage){
				pageCode.append("<li><a href='#'>下一页</a></li>");
			}else{
				pageCode.append("<li><a href='"+targetUrl+"?pageNum="+(currentPage+1)+"&"+param+"'>下一页</a></li>");		
			}
			pageCode.append("<li><a href='"+targetUrl+"?pageNum="+totalPage+"&"+param+"'>尾页</a></li>");
			
			return pageCode.toString();
		}
	}
	
	public static String genPaginationNoParam(String targetUrl,int totalNum,int currentPage,int pageSize){
		int totalPage=totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1;
		if(totalPage==0){
			return "<font color='red'>未查到数据</font>";
		}else{
			StringBuffer pageCode=new StringBuffer();
			pageCode.append("<li><a href='"+ targetUrl +"?pageNum=1'>首页</a></li>");
			if(currentPage == 1){
				pageCode.append("<li class='disabled'><a href='#'>上一页</a></li>");
			}else{
				pageCode.append("<li><a href='"+targetUrl+"?pageNum="+(currentPage-1)+"'>上一页</a></li>");			
			}
			for(int i=currentPage-2;i<=currentPage+2;i++){
				if(i<1||i>totalPage){
					continue;
				}
				if(i==currentPage){
					//pageCode.append("<li>"+i+"</li>");		
					pageCode.append("<li class='active'><a href='#'>"+ i +"</a></li>");
				}else{
					//pageCode.append("<li><a href='"+targetUrl+"?page="+i+"'>"+i+"</a></li>");	
					pageCode.append("<li><a href='"+ targetUrl +"?pageNum="+ i +"'>"+ i +"</a></li>");
				}
			}
			if(currentPage == totalPage){
				pageCode.append("<li><a href='#'>下一页</a></li>");
			}else{
				//pageCode.append("<li><a href='"+targetUrl+"?page="+(currentPage+1)+"'>下一页</a></li>");		
				pageCode.append("<li><a href='"+ targetUrl +"?pageNum="+ (currentPage+1) +"'>下一页</a></li>");
			}
			pageCode.append("<li><a href='"+targetUrl+"?pageNum="+totalPage+"'>尾页</a></li>");
			return pageCode.toString();
		}
	}
	
	
}
