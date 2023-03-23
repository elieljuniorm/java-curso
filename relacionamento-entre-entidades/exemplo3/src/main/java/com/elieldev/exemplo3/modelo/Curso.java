package com.elieldev.exemplo3.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cursos")
@Getter
@Setter
public class Curso {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long codigo;

  private String curso;

  @ManyToMany(mappedBy = "cursos")
  /* informa que a tabela de associação ja foi criada em alunos e o nome "cursos" para informar uma referencia a lista cursos que tem na classe Aluno dessa maneira que o spring entende que não precisa gerar duas tabela de aluno_curso e curso_aluno, gerando assim uma redundância, agora ele gera somente uma com o nome de tabela_auxiliar(nome escolhido por mim) */
  private List<Aluno> alunos = new ArrayList<>();
}
