package net.lshimokawa.ejemplos.springorm.dao.hibernate;

import net.lshimokawa.ejemplos.springorm.dao.UsuarioDao;
import net.lshimokawa.ejemplos.springorm.model.Usuario;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioDaoHibernate extends HibernateDaoSupport implements
		UsuarioDao {

	@Autowired
	public UsuarioDaoHibernate(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

	@Override
	public Usuario find(Integer idUsuario) {
		return getHibernateTemplate().get(Usuario.class, idUsuario);
	}

	@Override
	public Usuario findByUsername(String username) {
		return (Usuario) getHibernateTemplate().find(
				"from Usuario where username=?", username).get(0);
	}

	@Override
	public void save(Usuario usuario) {
		getHibernateTemplate().save(usuario);
	}

	@Override
	public void update(Usuario usuario) {
		getHibernateTemplate().update(usuario);
	}

	@Override
	public void delete(Usuario usuario) {
		getHibernateTemplate().delete(usuario);
	}

}