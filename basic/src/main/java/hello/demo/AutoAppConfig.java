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
	@Bean(name = "memoryMemberRepository")
	public MemberRepository memberRepository() {
		return new MemoryMemberRepository();
	}
}
