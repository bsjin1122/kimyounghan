package hello.demo.scan;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.demo.AutoAppConfig;
import hello.demo.member.MemberService;
import hello.demo.member.MemberServiceImpl;

public class AutoAppConfigTest {

	@Test
	void basicScan(){
		ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
		MemberService memberService = ac.getBean(MemberService.class);
		assertThat(memberService).isInstanceOf(MemberService.class);
	}
}
