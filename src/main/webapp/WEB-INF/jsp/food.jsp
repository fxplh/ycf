<%--
Created by IntelliJ IDEA.
User: Administrator
Date: 2019/5/12
Time: 12:24
To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>番茄牛腩的做法【步骤图】_菜谱_美食杰</title>
		<meta name="keywords" content="番茄牛腩的做法,番茄牛腩," />
		<meta name="description" content="番茄牛腩的做法 " />
		<meta content="www.ycf.net" name="author" />
		<script>
			var _hmt = _hmt || [];
		</script>
		<link rel="stylesheet" type="text/css" media="all" href="../../css/ss_base.css?v=1517"/>
		<link rel="stylesheet" type="text/css" media="all" href="../../css/main.css?v=1040"/>
		<link rel="stylesheet" type="text/css" media="all" href="../../css/list.css?v=123"/>
		<link rel="stylesheet" type="text/css" media="all" href="../../css/content.css?v=123" />
		<link rel="stylesheet" type="text/css" media="all" href="../../css/tipswindown.css" />
		<link rel="stylesheet" type="text/css" media="all" href="../../css/swiper.min.css" />
		<script type="text/javascript" src="../../js/j.m.js"></script>
		<script type="text/javascript" src="../../js/list.js?v=1108"></script>
		<script type="text/javascript" src="../../js/main.js?v=1515"></script>
		<script type="text/javascript" src="/js/jquery-1.8.0.min.js"></script>
		<script type="text/javascript" src="/js/lazyload.js"></script>
		<script type="text/javascript" src="/js/tipswindown.js"></script>
		<script type="text/javascript" src="/js/swiper.min.js"></script>
		<script type="text/javascript" src="/js/search.js?v=123"></script>
	</head>

	<body style="">
	<div class="header">
		<div class="header_c">
			<a href="#"  class="logo pngFix"><img style="height:129px" src="/images/log.jpg"/></a>
			<div class="main_search_top_w">
				<div class="suggestionsBox" id="suggestions" style="display:none;">
					<ul class="suggestionList" id="autoSuggestionsList"></ul>
				</div>
				<form id="form1" class="search" action="/food/wyGetBySearch" onsubmit="return searchFunction()">
					<input style="height:36px;width:345px" type="text" class="text" name="q" defaultval="请输入菜谱/食材"
						   x-webkit-speech="" value="请输入菜谱/食材" autocomplete="off"
						   onfocus="if(this.value=='请输入菜谱/食材'){this.value='';}$(this).css('color','#333');"
						   onblur="if(this.value==''){this.value='请输入菜谱/食材';$(this).css('color','#999');}"
						   name="inputString" style="color: rgb(153, 153, 153);">
					<input type="submit" class="submit" value="搜 索">
				</form>
			</div>
		</div>
	</div>
		<div class="nav">
			<ul id="main_nav" style="width:500px">
				<c:if test="${rand eq 'no'}">
					<li class="hasmore current">
				</c:if>
				<c:if test="${rand eq 'yes'}">
					<li class="hasmore">
				</c:if>
        <a href="/foodRecommend/getFoodRe" class="link pngFix"><strong>首页</strong></a></li>
        <li class="hasmore">
            <a href="/foodClass/foodList?id=10001" class="link pngFix"><strong>菜谱大全</strong></a>
        </li>
			<c:if test="${rand eq 'no'}">
			<li class="hasmore">
				</c:if>
				<c:if test="${rand eq 'yes'}">
			<li class="hasmore current">
				</c:if>
            <a href="/food/wyRandFood" class="link pngFix"><strong>随机菜谱</strong></a>
        </li>
        <li>
            <a href="/userLogin" class="link pngFix"><strong>个人信息</strong></a>
        </li>
      </ul>
		</div>
	<div class="main_search main_search_slideUp pngFix" slideUp="1" style="_display:none;" id="main_search">
		<div class="main_search_w">
			<div class="searchform_div" style="width: 571px">
				<form id="form2" action="" target="_blank" onsubmit="return searchFunction1()">
					<input style="height: 49px;" type="text" class="text" name="q"
						   x-webkit-speech="" autocomplete="off"
						   name="inputString" placeholder="">
					<input type="submit" class="submit" value="搜 索">
				</form>
			</div>
			<span id="searchslideup_btn" class="pngFix" style="background-position:0px -48px;">自动收缩</span>
		</div>
	</div>
		<div class="bottom_back_top_top bottom_back_top_top_slideUp" id="bottom_back_top_top">
			<a href="#" title="返回顶部" class="backtotop pngFix">回到顶部</a>
		</div>
		<div class="main_w clearfix">
			<div class="main clearfix">
				<div class="bbtitles">
					<c:if test="${'true' eq noFood}">
						暂无菜品
					</c:if>
					<span class="paixu"></span>
				</div>
				<div class="cp_header clearfix">
					<div class="cp_headerimg_w"><img alt="${foodInfo.name}的做法" src="${foodInfo.photo}" /></div>
					<div class="cp_main_info_w">
						<div class="info1">
							<h1 class="title"><a id="tongji_title" title="${foodInfo.name}的做法" href="">${foodInfo.name}</a></h1>
							<div class="ewmbox" id="ewmbox"></div>
							<span class="favbtns">
								<c:if test="${isCollect eq 'success'}">
									<a href="" title="${foodInfo.name}的做法" class="addToFav_con" id="addToFav_con">已收藏</c:if>
										<c:if test="${isCollect ne 'success'}"><a href="javascript:void(0);" onclick="shouCan('${foodInfo.id}')" title="${foodInfo.name}的做法" class="addToFav_con" id="addToFav_con">收藏</c:if><span id="f_num"></span></a>
							</span>
							<dl class="yj_tags clearfix">
								<c:forEach items="${tags}" var="tag" varStatus="status">
									<dt><a id="tongji_gx_${status.index}" href="javascript:;">${tag}</a></dt>
								</c:forEach>
							</dl>
						</div>
						<div class="cp_body_left">
							<div class="materials">
							<p><strong>“</strong>${foodInfo.name}<strong>”</strong></p>
							<strong class="cpc_h2">用料</strong>
							<div class="materials_box">
								<div class="yl zl clearfix">
									<h3><a href="javascript:;" title="${foodInfo.name}的主料">主料</a></h3>
									<ul class="clearfix">
										<c:forEach items="${ingredients}" var="ingredient" varStatus="status">
											<c:if test="${status.index % 2 eq 0}">
												<li class="">
											</c:if>
											<c:if test="${status.index % 2 ne 0}">
												<li class="br0">
											</c:if>
												<div class="c">
													<h4><a target="_blank" href="">${ingredient.key}</a><span>${ingredient.value}</span></h4>
												</div>
											</li>
										</c:forEach>
									</ul>
								</div>
								<div class="yl fuliao clearfix">
									<h3><a href="javascript:;" title="${foodInfo.name}的辅料">辅料</a></h3>
									<ul class="clearfix">
										<c:forEach items="${burden}" var="bur" varStatus="status">
											<c:if test="${status.index % 2 eq 0}">
												<li class="">
											</c:if>
											<c:if test="${status.index % 2 ne 0}">
												<li class="br0">
											</c:if>
											<h4><a target="_blank" href="">${bur.key}</a></h4><span>${bur.value}</span>
											</li>
										</c:forEach>
									</ul>
								</div>
							</div>
						</div>
						</div>
					</div>
				</div>
				<div class="cp_body clearfix">
					<div class="cp_body_left">
						<div class="measure">
							<h2 class="cpc_h2">${foodInfo.name}的做法</h2>
							<div class="editnew edit">
								<c:forEach items="${foodStepList}" var="foodStep">
									<div class="content clearfix">
										<em class="step" id="step_num${foodStep.index}">${foodStep.index}.</em>
										<div class="c">
											<p>${foodStep.link}</p>
											<p><img class="conimg" src="${foodStep.info}" alt=""></p>
										</div>
									</div>
								</c:forEach>
								<style>
									.swiper-container1 {
										margin: 20px 20px 20px 100px;
										width: 550px;
										height: 366px;
										overflow: hidden;
									}
									
									.swiper-container1 .swiper-slide {
										position: relative;
										overflow: hidden;
										background: #eee;
									}
									
									.swiper-container1 .swiper-slide img {
										display: block;
										width: 100%;
										position: absolute;
										left: 50%;
										top: 50%;
										transform: translate(-50%, -50%);
										-webkit-transform: translate(-50%, -50%);
									}
									
									.swiper-pagination-bullet {
										opacity: .5;
										background: #fff;
									}
									
									.swiper-pagination-bullet-active {
										opacity: 1;
										background: #f42e2b;
									}
								</style>
							</div>
						</div>
					</div>
					<div class="cp_body_right" style="background-color: #fff;">
						
						<style>
							
							
							.iphonestyle_new .imgsetw {
								width: 300px;
								height: 569px;
								position: relative;
							}
							
							.iphonestyle_new .imgsetw .mask {
								width: 300px;
								height: 569px;
								position: absolute;
								left: 0px;
								top: 0px;
								background: url(/images/shouji.png) center no-repeat;
								z-index: 10;
							}
							
							.iphonestyle_new .imgsetw .imgw {
								width: 248px;
								height: 537px;
								margin: 0px 26px 0px;
								overflow: hidden;
								position: relative;
								top: 16px;
							}
							
							.iphonestyle_new .imgsetw .imgw .imgs {
								width: 744px;
								height: 537px;
								transition: all ease 0.3s;
								font-size: 0px;
							}
							
							.iphonestyle_new .imgsetw .imgw1 .imgs {
								margin-left: 0px;
							}
							
							.iphonestyle_new .imgsetw .imgw2 .imgs {
								margin-left: -248px;
							}
							
							.iphonestyle_new .imgsetw .imgw3 .imgs {
								margin-left: -496px;
							}
							
							.iphonestyle_new .imgsetw .imgw .img {
								display: inline-block;
								vertical-align: top;
								height: 537px;
								width: 248px;
							}
							
							.side_qrcode {
								background: url(/images/erweima.png) center no-repeat;
								width: 120px;
								height: 193px;
								position: fixed;
								left: 50%;
								margin-left: 515px;
								bottom: 100px;
							}
						</style>

						<div class="side_qrcode"></div>

						<div class="iphonestyle_new" id="iphonestyle_new">

							<div class="imgsetw">

								<div class="imgw imgw1">
									<div class="imgs">
										<img src="/images/iphone1.png" class="img" />
										<img src="/images/iphone2.png" class="img" />
										<img src="/images/iphone3.png" class="img" />
									</div>
								</div>
								<div class="mask"></div>

							</div>

						</div>

						<script>
							$(function() {
								var sti_iphonestyle_new = setInterval(function() {
									var _ele = $("#iphonestyle_new .imgw");
									if(_ele.hasClass("imgw1")) {
										_ele.removeClass("imgw1").addClass("imgw2");
									} else if(_ele.hasClass("imgw2")) {
										_ele.removeClass("imgw2").addClass("imgw3");
									} else if(_ele.hasClass("imgw3")) {
										_ele.removeClass("imgw3").addClass("imgw1");
									}
								}, 3000);

							});
						</script>
					</div>
				</div>
			</div>
		</div>
	<div class="main_footer pngFix">
		<div class="footer_con1 clearfix">
			<div class="logobottom" style="height:225px;width:300px;background: url(../../images/ycf.jpg) right center no-repeat;background-size:70% auto;">
			</div>
		</div>

		<div class="footer_con3">
			<ul class="clearfix">
				<li>
					<a target="_blank" href="https://j.meishi.cc/" title="产品简介">产品简介</a>
				</li>
				<li>
					<a target="_blank" href="https://j.meishi.cc/aboutus.html" title="关于我们">关于我们</a>
				</li>
				<li>
					<a target="_blank" href="https://j.meishi.cc/download.html" title="产品下载">扫描二维码体验小程序</a>
				</li>
			</ul>
		</div>
	</div>

	<script type="text/javascript">
		function shouCan(id){
			$.post(
			    "/userCollection/wyAddCollect",
				{foodId:id},
				function(e){
					if(e.info.indexOf("success")>=0){
						alert("收藏成功");
                        location.reload();
					}
                    if(e.info.indexOf("erroe")>=0){
                        alert("收藏失败");
                        location.reload();
                    }
                    if(e.info.indexOf("notLogin")>=0){
                        alert("请先登录");
                        location.reload();
                    }
				},
				"JSON"
			)
		}
	</script>
	</body>

</html>