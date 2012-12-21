package fr.todooz.service;

import java.util.List;

import org.hibernate.SessionFactory;

import fr.todooz.domain.Task;

public interface TaskService {

	public void save(Task task);

	public void setSessionFactory(SessionFactory sessionFactory);

	public void delete(Long id);

	public List<Task> findAll();

	public List<Task> findByQuery(String query);

	public int count();

}