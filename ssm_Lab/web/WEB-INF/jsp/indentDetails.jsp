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

<body class="hold-transition skin-blue sidebar-mini">

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
                订单管理 <small>全部订单</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="${pageContext.request.contextPath}/dashboard"><i
                        class="fa fa-dashboard"></i> 首页</a></li>
                <li><a href="${pageContext.request.contextPath}/indent/findAll">订单管理</a></li>
                <li class="active">订单详情</li>
            </ol>
        </section>
        <!-- 内容头部 /-->

        <!-- 正文区域 -->
        <section class="content"> <!--订单信息-->
            <div class="panel panel-default">
                <div class="panel-heading">订单信息</div>
                <div class="row data-type">

                    <div class="col-md-2 title">订单编号</div>
                    <div class="col-md-4 data">
                        <input type="text" class="form-control" placeholder="订单编号"
                               value="${indent.indentNum }" readonly="readonly">
                    </div>

                    <div class="col-md-2 title">订单产品数</div>
                    <div class="col-md-4 data">
                        <input type="text" class="form-control" placeholder="订单产品数"
                               value="${indent.totalNumber }" readonly="readonly">
                    </div>

                    <div class="col-md-2 title">收货人</div>
                    <div class="col-md-4 data">
                        <input type="text" class="form-control" placeholder="收货人"
                               value="${indent.receiver }" readonly="readonly">
                    </div>

                    <div class="col-md-2 title">电话号码</div>
                    <div class="col-md-4 data">
                        <input type="text" class="form-control" placeholder="电话号码"
                               value="${indent.mobile }" readonly="readonly">
                    </div>

                    <div class="col-md-2 title">地址</div>
                    <div class="col-md-4 data">
                        <input type="text" class="form-control" placeholder="地址"
                               value="${indent.address }" readonly="readonly">
                    </div>

                    <div class="col-md-2 title">创建时间</div>
                    <div class="col-md-4 data">
                        <div class="input-group date">
                            <div class="input-group-addon">
                                <i class="fa fa-calendar"></i>
                            </div>
                            <label for="datepicker-a3"></label><input type="text" class="form-control pull-right"
                                                                      id="datepicker-a3" readonly="readonly"
                                                                      value="${indent.createTimeStr}">
                        </div>
                    </div>

                    <div class="col-md-2 title">支付时间</div>
                    <div class="col-md-4 data">
                        <div class="input-group date">
                            <div class="input-group-addon">
                                <i class="fa fa-calendar"></i>
                            </div>
                            <label for="datepicker-a6"></label><input type="text" class="form-control pull-right"
                                                                      id="datepicker-a6" value="${indent.payTimeStr}"
                                                                      readonly="readonly">
                        </div>
                    </div>

                    <div class="col-md-2 title">支付时间</div>
                    <div class="col-md-4 data">
                        <div class="input-group date">
                            <div class="input-group-addon">
                                <i class="fa fa-calendar"></i>
                            </div>
                            <label for="datepicker-a9"></label><input type="text" class="form-control pull-right"
                                                                      id="datepicker-a9" value="${indent.deliveryTimeStr}"
                                                                      readonly="readonly">
                        </div>
                    </div>

                    <div class="col-md-2 title">确认收货时间</div>
                    <div class="col-md-4 data">
                        <div class="input-group date">
                            <div class="input-group-addon">
                                <i class="fa fa-calendar"></i>
                            </div>
                            <label for="datepicker-a11"></label><input type="text" class="form-control pull-right"
                                                                      id="datepicker-a11" value="${indent.confirmTimeStr}"
                                                                      readonly="readonly">
                        </div>
                    </div>

                    <div class="col-md-2 title">订单状态</div>
                    <div class="col-md-4 data">
                        <input type="text" class="form-control" placeholder="订单状态"
                               value="${indent.indentStatusStr }" readonly="readonly">
                    </div>
                    <div class="col-md-2 title rowHeight2x">订单描述</div>
                    <div class="col-md-10 data rowHeight2x">
						<textarea class="form-control" rows="3" placeholder="订单描述">
                            ${indent.indentDesc }
                        </textarea>
                    </div>

                </div>
            </div>
            <!--订单信息/--> <!--游客信息-->
            <div class="panel panel-default">
                <div class="panel-heading">产品信息</div>
                <!--数据列表-->
                <table id="dataList"
                       class="table table-bordered table-striped table-hover dataTable">
                    <thead>
                    <tr>
                        <th class="">产品编号</th>
                        <th class="">产品名称</th>
                        <th class="">分类名称</th>
                        <th class="">生产时间</th>
                        <th class="">产品价格</th>
                        <th class="">产品库存</th>
                        <th class="">产品描述</th>
                        <th class="">产品状态</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="indentItem" items="${indent.indentItems}">

                        <tr>
                            <td>${indentItem.product.productNum}</td>
                            <td><label>
                                <input type="text" size="15" value="${indentItem.product.productName }"
                                           readonly="readonly">
                            </label></td>
                            <td><label>
                                <input type="text" size="10" value="${indentItem.product.category.categoryName }"
                                           readonly="readonly">
                            </label></td>
                            <td><label>
                                <input type="text" size="20"
                                           value="${indentItem.product.createTimeStr }" readonly="readonly">
                            </label></td>
                            <td><label>
                                <input type="text" size="5"
                                           value="${indentItem.product.productPrice}" readonly="readonly">
                            </label></td>
                            <td><label>
                                <input type="text" size="5"
                                           value="${indentItem.product.stock }" readonly="readonly">
                            </label></td>
                            <td><label>
                                <input type="text" size="15"
                                           value="${indentItem.product.productDesc }" readonly="readonly">
                            </label></td>
                            <td><label>
                                <input type="text" size="5"
                                           value="${indentItem.product.productStatusStr }" readonly="readonly">
                            </label></td>
                        </tr>
                    </c:forEach>


                    </tbody>
                </table>
                <!--数据列表/-->
            </div>
            <!--游客信息/--> <!--联系人信息-->
            <div class="panel panel-default">
                <div class="panel-heading">客户信息</div>
                <div class="row data-type">

                    <div class="col-md-2 title">客户姓名</div>
                    <div class="col-md-4 data text">${indent.customer.customerName }</div>

                    <div class="col-md-2 title">客户性别</div>
                    <div class="col-md-4 data text">${indent.customer.sex}</div>

                    <div class="col-md-2 title">电话号码</div>
                    <div class="col-md-4 data text">${indent.customer.phoneNum}</div>

                    <div class="col-md-2 title">证件类型</div>
                    <div class="col-md-4 data text">${indent.customer.credentialsTypeStr}</div>

                    <div class="col-md-2 title">证件号码</div>
                    <div class="col-md-4 data text">${indent.customer.credentialsNum}</div>

                    <div class="col-md-2 title">客户类型</div>
                    <div class="col-md-4 data text">${indent.customer.customerTypeStr}</div>


                </div>
            </div>
            <!--联系人信息/--> <!--费用信息--> <c:if test="${indent.indentStatus == 1}">
                <div class="panel panel-default">
                    <div class="panel-heading">费用信息</div>
                    <div class="row data-type">

                        <div class="col-md-2 title">支付方式</div>
                        <div class="col-md-4 data text">在线支付-${indent.payTypeStr}</div>

                        <div class="col-md-2 title">订单总金额</div>
                        <div class="col-md-4 data text">￥${indent.totalAmount}</div>

                    </div>
                </div>
            </c:if> <!--费用信息/--> <!--工具栏-->
            <div class="box-tools text-center">

                <button type="button" class="btn bg-default"
                        onclick="history.back(-1);">返回</button>
            </div>
            <!--工具栏/--> </section>
        <!-- 正文区域 /-->


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

        // 激活导航位置
        setSidebarActive("order-manage");

        // 列表按钮
        $("#dataList td input[type='checkbox']").iCheck({
            checkboxClass : 'icheckbox_square-blue',
            increaseArea : '20%'
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
</script>
</body>


</html>