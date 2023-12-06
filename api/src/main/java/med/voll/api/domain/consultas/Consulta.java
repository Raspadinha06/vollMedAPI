package med.voll.api.domain.consultas;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.paciente.Paciente;

import java.time.LocalDate;
import java.time.LocalTime;

@Table(name = "consultas")
@Entity(name = "Consulta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dataConsulta;
    private LocalTime horaConsulta;
    private Long idMedico;
    private Long idPaciente;

    public Consulta(DadosCadastroConsultas dados, Medico idMedico, Paciente idPaciente){
        this.dataConsulta = dados.dataConsulta();
        this.horaConsulta = dados.horaConsulta();
        this.idMedico = idMedico.getId();
        this.idPaciente = idPaciente.getId();
    }

}
