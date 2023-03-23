package com.elieldev.exemplo2.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "postagens")
@Getter
@Setter
public class Postagem {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long codigo;

  private String titulo;
  private String texto;

  /* O relacionamento 1 para muitos tem que ser feito na classe 1 originando uma tabela de relacionamento na classe MUITOS, nesse caso salva nos comentarios o codigo da postagem que origina os comentarios */
  @OneToMany
  @JoinColumn(name = "codigo_postagem") //coluna criada na tabela comentario(relacionamento)
  private List<Comentario> comentarios; //varios comentarios dentro de um post
}
