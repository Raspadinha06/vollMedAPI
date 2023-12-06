package med.voll.api.domain.consultas;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultasRepository extends JpaRepository<Consulta, Long> {
    Page<Consulta> findAll(Pageable paginacao);
}
