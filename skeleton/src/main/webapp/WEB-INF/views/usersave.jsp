<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
	function checkForm() {
		var name = $("#name").val();
		var password = $("#password").val();
		var adress = $("#address").val();
		var role = $("#role").val();
		var user_id = $("#user_id").val();
		var email = $("#email").val();
		
		if (name == null || name == "") {
			$("#error").html("用户名不能为空！");
			return false;
		}
		if (password == null || password == "") {
			$("#error").html("密码不能为空！");
			return false;
		}
		if (address == null || address == "") {
			$("#error").html("地址不能为空！");
			return false;
		}
		if (role == null || role == "") {
			$("#error").html("请填写用户角色！");
			return false;
		}
		if (user_id == null ||user_id== "") {
			$("#error").html("请填写学号！");
			return false;
		}
		if (email != null || email !="") {
			if (!email.match("^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$")){
				$("#error").html("请填写正确的邮箱格式！");
				 return false;
			} 	  
		}else{
			$("#error").html("请填写邮箱！");
			return false;
		}
		

		/* if(age==null||age==""){
		$("#error").html("请选择所属部门！");
		return false;
		} */

		return true;
	}

	function resetValue() {
		$("#name").val("");
		$("#password").val("");
		$("#address").val("");
		$("#role").val("");
		$("#email").val("");
		$("#user_id").val("");
	}
</script>
<div class="panel panel-default">
	<div class="panel-heading">
		<h3 class="panel-title">${actionName }</h3>
	</div>
	<div class="panel-body">
		<form class="form-horizontal" role="form" method="post"
			action="${pageContext.request.contextPath}/user/save.do"
			onsubmit="return checkForm()">
			
			<div class="form-group">
				<label class="col-md-2 control-label">学号：</label>
				<div class="col-md-10">
					<input type="text" class="form-control" id="user_id" name="user_id"
						style="width: 300px;" value="${user.user_id }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-2 control-label">用户名：</label>
				<div class="col-md-10">
					<input type="text" class="form-control" id="name" name="name"
						style="width: 300px;" value="${user.name }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-2 control-label">密码：</label>
				<div class="col-md-10">
					<input type="text" class="form-control" id="password"
						name="password" style="width: 300px;" value="${user.password }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-2 control-label">邮箱：</label>
				<div class="col-md-10">
					<input type="text" class="form-control" id="email" name="email"
						style="width: 300px;" value="${user.email }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-2 control-label">角色：</label>
				<div class="col-md-10">
					<input type="text" class="form-control" id="role" name="role"
						style="width: 300px;" value="${user.role }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-2 control-label">地址：</label>
				<div class="col-md-10">
					<input type="text" class="form-control" id="address" name="address"
						style="width: 300px;" value="${user.address }">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<input type="hidden" id="id" name="id" value="${user.id }" />
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

