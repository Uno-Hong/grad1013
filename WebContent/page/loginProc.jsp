<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="loginProcess" class="grad.UserInformationSQL"/>
<jsp:useBean id="test" class="grad.Rotprtm"></jsp:useBean>
<style>
      body {
         text-align : center;
      }
</style>

<%
	String id = request.getParameter("loginid");
	String pw = request.getParameter("loginpw");
	String url = "login.jsp";
	String msg = "로그인 정보가 잘못되었습니다.";
	
	int count = test.Sex();
	
	boolean result = loginProcess.login(id, pw);
	if(result){
		session.setAttribute("sessionID", id);
		session.setAttribute("sessionPW", pw);
		msg = "성공적으로 로그인되었습니다.";
		url = "Main.jsp";
	}
%>
<script type="text/javascript">
	alert("<%=msg%>");
	location.href="<%=url%>";
</script>