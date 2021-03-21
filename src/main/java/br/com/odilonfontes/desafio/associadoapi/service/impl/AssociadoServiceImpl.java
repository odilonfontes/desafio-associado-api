package br.com.odilonfontes.desafio.associadoapi.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.odilonfontes.desafio.associadoapi.service.AssociadoService;
import br.com.odilonfontes.desafio.associadoapi.service.dto.AssociadoDTO;

@Service
@Transactional(readOnly = true)
public class AssociadoServiceImpl implements AssociadoService {

    @Override
    public AssociadoDTO consultarAssociado(String cpf) throws JsonParseException, JsonMappingException, IOException {
        Set<AssociadoDTO> associadosDTO = consultarTodosAssociados();
        return associadosDTO.stream()
            .filter(associadoDTO -> cpf.equals(associadoDTO.getCpf()))
            .findAny()
            .orElse(null);
    }

    @Override
    public Set<AssociadoDTO> consultarTodosAssociados() throws JsonParseException, JsonMappingException, IOException {
        TypeReference<Set<AssociadoDTO>> typeReference = new TypeReference<Set<AssociadoDTO>>(){};
        InputStream inputStream = TypeReference.class.getResourceAsStream("/data.json");
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(inputStream, typeReference);
    }

}
