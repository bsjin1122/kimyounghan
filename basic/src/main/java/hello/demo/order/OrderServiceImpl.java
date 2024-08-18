package hello.demo.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import hello.demo.annotation.MainDiscountPolicy;
import hello.demo.discount.DiscountPolicy;
import hello.demo.discount.FixDiscountPolicy;
import hello.demo.discount.RateDiscountPolicy;
import hello.demo.member.Member;
import hello.demo.member.MemberRepository;
import hello.demo.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;

@Component
//@RequiredArgsConstructor //final이 붙으면 필수값이 되니까, final이 붙은 것을 가지고 생성자를 만들어준다.
public class OrderServiceImpl implements OrderService{

	// 인터페이스에만 의존하고 있다.
	private final MemberRepository memberRepository;
	private final DiscountPolicy discountPolicy;

	public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
		this.memberRepository = memberRepository;
		this.discountPolicy = discountPolicy;
	}

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


// @Autowired
// public void init(MemberRepository memberRepository, DiscountPolicy discountPolicy){
// 	this.memberRepository = memberRepository;
// 	this.discountPolicy = discountPolicy;
// }


//@Autowired(required=false)
// public void setMemberRepository(MemberRepository memberRepository) {
// 	System.out.println("memberRepository = " + memberRepository);
// 	this.memberRepository = memberRepository;
// }
//@Autowired
// public void setDiscountPolicy(DiscountPolicy discountPolicy) {
// 	System.out.println("discountPolicy = " + discountPolicy);
// 	this.discountPolicy = discountPolicy;
// }

// @Autowired 생성자가 하나일 땐 생략해도 자동 주입이 된다!
// public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
// 	this.memberRepository = memberRepository;
// 	this.discountPolicy = discountPolicy;
// }

// private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

