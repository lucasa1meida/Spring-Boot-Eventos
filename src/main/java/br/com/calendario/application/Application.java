package br.com.calendario.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import br.com.calendario.entity.Login;
import br.com.calendario.repository.EventoRepository;
import br.com.calendario.repository.LoginRepository;

@SpringBootApplication
@EntityScan(basePackages="br.com.calendario.entity")
@ComponentScan(basePackages="br.com.calendario.controller")
@EnableJpaRepositories(basePackages="br.com.calendario.repository")
public class Application implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);		
	}

	@Autowired
	EventoRepository dao;
	@Autowired
	LoginRepository ldao;
	
	@Override
	public void run(String... args) throws Exception {
	
//		Login l = new Login(null,"Administrador","adm@gmail.com","123456789");
//		l.gerarCript();
//		ldao.save(l);
		
		System.out.println("OK!");
	}
	
}
