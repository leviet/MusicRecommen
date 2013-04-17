<%
       boolean passed= "ok".equals(session.getAttribute("login"));
       if (passed) response.sendRedirect("home.jsp");
	   else response.sendRedirect("login.jsp");
%>
