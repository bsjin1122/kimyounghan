package hello.demo.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class NetworkClient {  // implements InitializingBean, DisposableBean
	private String url;

	public NetworkClient() {
		System.out.println("생성자 호출, url = " + url);

	}

	public void setUrl(String url) {
		this.url = url;
	}

	// 서비스 시작 시 호출하는 메서드
	public void connect(){
		System.out.println("connect: " + url);
	}

	public void call(String message){
		System.out.println("call : " + url + " message = " + message);
	}

	// 서비스 종료 시 호출
	public void disconnect(){
		System.out.println("close" + url);
	}


	@PostConstruct
	public void init() throws Exception { //@Override afterPropertiesSet()
		// 의존 관계 주입이 끝나면, 호출해주겠다.
		System.out.println("NetworkClient.afterPropertiesSet");
		connect();
		call("초기화 연결 메시지");
	}

	@PreDestroy
	//@Override
	public void close() throws Exception { // destroy()
		// disconnect 호출
		System.out.println("NetworkClient.destroy");
		disconnect();
	}
}
