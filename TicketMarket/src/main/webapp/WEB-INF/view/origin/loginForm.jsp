<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en" data-layout="horizontal" data-topbar="light" data-sidebar="light" data-sidebar-size="sm-hover" data-sidebar-image="none" 
data-preloader="disable" data-bs-theme="light" data-layout-width="boxed" data-layout-position="fixed" data-layout-style="default">

    <head>
        <meta charset="UTF-8" />
        <title>LoremTheater</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- App favicon -->
        <link rel="shortcut icon" href="../assets/images/favicon.ico">

        <!-- jsvectormap css -->
        <link href="../assets/libs/jsvectormap/css/jsvectormap.min.css" rel="stylesheet" type="text/css" />

        <!--Swiper slider css-->
        <link href="../assets/libs/swiper/swiper-bundle.min.css" rel="stylesheet" type="text/css" />

        <!-- Layout config Js -->
        <script src="../assets/js/layout.js"></script>
        <!-- Bootstrap Css -->
        <link href="../assets/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <!-- Icons Css -->
        <link href="../assets/css/icons.min.css" rel="stylesheet" type="text/css" />
        <!-- App Css-->
        <link href="../assets/css/app.min.css" rel="stylesheet" type="text/css" />
        <!-- custom Css-->
        <link href="../assets/css/custom.min.css" rel="stylesheet" type="text/css" />
        <style type="text/css">
        	#loginForm{
        		width: 40%;
        	}
        </style>
    </head>
    <body style="padding-top: 150px;">
    
	<!-- 메뉴바 -->
	<%@include file="../layouts/_menubar.jsp" %>
	<!-- /메뉴바 -->
        <div id="layout-wrapper">
            <!-- ============================================================== -->
            <div class="main-content">
                <div class="page-content">
                	<!-- 컨텐츠 내용 -->
                    <div class="container-fluid">
                        <!-- 현재 메뉴 -->
                        <div class="row">
                            <div class="col-12">
                                <div class="page-title-box d-sm-flex align-items-center justify-content-between">
                                    <h4 class="mb-sm-0">Home</h4>
                                    <div class="page-title-right">
                                        <ol class="breadcrumb m-0">
                                            <li class="breadcrumb-item"><a href="javascript: void(0);">Home</a></li>
                                            <li class="breadcrumb-item active">Home</li>
                                        </ol>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- /현재 메뉴 -->
                        <!-- 로그인폼 -->
                        <div id="loginForm">
                        	<form action="/auth" method="post">
								<input type="text" class="form-control" id="user_id" placeholder="User ID">
								<input type="password" class="form-control" id="user_pw" placeholder="Password">
	                        	<input type="submit" class="form-control" id="submitBtn" value="Login">
	                        </form>
						</div>
						<!-- /로그인폼 -->
                    </div>
                    <!-- /컨텐츠 내용 -->
                </div>
                <!-- End Page-content -->

                <footer class="footer">
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-sm-6">
                                <div class="text-sm-end d-none d-sm-block">
                                    Design & Develop by Themesbrand
                                </div>
                            </div>
                        </div>
                    </div>
                </footer>
            </div>
            <!-- end main content-->
        </div>
        <!-- END layout-wrapper -->
        

        <!-- JAVASCRIPT -->
        <script src="./assets/libs/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="./assets/libs/simplebar/simplebar.min.js"></script>
        <script src="./assets/js/pages/plugins/lord-icon-2.1.0.js"></script>
        <script src="./assets/js/plugins.js"></script>

        <!-- apexcharts -->
        <script src="./assets/libs/apexcharts/apexcharts.min.js"></script>

        <!--Swiper slider js-->
        <script src="./assets/libs/swiper/swiper-bundle.min.js"></script>

        <!-- Dashboard init -->
        <script src="./assets/js/pages/dashboard.init.js"></script>

        <!-- App js -->
        <script src="./assets/js/app.js"></script>
    </body>

</html>