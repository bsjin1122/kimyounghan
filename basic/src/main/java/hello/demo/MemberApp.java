package hello.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.demo.member.Grade;
import hello.demo.member.Member;
import hello.demo.member.MemberService;
import hello.demo.member.MemberServiceImpl;

public class MemberApp {
	public static void main(String[] args) {
		//AppConfig appConfig = new AppConfig();
		//MemberService memberService = appConfig.memberService();
		// MemberService memberService = new MemberServiceImpl();

		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

		Member member = new Member(1L, "memberA", Grade.VIP);
		memberService.join(member);

		Member findMember = memberService.findMember(1L);
		System.out.println("member = " + member.getName());
		System.out.println("findMember = " + findMember.getName());
	}
}
