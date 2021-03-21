package br.com.odilonfontes.desafio.associadoapi.service.impl;

import java.io.IOException;
import java.util.Set;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import br.com.odilonfontes.desafio.associadoapi.service.AssociadoService;
import br.com.odilonfontes.desafio.associadoapi.service.dto.AssociadoDTO;

public class AssociadoServiceImplTest {

    static AssociadoService associadoService;

    @BeforeAll
    static void inicializarContexto() {
        associadoService = new AssociadoServiceImpl();
    }
    
    @DisplayName("Ao chamar o método consultarAssociado")
    @Nested
    class AoChamarMetodoConsultarAssociado {
        ObjectMapper mapper;
        AssociadoDTO associadoDTO;
        
        @BeforeEach
        void inicializarContexto() {
            mapper = new ObjectMapper();
        }

        @DisplayName("Dado que possua associado cadastrado, deveria retornar o associado esperado")
        @Test
        void consultarAssociado() throws JsonParseException, JsonMappingException, IOException {
            associadoDTO = associadoService.consultarAssociado("00123456789");
        }
    }
    
    @DisplayName("Ao chamar o método consultarTodosAssociados")
    @Nested
    class AoChamarMetodoConsultarTodosAssociados {
        ObjectMapper mapper;
        Set<AssociadoDTO> associadosDTO;
        
        @BeforeEach
        void inicializarContexto() {
            mapper = new ObjectMapper();
        }

        @DisplayName("Dado que possua associados cadastrados, deveria retornar todos os associados")
        @Test
        void consultarTodosAssociados() throws JsonParseException, JsonMappingException, IOException {
            associadosDTO = associadoService.consultarTodosAssociados();
        }
    }

}
