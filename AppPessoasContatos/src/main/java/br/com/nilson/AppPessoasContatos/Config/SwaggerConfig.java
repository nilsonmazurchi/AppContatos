package br.com.nilson.AppPessoasContatos.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Classe de configuração do Swagger para a documentação da API.
 * O Swagger permite visualizar e testar os endpoints da API de forma interativa.
 */
@Configuration // Indica que esta classe é uma configuração do Spring
public class SwaggerConfig {

    /**
     * Método que configura o Swagger para a API.
     * @return Um objeto Docket configurado para gerar a documentação da API.
     */
    @Bean // Define este método como um Bean gerenciado pelo Spring
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2) // Define o tipo de documentação como Swagger 2
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.nilson")) // Define o pacote base para escanear os endpoints
                .paths(PathSelectors.any()) // Inclui todos os endpoints da API
                .build();
    }
}
