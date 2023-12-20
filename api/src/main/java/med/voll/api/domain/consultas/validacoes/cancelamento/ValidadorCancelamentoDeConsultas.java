package med.voll.api.domain.consultas.validacoes.cancelamento;

import med.voll.api.domain.consultas.DadosCancelamentoConsultas;

public interface ValidadorCancelamentoDeConsultas {
    void validar(DadosCancelamentoConsultas dados);
}
