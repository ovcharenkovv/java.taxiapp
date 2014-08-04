package ua.net.itlabs.beans;

import ua.net.itlabs.model.Driver;

//import javax.annotation.ManagedBean;
//import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "createDriverBean")
@SessionScoped
public class CreateDriverBean {

    private Driver driver = new Driver();

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public String create() {
        return "view";
    }
}
