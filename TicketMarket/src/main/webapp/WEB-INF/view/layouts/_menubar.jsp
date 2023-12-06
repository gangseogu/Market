<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 로그, 메뉴 , 알림 ,검색, 로그인 등등 -->
<div class="app-menu navbar-menu">
                <div class="container-fluid">
                	<div class="col">
                    <!-- 로고,로그인 등등 시작 -->
                    <div class="col-sm-12 border-bottom border-5 border-primary">
	                    <div class="d-flex mb-3 align-items-end">
		                    <div class="navbar-brand-box flex-fill">
		                        <a href="index.html" class="float-start" style="height: 100%">
	                                <img src="./images/TFT.png" style="height: 126px">
	                                <span class="display-5 align-bottom">LoremTheater</span>
		                        </a>
		                    </div>
		                    <div class="flex-fill">
		                    </div>
		                        <div class="d-flex ">
								<!-- 로그인 -->
									<div class="px-3 text-center">
										<a href="#">
											 <i class="fs-1 ri-lock-2-line"></i>
											 <br>
											 <span class="fs-9">로그인</span>
										</a>
									</div>
									<div class="px-3 text-center">
										<a href="#">
											 <i class="fs-1 ri-user-add-line"></i>
											 <br>
											 <span class="fs-9">회원가입</span>
										</a>
									</div>
									<div class="px-3 text-center">
										<a href="#">
											 <i class="fs-1 ri-user-line"></i>
											 <br>
											 <span class="fs-9">마이페이지</span>
										</a>
									</div>
									<div class="px-3 text-center">
										<a href="#">
											 <i class="fs-1  ri-customer-service-2-line"></i>
											 <br>
											 <span class="fs-9">고객센터</span>
										</a>
		                        </div>
		                    </div>
                    	</div>
                    </div>
                    <!-- 로고,로그인 등등 끝 -->
                   	<!-- 메뉴 -->
                    <div class="col-sm-12">
					<!-- 메뉴바 -->
					<nav class="navbar navbar-expand-lg  ">
					  <div class="container-fluid">
					    <div class="collapse navbar-collapse" id="navbarSupportedContent">
					      <!-- 왼쪽 -->
							<ul class="navbar-nav me-auto d-flex flex-row">
							<li class="menu-title"><span data-key="t-menu">Menu</span></li>
								<li class="nav-item visually-hidden">
                                </li>
								<!-- 메뉴 1개 -->
								<li class="nav-item">
                                    <a class="nav-link menu-link collapsed" href="#movie" role="button" aria-expanded="false" aria-controls="movie">
                                        <span data-key="t-apps">영화</span>
                                    </a>
                                    <div class="collapse menu-dropdown" id="movie">
                                        <ul class="nav nav-sm flex-column">
                                            <li class="nav-item">
                                                <a href="#" class="nav-link">무비차트 </a>
                                            </li>
                                            <li class="nav-item">
                                                <a href="#" class="nav-link">상영 예정작</a>
                                            </li>
                                        </ul>
                                    </div>
                                </li>
								<!-- /메뉴1개 -->
								<!-- 메뉴 1개 -->
								<li class="nav-item">
                                    <a class="nav-link menu-link collapsed" href="#theater" role="button" aria-expanded="false" aria-controls="theater">
                                        <span data-key="theater">극장</span>
                                    </a>
                                    <div class="collapse menu-dropdown" id="theater">
                                        <ul class="nav nav-sm flex-column">
                                            <li class="nav-item">
                                                <a href="#" class="nav-link">CGV </a>
                                            </li>
                                            <li class="nav-item">
                                                <a href="#" class="nav-link">롯데시네마</a>
                                            </li>
                                            <li class="nav-item">
                                                <a href="#" class="nav-link">메가박스</a>
                                            </li>
                                        </ul>
                                    </div>
                                </li>
								<!-- /메뉴1개 -->
								<!-- 메뉴 1개 -->
								<li class="nav-item">
                                    <a class="nav-link menu-link collapsed" href="#ticket" role="button" aria-expanded="false" aria-controls="ticket">
                                        <span data-key="ticket">예매</span>
                                    </a>
                                    <div class="collapse menu-dropdown" id="ticket">
                                        <ul class="nav nav-sm flex-column">
                                            <li class="nav-item">
                                                <a href="#" class="nav-link">빠른 예매</a>
                                            </li>
                                            <li class="nav-item">
                                                <a href="#" class="nav-link">상영 스케줄</a>
                                            </li>
                                        </ul>
                                    </div>
                                </li>
								<!-- /메뉴1개 -->
								<!-- 메뉴 1개 -->
								<li class="nav-item">
                                    <a class="nav-link menu-link collapsed" href="#store" role="button" aria-expanded="false" aria-controls="store">
                                        <span data-key="store">스토어</span>
                                    </a>
                                    <div class="collapse menu-dropdown" id="store">
                                        <ul class="nav nav-sm flex-column">
                                        	<li class="nav-item">
                                                <a href="./payment.do" class="nav-link">결제하기</a>
                                            </li>
                                            <li class="nav-item">
                                                <a href="./myPayment.do" class="nav-link">결제 내역</a>
                                            </li>
                                            <li class="nav-item">
                                                <a href="./myCoupon.do" class="nav-link">마일리지 내역</a>
                                            </li>
                                            <li class="nav-item">
                                                <a href="./myCoupon.do" class="nav-link">할인쿠폰 내역</a>
                                            </li>
                                        </ul>
                                    </div>
                                </li>
								<!-- /메뉴1개 -->
							</ul>
						<!-- /왼쪽 -->
						<!-- 검색창 -->
						      <form class="d-flex input-group w-auto ms-lg-3 my-3 my-lg-0">
						        <input type="search" class="form-control" placeholder="Search" aria-label="Search" />
							        <button class="btn btn-primary" type="button" >
							          Search
							        </button>
						      </form>
						    </div>
						  </div>
						</nav>
                    </div>
                	<!-- /메뉴 -->
                </div>
            </div>
         </div>
