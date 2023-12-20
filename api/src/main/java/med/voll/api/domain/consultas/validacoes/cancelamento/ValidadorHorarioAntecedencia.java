package med.voll.api.domain.consultas.validacoes.cancelamento;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consultas.ConsultasRepository;
import med.voll.api.domain.consultas.DadosCancelamentoConsultas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component("ValidadorHorarioAntecedenciaCancelamento")
public class ValidadorHorarioAntecedencia implements ValidadorCancelamentoDeConsultas{
    @Autowired
    private ConsultasRepository consultasRepository;

    @Override
    public void validar(DadosCancelamentoConsultas dados) {
        var consulta = consultasRepository.getReferenceById(dados.idConsulta());
        var agora = LocalDateTime.now();
        var diferencaEmHoras = Duration.between(agora, consulta.getData()).toHours();

        if (diferencaEmHoras < 24){
            throw new ValidacaoException("A consulta só pode ser cancelada com antecedência mínima de 24h!");
        }

    }
}
