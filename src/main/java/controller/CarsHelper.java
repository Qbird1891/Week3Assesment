package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Cars;

/**
 * @author Itsal - Quinn Birdsley CIS175 - Fall 2023 Sep 11, 2023
 */
public class CarsHelper {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("Cars");

	public void persist(Cars model) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(model);
		manager.getTransaction().commit();
		manager.close();
	}

	// deleting an entity
	public void delete(Cars model) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.remove(manager.find(Cars.class, model.getRowId()));
		manager.getTransaction().commit();
		manager.close();
	}

	// showing all entities
	public List<Cars> showAllCars() {
		EntityManager manager = factory.createEntityManager();
		@SuppressWarnings("unchecked")
		List<Cars> allItems = manager.createQuery("SELECT i FROM Cars i").getResultList();
		manager.close();
		return allItems;
	}

	// updating entities
	public void update(Cars model) {
		EntityManager manager = factory.createEntityManager();
		Cars cardbEntity = manager.find(Cars.class, model.getRowId());
		manager.getTransaction().begin();
		cardbEntity.setMake((model.getMake()));
		cardbEntity.setModel((model.getModel()));
		cardbEntity.setYear((model.getYear()));
		manager.getTransaction().commit();
		manager.close();

	}
}
