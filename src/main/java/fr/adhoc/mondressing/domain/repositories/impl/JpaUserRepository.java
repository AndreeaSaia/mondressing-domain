package fr.adhoc.mondressing.domain.repositories.impl;

import fr.adhoc.mondressing.domain.entities.User;
import fr.adhoc.mondressing.domain.repositories.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/** Find user objects by using the JPA API
 */

@Repository
public class JpaUserRepository implements UserRepository{ 
 
	@PersistenceContext
	private EntityManager entityManager;

	/** Set the entity manager. Assumes automatic dependency injection via the JPA @PersistenceContext
	*/
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager=(EntityManager) entityManager;
	}

	public User findById(int identifier) {
		return (User) ((EntityManager) entityManager).find(User.class,identifier);
	}

	public User findByEmail(String email) {
		return (User) ((EntityManager) entityManager).createQuery("select u from User u where u.email=?").setParameter(1,email).getSingleResult();	

	}

	@Override
	public void save(User user) {
		 entityManager.persist(user);
	}
	
	

	}




