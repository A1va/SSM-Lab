<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <!-- 页面meta -->
    <meta charset="utf-8" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>海信企业信息管理系统</title>
    <meta name="description" content="海信企业信息管理系统">
    <meta name="keywords" content="海信企业信息管理系统">

    <!-- Tell the browser to be responsive to screen width -->
    <meta
            content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no"
            name="viewport">


    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/statics/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/statics/plugins/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/statics/plugins/ionicons/css/ionicons.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/statics/plugins/iCheck/square/blue.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/statics/plugins/morris/morris.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/statics/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/statics/plugins/datepicker/datepicker3.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/statics/plugins/daterangepicker/daterangepicker.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/statics/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/statics/plugins/datatables/dataTables.bootstrap.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/statics/plugins/treeTable/jquery.treetable.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/statics/plugins/treeTable/jquery.treetable.theme.default.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/statics/plugins/select2/select2.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/statics/plugins/colorpicker/bootstrap-colorpicker.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/statics/plugins/bootstrap-markdown/css/bootstrap-markdown.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/statics/plugins/adminLTE/css/AdminLTE.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/statics/plugins/adminLTE/css/skins/_all-skins.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/statics/css/style.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/statics/plugins/ionslider/ion.rangeSlider.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/statics/plugins/ionslider/ion.rangeSlider.skinNice.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/statics/plugins/bootstrap-slider/slider.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/statics/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.css">
</head>

<body class="hold-transition skin-purple sidebar-mini">

<div class="wrapper">

    <!-- 页面头部 -->
    <jsp:include page="header.jsp"/>
    <!-- 页面头部 /-->
    <!-- 导航侧栏 -->
    <jsp:include page="sider.jsp"/>
    <!-- 导航侧栏 /-->

    <!-- 内容区域 -->
    <div class="content-wrapper">

        <!-- 内容头部 -->
        <section class="content-header">
            <h1>
                产品管理 <small>产品表单</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="${pageContext.request.contextPath}/dashboard"><i
                        class="fa fa-dashboard"></i> 首页</a></li>
                <li><a
                        href="${pageContext.request.contextPath}/customer/findAll">客户管理</a></li>
                <li class="active">客户表单</li>
            </ol>
        </section>
        <!-- 内容头部 /-->

        <form action="${pageContext.request.contextPath}/customer/save" method="post">
            <!-- 正文区域 -->
            <section class="content"> <!--客户信息-->

                <div class="panel panel-default">
                    <div class="panel-heading">客户信息</div>
                    <div class="row data-type">

                        <div class="col-md-2 title">客户姓名</div>
                        <div class="col-md-4 data">
                            <input type="text" class="form-control" name="customerName"
                                   placeholder="客户姓名" value="">
                        </div>

                        <div class="col-md-2 title">性别</div>
                        <div class="col-md-4 data">
                            <label>
                                <select class="form-control select2" style="width: 200%"
                                        name="sex">
                                    <option value="男" selected="selected">男</option>
                                    <option value="女">女</option>
                                </select>
                            </label>
                        </div>

                        <div class="col-md-2 title">电话号码</div>
                        <div class="col-md-4 data">
                            <input type="text" class="form-control" placeholder="电话号码"
                                   name="phoneNum" value="">
                        </div>


                        <div class="col-md-2 title">产品分类</div>
                        <div class="col-md-4 data">
                            <label>
                                <select class="form-control select2" style="width: 200%"
                                        name="credentialsType">
                                    <option value="0" selected="selected">身份证</option>
                                    <option value="1">护照</option>
                                    <option value="2">军官证</option>
                                </select>
                            </label>
                        </div>

                        <%--<div class="col-md-2 title">生产时间</div>--%>
                        <%--<div class="col-md-4 data">--%>
                            <%--<div class="input-group date">--%>
                                <%--<div class="input-group-addon">--%>
                                    <%--<i class="fa fa-calendar"></i>--%>
                                <%--</div>--%>
                                <%--<label for="datepicker-a3"></label><input type="text" class="form-control pull-right"--%>
                                                                          <%--id="datepicker-a3" name="createTime">--%>
                            <%--</div>--%>
                        <%--</div>--%>

                        <div class="col-md-2 title">证件号码</div>
                        <div class="col-md-4 data">
                            <input type="text" class="form-control" placeholder="证件号码"
                                   name="credentialsNum" value="">
                        </div>

                        <div class="col-md-2 title">客户类型</div>
                        <div class="col-md-4 data">
                            <label>
                                <select class="form-control select2" style="width: 100%"
                                        name="customerType">
                                    <option value="0" selected="selected">普通客户</option>
                                    <option value="1">会员</option>
                                    <option value="2">合作伙伴</option>
                                    <option value="3">中大型企业</option>
                                </select>
                            </label>
                        </div>
                        <%--<div></div>--%>
                        <%--<div class="col-md-2 title rowHeight2x">其他信息</div>--%>
                        <%--<div class="col-md-4 data rowHeight2x">--%>
							<%--<textarea class="form-control" rows="3" placeholder="其他信息"--%>
                                      <%--name="productDesc" cols=""></textarea>--%>
                        <%--</div>--%>

                    </div>
                </div>
                <!--订单信息/--> <!--工具栏-->
                <div class="box-tools text-center">
                    <button type="submit" class="btn bg-maroon">保存</button>
                    <button type="button" class="btn bg-default"
                            onclick="history.back(-1);">返回</button>
                </div>
                <!--工具栏/--> </section>
            <!-- 正文区域 /-->
        </form>
    </div>
    <!-- 内容区域 /-->

    <!-- 底部导航 -->
    <jsp:include page="footer.jsp"/>
    <!-- 底部导航 /-->

