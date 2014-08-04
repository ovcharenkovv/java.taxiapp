package ua.net.itlabs.beans;

import ua.net.itlabs.model.Order;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.HashMap;
import java.util.Map;

@ManagedBean(name = "createOrderBean")
@SessionScoped
public class CreateOrderBean {

    private Order order = new Order();

    public String create() {
        return "viewOrder";
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
