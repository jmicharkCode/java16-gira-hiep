package cybersoft.javabackend.java16girahiep.config;

import org.springframework.boot.autoconfigure.info.ProjectInfoProperties.Build;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiDescriptionBuilder;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig { 
	@Bean
	public Docket getDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("cybersoft.javabackend.java16girahiep"))
				.build()
				.apiInfo(new ApiInfoBuilder().title("Gira Application")
						.version("1.0.0")
						.description("This project í used for education purpose only.")
						.contact(new Contact("hiep", "https://tuanphan.dev/", "jmichark@gmail.com"))
						.build());
	}

}
