package hello.demo.order;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import hello.demo.discount.FixDiscountPolicy;
import hello.demo.member.Grade;
import hello.demo.member.Member;
import hello.demo.member.MemoryMemberRepository;

class OrderServiceImplTest {
	
	@Test
	void createOrder(){
		MemoryMemberRepository memberRepository = new MemoryMemberRepository();
		memberRepository.save(new Member(1L, "name", Grade.VIP));
		OrderServiceImpl orderService = new OrderServiceImpl(memberRepository, new FixDiscountPolicy()); // 필수값이 있다는 것을 알려준다!!!!
		Order order = orderService.createOrder(1L, "itemA", 10000);

		Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
	}

}