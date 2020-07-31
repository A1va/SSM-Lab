<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <!-- @@master = admin-layout.html-->
    <!-- @@block = content -->

    <div class="content-wrapper">

        <!-- 内容头部 -->
        <section class="content-header">
            <h1>
                用户管理
                <small>用户详情</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="${pageContext.request.contextPath}/dashboard"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li><a href="${pageContext.request.contextPath}/user/findAll">用户管理</a></li>
                <li class="active">用户详情</li>
            </ol>
        </section>
        <!-- 内容头部 /-->

        <!-- 正文区域 -->
        <section class="content">

            <div class="box-body">

                <!--树表格-->
                <div class="tab-pane" id="tab-treetable">
                    <table id="collapse-table" class="table table-bordered table-hover dataTable">
                        <thead>
                        <tr>
                            <th>用户</th>
                            <th>描述</th>

                        </tr>
                        </thead>
                        <tr data-tt-id="0">
                            <td colspan="2">${user.username}</td>
                        </tr>
                        <tbody>
                        <c:forEach items="${user.roles}" var="role" varStatus="vs">
                            <tr data-tt-id="${vs.index+1}" data-tt-parent-id="0">
                                <td>${role.roleName}</td>
                                <td>${role.roleDesc}</td>
                            </tr>
                            <c:forEach items="${role.permissions}" var="permissions">
                                <tr data-tt-id="1-1" data-tt-parent-id="${vs.index+1}">
                                    <td>${permissions.permissionName}</td>
                                    <td>${permissions.url}</td>
                                </tr>
                            </c:forEach>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <!--树表格/-->
            </div>
            <div class="box-body">
                <div></div>
                <div class="panel panel-default">
                    <div class="panel-heading">用户信息</div>
                    <div class="row data-type">
                        <%-- 传ID --%>
                        <input type="hidden" name="id" value="${user.id}">

                        <div class="col-md-2 title">用户名称</div>
                        <div class="col-md-4 data">
                            <input type="text" class="form-control" name="username"
                                   placeholder="用户名称" value="${user.username}">
                        </div>
                        <div class="col-md-2 title">密码</div>
                        <div class="col-md-4 data">
                            <input type="text" class="form-control" name="password"
                                   placeholder="密码" value="${user.password}">
                        </div>
                        <div class="col-md-2 title">邮箱</div>
                        <div class="col-md-4 data">
                            <input type="text" class="form-control" name="email"
                                   placeholder="邮箱" value="${user.email}">
                        </div>
                        <div class="col-md-2 title">联系电话</div>
                        <div class="col-md-4 data">
                            <input type="text" class="form-control" name="phoneNum"
                                   placeholder="联系电话" value="${user.phoneNum}">
                        </div>
                        <div class="col-md-2 title">用户状态</div>
                        <div class="col-md-4 data">
                            <label>
                                <select class="form-control select2" style="width: 100%"
                                        name="status">
                                    <option value="1" selected>开启</option>
                                    <option value="0">关闭</option>
                                </select>
                            </label>
                        </div>
                    </div>

                </div>
                <!--订单信息/--> <!--工具栏-->
                <div class="box-tools text-center">
                    <button type="submit" class="btn bg-maroon">保存</button>
                    <button type="button" class="btn bg-default"
                            onclick="history.back(-1);">返回</button>
                </div>
            </div>

        </section>
        <!-- 正文区域 /-->

    </div>
    <!-- @@close -->
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
    $(document).ready(function () {
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


    $(document).ready(function () {

        // 颜色选取器
        $(".my-colorpicker1").colorpicker();
        $(".my-colorpicker2").colorpicker();

    });


    $(document).ready(function () {
        // 选择框
        $(".select2").select2();
    });


    $(document).ready(function () {

        //Date picker
        $('#datepicker').datepicker({
            autoclose: true,
            language: 'zh-CN'
        });

        // datetime picker
        $('#dateTimePicker').datetimepicker({
            format: "mm/dd/yyyy - hh:ii",
            autoclose: true,
            todayBtn: true,
            language: 'zh-CN'
        });

        //Date range picker
        $('#reservation').daterangepicker({
            locale: {
                applyLabel: '确认',
                cancelLabel: '取消',
                fromLabel: '起始时间',
                toLabel: '结束时间',
                customRangeLabel: '自定义',
                firstDay: 1
            },
            opens: 'left', // 日期选择框的弹出位置
            separator: ' 至 '
            //showWeekNumbers : true,     // 是否显示第几周
        });

        //Date range picker with time picker
        $('#reservationtime').daterangepicker({
            timePicker: true,
            timePickerIncrement: 30,
            format: 'MM/DD/YYYY h:mm A',
            locale: {
                applyLabel: '确认',
                cancelLabel: '取消',
                fromLabel: '起始时间',
                toLabel: '结束时间',
                customRangeLabel: '自定义',
                firstDay: 1
            },
            opens: 'right', // 日期选择框的弹出位置
            separator: ' 至 '
        });

        //Date range as a button
        $('#daterange-btn').daterangepicker({
                locale: {
                    applyLabel: '确认',
                    cancelLabel: '取消',
                    fromLabel: '起始时间',
                    toLabel: '结束时间',
                    customRangeLabel: '自定义',
                    firstDay: 1
                },
                opens: 'right', // 日期选择框的弹出位置
                separator: ' 至 ',
                ranges: {
                    '今日': [moment(), moment()],
                    '昨日': [moment().subtract(1, 'days'), moment().subtract(1, 'days')],
                    '最近7日': [moment().subtract(6, 'days'), moment()],
                    '最近30日': [moment().subtract(29, 'days'), moment()],
                    '本月': [moment().startOf('month'), moment().endOf('month')],
                    '上个月': [moment().subtract(1, 'month').startOf('month'), moment().subtract(1, 'month').endOf('month')]
                },
                startDate: moment().subtract(29, 'days'),
                endDate: moment()
            },
            function (start, end) {
                $('#daterange-btn span').html(start.format('MMMM D, YYYY') + ' - ' + end.format('MMMM D, YYYY'));
            }
        );

    });


    $(document).ready(function () {

        /*table tree*/
        $("#collapse-table").treetable({
            expandable: true
        });

    });


    $(document).ready(function () {

        CKEDITOR.replace('editor1');

        // $(".textarea").wysihtml5({
        //     locale:'zh-CN'
        // });

        $("#markdown-textarea").markdown({
            language: 'zh',
            autofocus: false,
            savable: false
        });

    });


    $(document).ready(function () {

        // 激活导航位置
        setSidebarActive("admin-dataform");

    });
</script>
</body>

</html>
