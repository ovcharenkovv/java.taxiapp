package ua.net.itlabs.beans;

import ua.net.itlabs.model.Driver;

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
        return "view";
    }

    public Map<String, String> getBrands() {
        return brands;
    }

    public void setBrands(Map<String, String> brands) {
        this.brands = brands;
    }
}
