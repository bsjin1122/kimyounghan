package hello.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.demo.discount.DiscountPolicy;
import hello.demo.discount.FixDiscountPolicy;
import hello.demo.discount.RateDiscountPolicy;
import hello.demo.member.MemberRepository;
import hello.demo.member.MemberService;
import hello.demo.member.MemberServiceImpl;
import hello.demo.member.MemoryMemberRepository;
import hello.demo.order.OrderService;
import hello.demo.order.OrderServiceImpl;

@Configuration
public class AppConfig { // 환경 구성을 여기서 함.
	@Bean
	public MemberService memberService(){
		return new MemberServiceImpl(memberRepository());
	} // 생성자 주입.
	@Bean
	public MemberRepository memberRepository(){
		return new MemoryMemberRepository();
	}
	@Bean
	public OrderService orderService(){
		return new OrderServiceImpl(memberRepository(), discountPolicy());
	}
	@Bean
	public DiscountPolicy discountPolicy(){
		return new RateDiscountPolicy();
		// return new FixDiscountPolicy();
	}

}
