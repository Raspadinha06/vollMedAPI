CREATE TABLE consultas (
    id bigint NOT NULL AUTO_INCREMENT,
    data_consulta DATE NOT NULL,
    hora_consulta TIME NOT NULL,
    id_medico INT,
    id_paciente INT,

    PRIMARY KEY(id)
    );