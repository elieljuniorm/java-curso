package model.dao.impl;

import db.DB;
import db.DbException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

  public SellerDaoJDBC(Connection conn) { //conecta uma vez só e é utilizado em todo o código
    this.conn = conn;
  }

  //fim da dependencia

  @Override
  public void insert(Seller obj) {
    PreparedStatement st = null; //instancia
    try {
      st =
        conn.prepareStatement(
          "INSERT INTO seller " +
          "(Name, Email, BirthDate, BaseSalary, DepartmentId) " +
          "VALUES " +
          "(?, ?, ?, ?, ?)",
          Statement.RETURN_GENERATED_KEYS //recebe a resposta do banco em foma de key
        );

      st.setString(1, obj.getName());
      st.setString(2, obj.getEmail());
      st.setDate(3, new java.sql.Date(obj.getBirthDate().getTime()));
      st.setDouble(4, obj.getBaseSalary());
      st.setInt(5, obj.getDepartment().getId());

      int rowsAffected = st.executeUpdate();

      if (rowsAffected > 0) { //verifica se a linha foi afetada para receber o dado do banco
        ResultSet rs = st.getGeneratedKeys();
        if (rs.next()) { //armazena  o id do novo dado e armazena na variavel obj
          int id = rs.getInt(1);
          obj.setId(id);
        }
        DB.fecharResultado(rs); //fecha o recurso
      } else {
        throw new DbException("Erro inesperado, nenhuma linha foi afetada");
      }
    } catch (SQLException e) {
      throw new DbException(e.getMessage());
    } finally {
      DB.fecharConsulta(st); //fecha recurso
    }
  }

  @Override
	public void update(Seller obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"UPDATE seller "
					+ "SET Name = ?, Email = ?, BirthDate = ?, BaseSalary = ?, DepartmentId = ? "
					+ "WHERE Id = ?");
			
			st.setString(1, obj.getName());
			st.setString(2, obj.getEmail());
			st.setDate(3, new java.sql.Date(obj.getBirthDate().getTime()));
			st.setDouble(4, obj.getBaseSalary());
			st.setInt(5, obj.getDepartment().getId());
			st.setInt(6, obj.getId());
			
			st.executeUpdate();
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.fecharConsulta(st);
		}
	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("DELETE FROM seller WHERE Id = ?");
			
			st.setInt(1, id);
			
			st.executeUpdate();
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.fecharConsulta(st);
		}
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
