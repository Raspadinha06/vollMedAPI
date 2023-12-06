ALTER TABLE consultas
    ADD CONSTRAINT fk_id_medico
    FOREIGN KEY (id_medico)
    REFERENCES medicos(id),
    ADD CONSTRAINT fk_id_paciente
    FOREIGN KEY (id_paciente)
    REFERENCES pacientes(id);