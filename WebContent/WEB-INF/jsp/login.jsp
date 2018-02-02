<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/commons/common.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head></head>
  <body>

    <form action="${ctp}/shiro/login" method="post"class="form-horizontal">
    	username : <input type="text" name = "username"/>
    	<br><br>
    	password : <input type="password" name = "password"/>
    	<br><br>
    	<input type="submit" value="submit"/>
    	<br><br>
    	记住我 ： <input type="checkbox" name="remeberMe" id="remeberMe" value="yes"/>
    </form>
    	
  </body>
</html>
