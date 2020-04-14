package br.com.calendario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.calendario.entity.Login;

public interface LoginRepository extends JpaRepository<Login, Long>{

	public Login findByEmailAndSenha(String email, String senha);
}
