package med.voll.api.domain.consultas;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.medico.Especialidade;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public record DadosAgendamentoConsultas(
        Long idMedico,
        @NotNull(message = "O ID do paciente não pode ser nulo.")
        Long idPaciente,
        @NotNull(message = "A data é obrigatória")
        @Future
        LocalDateTime data,
        Especialidade especialidade

) {
}
