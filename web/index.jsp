<%--
  Created by IntelliJ IDEA.
  User: Danuja Fernando
  Date: 8/25/2020
  Time: 2:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Add New</title>
  <style>
    ul {
      list-style-type: none;
      margin: 0;
      padding: 0;
      overflow: hidden;
      background-color: #333;
    }

    li {
      float: left;
    }

    li a {
      display: block;
      color: white;
      text-align: center;
      padding: 14px 16px;
      text-decoration: none;
    }

    li a:hover {
      background-color: #111;
    }
    .AddItem{
      text-align: center;

    }
    form{
      padding: 10px 10px;
    }
  </style>
</head>
<body>

<ul>
  <li><a class="active" href="AllPost">Home</a></li>
</ul>
<div class="AddItem">
  <h1>Add New</h1>
<%--  Insert is the servlet that handle the insert data operation --%>
<%--    src/servlet/Insert is the location --%>
<%--  we send data in post method --%>
  <form action="Insert" method="post">
    Name: <br>
    <input type="text" class="input" name="name" style="width: 200px"><br>
    School: <br>
    <input type="text" class="input" name="school" style="width: 200px"><br>
    Age: <br>
    <input type="number" name="age" style="width: 200px"><br>
    <input type="submit" class="btn" value="Submit">
  </form>
</div>

</body>
</html>
