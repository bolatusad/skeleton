<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
	function userDelete(id){
		
		if(confirm("确认要删除这条记录吗？")){
		//此处利用jQuery发送了一个ajax请求，返回结果时页=也返回到此处
			$.post("${pageContext.request.contextPath}/user/delete.do",{id:id},
				function(){
						alert("删除成功!");
						window.location.href="${pageContext.request.contextPath}/user/list.do";

				}
			);
		}
	}
	
</script>
<div class="row search">
	<div class="col-md-6">
		<form action="${pageContext.request.contextPath}/user/list.do"
			method="post">
			<div class="input-group" style="width: 300px">
				<input type="text" class="form-control" name="name"
					value="${user.name }" placeholder="请输入要查询的用户名..."> <span
					class="input-group-btn">
					<button class="btn btn-default" type="submit">
						<span class="glyphicon glyphicon-search"></span>&nbsp;查询
					</button>
				</span>
			</div>
		</form>
	</div>
	<div class="col-md-6">
		<button type="button" style="float: right;" class="btn btn-primary"
			onclick="javascript:window.location.href='${pageContext.request.contextPath}/user/saveEdit.do'">添加</button>
	</div>
</div>
<div>
	<table class="table table-hover  table-bordered table-striped"
		style="margin-bottom: 0px;">
		<tr>
			<th>学号</th>
			<th>用户名</th>
			<th>密码</th>

			<th>邮箱</th>
			<th>角色</th>
			<th>地址</th>

		</tr>
		<c:forEach var="user" items="${userlist }" varStatus="status">
			<tr>
				<!--  <td>${status.index+1 }</td> -->
				<%-- <td>${user.id}</td> --%>
				<td>${user.user_id }</td>
				<td>${user.name }</td>
				<td>${user.password }</td>
				<td>${user.email }</td>
				<td>${user.role }</td>
				<td>${user.address }</td>
				<td><button type="button" class="btn btn-info btn-xs"
						onclick="javascript:window.location.href='${pageContext.request.contextPath}/user/saveEdit.do?id=${user.id }'">修改</button>&nbsp;

					<button type="button" class="btn btn-danger btn-xs"
						onclick="userDelete(${user.id })">删除</button><%--<c:if test="${user.xunjian==0 }">
		  				<button type="button" class="btn btn-info btn-xs" onclick="setXunjian(${user.id },1)">设置巡检</button> 
		  				</c:if>
		  				<c:if test="${user.xunjian==1 }">
		  				<button type="button" class="btn btn-info btn-xs" onclick="setXunjian(${user.id },0)">取消巡检</button> 
		  				</c:if>  --%></td>
			</tr>
		</c:forEach>
	</table>
	<nav>
		<ul class="pagination">${pageCode }
		</ul>
	</nav>
</div>



