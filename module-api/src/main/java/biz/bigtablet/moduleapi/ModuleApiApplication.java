package biz.bigtablet.moduleapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

// Spring Boot 애플리케이션 시작 지점으로 설정하며, 지정된 패키지를 기준으로 컴포넌트를 검색
@SpringBootApplication(
		scanBasePackages = {"biz.bigtablet.moduleapi", "biz.bigtablet.modulecommon"}
)
// JPA에서 엔티티(Entity)를 검색할 때 지정된 패키지(biz.bigtablet.modulecommon.domain)를 기준으로 검색
@EntityScan("biz.bigtablet.modulecommon.domain")
// JPA 리포지토리(Repository) 인터페이스를 지정된 패키지(biz.bigtablet.modulecommon.repository)에서 찾아 사용하도록 설정
@EnableJpaRepositories(basePackages = "biz.bigtablet.modulecommon.repository")

public class ModuleApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ModuleApiApplication.class, args);
	}

}
