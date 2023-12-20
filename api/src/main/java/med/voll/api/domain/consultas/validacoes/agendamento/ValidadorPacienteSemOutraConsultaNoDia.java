package med.voll.api.domain.consultas.validacoes.agendamento;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consultas.ConsultasRepository;
import med.voll.api.domain.consultas.DadosAgendamentoConsultas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ValidadorPacienteSemOutraConsultaNoDia implements ValidadorAgendamentoDeConsultas{

    @Autowired
    private ConsultasRepository repository;

    public void validar(DadosAgendamentoConsultas dados){
        var dataConsulta = dados.data();

        var primeiroHorario = dataConsulta.withHour(7);
        var ultimoHorario = dataConsulta.withHour(18);

        var pacientePossuiOutraConsultaNoDia = repository.existsByPacienteIdAndDataBetween(dados.idPaciente(),
                primeiroHorario, ultimoHorario);
        if(pacientePossuiOutraConsultaNoDia){
            throw new ValidacaoException("Paciente já possui uma consulta agendada no mesmo dia.");
        }

    }

}
