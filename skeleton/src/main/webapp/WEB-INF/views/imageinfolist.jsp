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
					value="${imageinfo.g }" placeholder="请输入要查询的图片名称..."> <span
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
			onclick="javascript:window.location.href='${pageContext.request.contextPath}/imageinfo/saveEdit.do'">上传</button>
	</div>
</div>

<div>
	<table class="table table-hover  table-bordered table-striped"
		style="margin-bottom: 0px;">
		<tr>
			<th>编号</th>
			<th>G</th>
			<th>R</th>
			<th>V</th>
			<th>类型</th>
			<th>难度</th>
			<th>是否完成</th>
			<th>次数</th>
			<th>批次</th>
		</tr>
		<c:forEach var="imageinfo" items="${imageinfolist }" varStatus="status">
			<tr>
				<!--  <td>${status.index+1 }</td> -->
				<%--  <td>${user.id}</td>  --%>
				<td>${imageinfo.id }</td>
				<td>${imageinfo.g }</td>
				<td>${imageinfo.r }</td>
				<td>${imageinfo.v}</td>
				<td>${imageinfo.image_type}</td>
				<td>${imageinfo.hard}</td>
				<td>${imageinfo.is_complete}</td>
				<td>${imageinfo.tag_times}</td>
				<td>${imageinfo.pici}</td>
				<td><button type="button" class="btn btn-info btn-xs"
						onclick="javascript:window.location.href='${pageContext.request.contextPath}/imageinfo/saveEdit.do?id=${imageinfo.id }'">修改</button>&nbsp;

					<button type="button" class="btn btn-danger btn-xs"
						onclick="Delete(${imageinfo.id})">删除</button> <%--<c:if test="${user.xunjian==0 }">
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



