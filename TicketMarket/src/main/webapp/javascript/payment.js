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