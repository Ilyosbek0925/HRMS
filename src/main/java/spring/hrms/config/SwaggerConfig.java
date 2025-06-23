package spring.hrms.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("HRMS API hujjatlari")
                        .version("1.0")
                        .description("HRMS loyihasi uchun Swagger API hujjatlari")
                        .contact(new Contact()
                                .name("Ilyosbek")
                                .email("ilyosbek@example.com")
                        )
                );
    }
}
