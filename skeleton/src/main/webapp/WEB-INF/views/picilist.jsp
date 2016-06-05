<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
	function Delete(id){
		if(confirm("确认要删除这条记录吗？")){
		//此处利用jQuery发送了一个ajax请求，返回结果时页=也返回到此处
			$.post("${pageContext.request.contextPath}/imageinfo/delete.do",{id:id},
				function(){
						alert("删除成功!");
						window.location.href="${pageContext.request.contextPath}/imageinfo/list.do";

				}
			);
		}
	}
	
</script>
<div class="row search">
<div class="col-md-6">
		<form action="${pageContext.request.contextPath}/imageinfo/list.do"
			method="post">
			<div class="input-group" style="width: 300px">
				<input type="text" class="form-control" name="image_name"
					value="" placeholder="请输入要查询的批次的ID..."> <span
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
			onclick="javascript:window.location.href='${pageContext.request.contextPath}/pici/saveEdit.do'">添加</button>
	</div>
</div>

<div>
	<table class="table table-hover  table-bordered table-striped"
		style="margin-bottom: 0px;">
		<tr>
			<th>编号</th>
			<th>开始时间</th>
			<th>结束时间</th>
			<th>数量</th>
		</tr>
		<c:forEach var="pici" items="${picilist }" varStatus="status">
			<tr>
				<!--  <td>${status.index+1 }</td> -->
				<%--  <td>${user.id}</td>  --%>
				<td>${pici.id }</td>
				<td>${pici.start }</td>
				<td>${pici.end }</td>
				<td>${pici.num}</td>
				
			</tr>
		</c:forEach>
	</table>
	<nav>
		<ul class="pagination">${pageCode }
		</ul>
	</nav>
</div>



