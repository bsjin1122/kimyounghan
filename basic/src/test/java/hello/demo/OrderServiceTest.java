package hello.demo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Or;

import hello.demo.member.Grade;
import hello.demo.member.Member;
import hello.demo.member.MemberService;
import hello.demo.member.MemberServiceImpl;
import hello.demo.order.Order;
import hello.demo.order.OrderService;
import hello.demo.order.OrderServiceImpl;

public class OrderServiceTest {
	MemberService memberService = new MemberServiceImpl();
	OrderService orderService = new OrderServiceImpl();

	@Test
	void createOrder(){
		Long memberId = 1L;
		Member member = new Member(memberId, "memberA", Grade.VIP);
		memberService.join(member);
		Order order = orderService.createOrder(memberId, "itemA", 10000);
		Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
	}
}
