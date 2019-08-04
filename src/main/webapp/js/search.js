/**
 * Created by Administrator on 2019/5/31.
 */
    function searchFunction(){
        var inputString = $("#form1 [name='inputString']").val();
        if(inputString.trim()==""){
            alert("内容不能有空格");
            return false;
        }
        if(inputString=="请输入菜谱/食材"){
            alert("请输入正确内容");
            return false;
        }
        return true;
    }
function searchFunction1(){
    var inputString = $("#form2 [name='inputString']").val();
    if(inputString.trim()==""){
        alert("内容不能有空格");
        return false;
    }
    if(inputString=="请输入菜谱/食材"){
        alert("请输入正确内容");
        return false;
    }
    return true;
}