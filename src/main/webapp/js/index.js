/**
 * Created by Administrator on 2019/5/29.
 */
$(function(){
    $.post("/price/getPriceFood",
        {name:"水果"},
        function(e){
            if(e.info.indexOf("success")>=0){
                var foods = e.foodPrice;
                for(var i=0;i<foods.length;i++){
                    $("#fruit").append("<a target='_blank' href=''><img src='"+foods[i].photo+"' /><span class='name pngFix'><em class='notz'></em><strong>"+foods[i].name+"</strong></span></a>")
                }
            }
        },
        "JSON"
    );
    $.post("/price/getPriceFood",
        {name:"蔬菜"},
        function(e){
            if(e.info.indexOf("success")>=0){
                var foods = e.foodPrice;
                for(var i=0;i<foods.length;i++){
                    $("#vegetables").append("<a target='_blank' href=''><img src='"+foods[i].photo+"' /><span class='name pngFix'><em class='notz'></em><strong>"+foods[i].name+"</strong></span></a>")
                }
            }
        },
        "JSON"
    );
    $.post("/price/getPriceFood",
        {name:"五谷"},
        function(e){
            if(e.info.indexOf("success")>=0){
                var foods = e.foodPrice;
                for(var i=0;i<foods.length;i++){
                    $("#wugu").append("<a target='_blank' href=''><img src='"+foods[i].photo+"' /><span class='name pngFix'><em class='notz'></em><strong>"+foods[i].name+"</strong></span></a>")
                }
            }
        },
        "JSON"
    );
    $.post("/price/getPriceFood",
        {name:"生鲜"},
        function(e){
            if(e.info.indexOf("success")>=0){
                var foods = e.foodPrice;
                for(var i=0;i<foods.length;i++){
                    $("#shengxian").append("<a target='_blank' href=''><img src='"+foods[i].photo+"' /><span class='name pngFix'><em class='notz'></em><strong>"+foods[i].name+"</strong></span></a>")
                }
            }
        },
        "JSON"
    );
    $.post("/hotfood/getHotFood",
        function(e){
            if(e.info.indexOf("success")>=0){
                var foods = e.foods;
                var string = "";
                for(var i=0;i<foods.length;i++){
                    if(i==4||i==0){
                        string = "<div class='listtyle1 ml0'>";
                    }else{
                        string = "<div class='listtyle1'>";
                    }
                    $("#listtyle1_list").append(string+
                        "<a target='_blank' href='/foodstep/getFoodInfo?id="+foods[i].id+"&rand=no' title='"+foods[i].name+"' class='big'>"+
                    "<img class='img' alt='"+foods[i].name+"' src='"+foods[i].photo+"'>"+
                    "<div class='i_w'>"+
                    "<div class='i' style='margin-top: 0px;'>"+
                    "<div class='c1'><strong>"+foods[i].name+"</strong><br/><span>"+foods[i].imtro+"</span></div>"+
                    "<div class='c2'>"+
                    "<ul>"+
                    "<li class='li1'>10步 / 大概30分钟</li>"+
                    "</ul>"+
                    "</div>"+
                    "</div>"+
                    " </div>"+
                    " <strong class='gx'><span>"+foods[i].info+"</span></strong></a>"+
                    "</div>")
                }
            }
        },
        "JSON"
    );
})