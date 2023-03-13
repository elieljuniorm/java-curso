package model.dao.impl;

import db.DB;
import db.DbException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class SellerDaoJDBC implements SellerDao {

  // dependencia para ser acessado em todo o SellerDaoJDBC
  private Connection conn;

  public SellerDaoJDBC(Connection conn) {
    this.conn = conn;
  }

  //fim da dependencia

  @Override
  public void insert(Seller obj) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'insert'");
  }

  @Override
  public void update(Seller obj) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'update'");
  }

  @Override
  public void deleteById(Integer id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException(
      "Unimplemented method 'deleteById'"
    );
  }

  @Override
  public Seller findById(Integer id) {
    PreparedStatement st = null;
    ResultSet rs = null;
    try {
      st =
        conn.prepareStatement(
          "SELECT seller.*,department.Name as DepName " +
          "FROM seller INNER JOIN department " +
          "ON seller.DepartmentId = department.Id " +
          "WHERE seller.Id = ?"
        );
      st.setInt(1, id);
      rs = st.executeQuery();

      if (rs.next()) {
        Department dep = instantiateDepartment(rs);
        Seller obj = instantiateSeller(rs, dep);
        return obj;
      }
      return null;
    } catch (SQLException e) {
      throw new DbException(e.getMessage());
    } finally {
      DB.fecharConsulta(st);
      DB.fecharResultado(rs);
    }
  }

  private Seller instantiateSeller(ResultSet rs, Department dep)
    throws SQLException {
    Seller obj = new Seller();
    obj.setId(rs.getInt("Id"));
    obj.setName(rs.getString("Name"));
    obj.setEmail(rs.getString("Email"));
    obj.setBirthDate(rs.getDate("BirthDate"));
    obj.setBaseSalary(rs.getDouble("BaseSalary"));
    obj.setDepartment(dep);
    return obj;
  }

  private Department instantiateDepartment(ResultSet rs) throws SQLException {
    Department dep = new Department();
    dep.setId(rs.getInt("DepartmentId"));
    dep.setName(rs.getString("DepName"));
    return dep;
  }

  @Override
  public List<Seller> findAll() {
    PreparedStatement st = null;
    ResultSet rs = null;
    try {
      st =
        conn.prepareStatement(
          "SELECT seller.*,department.Name as DepName " +
          "FROM seller INNER JOIN department " +
          "ON seller.DepartmentId = department.Id " +
          "ORDER BY Name"
        );

      rs = st.executeQuery();

      List<Seller> list = new ArrayList<>();
      Map<Integer, Department> map = new HashMap<>(); //lista vazia para receber o id do departamento

      while (rs.next()) { //faz o loop para imprimir os valores do seller com o department de cada tabela
        Department dep = map.get(rs.getInt("DepartmentId")); //intancia o departamento pela primeira vez e salva na variavel dep

        if (dep == null) { //testa se o department é null, se for ele intancia outro departamento com outro id. Se nao for ele pula e usa outro id existente
          dep = instantiateDepartment(rs);
          map.put(rs.getInt("DepartmentId"), dep);
        }
        Seller obj = instantiateSeller(rs, dep);
        list.add(obj);
      }
      return list;
    } catch (SQLException e) {
      throw new DbException(e.getMessage());
    } finally {
      DB.fecharConsulta(st);
      DB.fecharResultado(rs);
    }
  }

  @Override
  public List<Seller> findByDepartment(Department department) {
    PreparedStatement st = null;
    ResultSet rs = null;
    try {
      st =
        conn.prepareStatement(
          "SELECT seller.*,department.Name as DepName " +
          "FROM seller INNER JOIN department " +
          "ON seller.DepartmentId = department.Id " +
          "WHERE DepartmentId = ? " +
          "ORDER BY Name"
        );
      st.setInt(1, department.getId());
      rs = st.executeQuery();
      List<Seller> list = new ArrayList<>();
      Map<Integer, Department> map = new HashMap<>(); //lista vazia para receber o id do departamento

      while (rs.next()) { //faz o loop para imprimir os valores do seller com o department de cada tabela
        Department dep = map.get(rs.getInt("DepartmentId")); //intancia o departamento pela primeira vez e salva na variavel dep

        if (dep == null) { //testa se o department é null, se for ele intancia outro departamento com outro id. Se nao for ele pula e usa outro id existente
          dep = instantiateDepartment(rs);
          map.put(rs.getInt("DepartmentId"), dep);
        }
        Seller obj = instantiateSeller(rs, dep);
        list.add(obj);
      }
      return list;
    } catch (SQLException e) {
      throw new DbException(e.getMessage());
    } finally {
      DB.fecharConsulta(st);
      DB.fecharResultado(rs);
    }
  }
}
