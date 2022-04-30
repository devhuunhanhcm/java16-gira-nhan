package cybersoft.javabackend.java16giranhan.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket getDocket() {
		
		return new Docket(DocumentationType.SWAGGER_2)
				.securityContexts(List.of(getSecurityContext()))
				.securitySchemes(List.of(getSecurityScheme()))
				.select()
				.apis(RequestHandlerSelectors.basePackage("cybersoft.javabackend.java16giranhan"))
				.build()
				.apiInfo(new ApiInfoBuilder().title("Gira Application")
						.version("1.0.0")
						.description("Developed by HuuNhan")
						.contact(new Contact("Tran Huu Nhan","http://tranhuunhan.dev","nhandeptrai137@gmail.com"))
						.build()
						)
				
				;
	}

	private ApiKey getSecurityScheme() {
		//ApiKey(String name,String keyname,String passAs)
		//keyname: tên của nó (vd nếu bỏ lên header thì tên của nó là Authorization: (tên phổ biến luôn))
		//passAs: là gửi nó zo trong reqest theo dạng gì (vd ở đây là header)
		//Khi request gửi lên sẽ có một header tên là authorization có chứa JWT trong đó 
		return new ApiKey("JWT", "Authorization", "header");
	}

	private SecurityContext getSecurityContext() {
		
		return SecurityContext.builder()
				//những cái tham chiếu security (tham số là List securityReference)
				.securityReferences(List.of(getSecurityReference()))
				
				.build();
	}
	
	//return securityReference
	private SecurityReference getSecurityReference() {
		AuthorizationScope globalScope  = new AuthorizationScope("global", "use for all request");
		
		AuthorizationScope[] scopes = new AuthorizationScope[1];
		scopes[0] = globalScope;
		
		//Đặt tên cho reference là JWT rồi truyền scope vào là xong 
		return new SecurityReference("JWT", scopes);
	}

	
}