</div>


<script
        src="${pageContext.request.contextPath}/statics/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script
        src="${pageContext.request.contextPath}/statics/plugins/jQueryUI/jquery-ui.min.js"></script>
<script>
    $.widget.bridge('uibutton', $.ui.button);
</script>
<script
        src="${pageContext.request.contextPath}/statics/plugins/bootstrap/js/bootstrap.min.js"></script>
<script
        src="${pageContext.request.contextPath}/statics/plugins/raphael/raphael-min.js"></script>
<script
        src="${pageContext.request.contextPath}/statics/plugins/morris/morris.min.js"></script>
<script
        src="${pageContext.request.contextPath}/statics/plugins/sparkline/jquery.sparkline.min.js"></script>
<script
        src="${pageContext.request.contextPath}/statics/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script
        src="${pageContext.request.contextPath}/statics/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<script
        src="${pageContext.request.contextPath}/statics/plugins/knob/jquery.knob.js"></script>
<script
        src="${pageContext.request.contextPath}/statics/plugins/daterangepicker/moment.min.js"></script>
<script
        src="${pageContext.request.contextPath}/statics/plugins/daterangepicker/daterangepicker.js"></script>
<script
        src="${pageContext.request.contextPath}/statics/plugins/daterangepicker/daterangepicker.zh-CN.js"></script>
<script
        src="${pageContext.request.contextPath}/statics/plugins/datepicker/bootstrap-datepicker.js"></script>
<script
        src="${pageContext.request.contextPath}/statics/plugins/datepicker/locales/bootstrap-datepicker.zh-CN.js"></script>
<script
        src="${pageContext.request.contextPath}/statics/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<script
        src="${pageContext.request.contextPath}/statics/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<script
        src="${pageContext.request.contextPath}/statics/plugins/fastclick/fastclick.js"></script>
<script
        src="${pageContext.request.contextPath}/statics/plugins/iCheck/icheck.min.js"></script>
<script
        src="${pageContext.request.contextPath}/statics/plugins/adminLTE/js/app.min.js"></script>
<script
        src="${pageContext.request.contextPath}/statics/plugins/treeTable/jquery.treetable.js"></script>
<script
        src="${pageContext.request.contextPath}/statics/plugins/select2/select2.full.min.js"></script>
<script
        src="${pageContext.request.contextPath}/statics/plugins/colorpicker/bootstrap-colorpicker.min.js"></script>
<script
        src="${pageContext.request.contextPath}/statics/plugins/bootstrap-wysihtml5/bootstrap-wysihtml5.zh-CN.js"></script>
<script
        src="${pageContext.request.contextPath}/statics/plugins/bootstrap-markdown/js/bootstrap-markdown.js"></script>
<script
        src="${pageContext.request.contextPath}/statics/plugins/bootstrap-markdown/locale/bootstrap-markdown.zh.js"></script>
<script
        src="${pageContext.request.contextPath}/statics/plugins/bootstrap-markdown/js/markdown.js"></script>
<script
        src="${pageContext.request.contextPath}/statics/plugins/bootstrap-markdown/js/to-markdown.js"></script>
<script
        src="${pageContext.request.contextPath}/statics/plugins/ckeditor/ckeditor.js"></script>
<script
        src="${pageContext.request.contextPath}/statics/plugins/input-mask/jquery.inputmask.js"></script>
<script
        src="${pageContext.request.contextPath}/statics/plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
<script
        src="${pageContext.request.contextPath}/statics/plugins/input-mask/jquery.inputmask.extensions.js"></script>
<script
        src="${pageContext.request.contextPath}/statics/plugins/datatables/jquery.dataTables.min.js"></script>
<script
        src="${pageContext.request.contextPath}/statics/plugins/datatables/dataTables.bootstrap.min.js"></script>
<script
        src="${pageContext.request.contextPath}/statics/plugins/chartjs/Chart.min.js"></script>
<script
        src="${pageContext.request.contextPath}/statics/plugins/flot/jquery.flot.min.js"></script>
<script
        src="${pageContext.request.contextPath}/statics/plugins/flot/jquery.flot.resize.min.js"></script>
<script
        src="${pageContext.request.contextPath}/statics/plugins/flot/jquery.flot.pie.min.js"></script>
<script
        src="${pageContext.request.contextPath}/statics/plugins/flot/jquery.flot.categories.min.js"></script>
<script
        src="${pageContext.request.contextPath}/statics/plugins/ionslider/ion.rangeSlider.min.js"></script>
<script
        src="${pageContext.request.contextPath}/statics/plugins/bootstrap-slider/bootstrap-slider.js"></script>
<script
        src="${pageContext.request.contextPath}/statics/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.min.js"></script>

<script type="">
    $(document).ready(function() {
        // 选择框
        $(".select2").select2();

        // WYSIHTML5编辑器
        $(".textarea").wysihtml5({
            locale : 'zh-CN'
        });
    });

    // 设置激活菜单
    function setSidebarActive(tagUri) {
        var liObj = $("#" + tagUri);
        if (liObj.length > 0) {
            liObj.parent().parent().addClass("active");
            liObj.addClass("active");
        }
    }

    $(document).ready(function() {
        $('#datepicker-a3').datetimepicker({
            format : "yyyy-mm-dd hh:ii",
            autoclose : true,
            todayBtn : true,
            language : "zh-CN"
        });
    });

    $(document).ready(function() {
        // 激活导航位置
        setSidebarActive("order-manage");
        $("#datepicker-a3").datetimepicker({
            format : "yyyy-mm-dd hh:ii",

        });

    });
</script>


</body>

</html>
