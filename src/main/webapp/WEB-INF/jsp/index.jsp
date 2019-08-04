
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
		<title>宜厨房</title>
		<meta name="keywords" content="宜厨房" />
		<meta name="description" content="宜厨房" />
		<meta content="www.ycf.net" name="author" />

		<link rel="stylesheet" type="text/css" media="all" href="../../css/ss_base.css?v=1517" />
		<link rel="stylesheet" type="text/css" media="all" href="../../css/main.css?v=1040" />
		<link rel="stylesheet" type="text/css" media="all" href="../../css/index.css?v=143" />
		<script type="text/javascript" src="../../js/j.m.js"></script>
		<script type="text/javascript" src="../../js/list.js?v=1108"></script>
		<script type="text/javascript" src="../../js/main.js?v=1515"></script>
		<script type="text/javascript" src="/js/jquery-1.8.0.min.js"></script>
		<script type="text/javascript" src="/js/index.js?v=223"></script>
		<script type="text/javascript" src="/js/search.js?v=123"></script>
	</head>

	<body>
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
				<li class="current">
					<a href="/foodRecommend/getFoodRe" class="link pngFix"><strong>首页</strong></a>
				</li>
				<li class="hasmore">
					<a href="/foodClass/foodList?id=10001" class="link pngFix"><strong>菜谱大全</strong></a>
				</li>
				<li class="hasmore">
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
			<a href="#" class="backtotop pngFix">回到顶部</a>
		</div>
		<div class="main_w clearfix">
			<div class="main clearfix">
				<div class="index_zzw" id="index_zzw">
					<div class="index_zzw_main" id="index_zzw_main">
						<div class="zzw_item zzw_item_3" po="3" c="2">
							<ul class="clearfix">
								<c:if test="${!empty foods }">
								<c:forEach items="${foods }"  var="food" >
									<li>
										<a target="_blank" href="" title="${food.name}" class="img"><img alt="${food.name}" src="${food.photo}" /></a>
										<div class="c pngFix">
											<h2><a target="_blank" href="" title="${food.name}">${food.name}</a></h2>
											<strong>${food.imtro}</strong>
											<span><a href="####">${food.tags}</a><em class="arrow pngFix"></em></span>
										</div>
									</li>
								</c:forEach>
								</c:if>
							</ul>
						</div>
					</div>
				</div> 

				<h3 class="bbtitles">益气养心，清淡饮食<span class="paixu"><a href="/foodShicai/wyGetShicai">更多食材 ></a></span></h3>
				<div class="index_sc_w">
					<dl class="clearfix">
						<dd class="index_sc_dd index_sc_dd_current">
							<a href="####" class="link">水果</a>
							<div class="index_sc_con">
								<div class="c" id = "fruit">
								</div>
							</div>
						</dd>
						<dd class="index_sc_dd">
							<a href="####" class="link">蔬菜</a>
							<div class="index_sc_con">
								<div class="c" id="vegetables">
								</div>
							</div>
						</dd>
						<dd class="index_sc_dd">
							<a href="####" class="link">五谷</a>
							<div class="index_sc_con">
								<div class="c" id="wugu">
								</div>
							</div>
						</dd>
						<dd class="index_sc_dd">
							<a href="####" class="link">生鲜</a>
							<div class="index_sc_con">
								<div class="c" id="shengxian">
								</div>
							</div>
						</dd>
					</dl>
				</div>
				<div class="index_pxw_ww">
					<div id="index_cp_leftarrow"></div>
					<div id="index_cp_leftarrow_mask"></div>
					<div id="index_cp_rightarrow"></div>
					<div id="index_cp_rightarrow_mask"></div>
					<div class="index_pxw_w" id="index_pxw_w">
						<div class="index_pxw clearfix" id="index_pxw">
							<div class="index_pxi">
								<h3 class="bbtitles">最热菜谱</h3>
								<div class="listtyle2_w clearfix" id="listtyle1_w">
									<div class="listtyle1_list clearfix" id="listtyle1_list">
									</div>
								</div>
							</div>
						</div>
						<span class="paixu">
						<a target="_blank" href="/foodClass/foodList?id=10001">更多菜谱 &gt;</a>
						</span>
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
	</body>

</html>