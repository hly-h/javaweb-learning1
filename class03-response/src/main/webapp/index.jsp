<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>响应不同类型的资源文件</title>
  <style>
    ul li{
      list-style: none;
      float: left;
      margin-top: 40px;
    }

    ul li a {
      padding: 20px 50px;
      height: 40px;
      background-color: #adedad;
      color: #fff;
      box-sizing: border-box;
      margin-right: 10px;
      font-size: 16px;
      text-decoration: none;
    }

    ul li a:hover{
      background-color: mistyrose;
    }

  </style>
</head>
<body>
<h1><%= "设置 Content-Type 不同类型的资源" %></h1>
<h2><%= "根据不同的参数类型返回不同的资源" %></h2>
<br/>
<%--<a href="hello-servlet">Hello Servlet</a>--%>
<ul>
  <li>
    <a href="responseType?type=img">返回图片</a>
  </li>
  <li>
    <a href="responseType?type=html">返回html</a>
  </li>
  <li>
    <a href="responseType?type=pdf">返回pdf</a>
  </li>
  <li>
    <a href="responseType?type=txt">返回txt</a>
  </li>
</ul>
</body>
</html>