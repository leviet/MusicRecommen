<%@page import="Interface.ConnectionDB"%>
?<%@page language="java" import= "java.util.*, java.awt.*, Model.*, SelectData.*"%>
<%
    boolean passed = "ok".equals(session.getAttribute("login"));
    if (!passed) {
        response.sendRedirect("login.jsp");
    }
%>
<%
    String sType_id = request.getParameter("idtype");
    int typeid;
    try {
        typeid = Integer.parseInt(sType_id);
    } catch (Exception e) {
        typeid = -1;
    }
    User user = (User) session.getAttribute("user");
%>
<% ConnectionDB doc = new docData();
    ArrayList<Song> listsong = doc.getListSongType(typeid);
    kNN dd = new kNN();
%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="cs" lang="cs" >
    <head>

        <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
        <title>He Thong Tu Van Am Nhac V1.0</title>

        <!-- Free google font -->
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,300,600' rel='stylesheet' type='text/css' />
        <link href="css/form-style.css" rel="stylesheet" type="text/css" />
        <link href="style.css" rel="stylesheet" type="text/css" />
        <script src="http://code.jquery.com/jquery-latest.js"></script>
        <script src="js/jquery.js"></script>
        <script>
		 
            $(function() {

                $(".like").click(function(el,ev){
                    songid=$(this).attr("id");
                    tid=<%=typeid%>
                    var url="like.jsp?song="+songid;
                    self.location = url;
                });
            });
        </script>
        <!-- CSS code for IE Browser -->
        <!--[if lt IE 10]>
          <link href="css/form-style-ie.css" rel="stylesheet" type="text/css" />  
        <![endif]-->

    </head>

    <body>
        <div id="main-song">
            <ul class="list-song">
                <%for (int i = 0; i < listsong.size(); i++) {%>
                <li class="song" id="<%=listsong.get(i).getId()%>">
                    <div class="song-name"><a href="listen.jsp?idsong=<%=listsong.get(i).getId()%>"><%=listsong.get(i).getName()%></a></div>
                    <div class="singer"><%=doc.getNameSinger(listsong.get(i).getSingerid())%></div>
                    <div class="num"><%=listsong.get(i).getViewed()%></div>
                    <div class="user-post"><%=listsong.get(i).getPoster()%></div>
                    <div class="like" id="<%=listsong.get(i).getId()%>"><%if (dd.checklike(user, listsong.get(i))) {
                                        out.print("<img src='/MusicRecommen/images/like.jpg' width='50'/ >");
                                    }%></div>
                    <div class="clear"></div>
                </li>
                <%}%>
            </ul>
        </div>
    </body>
</html>