<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <!-- 页面meta -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <title>海信企业信息管理系统</title>
    <meta name="description" content="海信企业信息管理系统">
    <meta name="keywords" content="海信企业信息管理系统">

    <meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">

    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

    <!-- bootstrap-datetimepicker -->
    <!-- 页面meta /-->

    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/plugins/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/plugins/ionicons/css/ionicons.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/plugins/iCheck/square/blue.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/plugins/morris/morris.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/plugins/datepicker/datepicker3.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/plugins/daterangepicker/daterangepicker.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/plugins/datatables/dataTables.bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/plugins/treeTable/jquery.treetable.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/plugins/treeTable/jquery.treetable.theme.default.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/plugins/select2/select2.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/plugins/colorpicker/bootstrap-colorpicker.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/plugins/bootstrap-markdown/css/bootstrap-markdown.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/plugins/adminLTE/css/AdminLTE.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/plugins/adminLTE/css/skins/_all-skins.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/plugins/ionslider/ion.rangeSlider.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/plugins/ionslider/ion.rangeSlider.skinNice.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/plugins/bootstrap-slider/slider.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.css">
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
                用户管理 <small>添加角色表单</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="${pageContext.request.contextPath}/dashboard"><i
                        class="fa fa-dashboard"></i> 首页</a></li>
                <li><a
                        href="${pageContext.request.contextPath}/user/findAll">用户管理</a></li>
                <li class="active">添加角色表单</li>
            </ol>
        </section>
        <!-- 内容头部 /-->

        <form
                action="${pageContext.request.contextPath}/user/addRoleToUser"
                method="post">
            <!-- 正文区域 -->
            <section class="content">

                <input type="hidden" name="userId" value="${user.id}">

                <table id="dataList"
                       class="table table-bordered table-striped table-hover dataTable">
                    <thead>
                    <tr>
                        <th class="" style="padding-right: 0">
                            <label for="selall"></label><input id="selall"
                                                               type="checkbox" class="icheckbox_square-blue"></th>
                        <th class="sorting_asc">ID</th>
                        <th class="sorting">角色名称</th>
                        <th class="sorting">角色描述</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${roleList}" var="role">
                        <tr>
                            <td>

                                <label>
                                    <input name="ids" type="checkbox" value="${role.id}">
                                </label>

                            </td>
                            <td>${role.id}</td>
                            <td>${role.roleName }</td>
                            <td>${role.roleDesc}</td>

                        </tr>
                    </c:forEach>
                    </tbody>

                </table>
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


<script src="${pageContext.request.contextPath}/statics/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script src="${pageContext.request.contextPath}/statics/plugins/jQueryUI/jquery-ui.min.js"></script>
<script>
    $.widget.bridge('uibutton', $.ui.button);
