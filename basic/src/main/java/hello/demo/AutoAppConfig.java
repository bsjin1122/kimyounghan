package hello.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import hello.demo.member.MemberRepository;
import hello.demo.member.MemoryMemberRepository;

@Configuration
@ComponentScan(
	excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
	// spring.main.allow-bean-definition-overriding=true --> application.properties 에 오버라이딩 가능 설정
	// @Bean(name = "memoryMemberRepository")
	// public MemberRepository memberRepository() {
	// 	return new MemoryMemberRepository();
	// }



}
