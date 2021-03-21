package br.com.odilonfontes.desafio.associadoapi.web.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.odilonfontes.desafio.associadoapi.service.AssociadoService;
import br.com.odilonfontes.desafio.associadoapi.service.dto.AssociadoDTO;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Set;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
@RequestMapping(path = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class AssociadoResource {

    private final AssociadoService associadoService;

    public AssociadoResource(AssociadoService associadoService) {
        this.associadoService = associadoService;
    }

    @GetMapping("/v1/associado/{cpf}")
    public ResponseEntity<AssociadoDTO> consultarAssociado(@PathVariable String cpf) throws URISyntaxException,
        JsonParseException, JsonMappingException, IOException {
        AssociadoDTO retorno = associadoService.consultarAssociado(cpf);
        return new ResponseEntity<>(retorno, HttpStatus.OK);
    }

    @GetMapping("/v1/associado")
    public ResponseEntity<Set<AssociadoDTO>> consultarTodosAssociados() throws URISyntaxException,
        JsonParseException, JsonMappingException, IOException {
        Set<AssociadoDTO> retorno = associadoService.consultarTodosAssociados();
        return new ResponseEntity<>(retorno, HttpStatus.OK);
    }

}
