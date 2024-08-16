package hello.demo.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hello.demo.discount.DiscountPolicy;
import hello.demo.discount.FixDiscountPolicy;
import hello.demo.discount.RateDiscountPolicy;
import hello.demo.member.Member;
import hello.demo.member.MemberRepository;
import hello.demo.member.MemoryMemberRepository;
@Component
public class OrderServiceImpl implements OrderService{

	// 인터페이스에만 의존하고 있다.
	private final MemberRepository memberRepository;
	private final DiscountPolicy discountPolicy;
	@Autowired
	public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
		this.memberRepository = memberRepository;
		this.discountPolicy = discountPolicy;
	}

	// private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

	@Override
	public Order createOrder(Long memberId, String itemName, int itemPrice) {
		Member member = memberRepository.findById(memberId);
		int price = discountPolicy.discount(member, itemPrice);
		return new Order(memberId, itemName, itemPrice, price);
	}

	// 테스트 용도
	public MemberRepository getMemberRepository(){
		return memberRepository;
	}
}
