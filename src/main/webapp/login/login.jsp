<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head lang="en">
		<meta charset="UTF-8">
		<title>登录</title>
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
		<meta name="format-detection" content="telephone=no">
		<meta name="renderer" content="webkit">
		<meta http-equiv="Cache-Control" content="no-siteapp" />

		<link rel="stylesheet" href="AmazeUI-2.4.2/assets/css/amazeui.css" />
		<link href="css/dlstyle.css" rel="stylesheet" type="text/css">
		<style type="text/css">
			.am-icon-user,.am-icon-lock{
				margin-top:8px;
			}
			
			#user,#password{
				margin-top:5px;
				border: 1px solid black;
			}
			form label{
				height: 0px;
				top:10px;
			}
			.user-name{
				margin-bottom: 10px;
			}
			#tr{
				text-decoration: underline;
				    background: #f8f8f8;
				    color: blue;
			}
			
			.user-name,.user-pass{
				margin-bottom: 20px;
			}
			.login_fail{
				color:red;
				font-size: 8px;
				margin:10px auto;
				height:13px;
			}
			
		</style>
		<script type="text/javascript">
		function fn(){
			var user=document.getElementById("user").value;
			var pwd=document.getElementById("password").value;
			if(user==""){
				alert("账号不能为空！");
				return false;
			}
			if(pwd==""){
				alert("密码不能为空！");
				return false;
			}
			
		}
		
		</script>
	</head>

	<body>

		<div class="login-boxtitle">
			<a href="home.html"><img alt="logo" src="images/logobig.png" /></a>
		</div>

		<div class="login-banner">
			<div class="login-main">
				<div class="login-banner-bg"><span></span><img src="images/big.jpg" /></div>
				<div class="login-box">

							<h3 class="title">登录商城</h3>

							<div class="clear"></div>
						
						<div class="login-form">
						  <form action="login.do" method="post" onsubmit="fn()">
							   <div class="user-name">
								    <label for="user"><i class="am-icon-user"></i></label>
								    <input type="text" name="user" id="user" placeholder="手机/用户名">
								    <span class="login_fail">${login_fail_noUser }</span>
                 </div>
                 <div class="user-pass">
								    <label for="password"><i class="am-icon-lock"></i></label>
								    <input type="password" name="password" id="password" placeholder="请输入密码">
								    <span class="login_fail">${login_fail_pwdError }</span>
                 </div>
                 <div class="am-cf">
									<input type="submit" name="" value="登 录" class="am-btn am-btn-primary am-btn-sm">
				 </div>
              </form>
           </div>
            
            <div class="login-links">
                <label for="remember-me"><input id="remember-me" type="checkbox">记住密码</label>
								<a href="#" class="am-fr">忘记密码</a>
								<a href="toReg.do" class="zcnext am-fr am-btn-default"  id="tr">注 册</a>
								<br />
            </div>
						<div class="partner">		
								<h3>合作账号</h3>
							<div class="am-btn-group">
								<li><a href="#"><i class="am-icon-qq am-icon-sm"></i><span>QQ登录</span></a></li>
								<li><a href="#"><i class="am-icon-weibo am-icon-sm"></i><span>微博登录</span> </a></li>
								<li><a href="#"><i class="am-icon-weixin am-icon-sm"></i><span>微信登录</span> </a></li>
							</div>
						</div>	

				</div>
			</div>
		</div>


					<div class="footer ">
						<div class="footer-hd ">
							<p>
								<a href="# ">广淘</a>
								<b>|</b>
								<a href="# ">商城首页</a>
								<b>|</b>
								<a href="# ">支付宝</a>
								<b>|</b>
								<a href="# ">物流</a>
							</p>
						</div>
						<div class="footer-bd ">
							<p>
								<a href="# ">备用一</a>
								<a href="# ">合作伙伴</a>
								<a href="# ">联系我们</a>
								<a href="# ">网站地图</a>
								<em>© </em>
							</p>
						</div>
					</div>
	</body>

</html>