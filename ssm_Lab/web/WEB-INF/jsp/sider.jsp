<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- Sidebar user panel -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="${pageContext.request.contextPath}/statics/img/user1-128x128.jpg" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <p>Nolva</p>
                <a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
            </div>
        </div>
        <ul class="sidebar-menu">
            <li class="header">菜单</li>

            <li id="admin-index"><a href="${pageContext.request.contextPath}/dashboard"><i
                    class="fa fa-dashboard"></i> <span>首页</span></a></li>

            <!-- 菜单 -->
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-folder"></i> <span>系统管理</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>


                </a>
                <ul class="treeview-menu">

                    <li id="admin-login">
                        <a href="${pageContext.request.contextPath}/user/findAll">
                            <i class="fa fa-circle-o"></i> 用户管理
                        </a>
                    </li>

                    <li id="admin-register">
                        <a href="${pageContext.request.contextPath}/role/findAll">
                            <i class="fa fa-circle-o"></i> 角色管理
                        </a>
                    </li>

                    <li id="admin-404">
                        <a href="${pageContext.request.contextPath}/permission/findAll">
                            <i class="fa fa-circle-o"></i> 资源权限管理
                        </a>
                    </li>

                    <li id="admin-500">
                        <a href="${pageContext.request.contextPath}/sysLog/findAll">
                            <i class="fa fa-circle-o"></i> 访问日志
                        </a>
                    </li>

                    <li id="admin-profile">
                        <a href="${pageContext.request.contextPath}/user/UserInfo">
                            <i class="fa fa-circle-o"></i> 个人中心
                        </a>
                    </li>

                </ul>
            </li>

            <li class="treeview">
                <a href="#">
                    <i class="fa fa-pie-chart"></i> <span>基础数据</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                <ul class="treeview-menu">

                    <li id="产品管理">
                        <a href="${pageContext.request.contextPath}/product/findAll">
                            <i class="fa fa-circle-o"></i> 产品管理
                        </a>
                    </li>

                    <li id="订单管理">
                        <a href="${pageContext.request.contextPath}/indent/findAll">
                            <i class="fa fa-circle-o"></i> 订单管理
                        </a>
                    </li>

                    <li id="员工管理">
                        <a href="${pageContext.request.contextPath}/staff/findAll">
                            <i class="fa fa-circle-o"></i> 员工管理
                        </a>
                    </li>

                    <li id="客户管理">
                        <a href="${pageContext.request.contextPath}/customer/findAll">
                            <i class="fa fa-circle-o"></i> 客户管理
                        </a>
                    </li>

                    <li id="部门管理">
                        <a href="${pageContext.request.contextPath}/department/findAll">
                            <i class="fa fa-circle-o"></i> 部门管理
                        </a>
                    </li>

                    <li id="职位管理">
                        <a href="${pageContext.request.contextPath}/position/findAll">
                            <i class="fa fa-circle-o"></i> 职位管理
                        </a>
                    </li>
                </ul>
            </li>

            <li class="treeview">
                <a href="#">
                    <i class="fa fa-pie-chart"></i> <span>神奇管理</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                <ul class="treeview-menu">

                    <%--<li id="客户管理">--%>
                        <%--<a href="${pageContext.request.contextPath}/customer/findAll">--%>
                            <%--<i class="fa fa-circle-o"></i> 客户管理--%>
                        <%--</a>--%>
                    <%--</li>--%>
                </ul>
            </li>

            <!-- 菜单 /-->

        </ul>
    </section>
    <!-- /.sidebar -->
</aside>