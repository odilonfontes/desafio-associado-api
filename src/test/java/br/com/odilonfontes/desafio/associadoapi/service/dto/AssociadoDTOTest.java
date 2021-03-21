package br.com.odilonfontes.desafio.associadoapi.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import br.com.odilonfontes.desafio.associadoapi.domain.enumeration.SituacaoParaVotar;

public class AssociadoDTOTest {

    @DisplayName("Ao instanciar objetos da classe AssociadoDTO")
    @Nested
    class AoInstanciarObjetosDaClasseAssociadoDTO {
        AssociadoDTO associadoDTO1;
        AssociadoDTO associadoDTO2;

        @BeforeEach
        void inicializarContexto() {
            associadoDTO1 = new AssociadoDTO();
            associadoDTO2 = new AssociadoDTO();
        }

        @DisplayName("Dado que possuam mesmo estado, deveriam ser iguais")
        @Test
        void verificarSeEstaoIguais() {
            associadoDTO1.setId(1L);
            associadoDTO1.setCpf("00123456789");
            associadoDTO1.setSituacaoParaVotar(SituacaoParaVotar.ABLE_TO_VOTE);
            associadoDTO2.setId(associadoDTO1.getId());
            associadoDTO2.setCpf(associadoDTO1.getCpf());
            associadoDTO2.setSituacaoParaVotar(associadoDTO1.getSituacaoParaVotar());
            assertThat(associadoDTO1).isEqualTo(associadoDTO2);
        }
    }

}
