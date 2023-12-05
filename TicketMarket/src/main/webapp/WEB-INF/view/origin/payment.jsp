<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${payment}
	<table>
		<tr>
			<th>예약번호</th>
			<td id="reId">${reservation.get(0).reservationId }</td>
		</tr>
		<tr>
			<th>상품명</th>
			<td id="reName">${reservation.get(0).ticketName } ${reservation.size() }명</td>
		</tr>
		<tr>
			<th>좌석번호</th>
			<td>
				<c:forEach items="${reservation}" var="r" varStatus="i">
					${r.ticketColumn }${r.ticketRow }<c:if test="${i.last eq false}">, </c:if>
				</c:forEach>
			</td>
		</tr>
		<tr>
			<th>상영시간</th>
			<td>${reservation.get(0).startTime }</td>
		</tr>
		<tr>
			<th>총 가격</th>
			<td>
				<c:set var="total" value="0"/>
				<c:forEach items="${reservation }" var="r">
					<c:set var="total" value="${total+r.ticketPrice }"/>
				</c:forEach>
				<span><fmt:formatNumber value="${total }" type="currency" currencySymbol=""/></span> 원
				<span style="display:none;" id="rePrice"><c:out value="${total }"/></span>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<button onclick="requestPay()">결제하기</button>
			</td>
		</tr>
	</table>
</body>
<script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
<script src="https://cdn.iamport.kr/v1/iamport.js"></script>
<script type="text/javascript">
	var IMP = window.IMP;
	IMP.init("imp28750234");
	
	function requestPay() {
		IMP.request_pay(
			{
				pg: "html5_inicis.INIpayTest",
				pay_method: "card",
				// 주문번호 string
				merchant_uid: $("#reId").text(),
				// 상품명
				name: $("#reName").text(),
				// 결제금액 integer
				amount: Number($("#rePrice").text()),
				// 주문자
				buyer_name: "테스트 유저",
				// 주문자 전화번호 (필수)
				buyer_tel: "010-1234-5678",
			},
			rsp => {
				console.log(rsp);
		    	if (rsp.success) {   
					// axios로 HTTP 요청
					axios({
					url: "{서버의 결제 정보를 받는 endpoint}",
					method: "post",
					headers: { "Content-Type": "application/json" },
					data: {
						imp_uid: rsp.imp_uid,
						merchant_uid: rsp.merchant_uid
					}
				}).then((data) => {
				  // 서버 결제 API 성공시 로직
				})
		    } else {
				alert(`결제에 실패하였습니다. 에러 내용: ${rsp.error_msg}`);
		    }
		}
	)}
</script>
</html>