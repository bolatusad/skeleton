<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
	function checkForm() {
		var file_path = $("#fileText").val();
		
		if (file_path == null || file_path == "") {
			$("#error").html("文件不能为空！");
			return false;
		}else{
			var type = file_path.substring(file_path.length-3,file_path.length);
			if(type != "txt"){
				$("#error").html("文件类型只能为txt！");
				return false;
			}
			
		}
		

		/* if(age==null||age==""){
		$("#error").html("请选择所属部门！");
		return false;
		} */

		return true;
	}

	function resetValue() {
		$("#file_path").val("");
	}
	
	
</script>
<div class="panel panel-default">
	<div class="panel-heading">
		<h3 class="panel-title">${actionName }</h3>
	</div>
	
	<div class="panel-body">
	 
		<form class="form-horizontal" method="post" role="form"  enctype="multipart/form-data"
			action="${pageContext.request.contextPath}/imageinfo/upload.do" 
			
			onsubmit="return checkForm()">
			
			
			<div class="form-group">
				<label class="col-md-2 control-label">请选择文件：</label>
				<div class="col-md-10">
					
					<input type="file"  class="form-control" id="fileText" name="fileText" style="width: 300px;"  />
				</div>
			</div>
			
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
				<!--  
					<input type="hidden" id="id" name="id" value="${fileText }" />
				-->
					<button type="submit" class="btn btn-primary">保存</button>
					&nbsp;&nbsp;
					<button type="button" class="btn btn-primary"
						onclick="resetValue()">重置</button>
					&nbsp;&nbsp; <font color="red" id="error"></font> <font color="red"
						id="login_err">${errorMsg }</font>
				</div>
			</div>
		</form>
		
	</div>
</div>

