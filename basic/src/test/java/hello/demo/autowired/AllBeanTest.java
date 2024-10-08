package hello.demo.autowired;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

import hello.demo.AutoAppConfig;
import hello.demo.discount.DiscountPolicy;
import hello.demo.member.Grade;
import hello.demo.member.Member;

public class AllBeanTest {
	@Test
	void findAllBean(){
		ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class, DiscountService.class);
		DiscountService discountService = ac.getBean(DiscountService.class);
		
		Member member = new Member(1L, "userA", Grade.VIP);
		int discountPrice = discountService.discount(member, 10000, "fixDiscountPolicy");
		
		assertThat(discountService).isInstanceOf(DiscountService.class);
		assertThat(discountPrice).isEqualTo(1000);

		int rateDiscountPrice = discountService.discount(member, 20000, "rateDiscountPolicy");
		assertThat(rateDiscountPrice).isEqualTo(2000);
	}

	static class DiscountService{
		private final Map<String, DiscountPolicy> policyMap;
		private final List<DiscountPolicy> policies;


		DiscountService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> policies) {
			this.policyMap = policyMap;
			this.policies = policies;
			System.out.println("policyMap = " + policyMap);
			System.out.println("policies = " + policies);
			// policyMap = {}
			// policies = []

			// policyMap = {fixDiscountPolicy=hello.demo.discount.FixDiscountPolicy@f2c488, rateDiscountPolicy=hello.demo.discount.RateDiscountPolicy@54acff7d}
			// policies = [hello.demo.discount.FixDiscountPolicy@f2c488, hello.demo.discount.RateDiscountPolicy@54acff7d]

		}

		public int discount(Member member, int price, String discountCode) {
			DiscountPolicy discountPolicy = policyMap.get(discountCode);
			System.out.println("discountCode = " + discountCode);
			System.out.println("discountPolicy = " + discountPolicy);
			return discountPolicy.discount(member, price);
		}
	}
}
