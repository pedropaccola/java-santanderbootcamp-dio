package dio.web.api.docs;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenAPIConfig {
    @Value("${dio.web.api.dev-url}")
    private String devUrl;

    @Value("${dio.web.api.prd-url}")
    private String prdUrl;

    @Bean
    public OpenAPI myOpenAPI() {
        Server devServer = new Server();
        devServer.setUrl(devUrl);
        devServer.setDescription("URL for Development Environment");

        Server prdServer = new Server();
        devServer.setUrl(prdUrl);
        devServer.setDescription("URL for Production Environment");

        Contact contact = new Contact();
        contact.setEmail("email@email.com");
        contact.setName("Pedro");
        contact.setUrl("https://test.com");

        License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");

        Info info = new Info()
                .title("Web API")
                .version("1.0")
                .contact(contact)
                .description("Web API for the Dio's Java bootcamp")
                .license(mitLicense);

        return new OpenAPI().info(info).servers(List.of(devServer, prdServer));
    }

}
