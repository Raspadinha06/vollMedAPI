package med.voll.api.controller;

import med.voll.api.domain.consultas.Consulta;
import med.voll.api.domain.consultas.ConsultasRepository;
import med.voll.api.domain.consultas.DadosCadastroConsultas;
import med.voll.api.domain.medico.MedicoRepository;
import med.voll.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consultas") // Mapeamento de URL
public class ConsultasController {
    @Autowired
    private MedicoRepository repositoryMedico;

    @Autowired
    private PacienteRepository repositoryPaciente;

    @Autowired
    private ConsultasRepository repositoryConsultas;

    @PostMapping
    @Transactional
    public void agendar(@RequestBody DadosCadastroConsultas dados){
        var medico = repositoryMedico.getReferenceById(dados.idMedico());
        var paciente = repositoryPaciente.getReferenceById(dados.idPaciente());

        repositoryConsultas.save(new Consulta(dados, medico, paciente));
    }


}
