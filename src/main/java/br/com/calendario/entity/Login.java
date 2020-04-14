package br.com.calendario.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import org.jcommon.encryption.SimpleMD5;

@Entity
@Table(name="login")
public class Login implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idLogin;
	@Column
	private String nome;
	@Column(unique=true)
	@Email
	private String email;
	@Column
	private String senha;
	
	public Login() {
	}

	public Login(Long idLogin, String nome, @Email String email, String senha) {
		super();
		this.idLogin = idLogin;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}
	
	
	@Override
	public String toString() {
		return "Login [idLogin=" + idLogin + ", nome=" + nome + ", email=" + email + ", senha=" + senha + "]";
	}

	public Long getIdLogin() {
		return idLogin;
	}

	public void setIdLogin(Long idLogin) {
		this.idLogin = idLogin;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public void gerarCript() {
		SimpleMD5 md5 = new SimpleMD5(this.senha,"lucasmotocaalmeidacafezinho");
		this.senha = md5.toHexString();
	}
	
}
