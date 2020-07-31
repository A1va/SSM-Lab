<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- 页面头部 -->
<header class="main-header">
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <!-- Logo -->
    <a href="${pageContext.request.contextPath}/dashboard" class="logo">
        <!-- mini logo for sidebar mini 50x50 pixels -->
        <span class="logo-mini"><b>海信</b></span>
        <!-- logo for regular state and mobile devices -->
        <span class="logo-lg"><b>海信企业</b>后台管理</span>
    </a>


    <!-- Header Navbar: style can be found in header.less -->
    <nav class="navbar navbar-static-top">
        <!-- Sidebar toggle button-->
        <a href="${pageContext.request.contextPath}/dashboard" class="sidebar-toggle" data-toggle="offcanvas" role="button">
            <span class="sr-only">Toggle navigation</span>
        </a>

        <div class="navbar-custom-menu">
            <ul class="nav navbar-nav">


                <!-- User Account: style can be found in dropdown.less -->
                <li class="dropdown user user-menu">
                    <a href="${pageContext.request.contextPath}/dashboard" class="dropdown-toggle" data-toggle="dropdown">
                        <img src="${pageContext.request.contextPath}/statics/img/user1-128x128.jpg" class="user-image" alt="User Image">
                        <span class="hidden-xs"></span>
                    </a>
                    <ul class="dropdown-menu">
                        <!-- User image -->
                        <li class="user-header">
                            <img src="${pageContext.request.contextPath}/statics/img/user1-128x128.jpg" class="img-circle" alt="User Image">

                            <p>
                                Nolva - 后台管理员
                                <small>最后登录 11:20AM</small>
                            </p>
                        </li>
                        <!-- Menu Body
                <li class="user-body">
                    <div class="row">
                        <div class="col-xs-4 text-center">
                            <a href="#">Followers</a>
                        </div>
                        <div class="col-xs-4 text-center">
                            <a href="#">Sales</a>
                        </div>
                        <div class="col-xs-4 text-center">
                            <a href="#">Friends</a>
                        </div>
                    </div>
                </li>-->
                        <!-- Menu Footer-->
                        <li class="user-footer">
                            <div class="pull-left">
                                <a href="#" class="btn btn-default btn-flat">修改密码</a>
                            </div>
                            <div class="pull-right">
                                <a href="${pageContext.request.contextPath}/logout" class="btn btn-default btn-flat">注销</a>
                            </div>
                        </li>
                    </ul>
                </li>

            </ul>
        </div>
    </nav>
</header>
<!-- 页面头部 /-->