
<%@ page pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

		<title>首页</title>

		<link href="AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css" />
		<link href="AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css" />

		<link href="basic/css/demo.css" rel="stylesheet" type="text/css" />

		<link href="css/hmstyle.css" rel="stylesheet" type="text/css" />
		<script src="AmazeUI-2.4.2/assets/js/jquery.min.js"></script>
		<script src="AmazeUI-2.4.2/assets/js/amazeui.min.js"></script>

	</head>
	
		<body>
		<div class="hmtop">
		
			<%@ include file="header.jsp" %>
			
			</div>
			
			<div class="banner">
                      <!--轮播 -->
						<div class="am-slider am-slider-default scoll" data-am-flexslider id="demo-slider-0">
							<ul class="am-slides">
								<li class="banner1"><a href="introduction.html"><img src="${pageContext.request.contextPath}/images/111.jpg" /></a></li>
								<li class="banner2"><a><img src="${pageContext.request.contextPath}/images/222.jpg" /></a></li>
								<li class="banner3"><a><img src="${pageContext.request.contextPath}/images/333.jpg" /></a></li>
								<li class="banner4"><a><img src="${pageContext.request.contextPath}/images/666.jpg" /></a></li>
							</ul>
						</div>
						<div class="clear"></div>	
			</div>						
			
			<div class="shopNav">
				<div class="slideall">
			        
					   <div class="long-title"><span class="all-goods">全部分类</span></div>
					   <div class="nav-cont">
							<ul>
								<li class="index"><a href="#">首页</a></li>
                                <li class="qc"><a href="#">闪购</a></li>
                                <li class="qc"><a href="#">限时抢</a></li>
                                <li class="qc"><a href="#">团购</a></li>
							</ul>
						    
						</div>
		        				
						<!--侧边导航 -->
						<div id="nav" class="navfull">
							<div class="area clearfix">
								<div class="category-content" id="guide_2">
									
									<div class="category">
										<ul class="category-list" id="js_climit_li">
										<c:forEach items="${directorys}" var="u" varStatus="s">
											<li class="appliance js_toggle relative first">
												<div class="category-info">
													<h3 class="category-name b-category-name"><a class="ml-22" title="${u.dname }">${u.dname }</a></h3>
													<em>&gt;</em></div>
												<div class="menu-item menu-in top">
													
													<div class="area-in">
														<div class="area-bg">
															<div class="menu-srot">
																<div class="sort-side">
																	<dl class="dl-sort">
																		<dt><span title="${u.dname }">${u.dname }</span></dt>
																		<dd><a title="衬衫" href="#"><span>衬衫</span></a></dd>
																	</dl>
																</div>
																<div class="sort-side">
																	<dl class="dl-sort">
																		<dt><span title="${u.dname }">${u.dname }</span></dt>
																		<dd><a title="连衣裙" href="#"><span>连衣裙</span></a></dd>
																	</dl>
																</div>
															</div>
														</div>
													</div>
													
												</div>
											<b class="arrow"></b>	
											</li>
											</c:forEach>
										</ul>
									</div>
								</div>
							</div>
						</div>
						<!--轮播 -->
						<script type="text/javascript">
							(function() {
								$('.am-slider').flexslider();
							});
							$(document).ready(function() {
								$("li").hover(function() {
									$(".category-content .category-list li.first .menu-in").css("display", "none");
									$(".category-content .category-list li.first").removeClass("hover");
									$(this).addClass("hover");
									$(this).children("div.menu-in").css("display", "block")
								}, function() {
									$(this).removeClass("hover")
									$(this).children("div.menu-in").css("display", "none")
								});
							})
						</script>


					<!--小导航 -->
					<div class="am-g am-g-fixed smallnav">
						<div class="am-u-sm-3">
							<a href="sort.html"><img src="../images/navsmall.jpg" />
								<div class="title">商品分类</div>
							</a>
						</div>
						<div class="am-u-sm-3">
							<a href="#"><img src="../images/huismall.jpg" />
								<div class="title">大聚惠</div>
							</a>
						</div>
						<div class="am-u-sm-3">
							<a href="#"><img src="../images/mansmall.jpg" />
								<div class="title">个人中心</div>
							</a>
						</div>
						<div class="am-u-sm-3">
							<a href="#"><img src="../images/moneysmall.jpg" />
								<div class="title">投资理财</div>
							</a>
						</div>
					</div>

					<!--走马灯 -->
					
					<div class="clear"></div>
				</div>
				<script type="text/javascript">
					if ($(window).width() < 640) {
						function autoScroll(obj) {
							$(obj).find("ul").animate({
								marginTop: "-39px"
							}, 500, function() {
								$(this).css({
									marginTop: "0px"
								}).find("li:first").appendTo(this);
							})
						}
						$(function() {
							setInterval('autoScroll(".demo")', 3000);
						})
					}
				</script>
			</div>
			<div class="shopMainbg">
				<div class="shopMain" id="shopmain">

					<div class="clear "></div>


					<div class="am-container ">
						<div class="shopTitle ">
							<h4>服装</h4>
						</div>
					</div>
					<div class="am-g am-g-fixed flood method3 ">
						<ul class="am-thumbnails ">
							<li>
								<div class="list ">
									<a href="# ">
										<img src="${pageContext.request.contextPath}/images/cp.jpg " />
										<div class="pro-title ">萨拉米 1+1小鸡腿</div>
										<span class="e-price ">￥29.90</span>
									</a>
								</div>
							</li>
							<li>
								<div class="list ">
									<a href="# ">
										<img src="${pageContext.request.contextPath}/images/cp2.jpg " />
										<div class="pro-title ">ZEK 原味海苔</div>
										<span class="e-price ">￥8.90</span>
									</a>
								</div>
							</li>
							<li>
								<div class="list ">
									<a href="# ">
										<img src="${pageContext.request.contextPath}/images/cp.jpg " />
										<div class="pro-title ">萨拉米 1+1小鸡腿</div>
										<span class="e-price ">￥29.90</span>
									</a>
								</div>
							</li>
							
						</ul>
					</div>
					
					<div class="am-container ">
						<div class="shopTitle ">
							<h4>办公用品</h4>
						</div>
					</div>
					<div class="am-g am-g-fixed flood method3 ">
						<ul class="am-thumbnails ">
							<li>
								<div class="list ">
									<a href="# ">
										<img src="${pageContext.request.contextPath}/images/cp.jpg " />
										<div class="pro-title ">萨拉米 1+1小鸡腿</div>
										<span class="e-price ">￥29.90</span>
									</a>
								</div>
							</li>
							<li>
								<div class="list ">
									<a href="# ">
										<img src="${pageContext.request.contextPath}/images/cp2.jpg " />
										<div class="pro-title ">ZEK 原味海苔</div>
										<span class="e-price ">￥8.90</span>
									</a>
								</div>
							</li>
							<li>
								<div class="list ">
									<a href="# ">
										<img src="${pageContext.request.contextPath}/images/cp.jpg " />
										<div class="pro-title ">萨拉米 1+1小鸡腿</div>
										<span class="e-price ">￥29.90</span>
									</a>
								</div>
							</li>
							
						</ul>
					</div>
					
					<div class="am-container ">
						<div class="shopTitle ">
							<h4>食品</h4>
						</div>
					</div>
					<div class="am-g am-g-fixed flood method3 ">
						<ul class="am-thumbnails ">
							<li>
								<div class="list ">
									<a href="# ">
										<img src="${pageContext.request.contextPath}/images/cp.jpg " />
										<div class="pro-title ">萨拉米 1+1小鸡腿</div>
										<span class="e-price ">￥29.90</span>
									</a>
								</div>
							</li>
							<li>
								<div class="list ">
									<a href="# ">
										<img src="${pageContext.request.contextPath}/images/cp2.jpg " />
										<div class="pro-title ">ZEK 原味海苔</div>
										<span class="e-price ">￥8.90</span>
									</a>
								</div>
							</li>
							<li>
								<div class="list ">
									<a href="# ">
										<img src="${pageContext.request.contextPath}/images/cp.jpg " />
										<div class="pro-title ">萨拉米 1+1小鸡腿</div>
										<span class="e-price ">￥29.90</span>
									</a>
								</div>
							</li>
							
						</ul>
					</div>
					
					<div class="am-container ">
						<div class="shopTitle ">
							<h4>电子产品</h4>
						</div>
					</div>
					<div class="am-g am-g-fixed flood method3 ">
						<ul class="am-thumbnails ">
							<li>
								<div class="list ">
									<a href="# ">
										<img src="${pageContext.request.contextPath}/images/cp.jpg " />
										<div class="pro-title ">萨拉米 1+1小鸡腿</div>
										<span class="e-price ">￥29.90</span>
									</a>
								</div>
							</li>
							<li>
								<div class="list ">
									<a href="# ">
										<img src="${pageContext.request.contextPath}/images/cp2.jpg " />
										<div class="pro-title ">ZEK 原味海苔</div>
										<span class="e-price ">￥8.90</span>
									</a>
								</div>
							</li>
							<li>
								<div class="list ">
									<a href="# ">
										<img src="${pageContext.request.contextPath}/images/cp.jpg " />
										<div class="pro-title ">萨拉米 1+1小鸡腿</div>
										<span class="e-price ">￥29.90</span>
									</a>
								</div>
							</li>
							
						</ul>
					</div>
					
					<div class="am-container ">
						<div class="shopTitle ">
							<h4>汽车用品</h4>
						</div>
					</div>
					<div class="am-g am-g-fixed flood method3 ">
						<ul class="am-thumbnails ">
							<li>
								<div class="list ">
									<a href="# ">
										<img src="${pageContext.request.contextPath}/images/cp.jpg " />
										<div class="pro-title ">萨拉米 1+1小鸡腿</div>
										<span class="e-price ">￥29.90</span>
									</a>
								</div>
							</li>
							<li>
								<div class="list ">
									<a href="# ">
										<img src="${pageContext.request.contextPath}/images/cp2.jpg " />
										<div class="pro-title ">ZEK 原味海苔</div>
										<span class="e-price ">￥8.90</span>
									</a>
								</div>
							</li>
							<li>
								<div class="list ">
									<a href="# ">
										<img src="${pageContext.request.contextPath}/images/cp.jpg " />
										<div class="pro-title ">萨拉米 1+1小鸡腿</div>
										<span class="e-price ">￥29.90</span>
									</a>
								</div>
							</li>
							
						</ul>
					</div>

				<%@ include file="footer.jsp" %>
				</div>
			</div>
		</div>
		</div>
		<!--引导 -->

		<div class="navCir">
			<li class="active"><a href="home3.html"><i class="am-icon-home "></i>首页</a></li>
			<li><a href="sort.html"><i class="am-icon-list"></i>分类</a></li>
			<li><a href="shopcart.html"><i class="am-icon-shopping-basket"></i>购物车</a></li>	
			<li><a href="${pageContext.request.contextPath}/person/index.html"><i class="am-icon-user"></i>我的</a></li>					
		</div>
		<!--菜单 -->
		<div class=tip>
			
		</div>
		<script>
			window.jQuery || document.write('<script src="basic/js/jquery.min.js "><\/script>');
		</script>
		<script type="text/javascript " src="${pageContext.request.contextPath}/basic/js/quick_links.js "></script>
	</body>

</html>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	