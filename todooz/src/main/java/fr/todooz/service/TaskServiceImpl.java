package fr.todooz.service;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.todooz.domain.Task;

@Service
public class TaskServiceImpl implements TaskService {
	
	@Inject
	private SessionFactory sessionFactory;


	@Override
	@Transactional
	public void save(Task task) {
		Session session = sessionFactory.getCurrentSession();
		session.save(task);

	}


	@Override
	@Transactional
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	@Override
	@Transactional
	public void delete(Long id) {
		Session session = sessionFactory.getCurrentSession();
		session.createQuery("delete from Task where id = :id").setParameter("id", id).executeUpdate();		
	}

	@Override
	@Transactional
	public List<Task> findAll() {
		Session session = sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(Task.class);
		return crit.list();
	}

	
	@Override
	@Transactional
	public List<Task> findByQuery(String query) {
		Session session = sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(Task.class);
		crit.add(Restrictions.ilike("title",query,MatchMode.ANYWHERE));
		return crit.list();
	}

	@Override
	@Transactional
	public int count() {
		return findAll().size();
	}
	

}
