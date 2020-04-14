package br.com.calendario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.calendario.entity.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long>{
}
