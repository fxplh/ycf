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
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>搜索</title>
    <meta name="keywords" content="菜谱大全,家庭菜谱,家庭实用菜谱大全"/>
    <meta name="description" content="菜谱大全,家庭菜谱,家庭实用菜谱大全"/>
    <meta content="www.ycf.net" name="author"/>
    <script>var _hmt = _hmt || [];</script>
    <link rel="stylesheet" type="text/css" media="all" href="../../css/ss_base.css?v=1517"/>
    <link rel="stylesheet" type="text/css" media="all" href="../../css/main.css?v=1040"/>
    <link rel="stylesheet" type="text/css" media="all" href="../../css/index.css?v=123"/>
    <link rel="stylesheet" type="text/css" media="all" href="../../css/list.css?v=123"/>
    <script type="text/javascript" src="../../js/j.m.js"></script>
    <script type="text/javascript" src="../../js/list.js?v=1108"></script>
    <script type="text/javascript" src="../../js/main.js?v=1515"></script>
    <script type="text/javascript" src="/js/jquery-1.8.0.min.js"></script>
    <script type="text/javascript" src="/js/foodList.js?v=123"></script>
    <script type="text/javascript" src="/js/search.js?v=123"></script>
</head>
<body style="">
<div class="header">
    <div class="header_c">
        <a href="" class="logo pngFix"><img style="height:129px" src="/images/log.jpg"/></a>
        <div class="main_search_top_w">
            <div class="suggestionsBox" id="suggestions" style="display:none;">
                <ul class="suggestionList" id="autoSuggestionsList"></ul>
            </div>
            <form id="form1" class="search" action="/food/wyGetBySearch" onsubmit="return searchFunction()">
                <input style="height:36px;width:345px" type="text" class="text" name="q" defaultval="请输入菜谱/食材"
                       x-webkit-speech="" value="<c:if test='${empty q}'>请输入菜谱/食材</c:if><c:if test='${!empty q}'>${q}</c:if>" autocomplete="off"
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
        <li class="hasmore current"><a href="/foodRecommend/getFoodRe" class="link pngFix"><strong>首页</strong></a></li>
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
                <input style="height: 49px;" type="text" class="text" name="q" value="${q}"
                                                                        x-webkit-speech="" autocomplete="off"
                                                                        name="inputString" placeholder="">
                <input type="submit" class="submit" value="搜 索">
            </form>
        </div>
        <span id="searchslideup_btn" class="pngFix" style="background-position:0px -48px;">自动收缩</span>
    </div>
</div>
<div class="bottom_back_top_top bottom_back_top_top_slideUp" id="bottom_back_top_top"><a href="#" title="返回顶部"
                                                                                         class="backtotop pngFix">回到顶部</a>
</div>
<div class="main_w clearfix">
    <div class="main">
        <div class="bbtitles">
            <c:if test="${!empty foodList}">
                所有菜品
            </c:if>
            <c:if test="${empty foodList}">
                暂无菜品
            </c:if>
            <span class="paixu"></span>
        </div>
        <div class="liststyle1_w clearfix">
            <div class="listtyle2_w clearfix" id="listtyle1_w">
                <div class="listtyle1_list clearfix" id="listtyle1_list">

                    <c:forEach items="${foodList}" var="food" varStatus="status">
                    <c:if test="${status.index eq 0 || status.index eq 4 }">
                    <div class="listtyle1 ml0">
                        </c:if>
                        <c:if test="${status.index ne 0 && status.index ne 4 }">
                        <div class="listtyle1">
                            </c:if>
                            <a target="_blank" href="/foodstep/getFoodInfo?id=${food.id}&rand=no" title="${food.name}"
                               class="big">
                                <img class="img" alt="${food.name}"
                                     src="${food.photo}">
                                <div class="i_w">
                                    <div class="i" style="margin-top: 0px;">
                                        <div class="c1"><strong>${food.name}</strong><br/><span>${food.imtro}</span>
                                        </div>
                                        <div class="c2">
                                            <ul>
                                                <li class="li1">9步 / 大概5分钟</li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                                <strong class="gx"><span>${food.info}</span></strong> </a>
                        </div>
                        </c:forEach>
                    </div><!-- listtyle1_list end -->
                    <div class="listtyle1_page">
                        <div class="listtyle1_page_w">
                            <c:if test="${page.countPage gt 1}">
                                <a href="/food/wyGetBySearch?q=${q}&currPage=${page.currPage-1}" class="prev">上一页</a>
                            </c:if>
                            <c:if test="${page.countPage le 5}">
                                <c:forEach var="index" begin="1" end="${page.countPage}" >
                                    <a href="/food/wyGetBySearch?q=${q}&currPage=${index}" <c:if test="${page.currPage eq index}">class="current"</c:if>>${index}</a>
                                </c:forEach>
                            </c:if>

                            <c:if test="${page.countPage gt 5 && page.currPage ge 5}" >
                                <c:forEach var="index" begin="${page.currPage-4}" end="${page.currPage}" >
                                    <a href="/food/wyGetBySearch?q=${q}&currPage=${index}" <c:if test="${page.currPage eq index}">class="current"</c:if>>${index}</a>
                                </c:forEach>
                                <span>...</span>
                            </c:if>
                            <c:if test="${page.countPage gt 5 && page.currPage lt 5}" >
                                <c:forEach var="index" begin="1" end="5" >
                                    <a href="/food/wyGetBySearch?q=${q}&currPage=${index}" <c:if test="${page.currPage eq index}">class="current"</c:if>>${index}</a>
                                </c:forEach>
                                <span>...</span>
                            </c:if>
                            <c:if test="${page.countPage gt page.currPage }">
                                <a href="/food/wyGetBySearch?q=${q}&currPage=${page.currPage+1}" class="next">下一页</a>
                            </c:if>
                            <span class="gopage">
                                <form action="/food/wyGetBySearch">
                                    <input type="hidden" name="q" value="${q}"/>共${page.countPage}页，到第
                                    <input type="text" class="text" value="2" name="currPage"> 页
                                    <input type="submit" class="submit" value="确定">
                                </form>
                            </span>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
    <div class="main_footer pngFix">
        <div class="footer_con1 clearfix">
            <div class="logobottom"
                 style="height:225px;width:300px;background: url(../../images/ycf.jpg) right center no-repeat;background-size:70% auto;">
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
        <script type="text/javascript">var cnzz_protocol = (("https:" == document.location.protocol) ? " https://" : " http://");
        document.write(unescape("%3Cspan id='cnzz_stat_icon_1259001544'%3E%3C/span%3E%3Cscript src='" + cnzz_protocol + "s95.cnzz.com/stat.php%3Fid%3D1259001544' type='text/javascript'%3E%3C/script%3E"));</script>
    </div>
</div>
</body>
</html>