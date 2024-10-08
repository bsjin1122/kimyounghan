package hello.demo.discount;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import hello.demo.annotation.MainDiscountPolicy;
import hello.demo.member.Grade;
import hello.demo.member.Member;
@Component
//@Qualifier("mainDiscountPolicy")
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy{

	private int discountPercent = 10;

	@Override
	public int discount(Member member, int price) {
		if(member.getGrade() == Grade.VIP){
			return price * discountPercent / 100;
		}else{
			return 0;
		}
	}
}
