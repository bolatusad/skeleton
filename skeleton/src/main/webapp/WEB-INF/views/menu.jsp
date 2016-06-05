<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
function logout(){
	if(confirm('您确定要退出系统吗？')){
		window.location.href="${pageContext.request.contextPath}/user/logout.do";
	}
}
</script>
<div class="list-group">
  <a href="#" class="list-group-item active">
    系统菜单
  </a>
  <%-- <c:if test="${ currentUser.roleName=='管理员'}"> --%>
	  <a href="${pageContext.request.contextPath}/user/list.do" class="list-group-item">用户管理</a>
      <a href="${pageContext.request.contextPath}/jgjcxx/list.do"  class="list-group-item">极光类型管理</a>
	  <a href="${pageContext.request.contextPath}/imageinfo/list.do" class="list-group-item">极光图像信息管理</a>
	  <a href="${pageContext.request.contextPath}/pici/list.do" class="list-group-item">极光图像批次管理</a>
	  <a href="${pageContext.request.contextPath}/picture/list.do" class="list-group-item">极光标记</a>
	  <a href="${pageContext.request.contextPath}/bjxx/list.do" class="list-group-item">标记信息查询</a>
      <a href="#" class="list-group-item">统计查询</a>
	<%--  <a href="${pageContext.request.contextPath}/checkRecord/list.do" class="list-group-item">设备巡检管理</a>
	  <a href="${pageContext.request.contextPath}/equipment/repairList.do" class="list-group-item">维修设备管理</a>
	  <a href="${pageContext.request.contextPath}/equipment/repairHistory.do" class="list-group-item">维修历史</a>  --%>
	  <a href="javascript:logout()" class="list-group-item">安全退出</a>
<%--   </c:if> --%>
 
</div>