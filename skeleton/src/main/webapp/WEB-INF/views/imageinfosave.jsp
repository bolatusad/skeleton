<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
	function checkForm() {
		var g = $("#g").val();
		var r = $("#r").val();
		var v = $("#v").val();
		var type = $("#type").val();
		var hard = $("#hard").val();
		var pici = $("#pici").val();
		
		if (type == null || type == "") {
			$("#error").html("图片类型不能为空！");
			return false;
		}
		if (hard == null || hard == "") {
			$("#error").html("图像难度不能为空！");
			return false;
		}
		if (pici == null || pici == "") {
			$("#error").html("图像批次不能为空！");
			return false;
		}

		
		/* if(age==null||age==""){
		$("#error").html("请选择所属部门！");
		return false;
		} */

		return true;
	}

	function resetValue() {
		var type = ${imageInfo.image_type };
		var pici = ${imageInfo.pici };
		var hard = ${imageInfo.hard };
		
		$("#type").val( type);
		$("#hard").val( hard);
		$("#pici").val( pici);
		
	}
</script>
<div class="panel panel-default">
	<div class="panel-heading">
		<h3 class="panel-title">${actionName }</h3>
	</div>
	<div class="panel-body">
		<form class="form-horizontal" role="form" method="post"
			action="${pageContext.request.contextPath}/imageinfo/save.do"
			onsubmit="return checkForm()">
			
			<div class="form-group">
				<label class="col-md-2 control-label">图像G：</label>
				<div class="col-md-10">
					<input type="text" class="form-control" id="g" name="g"
						style="width: 300px;" readonly="true" value="${imageInfo.g }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-2 control-label">图像R：</label>
				<div class="col-md-10">
					<input type="text" class="form-control" id="r" name="r"
						style="width: 300px;" readonly="true" value="${imageInfo.r }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-2 control-label">图像V:</label>
				<div class="col-md-10">
					<input type="text" class="form-control" id="v"
						name="v" style="width: 300px;" readonly="true" value="${imageInfo.v}">
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-2 control-label">图像类型：</label>
				<div class="col-md-10">
					<input type="text" class="form-control" id="type" name="image_type"
						style="width: 300px;" value="${imageInfo.image_type }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-2 control-label">图像难度：</label>
				<div class="col-md-10">
					<input type="text" class="form-control" id="hard" name="hard"
						style="width: 300px;" value="${imageInfo.hard }">
				</div>
			</div>
			<!--  
			<div class="form-group">
				<label class="col-md-2 control-label">是否标记：</label>
				<div class="col-md-10">
					<select class="form-control" style="width: 300px;" id="iscomplete" name="is_complete">
						<option value="">请选择..</option>
					  		<option value="1" >是</option>
					  		<option value="0" >否</option>
					</select>
				</div>
			</div>
			-->
			<div class="form-group">
				<label class="col-md-2 control-label">图像批次：</label>
				<div class="col-md-10">
					<input type="text" class="form-control" id="pici" name="pici"
						style="width: 300px;" value="${imageInfo.pici }">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<input type="hidden" id="id" name="id" value="${imageInfo.id }" />
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

