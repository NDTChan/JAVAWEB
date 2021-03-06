<%@page contentType="text/html" pageEncoding="UTF-8" %>
<aside class="main-sidebar">

    <section class="sidebar">

      <!-- Sidebar user panel (optional) -->
      <div class="user-panel">
        <div class="pull-left image">
          <img src="${pageContext.request.contextPath}/resources/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
        </div>
        <div class="pull-left info">
          <p>${username}</p>
          <!-- Status -->
          <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
        </div>
      </div>

      <form action="#" method="get" class="sidebar-form">
        <div class="input-group">
          <input type="text" name="q" class="form-control" placeholder="Search...">
          <span class="input-group-btn">
              <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
              </button>
            </span>
        </div>
      </form>
      <ul class="sidebar-menu" data-widget="tree">
        <li class="header">Menu</li>
<!--         <li class="active"><a href="#"><i class="fa fa-link"></i> </a></li> -->
<!--         <li><a href="#"><i class="fa fa-link"></i> <span>Another Link</span></a></li> -->
        <li class="treeview">
          <a href="#"><i class="fa fa-link"></i> <span>Hệ thống danh mục</span>
            <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
              </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="${pageContext.request.contextPath}/admin/donvitinh">Đơn vị tính</a></li>
            <li><a href="${pageContext.request.contextPath}/admin/loaivattu">Loại vật tư</a></li>
            <li><a href="${pageContext.request.contextPath}/admin/nhomvattu">Nhóm vật tư</a></li>
            <li><a href="${pageContext.request.contextPath}/admin/vattu">Vật tư</a></li>
            <li><a href="${pageContext.request.contextPath}/admin/khachhang">Khách hàng</a></li>
            <li><a href="${pageContext.request.contextPath}/admin/nhacungcap">Nhà cung cấp</a></li>
          </ul>
        </li>
        <li class="treeview">
          <a href="#"><i class="fa fa-link"></i> <span>Hệ thống nghiệp vụ</span>
            <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
              </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="${pageContext.request.contextPath}/admin/nhapmua">Nhập mua</a></li>
            <li><a href="${pageContext.request.contextPath}/admin/xuatban">Xuất bán</a></li>
          </ul>
        </li>
      </ul>
      <!-- /.sidebar-menu -->
    </section>
    <!-- /.sidebar -->
  </aside>