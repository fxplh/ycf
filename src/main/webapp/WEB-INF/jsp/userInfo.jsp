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
<%
	Cookie[] cookies = request.getCookies();    //从request中获的Cookie对象的集合
	String rdSession = "";    //登录用户
	String isLogin = "false";
	if(cookies !=null){
		for(Cookie cookie : cookies){  //遍历cookie对象集合
			System.out.println(cookie.getName());
			if("isLogin".equals(cookie.getName())){
				isLogin = cookie.getValue();
			}
			if("rdSession".equals(cookie.getName())){
				rdSession = cookie.getValue();
			}
		}
		if(!"true".equals(isLogin)){
			rdSession = "";
		}
	}
%>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>个人空间</title>
		<meta name="keywords" content="美食,美食网" />
		<meta name="description" content="宜厨房" />
		<meta content="www.meishij.net" name="author" />
		<script>
			var _hmt = _hmt || [];
		</script>
		<link rel="stylesheet" type="text/css" media="all" href="/css/ss_base.css?v=1517" />
		<link rel="stylesheet" type="text/css" media="all" href="/css/main.css?v=1961" />
		<link rel="stylesheet" type="text/css" media="all" href="/css/user.css" />
		<link rel="stylesheet" type="text/css" media="all" href="/css/tipswindown.css" />
		<script type="text/javascript" src="/js/j.m.js?v=1551"></script>
		<script type="text/javascript" src="/js/main.js?v=1516"></script>
		<script type="text/javascript" src="/js/user.js?v=1516"></script>
		<script type="text/javascript" src="/js/tipswindown.js"></script>
		<script type="text/javascript" src="/js/jquery-1.8.0.min.js"></script>
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
				<li class="hasmore">
					<a href="/foodRecommend/getFoodRe" class="link pngFix"><strong>首页</strong></a>
				</li>
				<li class="hasmore">
					<a href="/foodClass/foodList?id=10001" class="link pngFix"><strong>菜谱大全</strong></a>
				</li>
				<li class="hasmore">
					<a href="/food/wyRandFood" class="link pngFix"><strong>随机菜谱</strong></a>
				</li>
				<li class="current">
					<a href="/userLogin" class="link pngFix"><strong>个人信息</strong></a>
				</li>
			</ul>
		</div>
	<div class="main_search main_search_slideUp pngFix" slideUp="1" style="_display:none;" id="main_search">
		<div class="searchform_div" style="width: 571px">
			<form id="form2" action="" target="_blank" onsubmit="return searchFunction1()">
				<input style="height: 49px;" type="text" class="text" name="q"
					   x-webkit-speech="" autocomplete="off"
					   name="inputString" placeholder="">
				<input type="submit" class="submit" value="搜 索">
			</form>
		</div>
	</div>
		<div class="bottom_back_top_top bottom_back_top_top_slideUp" id="bottom_back_top_top">
			<a href="#" class="backtotop pngFix">回到顶部</a>
		</div>
		<div class="main_w clearfix">
			<script type="text/javascript">
				function delete_sc_recipe(nid) {
					if(confirm("确定取消收藏这个菜谱么？")) {
                        $.post(
                            "/userCollection/wyAddCollect",
                            {foodId:nid},
                            function(e){
                                if(e.info.indexOf("fail")>=0){
                                    alert("取消收藏成功");
                                    location.reload();
                                }
                                if(e.info.indexOf("error")>=0){
                                    alert("取消收藏失败");
                                    location.reload();
                                }
                            },
                            "JSON"
                        )
					}
					return false;
				}
			</script>
			<div class="main clearfix">
				<h1 class="bbtitles">欢迎来到我的美食空间</h1>
				<div class="userheader">
					<div class="avatar_w">
						<img id = "avatarUrl" src="https://s1.c.meishij.net/images/default/tx2_2.png" />
					</div>
					<div class="userh_main">
						<div class="info1">
							<h1  id = "userName"></h1>
							<span class="info"><em id="email"></em> | <em id="city"></em></span>
							<div class="tools">
								<a class="mail" href="/user/back">退出</a>
							</div>
							
						</div>
					</div>
					
				</div>

				<style>
					.dryrw_btn {
						display: inline-block;
						vertical-align: top;
						height: 22px;
						padding: 0px 12px;
						background: #ff3232;
						ext-align: center;
						color: #fff;
						line-height: 22px;
					}
					
					.dryrw_btn:hover {
						background: #e80000;
					}
				</style>

				<div class="user_nav">
					<ul>
						
						<li class="current">
							<a href="https://i.meishi.cc/collected.php?id=13814349">收藏</a>
						</li>
						
					</ul>
				</div>
				<div class="user_main clearfix">
					<div class="user_inner_tab">
						<ul class="user_inner_tab_ul">
							<li>
								<a href="https://i.meishi.cc/collected.php?t=1&id=13814349" class="current link">我的收藏</a>
							</li>
							
						</ul>
					</div>
					<div class="usc_w clearfix">
						<div class="listtyle3_list1 clearfix" id="listtyle1_list">

						</div>

						<div class="fliterstyle11" id="fliterstyle1">
							<div class="fliterstyle1_main">
								<ul class="tab">
									<%--<li class="li1 current" po="1">
										<a href="####">菜谱</a>
									</li>--%>
								</ul>
								<div class="tabcon" po="1" style="display:block;">
									<%--<dl class="clearfix on">
										<dd class="clearfix row2 bb0">
											<a href="https://i.meishi.cc/collected.php?t=1&id=13814349&cat=0" class="chosed"><strong>全部</strong><em>4</em></a>
										</dd>
									</dl>--%>
								</div>
								<div class="tabcon" po="2" style="display:none;">
									<dl class="clearfix on">
										<dd class="clearfix row2 bb0">
										</dd>
									</dl>
								</div>
							</div>
						</div>
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
		<div style="display:none;">
			<script type="text/javascript">
				var cnzz_protocol = (("https:" == document.location.protocol) ? " https://" : " http://");
				document.write(unescape("%3Cspan id='cnzz_stat_icon_1259001544'%3E%3C/span%3E%3Cscript src='" + cnzz_protocol + "s95.cnzz.com/stat.php%3Fid%3D1259001544' type='text/javascript'%3E%3C/script%3E"));
			</script>
		</div>
	<script type="text/javascript">
        $(function(){
            var loginStatus = "<%=isLogin%>";
            if("true"==loginStatus){
                var rdSession = "<%=rdSession%>";
                $.post(
                    "/user/wyGetUserInfo",
                    function(e){
                        if(e.info.indexOf("success")>=0){
                            $("#userName").text(e.user.name);
                            $("#email").text(e.user.phone);
                            $("#city").text(e.user.city);
                            $("#avatarUrl").attr("src",e.user.avatarurl);
                            var foods = e.foods;
                            var str = "<div class='listtyle3 listtyle3_332'>";
                            for(var i=0;i<foods.length;i++){
                                if(i%3 == 0){
                                    str = "<div class='listtyle3 listtyle3_332 ml0'>";
                                }
                                $("#listtyle1_list").append(str+
                                    "<div class='img'>"+
                                    "<a target='_blank' href='/foodstep/getFoodInfo?id="+foods[i].id+"&rand=no' title='"+foods[i].name+"' class='img'>"+
                                    "<img class='cpimg' alt='"+foods[i].name+"' src='"+foods[i].photo+"' width='232' height='232' /></a>"+
                                    "<strong class='gx'><span>"+foods[i].info+"</span></strong></div>"+
                                    "<div class='info2'>"+
                                    "<a target='_blank' title='"+foods[i].name+"' href='/foodstep/getFoodInfo?id="+foods[i].id+"&rand=no' class='img'></a>"+
                                    "<div class='info2_c' style='left: 232px; opacity: 0;'>"+
                                    "<a target='_blank' title='"+foods[i].name+"' href='/foodstep/getFoodInfo?id="+foods[i].id+"&rand=no' class='link_cp'>"+
                                    "<ul>"+
                                    "<li class='gy pngFix'>炒</li>"+
                                    "</ul>"+
                                    "</a>"+
                                    "<div class='gx2'><span>"+foods[i].tags+"</span></div>"+
                                    "</div>"+
                                    "</div>"+
                                    "<div class='info3'>"+
                                    "<h3><a target='_blank' title='"+foods[i].name+"' href='/foodstep/getFoodInfo?id="+foods[i].id+"&rand=no'>"+foods[i].name+"</a></h3>"+
                                    "<div class='d1'><span>"+foods[i].imtro+"</span></div>"+
                                    "<div class='delete'>"+
                                    "<a href='javascript:void(0);' onclick='delete_sc_recipe("+foods[i].id+")' class='delete_b'>取消收藏</a>"+
                                    "</div>"+
                                    "</div>"+
                                    "</div>");
                            }
                        }
                    },
                    "JSON"
                )
            }

        })

	</script>
	</body>

</html>