package com.elieldev.apijava.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pessoas") //nome da tabela
public class Pessoa { //tabela com nome da class nao precisa usar @table

  // Atributo
  @Id //repsonsavel pela key do id
  @GeneratedValue(strategy = GenerationType.IDENTITY)//gera valor crescente automatico de ID
  private int codigo;

  private String nome;
  private int idade;

  // Get e Set
  public int getCodigo() {
    return codigo;
  }

  public void setCodigo(int codigo) {
    this.codigo = codigo;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getIdade() {
    return idade;
  }

  public void setIdade(int idade) {
    this.idade = idade;
  }
}
