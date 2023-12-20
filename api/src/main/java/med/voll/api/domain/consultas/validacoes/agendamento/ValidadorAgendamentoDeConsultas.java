package med.voll.api.domain.consultas.validacoes.agendamento;

import med.voll.api.domain.consultas.DadosAgendamentoConsultas;

public interface ValidadorAgendamentoDeConsultas {

    void validar(DadosAgendamentoConsultas dados);
}
