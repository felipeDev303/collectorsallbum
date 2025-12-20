package ipss.cl.collectorsallbum.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Collectors Album API")
                        .version("1.0")
                        .description("API REST para gestión de álbumes de colección y láminas")
                        .contact(new Contact()
                                .name("Felipe Dev")
                                .url("https://github.com/felipeDev303/collectorsallbum")));
    }
}
