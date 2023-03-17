package com.elieldev.cursojava.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_user") //modifica o nome da tabela no banco para nao ter conflito, User é palavra reservada no banco
public class User implements Serializable {

  private static final long serialVersionUID = 1L; //numero de série padrão(opcional)

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) //gera o numero automatico de id no banco
  private Long id;

  private String name;
  private String email;
  private String phone;
  private String password;

  @JsonIgnore //anotação para retiar um loop infinito de repetição de associação(evita erro)
  @OneToMany(mappedBy = "client") //anotaçoes do spring para resolver a questao de informações entre classes, associação um(User) para muitos(Order)
  private List<Order> orders = new ArrayList<>();

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    User other = (User) obj;
    if (id == null) {
      if (other.id != null) return false;
    } else if (!id.equals(other.id)) return false;
    return true;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public List<Order> getOrders() {
    return orders;
  }

  public User() {}

  public User(
    Long id,
    String name,
    String email,
    String phone,
    String password
  ) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.phone = phone;
    this.password = password;
  }
}
