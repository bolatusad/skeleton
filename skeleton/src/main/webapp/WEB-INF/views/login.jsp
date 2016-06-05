<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>极光标记系统-用户登录</title>

        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/loginPage.css" />	
		<script src="${pageContext.request.contextPath}/js/jquery-2.1.1.min.js"></script>
		<script type="text/javascript">
		function checkForm(){
		var name=document.getElementById("name").value;
		var password=document.getElementById("password").value;
		if(name==null || name==""){
			document.getElementById("login_err").innerHTML="用户名不能为空";
			return false;
		}
		if(password==null || password==""){
			document.getElementById("login_err").innerHTML="密码不能为空";
			return false;
		}
		return true;
	}
</script>
		<style type="text/css">
			body {
				background: #fff url(${pageContext.request.contextPath}/images/index_bg.jpg) repeat top left;
			}
		</style>	
    </head>
    <body>
       <div class="container">
        <div style="text-align:center;clear:both;"></div>
            <section>				
                <div id="container_demo" >
                    <div id="wrapper">
                        <div style="margin-top: 30%;" id="login" class="animate form">
                            <form id="submitForm"  action="${pageContext.request.contextPath}/user/login.do"  method="post" onsubmit="return checkForm()">
                                <h1>极光标记系统</h1> 
                                <p> 
                                    <label for="username" class="uname" data-icon="" > 用户名 </label>
                                    <input id="name" name="name" required="required" type="text" placeholder="Username"/>
                                </p>
                                <p> 
                                    <label for="password" class="youpasswd" data-icon=""> 密&nbsp;&nbsp;码 </label>
                                    <input id="password" name="password" required="required" type="password" placeholder="Password" />
                                </p>
                               <!-- <p class="keeplogin"> 
									<input type="checkbox" name="loginkeeping" id="loginkeeping" value="loginkeeping" />
									<label for="loginkeeping">Keep me logged in</label>
								</p>-->
								
								<a href="javascript:Helper_Session.Login();">
                                <p class="login button"> 
                                    <input id="loginsubmit" type="submit" value="登录" /> 
								</p>
								</a>
                            </form>
                        </div>
                    </div>
                </div>  
            </section>
        </div>
	</body>
</html>