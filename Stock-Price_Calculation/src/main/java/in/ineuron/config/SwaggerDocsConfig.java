package in.ineuron.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerDocsConfig {

	@Bean
	public Docket createDocket() {
		return new Docket(DocumentationType.SWAGGER_2).// UI Screen type
				select(). // to specify RestControllers
				apis(RequestHandlerSelectors.basePackage("in.ineuron.restcontroller"))// base packages for// RestController
				.paths(PathSelectors.regex("/calc.*")).// To specify the request paths
				build()// build the docket object
				.useDefaultResponseMessages(true).apiInfo(getApiInfo());
	}

	private ApiInfo getApiInfo() {
		Contact contact = new Contact("shivam", "http://www.ineuron.ai/course", "dubeyshivam43@gmail.com");
		return new ApiInfo("STOCK-API PRICE", "Gives information about stocks ", "3.4.RELEASE", "http:", contact,
				"GNU PUBLIC", "http://apache.org/license/guru", Collections.emptyList());
	}

}
