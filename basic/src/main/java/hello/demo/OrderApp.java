package hello.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.demo.member.Grade;
import hello.demo.member.Member;
import hello.demo.member.MemberService;
import hello.demo.member.MemberServiceImpl;
import hello.demo.order.Order;
import hello.demo.order.OrderService;
import hello.demo.order.OrderServiceImpl;

public class OrderApp {
	public static void main(String[] args) {
		// AppConfig appConfig = new AppConfig();
		//
		// MemberService memberService = appConfig.memberService();
		// OrderService orderService = appConfig.orderService();

		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
		OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

		// MemberService memberService = new MemberServiceImpl(null);
		// OrderService orderService = new OrderServiceImpl(null, null);

		Long memberId = 1L;
		Member member = new Member(memberId, "memberA", Grade.VIP);
		memberService.join(member);

		Order order = orderService.createOrder(memberId, "itemA", 20000);
		System.out.println("order = " + order);
		System.out.println("order.calculatePrice() = " + order.calculatePrice());
	}
}
