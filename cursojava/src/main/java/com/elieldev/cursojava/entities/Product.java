package com.elieldev.cursojava.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_product")
public class Product implements Serializable {

  private static final long serialVersionUID = 1L; //numero de série padrão(opcional)

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) //gera o numero automatico de id no banco
  private Long id;

  private String name;
  private String description;
  private Double price;
  private String imgUrl;

  @Transient //provisorio somente para o JPA nao interpertar e deixar passar
  private Set<Category> categories = new HashSet<>(); //associação entre a categoria e o produto

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
    Product other = (Product) obj;
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

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public String getImgUrl() {
    return imgUrl;
  }

  public void setImgUrl(String imgUrl) {
    this.imgUrl = imgUrl;
  }

  public Set<Category> getCategories() {
    return categories;
  }

  public Product() {}

  public Product(
    Long id,
    String name,
    String description,
    Double price,
    String imgUrl,
    Set<Category> categories
  ) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.price = price;
    this.imgUrl = imgUrl;
    this.categories = categories;
  }
}
