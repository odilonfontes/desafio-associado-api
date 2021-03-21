package br.com.odilonfontes.desafio.associadoapi.service;

import java.io.IOException;
import java.util.Set;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import br.com.odilonfontes.desafio.associadoapi.service.dto.AssociadoDTO;

public interface AssociadoService {

    public AssociadoDTO consultarAssociado(String cpf) throws JsonParseException, JsonMappingException, IOException;

    public Set<AssociadoDTO> consultarTodosAssociados() throws JsonParseException, JsonMappingException, IOException;

}