<%@page language="java" import= "java.util.*, java.awt.*, Model.*, SelectData.*"%>
<% 
session.setAttribute("login","");
User u=new User();
DAO userDAO= new DAO();
String na=request.getParameter("login");
u.setName(na);
u.setAge(20);
u.setEmail("abc@mail.com");
u.setId(1);
if(userDAO.checkLogin(u)){
response.sendRedirect("home.jsp");
session.setAttribute("login","ok");
session.setAttribute("user",userDAO.getUserName(na));
}
else{
response.sendRedirect("login.jsp");
}
%>