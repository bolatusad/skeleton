<%@page import="com.dreamchain.skeleton.model.ImageInfo"%>
<%@page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/styles/bootstrap.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/styles/carousel.css"><!--图片轮播CSS插件-->
<link rel="stylesheet" href="${pageContext.request.contextPath}/styles/skins/icheck_all.css?v=0.9.1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/styles/icheck_custom.css?v=0.9.1"><!--icheck CSS插件-->
<style type="text/css">
input
{
  border-top:0px ;
  border-left:0px ;
  border-right:0px ;
}

.myLegend
{
	font-size:17px;
	margin-bottom:8px;
	text-align:center;
	padding:5px 0px 7px 0px;
}
.mytable tr td
{
	padding:10px;
}


</style>
<script src="${pageContext.request.contextPath}/scripts/jquery-2.1.1.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/scripts/jquery.icheck.js"></script>
<script src="${pageContext.request.contextPath}/scripts/carouselPage.js"></script>
<script src="${pageContext.request.contextPath}/scripts/bootstrap.js" type="text/javascript"></script>
<title>Insert title here</title>
</head>
<body>
<%request.setCharacterEncoding("utf-8");%>
<form name="form1" method="post" action="${pageContext.request.contextPath}/picture/mark.do">
		<div id="div_body_right" style="width:100%;margin-left:2%;float:left;">
		<div style="border:2px solid #E5E5E5; border-radius:5px; padding-bottom:0px; margin-top:10px;padding-top:5px;">
			<section id="section" class="htmleaf-container" >
				  <h4></h4>
			</section>
				<!-- *************arrow**************** -->
				<div class="row show-grid" style="border:0px solid #E5E5E5; border-radius:5px;">
					<div class="col-xs-5">	
							<button class="btn-xs btn-default" type="button" style="margin:3px 7px 7px 7px;float:right;">
								 <span id="arrowLeft" class="glyphicon glyphicon-chevron-left"style="font-size:25px;"></span>
							</button>	
							<span style="margin:3px 180px 7px 7px;font-size:20px;float:right;">Red</span>		
					</div>
					<div class="col-xs-2">
						<span style="margin:3px 7px 7px 36px;font-size:20px; float:left;">Green</span>			
					</div>
					<div class="col-xs-5">	
							<button class="btn-xs btn-default" type="button" style="margin:3px 7px 7px 7px;float:left;">
							  <span id="arrowRight" class="glyphicon glyphicon-chevron-right" style="font-size:25px;"></span>
							</button>	
							<span style="margin:3px 7px 7px 160px;font-size:20px; float:left;">Violet</span>			
					</div>
				</div>	
			</div>


	<!-- *************radio and info**************** -->
	<div style=";border:2px solid #E5E5E5; border-radius:5px;margin-top:15px;">
		<div style="padding:0px 5px 0px 5px; width:12.5%;height:100%; float:left; ">
				<fieldset class="myFieldset" style="width:100%">
					<legend class="myLegend"  style="text-align:center;">Select Mode</legend>						
						<div style="width:100%;height:100%;;text-align:center;vertical-align:middle;">
							<p style="margin:35px 0 3px 0;clear:both;height:35px;">
								<a style="padding-top:20px;padding-bottom:20px;font-size:15px;" class="btn btn-primary btn-sm" href="#" role="button">Browse</a>
							</p>
							<div style="clear:both;"></div>
						</div>
				</fieldset>
			</div>
			<div  style="padding:0px 2px 0px 0px; width:15%; float:left; ">
				<fieldset class="myFieldset">
					<legend class="myLegend"  style="text-align:center;">Select Phase</legend>
					<div class="btn-group-vertical" role="group" style="margin-left:10px;">
						<button type="button" class="btn btn-default" style="padding:10px 30px 10px 30px;">Train</button>
						<button type="button" class="btn btn-default" style="padding:10px 30px 10px 30px;">Test</button>
						<button type="button" class="btn btn-default" style="padding:10px 30px 10px 30px;">Label</button>
					</div>
					<!--  
						<p style="margin:7px;">
							<a style="width:100%" class="btn btn-primary btn-sm" href="#" role="button">Train</a>
						</p>
						<p style="margin:7px; ">
							<a  style="width:100%" class="btn btn-primary btn-sm" href="#" role="button">Test</a>
						</p>
						<p style="margin:7px; ">
							<a  style="width:100%" class="btn btn-primary btn-sm" href="#" role="button">Label</a>
						</p>-->
				</fieldset>
			</div>
	
		<div   id="radio" style="width:37%;float:left;margin-left:6px;">
			<fieldset>
			<legend class="myLegend"  style="text-align:center;margin-bottom:10px;">Select Class</legend>			
			<div style="width:77%;float:left;margin:0px 0px 0px 0px ">
			
			
			
					<div id="radioLeft" style="width:45%;float:left; padding-left:5px;"> 

						<div class="demo-list clear" style="padding-top:10px;">
						  <ul class="icheckUl">
							<li  style="float:left; padding-left:26px;margin-right:13px;">
							  <input tabindex="1" type="radio" id="input1" name="resultType" value=1>
							  <label for="input1">No Aurora</label>
							</li>
							<li style="float:left; padding-left:26px;margin-right:13px;">
							  <input tabindex="2" type="radio" id="input2" name="resultType" value="2">
							  <label for="input2">CurCor</label>
							</li>
							<li style="float:left; padding-left:26px;margin-right:13px;">
							  <input tabindex="3" type="radio" id="input3" name="resultType" value="3">
							  <label for="input3">RadCor</label>
							</li>
						  </ul>
						</div>

					</div>
					<div id="radioRight" style="width:50%;float:left"> 
						<div class="demo-list clear" style="padding-top:10px;">
						  <ul class="icheckUl">
							<li style="float:left; padding-left:26px;margin-right:13px;">
							  <input tabindex="4" type="radio" id="input4" name="resultType" value="4">
							  <label for="input4">Diffuse Aurora</label>
							</li>
							<li style="float:left; padding-left:26px;margin-right:13px;">
							  <input tabindex="5" type="radio" id="input5" name="resultType" value="5">
							  <label for="input5">MulArc</label>
							</li>
							<li style="float:left; padding-left:26px;margin-right:13px;">
							  <input tabindex="6" type="radio" id="input6" name="resultType" value="6">
							  <label for="input6">HotCor</label>
							</li>
						  </ul>
						</div>
					</div>
				
			<!-- 
				<div id="radioUp">
					<div class="demo-list clear" style="padding-top:10px;">
						  <ul class="icheckUl">
							<li style="float:left; padding-left:26px;margin-right:13px;">
							  <input tabindex="1" type="radio" id="input1" name="resultType" value=1>
							  <label for="input1">类型1</label>
							</li>
							<li style="float:left; padding-left:26px;margin-right:13px;">
							  <input tabindex="2" type="radio" id="input2" name="resultType" value="2">
							  <label for="input2">类型2</label>
							</li>
							<li style="float:left; padding-left:26px;margin-right:13px;">
							  <input tabindex="3" type="radio" id="input3" name="resultType" value="3">
							  <label for="input3">类型3</label>
							</li>
						  </ul>
					</div>			
				</div>
				<div id="radioDown">
					<div class="demo-list clear" style="padding-top:10px;">
						  <ul class="icheckUl">
							<li style="float:left; padding-left:26px;margin-right:13px;">
							  <input tabindex="4" type="radio" id="input4" name="resultType" value="4">
							  <label for="input4">类型4</label>
							</li>
							<li style="float:left; padding-left:26px;margin-right:13px;">
							  <input tabindex="5" type="radio" id="input5" name="resultType" value="5">
							  <label for="input5">类型5</label>
							</li>
							<li style="float:left; padding-left:26px;margin-right:13px;">
							  <input tabindex="6" type="radio" id="input6" name="resultType" value="6">
							  <label for="input6">类型6</label>
							</li>
						  </ul>
						</div>
				</div>
		-->
			</div>
			<div  style="width:20%;float:left;margin-left:-5px;">
				<div style="width:100%;height:100%;">
					<button style="padding-top:15px;padding-bottom:15px;font-size:15px;margin-top:36px;"  type="submit" class="btn btn-primary btn-sm">提&nbsp;&nbsp;交</button>					
					<div style="clear:both"></div>
				</div>
			</div>
			</fieldset>
		</div>
		<div style="width:32%;float:left;">
				<fieldset>
					<legend class="myLegend"  style="text-align:center;">待标记图片<span id="currentImg" name="currentImg"></span></legend>
						<!-- 	<button  class="btn-sm btn-primary" type="button" style="margin:5px;">
							  第 <span id="round" class="badge"></span> 轮:
							</button>		
							<br>
							<button class="btn-sm btn-primary" type="button" style="margin:5px;">
							  准确率： <span id="accuracy_rate" class="badge" name="accuracy_rate"></span>
							</button>
							<br>
							<button class="btn-sm btn-primary" type="button" style="margin:5px;">
							  已训练数量： <span id="count_trained" class="badge" name="count_trained"></span>
							</button>
							 -->	
							 							 							 															
						<table class="myTable">
							<tr>
								<td style="padding:8px 2px;width:50%;">第几轮:<span id="round" class="badge"></span></td>
								<td style="padding:8px 2px;">Test Accuracy:</td>
							</tr>
							<tr>
								<td style="padding:8px 2px;width:50%;">准确率: <span id="accuracy_rate" class="badge" name="accuracy_rate"></span></td>
								<td style="padding:8px 2px;">Trained Batch:</td>
							</tr>
							<tr>
								<td style="padding:8px 2px;width:50%;">已训练量:<span id="count_trained" class="badge" name="count_trained"></span></td>
								<td style="padding:8px 2px;"></td>
							</tr>
						</table>
					</fieldset>
		</div>
		<div style="clear:both;"></div>
	</div>
	
			<p style="margin:15px 0 3px 0; float:right;">
				<a class="btn btn-default btn-sm" href="#" role="button">提示信息</a>
			</p>
			<p style="margin:15px 20px 3px 20px; float:right;">
				<a class="btn btn-info btn-sm" href="#" role="button">帮助</a>
			</p>
	</div>
</form>
</body>
</html>