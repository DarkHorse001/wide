<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head lang="en">
		<meta charset="UTF-8">
		<title>注册</title>
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
		<meta name="format-detection" content="telephone=no">
		<meta name="renderer" content="webkit">
		<meta http-equiv="Cache-Control" content="no-siteapp" />

		<link rel="stylesheet" href="AmazeUI-2.4.2/assets/css/amazeui.min.css" />
		<link href="css/dlstyle.css" rel="stylesheet" type="text/css">
		<script src="AmazeUI-2.4.2/assets/js/jquery.min.js"></script>
		<script src="AmazeUI-2.4.2/assets/js/amazeui.min.js"></script>
		
		<style type="text/css">
			.am-icon-code-fork{
				margin-top: 10px;
			}
			.am-icon-lock{
			margin-top: 10px;
			}
			.reg_fail{
				color:red;
				font-size: 8px;
				margin:10px auto;
				height:13px;
			}
			form input{
				height:35px;
			}
			form label{
			height:33px;
			}
			#have{
			color:blue;
			}
		</style>
	<script type="text/javascript">
		function check(){
			var phone=document.getElementById("phone").value;
			var pwd=document.getElementById("password").value;
			var pwdRepeat=document.getElementById("passwordRepeat").value;
			var code=document.getElementById("code").value;
			if(phone==""){
				alert("手机号不能为空！");
				return false;
			}
			if(pwd==""){
				alert("密码不能为空！");
				return false;
			}
			if(pwdRepeat==""){
				alert("密码确认不能为空！");
				return false;
			}
			if(code==""){
				alert("验证码不能为空！");
				return false;
			}
			if(pwd!=pwdRepeat){
				alert("两次密码不一致")
				return false;
			}
		}
	
	</script>
	</head>

	<body>

		<div class="login-boxtitle">
			<a href="home/demo.html"><img alt="" src="images/logobig.png" /></a>
		</div>

		<div class="res-banner">
			<div class="res-main">
				<div class="login-banner-bg"><span></span><img src="images/big.jpg" /></div>
				<div class="login-box">

						<div class="am-tabs" id="doc-my-tabs">
							<ul class="am-tabs-nav am-nav am-nav-tabs am-nav-justify">
								
								<li><a href="">手机号注册</a></li>
							</ul>

							<div class="am-tabs-bd">
								

								<div class="am-tab-panel">
									<form action="reg.do" method="post" onsubmit="return check()">
                 <div class="user-phone">
								    <label for="phone"><i class="am-icon-mobile-phone am-icon-md"></i></label>
								    <input type="tel" name="phone" id="phone" placeholder="请输入手机号">
                 					<span class="reg_fail">${reg_fail_phone }</span>
                 </div>																			
										<div class="verification">
											<label for="code"><i class="am-icon-code-fork"></i></label>
											<input type="text" name="code" id="code" placeholder="请输入验证码">
											<a class="btn" href="javascript:void(0);" onclick="sendMobileCode();" id="sendMobileCode">
												<span id="dyMobileButton">获取</span></a>
												<span class="reg_fail">${reg_fail_code }</span>
										</div>
                 <div class="user-pass">
								    <label for="password"><i class="am-icon-lock"></i></label>
								    <input type="password" name="password" id="password" placeholder="设置密码">
								    <span class="reg_fail">${reg_fail_pwd }</span>
                 </div>										
                 <div class="user-pass">
								    <label for="passwordRepeat"><i class="am-icon-lock"></i></label>
								    <input type="password" name="passwordRepeat" id="passwordRepeat" placeholder="确认密码">
								    <span class="reg_fail">${reg_fail_haveEmpt }</span>
                 </div>	
									
								
										<div class="am-cf">
											<input type="submit" name="" value="注册" class="am-btn am-btn-primary am-btn-sm am-fl" >
										</div>
								
									
									</form>
									 <div class="login-links">
										<label for="reader-me">
											<input id="reader-me" type="checkbox"> 点击表示您同意商城<a href="#">《服务协议》</a>
										</label>
										<p>已有账号？<a id="have" href="toLogin.do" >登录</a></p>
							  	</div>
							  	<hr>
								</div>

								<script>
									$(function() {
									    $('#doc-my-tabs').tabs();
									  })
								</script>

							</div>
						</div>

				</div>
			</div>
			
				<div class="footer ">
						<div class="footer-hd ">
							<p>
								<a href="# ">广淘</a>
								<b>|</b>
								<a href="toHome.do ">商城首页</a>
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