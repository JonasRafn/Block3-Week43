package facade;

import entity.Car;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Facade {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_dev");
    EntityManager em = emf.createEntityManager();

    public Car addCar(Car car) {
        em.getTransaction().begin();
        em.persist(car);
        em.getTransaction().commit();
        return car;
    }

    public List<Car> getCars() {
        Query query = em.createQuery("SELECT c FROM Car c");
        return query.getResultList();
    }

    public Car editCar(Car car) {
        
        return car;
    }

    public void deleteCar(Long id) {
        em.getTransaction().begin();
        em.remove(id);
        em.getTransaction().commit();
    }
}
