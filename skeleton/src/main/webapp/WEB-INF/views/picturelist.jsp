<%@page import="com.dreamchain.skeleton.model.ImageInfo"%>
<%@page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<%request.setCharacterEncoding("utf-8");%>
<form name="form1" method="post" action="${pageContext.request.contextPath}/picture/mark.do">
  <table width="737" border="1" align="center">
    <tr>
      <td width="25%"><div align="center"><img src=${jgbj1.image_path }>&nbsp;<input type="text" name="id1" value=${jgbj1.id } readonly>
      </div></td>
      <td width="25%"><div align="center"><img src=${jgbj2.image_path }>&nbsp;<input type="text" name="id2" value=${jgbj2.id } readonly>
      </div></td>
      <td width="25%"><div align="center"><img src=${jgbj3.image_path }>&nbsp; 
          <input type="text" name="id3" value=${jgbj3.id } readonly>
      </div></td>
    </tr>
  <tr>
      <td colspan="3">
        <div align="center">
          <select name="jgbj2">
            <option value="1">类别1</option>
            <option value="2">类别2</option>
          </select>
        </div>
      </td>

    <tr>
    <td colspan="3"><div align="center">
    <input type="submit" value="提交标记"> <input type="reset" value="重置">
    </div></td>
    </tr>
  

  </table>
</form>
</body>
</html>