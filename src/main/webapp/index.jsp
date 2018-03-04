<%@ page import="controllers.ContentDAO" %>
<%@ page import="java.util.ArrayList" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Personal Diary</title>
</head>
<body>
<%
    String user = (String)request.getSession().getAttribute("login");
    if (user != null) {
        %>
<a href="/logout">Log out</a>
<form action="/home" method="post">
    Text:<input type="text" name="text"><br>
    <input type="submit" value="post">
</form>
    <%
        ArrayList<String> content = ContentDAO.getRecords(user);
        if (content != null) {
            for (int i = 0; i < content.size(); i++) {
                %> <p> <%
                out.println(content.get(i));
                %>
                </p>
                <hr>
                    <%
            }
        }
    } else {
        %>
        <a href="/login">Log in</a>
        <a href="/register">Register</a>
        <%
    }
%>

</body>
</html>
