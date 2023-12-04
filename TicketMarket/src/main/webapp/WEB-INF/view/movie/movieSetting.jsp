<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
    </head>
    <body style="padding-top: 150px;">
    
	<!-- 메뉴바 -->
	<%@include file="../layouts/_menubar.jsp" %>
	<!-- /메뉴바 -->
        <div id="layout-wrapper">
            <!-- ============================================================== -->
            <div class="main-content">
                <div class="page-content" style="display: flex">
                	<!-- 컨텐츠 내용 -->

                    <div class="row col-sm-6">
                        <div class="col-sm-12 stretch-card">
                            <div class="card">
                                <div class="card-body">
                                    <h4 class="card-title">영화 추가 (*Admin)</h4>
                                    <p class="card-description">
                                    </p>
                                    <div class="table-responsive">
                                        <table class="table">
                                            <thead>
                                            <tr>
                                                <th>Select</th>
                                                <th>movieImg</th>
                                                <th>movieTitle</th>
                                                <th>movieId</th>
                                                <th>movieRate</th>
                                                <th>movieOpenDate</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <c:forEach var="cgv" items="${cgvList}">
                                                <tr>
                                                    <td><input type="checkbox" class="form-check-input idSelect" value="${cgv.movieId}"></td>
                                                    <td><img src="${cgv.img}" width="80px" height="100px"></td>
                                                    <td>${cgv.movieTitle}</td>
                                                    <td>${cgv.movieId}</td>
                                                    <td>${cgv.movieRate}</td>
                                                    <td>${cgv.movieOpenDate}</td>
                                                </tr>
                                            </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row col-sm-6" >
                        <div class="col-sm-12 stretch-card">
                            <div class="card">
                                <div class="card-body">
                                    <form id="movieForm" action="${pageContext.request.contextPath}/addMoive.do" method="get" accept-charset="UTF-8">
                                    <h4 class="card-title">추가할 영화<button type="submit" id="add">추가하기</button></h4>
                                    <p class="card-description">
                                    </p>
                                    <div class="table-responsive">
                                        <table class="table">
                                            <thead>
                                            <tr>
                                                <th>movieImg</th>
                                                <th>movieTitle</th>
                                                <th>movieId</th>
                                                <th>movieRate</th>
                                                <th>movieOpenDate</th>
                                            </tr>
                                            </thead>
                                            <tbody id="addTableBody">
                                                <tr>
                                                    <!--셀렉트한것만 추가 -->
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                    </form>
                                </div>
                            </div>
                        </div>
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

    <script>
        document.addEventListener('DOMContentLoaded', function () {
            var selectCheckboxes = document.querySelectorAll('.idSelect');
            var addTableBody = document.getElementById('addTableBody');

            selectCheckboxes.forEach(function (checkbox) {
                checkbox.addEventListener('change', function () {
                    var row = checkbox.closest('tr');
                    var movieInfo = {
                        movieId: row.querySelector('td:nth-child(4)').textContent
                    };

                    // 체크가 되어 있으면 리스트에 추가, 해제되어 있으면 리스트에서 제거
                    if (checkbox.checked) {
                        // 선택된 영화를 추가
                        var newRow = addTableBody.insertRow();
                        var imgCell = newRow.insertCell(0);
                        var titleCell = newRow.insertCell(1);
                        var idCell = newRow.insertCell(2);
                        var rateCell = newRow.insertCell(3);
                        var openDateCell = newRow.insertCell(4);

                        imgCell.innerHTML = '<img src="' + row.querySelector('td:nth-child(2) img').src + '" width="80px" height="100px">';
                        titleCell.textContent = row.querySelector('td:nth-child(3)').textContent;
                        idCell.textContent = movieInfo.movieId;
                        idCell.valueOf()
                        rateCell.textContent = row.querySelector('td:nth-child(5)').textContent;
                        openDateCell.textContent = row.querySelector('td:nth-child(6)').textContent;

                        // 폼에 추가된 영화 정보를 숨은 필드로 추가
                        var hiddenInput = document.createElement('input');
                        hiddenInput.type = 'hidden';
                        hiddenInput.name = 'selectedMovies';
                        hiddenInput.value = JSON.stringify(movieInfo);
                        movieForm.appendChild(hiddenInput);
                    } else {
                        // 체크가 해제되면 리스트에서 해당 영화를 삭제
                        var rows = addTableBody.getElementsByTagName('tr');
                        for (var i = 0; i < rows.length; i++) {
                            var cells = rows[i].getElementsByTagName('td');
                            if (cells.length > 0 && cells[2].textContent === movieInfo.movieId) {
                                addTableBody.deleteRow(i);
                                break;
                            }
                        }
                    }
                });
            });
        });
    </script>

</html>