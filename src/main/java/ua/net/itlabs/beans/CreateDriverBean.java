package ua.net.itlabs.beans;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.net.itlabs.entities.DriverEntity;
import ua.net.itlabs.model.Driver;
import ua.net.itlabs.utils.HibernateUtil;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.HashMap;
import java.util.Map;

@ManagedBean(name = "createDriverBean")
@SessionScoped
public class CreateDriverBean {

    private Driver driver = new Driver();

    private Map<String, String> brands = new HashMap<String, String>();

    @PostConstruct
    public void init() {
        brands = new HashMap<String, String>();
        brands.put("Audi", "Audi");
        brands.put("BMW", "BMW");
        brands.put("Opel", "Opel");
    }


    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }



    public String create() {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            DriverEntity driverEntity = new DriverEntity();
            driverEntity.setAutoPlate(driver.getAutoPlate());
            driverEntity.setBrand(driver.getBrand());
            driverEntity.setFirstName(driver.getFirstName());
            driverEntity.setLastName(driver.getLastName());
            driverEntity.setModel(driver.getModel());
            long driverId = (Long) session.save(driverEntity);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return "viewDriver";
    }






    public Map<String, String> getBrands() {
        return brands;
    }

    public void setBrands(Map<String, String> brands) {
        this.brands = brands;
    }
}
