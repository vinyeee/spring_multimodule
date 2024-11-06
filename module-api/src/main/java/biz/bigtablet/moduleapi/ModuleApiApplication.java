package biz.bigtablet.moduleapi;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(
		scanBasePackages = {"biz.bigtablet.moduleapi", "biz.bigtablet.modulecommon"}
)
@EntityScan("biz.bigtablet.modulecommon.domain")
@EnableJpaRepositories(basePackages = "biz.bigtablet.modulecommon.repository")
public class ModuleApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ModuleApiApplication.class, args);
	}

}
