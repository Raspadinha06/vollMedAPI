package med.voll.api.domain.consultas;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

public record DadosCadastroConsultas(
        @NotBlank(message = "A data é obrigatória")
        LocalDate dataConsulta,
        @NotBlank(message = "A hora é obrigatória")
        LocalTime horaConsulta,
        @NotNull(message = "O ID do médico não pode ser nulo.")
        Long idMedico,
        @NotNull(message = "O ID do paciente não pode ser nulo.")
        Long idPaciente

) {
}
