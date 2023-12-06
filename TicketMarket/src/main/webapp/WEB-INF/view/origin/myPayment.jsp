<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
        
        <link href="./css/myPayment.css" rel="stylesheet" type="text/css" />
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
                                    <h4 class="mb-sm-0">결제내역</h4>
                                    <div class="page-title-right">
                                        <ol class="breadcrumb m-0">
                                            <li class="breadcrumb-item"><a href="javascript: void(0);">마이페이지</a></li>
                                            <li class="breadcrumb-item active">결제내역</li>
                                        </ol>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- /현재 메뉴 -->
                       	${payment}
                       	<div>
                       		<div id="dateSelector">
							    <button type="button" class="btn btn-soft-write">최근 6개월</button>
							    <button type="button" class="btn btn-soft-write">2023년</button>
							    <button type="button" class="btn btn-soft-write">2022년</button>
							    <button type="button" class="btn btn-soft-write">2021년</button>
							</div>
                       	</div>
						<table class="table table-nowrap">
						    <thead>
						        <tr>
						            <th scope="col">번호</th>
						            <th scope="col">예매번호</th>
						            <th scope="col">결제일시</th>
						            <th scope="col">결제금액</th>
						            <th scope="col">상세보기</th>
						        </tr>
						    </thead>
						    <tbody>
						        <tr>
						            <th scope="row"><a href="#" class="fw-semibold">#VZ2110</a></th>
						            <td>Bobby Davis</td>
						            <td>October 15, 2021</td>
						            <td>$2,300</td>
						            <td><a href="javascript:void(0);" class="link-success">View More <i class="ri-arrow-right-line align-middle"></i></a></td>
						        </tr>
						    </tbody>
						</table>
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
        <script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/handlebars@latest/dist/handlebars.js"></script>
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