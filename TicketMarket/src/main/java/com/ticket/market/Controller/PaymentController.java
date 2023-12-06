package com.ticket.market.Controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ticket.market.service.PaymentService;

import java.util.List;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
public class PaymentController {

	private final PaymentService paymentService;

	@RequestMapping(value="/payment.do", method = RequestMethod.GET)
	public String paymentHome(Model model) {
		
		log.info("@@@@@@@@@@@@@@@ 결제하기 이동");
		
		// 더미데이터 시작
		Map<String, Object> ticket1 = new HashMap<String, Object>();
		ticket1.put("reservationId", "T1E1-S1T1-TEST-0005");
		ticket1.put("ticketId", "TICKET006");
		ticket1.put("ticketName", "테스트 상영작");
		ticket1.put("ticketPrice", 10000);
		ticket1.put("startTime", "2023-12-10 18:30:00");
		ticket1.put("ticketRow", "01");
		ticket1.put("ticketColumn", "A");
		ticket1.put("userId", "user1");
		
		Map<String, Object> ticket2 = new HashMap<String, Object>();
		ticket2.put("reservationId", "T1E1-S1T1-TEST-0005");
		ticket2.put("ticketId", "TICKET007");
		ticket2.put("ticketName", "테스트 상영작");
		ticket2.put("ticketPrice", 10000);
		ticket2.put("startTime", "2023-12-10 18:30:00");
		ticket2.put("ticketRow", "02");
		ticket2.put("ticketColumn", "A");
		ticket2.put("userId", "user1");
		
		List<Map<String, Object>> reservation = new ArrayList<Map<String, Object>>();
		reservation.add(ticket1);
		reservation.add(ticket2);
		// 더미데이터 끝
		
		model.addAttribute("reservation",reservation);
		
		return "payment";
	}
	
	@RequestMapping(value="/myPayment.do", method = RequestMethod.GET)
	public String myPayment(Model model) {
		
		log.info("@@@@@@@@@@@@@@@ 결제내역 이동");
		
		LocalDate startDate = LocalDate.of(2023, 10, 1);
		LocalDate endDate = LocalDate.of(2023, 11, 30);
		
		model.addAttribute("payment", paymentService.findAllByUserIdAndPaymentDateBetween("user1", startDate, endDate));
		
		return "myPayment";
	}
}
