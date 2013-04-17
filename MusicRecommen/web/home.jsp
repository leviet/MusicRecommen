<%@page import="Interface.ConnectionDB"%>
<%@page language="java" import= "java.util.*, java.awt.*, Model.*, SelectData.*"%>
<%
       boolean passed= "ok".equals(session.getAttribute("login"));
       if (!passed) response.sendRedirect("login.jsp");
%>
<%
	User user=(User)session.getAttribute("user");
%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="cs" lang="cs" >
<head>

  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>He Thong Tu Van Am Nhac V1.0</title>
  
  <!-- Free google font -->
  <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,300,600' rel='stylesheet' type='text/css' />
  <link href="css/form-style.css" rel="stylesheet" type="text/css" />
   <link href="style.css" rel="stylesheet" type="text/css" />
  <script src="js/jquery.js"></script>
  
  <!-- CSS code for IE Browser -->
  <!--[if lt IE 10]>
    <link href="css/form-style-ie.css" rel="stylesheet" type="text/css" />  
  <![endif]-->
  
  </head>
<% ConnectionDB doc=new docData();
ArrayList<Type> listtype=doc.getListType();
%>
<body>
<div id="list-type">
<%for(int i=0;i<listtype.size();i++){%>
	<div class="type" align="center">
		<a href="type.jsp?idtype=<%=listtype.get(i).getId()%>"><img src="icontype/<%=i%>.ico" width="100"/></a><br/>
		<a href="type.jsp?idtype=<%=listtype.get(i).getId()%>"><span class="name-type"><%=listtype.get(i).getName()%></span></a>
	</div>
<%}%>
</div>
</body>
</html>