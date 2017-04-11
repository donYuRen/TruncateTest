package test.optus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.PropertySource;


@SpringBootApplication(scanBasePackages = {
        "test.optus",
        "test.optus.controller",
        "test.optus.service",
        "test.optus.serviceimpl"})
@PropertySource("classpath:application.properties")
public class OptusTestApp extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(OptusTestApp.class, args);
	}
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(applicationClass);
    }

    private static Class<OptusTestApp> applicationClass = OptusTestApp.class;

}
