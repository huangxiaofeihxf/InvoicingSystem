<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Huangxiaofei
  Date: 2018/8/17
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<script type="text/javascript" src="/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="/js/jquery.pagination.js"></script>
<script type="text/javascript">
    function quitout() {
        var flag=confirm('确认要退出系统吗？');
        if(flag){
            location.href="/user/quit";
        };
    };

  /*  $(function (){
    var soption=$("#s_option");
    $.post("/product/option",function(data){
          var json=eval("("+data+")");
          htmls=[];
          $.each(json,function(i,item){
              var id=item.id;
              htmls[i]='<option value="">'+item.productName
                  +'</option>'
                  +'<br/>'
            //  $(htmls[i]).val(item.id);
          });
        soption.after(htmls);
    });
});*/
function validate() {
    var s_select=$("#s_select").val();
    var s_price=$("#s_price").val();
    var s_number=$("#s_number").val();
    var flag=true;
    if(flag) {
        if (s_select == "请选择商品") {
            flag=false;
            alert("请选择商品！");
        }
        ;
        if (s_price == null || s_price == "") {
            flag=false;
            alert("销售价格不能为空！")
        } else {
            if (!$.isNumeric(s_price)) {
                flag=false;
                alert("销售单价必须是数字")
            };
        }
        ;
        if (s_number == null || s_number == "") {
            flag=false;
            alert("销售数量不能为空！");
        } else {
            if (!$.isNumeric(s_number)) {
                flag=false;
                alert("销售数量必须是数字");
            };
        }
        ;
    };
    var id=$("#s_select").val();
    if(flag){
        alert("ahha");
        $.post("/product/addSale",{"productId":id,"price":s_price,"quantity":s_number},
            function(data){
                alert("哈哈");
                alert(data);
                alert(json);
                if(json==1){
                    alert("添加成功！")
                };
            });
    };
};

function findAllSales(pageNum){
    $.ajax({
        url: "/product/findAllSaleDetail",
        type:"post",
        date:{"pageNum":pageNum},
        success:function(data){
            //清空tbody中的内容
            $("#content").empty();
            //遍历数据
            $.each(data.list,function(i,item){
                $("#content").append(
                "<tr>"+
                +"<td>"+item.id+"</td>\n"
                +"<td>"+item.productName+"</td>\n"
                +"<td>"+item.price+"</td>\n"
                +"<td>"+item.quantity+"</td>\n"
                +"<td>"+item.totalPrice+"</td>\n"
                +"<td>"+item.saleDate+"</td>\n"
                +"<td>"+item.realName+"</td>\n"
                +"</tr>"
                )
            });
            //使用pagination插件
            $("#pagination").pagination(data.total,
                {
                    current_page:data.pageNum,//当前页
                    items_per_page:data.pageSize,//页大小
                    prev_text: "上一页",
                    next_text: "下一页",
                    callback:findAllSales //回调函数
            })
        },//success结束
    });
};

</script>
<head>
    <title>Title</title>
    <link href="/js/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
<h1>欢迎:${sessionScope.loginUser.realName}，<a href="#" onclick="quitout()">退出登录</a></h1>

<h2><a href="#">销售</a></h2>
<h2><a href=javascript:findAllSales()>销售信息查询</a></h2>
<h2><a href="#">查看库存</a></h2>
<h2>欢迎使用小型进销存系统</h2>
<div style="border: solid">
    <h3>添加销售</h3>
   <form action="/product/option" method="post">
      商品名称：<select id="s_select">
                    <option id="s_option">请选择商品</option>
       <c:forEach items="${requestScope.list}" var="item">
           <option value="${item.id}" name="${item.id}">${item.productName}</option>
       </c:forEach>
                </select>
      销售单价：<input type="text" name="price" id="s_price">
      销售数量：<input type="text" name="number" id="s_number">
       <input type="submit" value="保存" onclick="validate()">
   </form>
</div>

    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>商品</th>
                <th>单价</th>
                <th>数量</th>
                <th>总价</th>
                <th>销售日期</th>
                <th>销售员</th>
            </tr>
        </thead>
        <tbody id="content" style="border: solid">
        </tbody>
    </table>
    <div class="pagination" id="pagination"></div>
</body>
</html>
