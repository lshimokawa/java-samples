package net.lshimokawa.ejemplos.apachecxf.jaxrs.dao.jdbc;

import javax.sql.DataSource;

import net.lshimokawa.ejemplos.apachecxf.jaxrs.dao.UsuarioDao;
import net.lshimokawa.ejemplos.apachecxf.jaxrs.model.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author lshimokawa
 * 
 */
@Repository
public class UsuarioDaoJdbc extends SimpleJdbcDaoSupport implements UsuarioDao {

	@Autowired
	public UsuarioDaoJdbc(DataSource dataSource) {
		setDataSource(dataSource);
	}

	public Usuario find(String username) {
		try {
			return getSimpleJdbcTemplate()
					.queryForObject(
							"select username, password, nombre from usuario where username=?",
							new BeanPropertyRowMapper<Usuario>(Usuario.class),
							username);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public void save(Usuario usuario) {
		getSimpleJdbcTemplate()
				.update("insert into usuario(username, password, nombre) values (?, ?, ?)",
						usuario.getUsername(), usuario.getPassword(),
						usuario.getNombre());
	}

	@Override
	public void update(Usuario usuario) {
		getSimpleJdbcTemplate().update(
				"update usuario set password=?, nombre=? where username=?",
				usuario.getPassword(), usuario.getNombre(),
				usuario.getUsername());
	}

	@Override
	public void delete(Usuario usuario) {
		getSimpleJdbcTemplate().update("delete from usuario where username=?",
				usuario.getUsername());
	}

}
