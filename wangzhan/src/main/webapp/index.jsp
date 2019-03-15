<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>森-登录</title>
    <link rel="stylesheet" type="text/css" href="/wangzhan/css/login2.css" />
</head>
<body>
    <div id="id01" class="modal">
  
          <div class="imgcontainer">
            <img src="https://static.runoob.com/images/mix/img_avatar.png" alt="Avatar" class="avatar">
          </div>
      
          <div class="container">
            <label><b>用户名:</b></label>
            <input type="text" placeholder="请输入用户名" id="name" required>
          </div>
          <div>
            <label><b>密&nbsp;&nbsp;&nbsp;码:</b></label>
            <input type="password" placeholder="请输入密码" id="pass" required>
          </div>
          <div>
            <label><b>验证码:</b></label>
            <input type="text" placeholder="验证码" id="name22" required>
            <span id="name33" ></span>
          </div>
          <div>
            <button type="submit" id="login">登陆</button>
            <a href="/wangzhan/html/register1.html"><button type="submit" id="register">注册</button></a>
          </div>
    </div>
</body>
<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<script src="/wangzhan/js/login2.js" type="text/javascript"></script>
</html>
