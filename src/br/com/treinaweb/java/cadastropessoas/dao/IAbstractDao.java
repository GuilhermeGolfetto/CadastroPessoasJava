package br.com.treinaweb.java.cadastropessoas.dao;

import java.sql.SQLException;
import java.util.List;

public interface IAbstractDao<T> {

	List<T> all() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;

	T findById(int id) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;

	void insert(T entidade) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;

	void update(T entidade) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;

	void delete(T entidade) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;
}
