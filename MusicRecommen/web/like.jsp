<%@page import="Interface.ConnectionDB"%>
<%@page language="java" import= "java.util.*, java.awt.*, Model.*, SelectData.*"%>
<%
    User user = (User) session.getAttribute("user");
    String sSong_id = request.getParameter("song");

    int songid;
    try {
        songid = Integer.parseInt(sSong_id);
    } catch (Exception e) {
        songid = -1;
    }
    ConnectionDB ghi = new ghiData();
    ConnectionDB doc = new docData();
    Song so = doc.getSong(songid);
    Vote vo = new Vote(1, 100, user.getId(), songid);
    ghi.vote(vo);
    response.sendRedirect("type.jsp?idtype=" + so.getTypeid());
%>