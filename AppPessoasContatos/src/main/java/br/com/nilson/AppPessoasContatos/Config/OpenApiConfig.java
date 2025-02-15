package br.com.nilson.AppPessoasContatos.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;

/**
 * Classe de configuração do OpenAPI (Swagger).
 * Essa classe configura a documentação da API, incluindo informações como título, descrição, contato e esquema de segurança.
 */
@Configuration // Indica que esta classe é uma configuração do Spring
public class OpenApiConfig {

    /**
     * Método que configura e retorna uma instância do OpenAPI personalizada.
     * @return OpenAPI configurado com informações básicas e segurança.
     */
    @Bean // Define este método como um Bean gerenciado pelo Spring
    public OpenAPI customOpenAPI() {        
        return new OpenAPI()
                // Configura o esquema de segurança para autenticação básica HTTP
                .components(new Components().addSecuritySchemes("basicScheme",
                        new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("basic")))
                
                // Define informações gerais da API
                .info(new Info()
                        .title("Título API") // Define o título da API
                        .description("Descrição API") // Adiciona uma breve descrição sobre a API
                        .contact(new Contact()
                                .name("Nome") // Nome do responsável pela API
                                .email("Email") // E-mail para contato
                                .url("URL")) // URL para mais informações
                        .version("Versão API")); // Define a versão da API
    }
}