package hello.demo.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {
	@Test
	public void lifeCycleTest(){
		ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
		NetworkClient client = ac.getBean(NetworkClient.class);
		ac.close(); // AnnotationConfigApplicationContext -Closing 싱글톤 빈들이 하나씩 죽음..
	}

	@Configuration
	static class LifeCycleConfig{
		@Bean //(initMethod = "init", destroyMethod = "close")
		public NetworkClient networkClient(){
			NetworkClient networkClient = new NetworkClient();
			networkClient.setUrl("http://hello-spiring.dev");
			return networkClient;
		}
	}
}
