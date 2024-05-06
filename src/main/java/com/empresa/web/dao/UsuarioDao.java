package com.empresa.web.dao;

import java.sql.SQLException;
import java.util.List;

import com.empresa.web.modelo.Usuario;

public interface UsuarioDao {

	public void insert(Usuario usuario) throws SQLException;
	public Usuario select(int id);
	public List<Usuario> selectAll();
	public void delete(int id) throws SQLException;
	public void update(Usuario usuario) throws SQLException;
	
}
