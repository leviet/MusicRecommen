<%@page language="java" import= "java.util.*, java.awt.*, Model.*, SelectData.*,Interface.*"%>
<%
    boolean passed = "ok".equals(session.getAttribute("login"));
    if (!passed) {
        response.sendRedirect("login.jsp");
    }
%>
<%
    String sSong_id = request.getParameter("idsong");
    int songid;
    try {
        songid = Integer.parseInt(sSong_id);
    } catch (Exception e) {
        songid = -1;
    }
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
        <script>
		 
            $(function() {

                $(".like").click(function(el,ev){
                    songid=$(this).attr("id");
                    var url="like2.jsp?song="+songid;
                    self.location = url;
                });
            });
        </script>
        <!-- CSS code for IE Browser -->
        <!--[if lt IE 10]>
          <link href="css/form-style-ie.css" rel="stylesheet" type="text/css" />  
        <![endif]-->

    </head>
    <% ConnectionDB doc = new docData();
        Song so = doc.getSong(songid);
        User user = (User) session.getAttribute("user");
        ConnectionDB ghi = new ghiData();
    %>
    <body>
        <div id="main-song">
            <div class="listen" align="center">
                <object width="700" height="100">  <param name="movie" value="http://www.nhaccuatui.com/m/<%=so.getCode()%>" />  <param name="quality" value="high" />  <param name="wmode" value="transparent" />  <param name="allowscriptaccess" value="always" />  <param name="flashvars" value="autostart=true" />  <embed src="http://www.nhaccuatui.com/m/<%=so.getCode()%>" flashvars="target=blank&autostart=true" allowscriptaccess="always" quality="high" wmode="transparent" type="application/x-shockwave-flash" width="700" height="100"></embed></object>
            </div>
            <h2 class="tieude">Lời bài hát</h2>
            <p class="tieude"><%=new getLyric().getLyric(so.getName(), doc.getNameSinger(so.getSingerid()))%></p>
            <%
                ArrayList<Vote> liVote = doc.getListVote();
                boolean add = true;
                for (Vote vo : liVote) {
                    if (vo.getUser() == user.getId() && vo.getSong() == so.getId()) {
                        add = false;
                    }
                }
                if (add) {
                    Vote v = new Vote(1, 1, user.getId(), so.getId());
                    ghi.vote(v);
                }
                kNN dd = new kNN();
                ArrayList<Song> listsong = dd.tinh(user);
                ArrayList<Song> li = dd.getLiSongType(so);
            %>
            <h2 class="tieude">Bài hát dự đoán theo KNN</h2>
            <ul class="list-song">
                <%for (int i = 0; i < listsong.size(); i++) {%>
                <li class="song">
                    <div class="song-name"><a href="listen.jsp?idsong=<%=listsong.get(i).getId()%>"><%=listsong.get(i).getName()%></a></div>
                    <div class="singer"><%=doc.getNameSinger(listsong.get(i).getSingerid())%></div>
                    <div class="num"><%=listsong.get(i).getViewed()%></div>
                    <div class="user-post"><%=listsong.get(i).getPoster()%></div>
                    <div class="like"><%if (dd.checklike(user, listsong.get(i))) {
                                        out.print("<img src='/MusicRecommen/images/like.jpg' width='50'/>");
                                    }%></div>
                    <div class="clear"></div>
                </li>
                <%}%>
            </ul>
            <h2 class="tieude">Bài hát dự đoán theo cộng đồng đa tiêu chí</h2>
            <ul class="list-song">
                <%for (int i = 0; i < li.size(); i++) {%>
                <li class="song" id="<%=li.get(i).getId()%>">
                    <div class="song-name"><a href="listen.jsp?idsong=<%=li.get(i).getId()%>"><%=li.get(i).getName()%></a></div>
                    <div class="singer"><%=doc.getNameSinger(li.get(i).getSingerid())%></div>
                    <div class="num"><%=li.get(i).getViewed()%></div>

                    <div class="like"><%if (dd.checklike(user, listsong.get(i))) {
                                        out.print("<img src='/MusicRecommen/images/like.jpg' width='50'/>");
                                    }%></div>
                    <div class="clear"></div>
                </li>
                <%}%>
            </ul>
        </div>

    </body>
</html>