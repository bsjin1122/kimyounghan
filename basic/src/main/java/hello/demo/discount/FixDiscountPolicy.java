package hello.demo.discount;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import hello.demo.member.Grade;
import hello.demo.member.Member;
@Component
@Qualifier("fixDiscountPolicy")
public class FixDiscountPolicy implements DiscountPolicy{

	private int discountFixAmount = 1000; // 1000원 할인
	@Override
	public int discount(Member member, int price) {
		if(member.getGrade() == Grade.VIP){
			return discountFixAmount;
		}else{
			return 0;
		}
	}
}
