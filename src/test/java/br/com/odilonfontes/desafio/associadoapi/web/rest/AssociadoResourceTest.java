package br.com.odilonfontes.desafio.associadoapi.web.rest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collections;
import java.util.Set;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import br.com.odilonfontes.desafio.associadoapi.service.AssociadoService;
import br.com.odilonfontes.desafio.associadoapi.service.dto.AssociadoDTO;
import br.com.odilonfontes.desafio.associadoapi.service.impl.AssociadoServiceImpl;

@SpringBootTest
@AutoConfigureMockMvc
public class AssociadoResourceTest {

    public static final String URI_PAUTA = "/api/v1/associado";
    static MockMvc mockMvc;
    static ObjectMapper objectMapper;
    static AssociadoService associadoServiceMock;

    @BeforeAll
    static void inicializarContexto() {
        associadoServiceMock = mock(AssociadoServiceImpl.class);
        mockMvc = MockMvcBuilders
                .standaloneSetup(new AssociadoResource(associadoServiceMock))
                .build();
        objectMapper = new ObjectMapper();
    }

    @DisplayName("Ao chamar método consultarAssociado")
    @Nested
    class AoChamarMetodoConsultarAssociado {
        AssociadoDTO associadoDTO;

        @BeforeEach
        void inicializarContexto() {
            associadoDTO = new AssociadoDTO();
        }
        
        @DisplayName("Dado que possua associado cadastrado, deveria retornar o associado esperado")
        @Test
        void deveriaConsultarAssociado() throws Exception {
            String cpf = "00123456789";
            BDDMockito.given(associadoServiceMock.consultarAssociado(cpf)).willReturn(associadoDTO);
            ResultActions resultActions = consultarAssociado(cpf);
            resultActions.andExpect(status().isOk());
            BDDMockito.verify(associadoServiceMock, times(1)).consultarAssociado(cpf);
        }

        ResultActions consultarAssociado(String cpf) throws Exception {
            return mockMvc.perform(MockMvcRequestBuilders.get(URI_PAUTA + "/" + cpf)
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON));
        }
    }

    @DisplayName("Ao chamar método consultarTodosAssociados")
    @Nested
    class AoChamarMetodoConsultarTodosAssociados {
        Set<AssociadoDTO> associadosDTO;

        @BeforeEach
        void inicializarContexto() {
            associadosDTO = Collections.singleton(new AssociadoDTO());
        }
        
        @DisplayName("Dado que possua associados cadastrados, deveria retornar todos os associados")
        @Test
        void deveriaConsultarTodosAssociados() throws Exception {
            BDDMockito.given(associadoServiceMock.consultarTodosAssociados()).willReturn(associadosDTO);
            ResultActions resultActions = consultarTodosAssociados();
            resultActions.andExpect(status().isOk());
            BDDMockito.verify(associadoServiceMock, times(1)).consultarTodosAssociados();
        }

        ResultActions consultarTodosAssociados() throws Exception {
            return mockMvc.perform(MockMvcRequestBuilders.get(URI_PAUTA)
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON));
        }
    }
    
}
