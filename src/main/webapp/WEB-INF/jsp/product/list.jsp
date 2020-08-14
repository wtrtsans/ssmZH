<%--
  Created by IntelliJ IDEA.
  User: 95109
  Date: 2020/8/10
  Time: 18:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Layui</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css" media="all">
</head>
<body>
<table id="demo" lay-filter="test"></table>

<script src="${pageContext.request.contextPath}/layui/layui.js"></script>

<script type="text/html" id="tools">
    <button class="layui-btn layui-btn-radius" lay-event="add" ><i class="layui-icon layui-icon-addition"></i>添加</button>
    <button class="layui-btn layui-btn-danger layui-btn-radius" lay-event="delete" ><i class="layui-icon layui-icon-delete"></i>删除选中</button>
</script>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="update">修改</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<script>

    layui.use('table', function(){
        var table = layui.table;

        //第一个实例
        table.render({
            elem: '#demo'
            ,toolbar: '#tools'
            ,url: '${pageContext.request.contextPath}/product/date' //数据接口
            ,page: true //开启分页
            ,limit:5
            ,limits:[5,10,15,20,30,40,50]
            ,cols: [[ //表头
                {field: 'id', title: 'id', width:80, sort: true, fixed: 'left',checkbox: true}
                ,{field: 'id', title: '编号', width:150, sort: true, fixed: 'left'}
                ,{field: 'name', title: '商品名', width:80, sort: true, fixed: 'left'}
                ,{field: 'price', title: '价格', width:150, sort: true, fixed: 'left'}
                ,{field: 'pic', title: '图片', width:150, sort: true, fixed: 'left'}
                ,{field: 'detail', title: '简介', width:300, sort: true, fixed: 'left'}
                ,{field: 'createtime', title: '上架时间', width:200, sort: true,templet : function(value){
                        return layui.util.toDateString(value.createtime);
                    }, fixed: 'left'}
                ,{fixed: 'right', title: 'settings', width: 150, align:'center', toolbar: '#barDemo'}
            ]]
        });

    });
</script>
</body>
</html>
