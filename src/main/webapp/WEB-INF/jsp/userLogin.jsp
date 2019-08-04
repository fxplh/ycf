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
		<title>用户登录 - 宜厨房 - 美食,菜谱 </title>
		<meta name="keywords" content="美食,美食网,菜谱,菜谱网" />
		<meta name="description" content="宜厨房" />
		<meta content="www.meishij.net" name="author" />
		<script>
			var _hmt = _hmt || [];
		</script>
		<link rel="stylesheet" type="text/css" media="all" href="../../css/ss_base.css?v=1517"/>
		<link rel="stylesheet" type="text/css" media="all" href="../../css/main.css?v=1040"/>
		<link rel="stylesheet" type="text/css" media="all" href="../../css/login.css?v=1040"/>
		<link rel="stylesheet" type="text/css" media="all" href="../../css/tipswindown.css" />
		<script type="text/javascript" src="../../js/j.m.js"></script>
		<script type="text/javascript" src="../../js/list.js?v=1108"></script>
		<script type="text/javascript" src="../../js/main.js?v=1515"></script>
		<script type="text/javascript" src="/js/jquery-1.8.0.min.js"></script>
		<script type="text/javascript" src="/js/tipswindown.js"></script>
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
				<li><a href="/foodRecommend/getFoodRe" class="link pngFix"><strong>首页</strong></a></li>
				<li class="hasmore">
					<a href="/foodClass/foodList?id=10001" class="link pngFix"><strong>菜谱大全</strong></a>
				</li>
				<li class="hasmore">
					<a href="/food/wyRandFood" class="link pngFix"><strong>随机菜谱</strong></a>
				</li>
				<li class="hasmore current">
					<a href="" class="link pngFix"><strong>个人信息</strong></a>
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
			<a href="#" class="backtotop pngFix">回到顶部</a>
		</div>
		<div class="main_w clearfix">
			<style>
				body {
					font-family: "Hiragino Sans GB", "冬青黑体", "Microsoft Yahei", "微软雅黑";
				}
				
				.new_loginpage {
					width: 1000px;
					background: #fff;
					margin: 40px auto 0px;
					padding: 1px 0px 60px;
				}
				
				.nl_title {
					height: 43px;
					line-height: 42px;
					font-size: 22px;
					color: #333;
					text-align: center;
					margin: 40px auto;
				}
				
				.nl_title .nl_t_left {
					display: inline-block;
					vertical-align: top;
					*zoom: 1;
					*display: inline;
					width: 91px;
					height: 9px;
					margin-top: 17px;
					background: url(/images/nl_title_left.png) center no-repeat;
					margin-right: 20px;
				}
				
				.nl_title .nl_t_right {
					display: inline-block;
					vertical-align: top;
					*zoom: 1;
					*display: inline;
					width: 91px;
					height: 9px;
					margin-top: 17px;
					background: url(/images/nl_title_right.png) center no-repeat;
					margin-left: 20px;
				}
				
				.nl_dsf_w {
					text-align: center;
				}
				
				.nl_dsf_w1 {
					text-align: center;
				}
				
				.nl_dsf_w1 a {
					display: inline-block;
					vertical-align: top;
					*display: inline;
					*zoom: 1;
					width: 108px;
					margin: 0px 25px;
					line-height: 44px;
					font-size: 15px;
				}
				
				.nl_dsf_w1 .a1 {
					color: #8fc31f;
				}
				
				.nl_dsf_w1 .a2 {
					color: #7ecef4;
				}
				
				.nl_dsf_w1 .a3 {
					color: #fd4e5d;
				}
				
				.nl_dsf_w1 .a1 span {
					background-position: 0px 0px;
				}
				
				.nl_dsf_w1 .a1:hover span {
					background-position: 0px -108px;
				}
				
				.nl_dsf_w1 .a2 span {
					background-position: -108px 0px;
				}
				
				.nl_dsf_w1 .a2:hover span {
					background-position: -108px -108px;
				}
				
				.nl_dsf_w1 .a3 span {
					background-position: -216px 0px;
				}
				
				.nl_dsf_w1 .a3:hover span {
					background-position: -216px -108px;
				}

				
				.nl_loginbox_w {
					width: 320px;
					margin: 24px auto 0px;
					overflow: hidden;
					text-align: left;
				}
				
				.nl_loginitem {
					height: 44px;
					width: 320px;
					margin-bottom: 14px;
				}
				
				.nl_loginitem .text {
					height: 22px;
					border: 1px solid #ddd;
					border-radius: 4px;
					line-height: 22px;
					font-size: 14px;
					color: #333;
					padding: 11px;
					width: 296px;
					font-family: "Hiragino Sans GB", "冬青黑体", "Microsoft Yahei", "微软雅黑";
				}
				
				.nl_loginitem .password {
					height: 22px;
					border: 1px solid #ddd;
					border-radius: 4px;
					line-height: 22px;
					font-size: 14px;
					color: #333;
					padding: 11px;
					width: 296px;
					font-family: "Hiragino Sans GB", "冬青黑体", "Microsoft Yahei", "微软雅黑";
				}
				
				.nl_loginitem .submit {
					display: inline-block;
					vertical-align: top;
					: *display:inline;
					*zoom: 1;
					height: 42px;
					border: 1px solid #db432e;
					border-radius: 4px;
					line-height: 40px;
					font-size: 15px;
					color: #fff;
					padding: 0px 24px;
					font-family: "Hiragino Sans GB", "冬青黑体", "Microsoft Yahei", "微软雅黑";
					background: #ec5541;
					cursor: pointer;
				}
				
				.nl_loginitem .submit:hover {
					background: #db432e;
				}
				
				.nl_loginitem .yzm_text {
					height: 22px;
					border: 1px solid #ddd;
					border-radius: 4px;
					line-height: 22px;
					font-size: 14px;
					color: #333;
					padding: 11px;
					width: 100px;
					font-family: "Hiragino Sans GB", "冬青黑体", "Microsoft Yahei", "微软雅黑";
				}
				
				#img_verifycode_key_email {
					display: inline-block;
					vertical-align: top;
					*display: inline;
					*zoom: 1;
					height: 44px;
					margin: 1px 0px 0px 4px;
				}
				
				#mail_yzm_refresh {
					line-height: 46px;
					padding-left: 4px;
					color: #666;
					font-size: 15px;
					display: inline-block;
					vertical-align: top;
					*display: inline;
					*zoom: 1;
				}
				
				#mail_yzm_refresh:hover {
					color: #ec5541;
					text-decoration: underline;
				}
				
				.nl_loginitem label {
					color: #666;
					font-size: 13px;
					line-height: 22px;
				}
				
				.nl_loginitem label input {
					margin-top: -2px;
					position: relative;
				}
				
				.nl_loginitem label a {
					color: #ec5541;
				}
				
				.nl_loginitem label a:hover {
					text-decoration: underline;
				}
				
				.nl_loginitem .forgetpassword {
					float: right;
					display: block;
					line-height: 22px;
					color: #999;
					font-size: 13px;
				}
				
				.nl_loginitem .forgetpassword:hover {
					text-decoration: underline;
					color: #ec5541;
				}
				
				.golink {
					color: #333;
					font-size: 15px;
					display: block;
					margin-top: 20px;
					text-align: center;
					line-height: 66px;
					height: 66px;
				}
				
				.golink:hover {
					color: #ec5541;
					text-decoration: underline;
				}
				
				.nl_moredsf {
					width: 60%;
					text-align: center;
					background: #f5f5f5;
					height: 100px;
					border: 1px solid #eee;
					margin: 0px auto;
					border-radius: 4px;
					display: none;
				}
				
				.nl_moredsf a {
					display: inline-block;
					vertical-align: top;
					*display: inline;
					*zoom: 1;
					height: 16px;
					margin-top: 42px;
					line-height: 16px;
					padding: 0px 20px;
					color: #333;
					background: url(/images/nl_moredsf_icons.png) no-repeat;
				}
				
				.nl_moredsf a:hover {
					color: #ec5541;
					text-decoration: underline;
				}
				
				.nl_moredsf .a1 {
					background-position: 0px 0px;
				}
				
				.nl_moredsf .a2 {
					background-position: 0px -16px;
				}
				
				.nl_moredsf .a3 {
					background-position: 0px -32px;
				}
				
				.nl_moredsf .a4 {
					background-position: 0px -48px;
				}
				
				.nl_more_zc {
					width: 60%;
					text-align: center;
					background: #f5f5f5;
					border: 1px solid #eee;
					margin: 0px auto;
					border-radius: 4px;
					display: none;
					padding-bottom: 20px;
				}
				
				.phone_yzmbtn {
					width: 134px;
					float: right;
					background: #8fc31f;
					border: 1px solid #75ab49;
					display: block;
					color: #fff;
					line-height: 43px;
					height: 43px;
					border-radius: 4px;
					font-size: 15px;
					text-align: center;
				}
				
				.phone_yzmbtn:hover {
					background: #75ab49;
				}
				
				.phone_yzmbtn.sended {
					background: #ddd;
					border: 1px solid #ccc;
					color: #999;
				}
				
				.nl_tab {
					height: 32px;
					line-height: 32px;
					margin: 32px auto 0px;
					text-align: center;
					color: #ddd;
				}
				
				.nl_tab a {
					font-size: 18px;
					color: #999;
				}
				
				.nl_tab a:hover {
					color: #ec5541;
					text-decoration: underline;
				}
				
				.nl_tab a.current {
					font-weight: bold;
					color: #333;
					text-decoration: none;
				}
				
				.nl_loginbox_www {
					width: 320px;
					overflow: hidden;
					margin: 0px auto 0px;
				}
				
				.nl_loginbox_ww {
					width: 640px;
					margin-left: 0px;
				}
				
				.login_false_tip {
					height: 44px;
					line-height: 44px;
					border: 1px solid #c90000;
					color: #fff;
					background: #c90000;
					text-align: center;
					margin: 0px 0px 20px;
					font-size: 14px;
				}
				

				
				.login_tips.true {
					background-position: 0px -24px;
					color: #8fc31f;
				}
				
				.login_tips.false {
					background-position: 0px -48px;
					color: #ec5541;
				}
				
				.login_tips.tip {
					background-position: 0px 0px;
					color: #7ecef4;
				}
				
				.login_tips a {
					padding-left: 3px;
					color: #666;
					text-decoration: underline;
				}
				
				.login_tips a:hover {
					color: #ec5541;
				}
				

				
				.login_pw_tips.state1 {
					background-position: 0px -0px;
					color: #ec5541;
				}
				
				.login_pw_tips.state2 {
					background-position: 0px -24px;
					color: #f98120;
				}
				
				.login_pw_tips.state3 {
					background-position: 0px -48px;
					color: #8fc31f;
				}
			</style>

			<div class="new_loginpage">

				<h3 class="nl_title"><span class="nl_t_left"></span>登录宜厨房<span class="nl_t_right"></span></h3>


				<div class="nl_loginbox_w" id="msj_loginbox">

					<form method="POST" action="/user/login">
						<input type="hidden" value="https://www.meishij.net/zuofa/qingzhengxiawan_1.html" name="redirect" />
						<div class="nl_loginitem">
							<input style="height: 46px;" type="text" class="text" value="" name="name" placeholder="请输入邮箱">
						</div>
						<div class="nl_loginitem">
							<input style="height: 46px;" type="password" class="password" name="password" placeholder="请输入密码">
						</div>
						<div class="nl_loginitem" style="height:33px;"><!--
							<label><input type="checkbox" id="auto_login_next" value="auto" class="checkbox"> 下次自动登录</label>-->
							
						</div>
						<div class="nl_loginitem" style="text-align:center;">
							<input type="submit" class="submit" value="登录">
						</div>
					</form>

				</div>

				<a href="javascript:void(0)" class="golink" id="nl_gozc" opened="0">还没有账号？进入小程序设置账号</a>

			</div>

			<!--</body>-->
			<!--</html>-->
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
		<div style="display:none;">
			<script type="text/javascript">
				var cnzz_protocol = (("https:" == document.location.protocol) ? " https://" : " http://");
				document.write(unescape("%3Cspan id='cnzz_stat_icon_1259001544'%3E%3C/span%3E%3Cscript src='" + cnzz_protocol + "s95.cnzz.com/stat.php%3Fid%3D1259001544' type='text/javascript'%3E%3C/script%3E"));
			</script>
		</div>
	</body>

</html>