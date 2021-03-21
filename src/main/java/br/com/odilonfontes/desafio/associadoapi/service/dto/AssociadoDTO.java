package br.com.odilonfontes.desafio.associadoapi.service.dto;

import java.io.Serializable;

import br.com.odilonfontes.desafio.associadoapi.domain.enumeration.SituacaoParaVotar;

public class AssociadoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String cpf;

    private SituacaoParaVotar situacaoParaVotar;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public SituacaoParaVotar getSituacaoParaVotar() {
        return situacaoParaVotar;
    }

    public void setSituacaoParaVotar(SituacaoParaVotar situacaoParaVotar) {
        this.situacaoParaVotar = situacaoParaVotar;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AssociadoDTO other = (AssociadoDTO) obj;
        if (cpf == null) {
            if (other.cpf != null)
                return false;
        } else if (!cpf.equals(other.cpf))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (situacaoParaVotar != other.situacaoParaVotar)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((situacaoParaVotar == null) ? 0 : situacaoParaVotar.hashCode());
        return result;
    }

}
