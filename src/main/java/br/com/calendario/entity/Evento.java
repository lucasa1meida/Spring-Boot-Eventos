package br.com.calendario.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("deprecation")
@Entity
@Table(name="evento")
public class Evento implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long cod;
	@Column
	private String nome;
	@Column
	private String data;
	@Column
	private String horario;
	@Column(length=250)
	private String descricao;		
	
	public Evento() {
	}

	public Evento(Long cod, String nome, String data, String horario, String descricao) {
		super();
		this.cod = cod;
		this.nome = nome;
		this.data = data;
		this.horario = horario;
		this.descricao = descricao;
	}
	
	public Evento(String nome, String data, String horario, String descricao) {
		super();
		this.nome = nome;
		this.data = data;
		this.horario = horario;
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Evento [cod=" + cod + ", nome=" + nome + ", data=" + data + ", horario=" + horario + ", descricao="
				+ descricao + "]";
	}

	public Long getCod() {
		return cod;
	}

	public void setCod(Long cod) {
		this.cod = cod;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
