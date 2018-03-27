package br.com.tarefas.model;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Movimentacao {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	private Cliente cliente;
	
	@Column(nullable=false)
	private BigDecimal valor;
	
	private boolean manutencao;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Calendar dataMovimentacao;
	
	
	
	
	public Movimentacao() {
		super();
	}

	public Movimentacao(BigDecimal valor, boolean manutencao, Calendar dataMovimentacao) {
		super();
		this.valor = valor;
		this.manutencao = manutencao;
		this.dataMovimentacao = dataMovimentacao;
	}

	public Calendar getDataMovimentacao() {
		return dataMovimentacao;
	}

	public void setDataMovimentacao(Calendar dataMovimentacao) {
		this.dataMovimentacao = dataMovimentacao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public boolean isManutencao() {
		return manutencao;
	}

	public void setManutencao(boolean manutencao) {
		this.manutencao = manutencao;
	}
	
	
	public String verificaSeEManutencao(boolean manutencao) {
		if(manutencao == true) {
			return "É Manutenção";
		}else {
			return "Não é manutenção";
		}
	}

	@Override
	public String toString() {
		return "Movimentacao [valor=" + valor + "]";
	}
	

	
}
