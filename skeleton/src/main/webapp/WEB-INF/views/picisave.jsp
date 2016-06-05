<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript">
	function checkForm() {
		var start = $("#start").val();
		var end = $("#end").val();
		var num = $("#num").val();

		if (start == null || start == "") {
			$("#error").html("开始时间不能为空！");
			return false;
		}
		if (end == null || end == "") {
			$("#error").html("截止时间不能为空！");
			return false;
		}
		
		if(end <= start){
			$("#error").html("截止时间不能小于等于开始时间！");
			return false;
		}
		if (num == null || num == "") {
			$("#error").html("批次数量不能为空！");
			return false;
		}
		
		
		
		return true;
	}

	function resetValue() {

		$("#start").val("");
		$("#end").val("");
		$("#num").val("");

	}

	$(document).ready(function() {

		$(".form_date").datetimepicker({
			 language:  'zh-CN',
			 show: true,  
			 weekStart: 1,
	         todayBtn:  1,
			 autoclose: 1,
			 todayHighlight: 1,
			 startView: 2,
			 minView: 2,
			 forceParse: 0,
			 orientation:'right',
	         todayBtn:'linked'
		});
	});
</script>
<div class="panel panel-default">
	<div class="panel-heading">
		<h3 class="panel-title">${actionName }</h3>
	</div>
	<div class="panel-body">
		<form class="form-horizontal" role="form" method="post"
			action="${pageContext.request.contextPath}/pici/save.do"
			onsubmit="return checkForm()">



		   <div class="form-group">
                <label for="dtp_input2" class="col-md-2 control-label">开始时间：</label>
                <div  class="input-group date form_date col-md-5" data-date="" data-date-format="yyyy-mm-dd" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
                    <input id="start" name="start" class="form-control" size="16" type="text" value="" readonly>
                    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
					<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                </div>
				<input type="hidden" id="dtp_input2" value="" /><br/>
            </div>
            
             <div class="form-group">
                <label for="dtp_input2" class="col-md-2 control-label">截止时间：</label>
                <div  class="input-group date form_date col-md-5" data-date="" data-date-format="yyyy-mm-dd" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
                    <input id="end" name="end" class="form-control" size="16" type="text" value="" readonly>
                    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
					<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                </div>
				<input type="hidden" id="dtp_input2" value="" /><br/>
            </div>
            
			<div class="form-group">
				<label class="col-md-2 control-label">批次数量：</label>
				<div class="col-md-6">
					<input type="text" class="form-control" id="num" name="num" 
						style="width: 300px;" />
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
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