</script>
<script src="${pageContext.request.contextPath}/statics/plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/statics/plugins/raphael/raphael-min.js"></script>
<script src="${pageContext.request.contextPath}/statics/plugins/morris/morris.min.js"></script>
<script src="${pageContext.request.contextPath}/statics/plugins/sparkline/jquery.sparkline.min.js"></script>
<script src="${pageContext.request.contextPath}/statics/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script src="${pageContext.request.contextPath}/statics/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<script src="${pageContext.request.contextPath}/statics/plugins/knob/jquery.knob.js"></script>
<script src="${pageContext.request.contextPath}/statics/plugins/daterangepicker/moment.min.js"></script>
<script src="${pageContext.request.contextPath}/statics/plugins/daterangepicker/daterangepicker.js"></script>
<script src="${pageContext.request.contextPath}/statics/plugins/daterangepicker/daterangepicker.zh-CN.js"></script>
<script src="${pageContext.request.contextPath}/statics/plugins/datepicker/bootstrap-datepicker.js"></script>
<script src="${pageContext.request.contextPath}/statics/plugins/datepicker/locales/bootstrap-datepicker.zh-CN.js"></script>
<script src="${pageContext.request.contextPath}/statics/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<script src="${pageContext.request.contextPath}/statics/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<script src="${pageContext.request.contextPath}/statics/plugins/fastclick/fastclick.js"></script>
<script src="${pageContext.request.contextPath}/statics/plugins/iCheck/icheck.min.js"></script>
<script src="${pageContext.request.contextPath}/statics/plugins/adminLTE/js/app.min.js"></script>
<script src="${pageContext.request.contextPath}/statics/plugins/treeTable/jquery.treetable.js"></script>
<script src="${pageContext.request.contextPath}/statics/plugins/select2/select2.full.min.js"></script>
<script src="${pageContext.request.contextPath}/statics/plugins/colorpicker/bootstrap-colorpicker.min.js"></script>
<script src="${pageContext.request.contextPath}/statics/plugins/bootstrap-wysihtml5/bootstrap-wysihtml5.zh-CN.js"></script>
<script src="${pageContext.request.contextPath}/statics/plugins/bootstrap-markdown/js/bootstrap-markdown.js"></script>
<script src="${pageContext.request.contextPath}/statics/plugins/bootstrap-markdown/locale/bootstrap-markdown.zh.js"></script>
<script src="${pageContext.request.contextPath}/statics/plugins/bootstrap-markdown/js/markdown.js"></script>
<script src="${pageContext.request.contextPath}/statics/plugins/bootstrap-markdown/js/to-markdown.js"></script>
<script src="${pageContext.request.contextPath}/statics/plugins/ckeditor/ckeditor.js"></script>
<script src="${pageContext.request.contextPath}/statics/plugins/input-mask/jquery.inputmask.js"></script>
<script src="${pageContext.request.contextPath}/statics/plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
<script src="${pageContext.request.contextPath}/statics/plugins/input-mask/jquery.inputmask.extensions.js"></script>
<script src="${pageContext.request.contextPath}/statics/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="${pageContext.request.contextPath}/statics/plugins/datatables/dataTables.bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/statics/plugins/chartjs/Chart.min.js"></script>
<script src="${pageContext.request.contextPath}/statics/plugins/flot/jquery.flot.min.js"></script>
<script src="${pageContext.request.contextPath}/statics/plugins/flot/jquery.flot.resize.min.js"></script>
<script src="${pageContext.request.contextPath}/statics/plugins/flot/jquery.flot.pie.min.js"></script>
<script src="${pageContext.request.contextPath}/statics/plugins/flot/jquery.flot.categories.min.js"></script>
<script src="${pageContext.request.contextPath}/statics/plugins/ionslider/ion.rangeSlider.min.js"></script>
<script src="${pageContext.request.contextPath}/statics/plugins/bootstrap-slider/bootstrap-slider.js"></script>
<script src="${pageContext.request.contextPath}/statics/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.js"></script>
<script src="${pageContext.request.contextPath}/statics/plugins/bootstrap-datetimepicker/locales/bootstrap-datetimepicker.zh-CN.js"></script>
<script>
    $(document).ready(function() {
        // 选择框
        $(".select2").select2();

        // WYSIHTML5编辑器
        $(".textarea").wysihtml5({
            locale: 'zh-CN'
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

        // 激活导航位置
        setSidebarActive("admin-datalist");

        // 列表按钮
        $("#dataList td input[type='checkbox']").iCheck({
            checkboxClass: 'icheckbox_square-blue',
            increaseArea: '20%'
        });
        // 全选操作
        $("#selall").click(function() {
            var clicks = $(this).is(':checked');
            if (!clicks) {
                $("#dataList td input[type='checkbox']").iCheck("uncheck");
            } else {
                $("#dataList td input[type='checkbox']").iCheck("check");
            }
            $(this).data("clicks", !clicks);
        });
    });
    // $(document).ready(function() {
    //     // 选择框
    //     $(".select2").select2();
    //
    //     // WYSIHTML5编辑器
    //     $(".textarea").wysihtml5({
    //         locale : 'zh-CN'
    //     });
    //     // 全选操作
    //     $("#selall").click(function() {
    //         var clicks = $(this).is(':checked');
    //         if (!clicks) {
    //             $("#dataList td input[type='checkbox']").iCheck("uncheck");
    //         } else {
    //             $("#dataList td input[type='checkbox']").iCheck("check");
    //         }
    //         $(this).data("clicks", !clicks);
    //     });
    // });

    // 设置激活菜单
    function setSidebarActive(tagUri) {
        var liObj = $("#" + tagUri);
        if (liObj.length > 0) {
            liObj.parent().parent().addClass("active");
            liObj.addClass("active");
        }
    }
</script>


</body>

</html>