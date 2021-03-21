package br.com.odilonfontes.desafio.associadoapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
public class SwaggerConfig {
    public static final String CAMINHO_ENDPOINTS = "/api/**";
    private static final String TITULO = "API REST para consulta de associados";
    private static final String VERSAO = "SNAPSHOT";

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant(CAMINHO_ENDPOINTS))
                .build()
                .apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo() {
        return new ApiInfo(
                TITULO,
                null,
                VERSAO,
                null,
                null,
                null,
                null,
                Collections.emptyList());
    }

}
