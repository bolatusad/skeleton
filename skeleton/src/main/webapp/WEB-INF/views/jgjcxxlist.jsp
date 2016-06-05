<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
	function Delete(id){
		if(confirm("确认要删除这条记录吗？")){
		//此处利用jQuery发送了一个ajax请求，返回结果时页=也返回到此处
			$.post("${pageContext.request.contextPath}/jgjcxx/delete.do",{id:id},
				function(){
						alert("删除成功!");
						window.location.href="${pageContext.request.contextPath}/jgjcxx/list.do";

				}
			);
		}
	}
	
</script>
<div class="row search">
<div class="col-md-6">
		<form action="${pageContext.request.contextPath}/jgjcxx/list.do"
			method="post">
			<div class="input-group" style="width: 300px">
				<input type="text" class="form-control" name="jg_yw"
					value="${jgjcxx.jg_yw }" placeholder="请输入要查询的极光有无..."> <span
					class="input-group-btn">
					<button class="btn btn-default" type="submit">
						<span class="glyphicon glyphicon-search"></span>&nbsp;查询
					</button>
				</span>
			</div>
		</form>
	</div>

	<div class="col-md-6" style="float: right">
		<button type="button" style="float: right" class="btn btn-primary"
			onclick="javascript:window.location.href='${pageContext.request.contextPath}/jgjcxx/saveEdit.do'">添加</button>
	</div>
</div>

<div>
	<table class="table table-hover  table-bordered table-striped"
		style="margin-bottom: 0px;">
		<tr>
			<th>编号</th>
			<th>极光有无</th>
			<th>极光弥散分离</th>
			<th>极光弧状冕状</th>
			<th>冕状极光类别</th>
		</tr>
		<c:forEach var="jgjcxx" items="${jgjcxxlist }" varStatus="status">
			<tr>
				<!--  <td>${status.index+1 }</td> -->
				<%--  <td>${user.id}</td>  --%>
				<td>${jgjcxx.id }</td>
				<td>${jgjcxx.jg_yw }</td>
				<td>${jgjcxx.jg_msfl }</td>
				<td>${jgjcxx.jg_hm }</td>
				<td>${jgjcxx.jg_mz}</td>
				<td><button type="button" class="btn btn-info btn-xs"
						onclick="javascript:window.location.href='${pageContext.request.contextPath}/jgjcxx/saveEdit.do?id=${jgjcxx.id }'">修改</button>&nbsp;

					<button type="button" class="btn btn-danger btn-xs"
						onclick="Delete(${jgjcxx.id})">删除</button> <%--<c:if test="${user.xunjian==0 }">
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



