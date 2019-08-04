package com.lh;

import com.lh.food.dao.FoodMapper;
import com.lh.food.entity.Food;
import com.lh.food.service.impl.FoodServiceimpl;
import com.lh.foodstep.entity.Foodstep;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2019/6/3.
 */
public class MeiShi {
    static String url=  "jdbc:mysql://localhost:3306/ycf?useUnicode=true&useSSL=true&serverTimezone=UTC";
    static String  username=  "root";
    static String password=  "root";
    static Connection conn ;
    static  Statement st;
    public static void jdbc(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
            st = conn.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void colse(){
        try {
            st.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){


        /*String url = "https://www.meishij.net/chufang/diy/?&page=1";
        try {
            Document document = Jsoup.connect(url).post();
            Elements elementsByClass = document.getElementsByClass("listtyle1");
            Iterator it = elementsByClass.iterator();
            while(it.hasNext()) {
                Food food = new Food();
                String foodId = UUID.randomUUID().toString();
                foodId = foodId.replaceAll("-","");
                food.setId(foodId);
                Element element = (Element)it.next();
                Elements img = element.getElementsByClass("img");
                String photo = img.attr("src");
                String name = img.attr("alt");
                System.out.println("src==>"+photo);
                System.out.println("alt==>"+name);
                food.setPhoto(photo);
                food.setName(name);
                Elements a = element.getElementsByClass("big");
                //进入当前食谱的详细信息页面
                //获取tags
                String href = a.get(0).attr("href");
                Document foodInfo = Jsoup.connect(href).post();
                int i = 0;
                String tag = "";
                String info = "";
                while(foodInfo.getElementById("tongji_gx_"+i) != null){

                    if(i>0){
                        tag = tag+";";
                    }
                    tag = tag+foodInfo.getElementById("tongji_gx_" + i).text();
                    if(i==0){
                        info = tag;
                    }
                    i++;
                }
                System.out.println("tag==>"+tag);
                food.setTags(tag);
                food.setInfo(info);
                //获取简介
                Elements materials = foodInfo.getElementsByClass("materials");
                String imtro = "";
                if(materials!=null){
                    Elements p = materials.get(0).getElementsByTag("p");
                    if(p!=null){
                        imtro = p.get(0).text();
                    }
                }
                System.out.println("imtro==>"+imtro);
                food.setImtro(imtro);
                //获取主料
                Elements elementsByClass1 = foodInfo.getElementsByClass("yl zl clearfix");
                String ingredients = "";
                if(elementsByClass1!=null){
                    Elements c = elementsByClass1.get(0).getElementsByClass("c");
                    Iterator<Element> iterator = c.iterator();
                    while(iterator.hasNext()){
                        Elements h4 = iterator.next().getElementsByTag("h4");
                        if(h4!=null){
                            String inName = h4.get(0).getElementsByTag("a").get(0).text();
                            String inNum = h4.get(0).getElementsByTag("span").get(0).text();
                            ingredients = ingredients+inName+","+inNum+";";
                        }
                    }
                    if("".equals(ingredients)){
                        ingredients = ingredients.substring(0,ingredients.length()-1);
                    }
                }
                System.out.println("ingredients==>"+ingredients);
                food.setIngredients(ingredients);
                //获取辅料
                Elements elementsByClass2 = foodInfo.getElementsByClass("yl fuliao clearfix");
                String burden = "";
                if(elementsByClass2!=null){
                    Elements li = elementsByClass2.get(0).getElementsByTag("li");
                    Iterator<Element> iterator1 = li.iterator();
                    while(iterator1.hasNext()){
                        Elements h4 = iterator1.next().getElementsByTag("h4");
                        if(h4!=null){
                            String inName = h4.get(0).getElementsByTag("a").get(0).text();
                            burden = burden+inName+",";
                        }
                        String inNum = h4.next().text();
                        burden = burden+inNum+";";
                    }
                    if("".equals(burden)){
                        burden = burden.substring(0,burden.length()-1);
                    }
                }
                System.out.println("burdenburden==>"+burden);
                food.setBurden(burden);
                jdbc();
                st.execute("insert into food values('"+food.getId()+"','"+food.getName()+"','"+food.getPhoto()+"','"+food.getIngredients()+"','"+food.getBurden()+"','"+food.getInfo()+"','','"+food.getTags()+"','"+food.getImtro()+"')");
                colse();
                //获取步骤
                Elements elementsByClass3 = foodInfo.getElementsByClass("editnew edit");
                Elements elementsByClass4 = elementsByClass3.get(0).getElementsByClass("content clearfix");
                Iterator<Element> iterator2 = elementsByClass4.iterator();
                int index = 1;
                while(iterator2.hasNext()){
                    Foodstep foodstep = new Foodstep();
                    Elements c = iterator2.next().getElementsByClass("c");
                    Elements p = c.get(0).getElementsByTag("p");
                    String link = "";
                    if(p!=null){
                        link = p.text();
                    }
                    String info1 = "";
                    Elements img1 = c.get(0).getElementsByTag("img");
                    if(img1!=null){
                        info1 = img1.attr("src");
                    }
                    String uuid_key = UUID.randomUUID().toString();
                    uuid_key = uuid_key.replaceAll("-","");
                    foodstep.setId(uuid_key);
                    foodstep.setIndex(index);
                    foodstep.setLink(link);
                    foodstep.setInfo(info1);
                    foodstep.setFkFoodId(foodId);
                    index++;
                    jdbc();
                    st.execute("insert into foodstep values('"+foodstep.getId()+"','"+foodstep.getIndex()+"','"+foodstep.getInfo()+"','"+foodstep.getLink()+"','"+foodstep.getFkFoodId()+"')");
                    colse();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }
}
