package ua.net.itlabs.beans;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.net.itlabs.entities.DriverEntity;
import ua.net.itlabs.entities.OrderEntity;
import ua.net.itlabs.model.Order;
import ua.net.itlabs.utils.HibernateUtil;

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


        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            OrderEntity orderEntity = new OrderEntity();
            orderEntity.setSource(order.getFrom());
            orderEntity.setState(order.getStatus());
            orderEntity.setTarget("stub");


            DriverEntity driverEntity = new DriverEntity();
            driverEntity.setAutoPlate("ppp");
            driverEntity.setBrand("Brand");
            driverEntity.setFirstName("first");
            driverEntity.setLastName("last");
            driverEntity.setModel("model");

            long orderId = (Long) session.save(orderEntity);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return "viewOrder";

    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
