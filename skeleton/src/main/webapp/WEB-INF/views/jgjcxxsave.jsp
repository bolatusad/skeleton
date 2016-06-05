<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
/* 	function checkForm() {
		var jg_yw = $("#jg_yw").val();
		var jg_msfl = $("#jg_msfl").val();
		var jg_hm = $("#jg_hm").val();
		var jg_mz = $("#jg_mz").val();
		
		 if (jg_yw!=0&&jg_yw!=1) {
			$("#error").html("极光有无只能输入0或者1！");
			return false;
		}
		if (jg_msfl !=0&&jg_msfl!=1) {
			$("#error").html("极光弥散分离只能输入0或者1！");
			return false;
		}
		if (jg_hm !=0&&jg_hm!=1) {
			$("#error").html("极光弧状冕状只能输入0或者1！");
			return false;
		}
		if (jg_mz !=0&&jg_mz!=1) {
			$("#error").html("冕状极光类别只能输入0或者1！");
			return false;
		} 

		return true;
	} */

	function resetValue() {
		 $("#jg_yw").val("");
		 $("#jg_msfl").val("");
		 $("#jg_hm").val("");
		 $("#jg_mz").val();
	}
</script>
<div class="panel panel-default">
	<div class="panel-heading">
		<h3 class="panel-title">${actionName }</h3>
	</div>
	<div class="panel-body">
		<form class="form-horizontal" role="form" method="post"
			action="${pageContext.request.contextPath}/jgjcxx/save.do">
			
			 <div class="form-group">
				<label class="col-md-2 control-label">极光有无：</label>
				<select class="form-control" style="width: 300px;" id="jg_yw" name="jg_yw" >
				<option value="">请选择..</option>
					  <option value="1" >有</option>
					  <option value="0" >无</option>
				</select>
			</div>
			<div class="form-group">
				<label class="col-md-2 control-label">极光弥散分离：</label>
				<select class="form-control" style="width: 300px;" id="jg_msfl" name="jg_msfl" >
				<option value="">请选择..</option>
					  <option value="1" >分离极光</option>
					  <option value="0" >弥散极光</option>
				</select>
			</div>
			<div class="form-group">
				<label class="col-md-2 control-label">极光弧状冕状：</label>
				<select class="form-control" style="width: 300px;" id="jg_hm" name="jg_hm" >
				<option value="">请选择..</option>
					  <option value="1" >冕状</option>
					  <option value="0" >弧状</option>
				</select>
			</div>
			<div class="form-group">
				<label class="col-md-2 control-label">冕状极光类别：</label>
				<select class="form-control" style="width: 300px;" id="jg_mz" name="jg_mz" >
				<option value="">请选择..</option>
					  <option value="1" >极光热点</option>
					  <option value="0" >帷幔</option>
				</select>
			</div> 
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<input type="hidden" id="id" name="id" value="${jgjcxx.id }" />
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

