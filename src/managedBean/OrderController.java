package managedBean;

import java.io.Serializable;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import model.Order;

@Named("orderController")
@SessionScoped
public class OrderController implements Serializable {
	
	 private Order order;

	 @Inject
	 private RingController ringController;
	 
	 @Inject
	 private UserController userController;
	 
	 @Inject
	 private beanDao.OrderHome orderHome;

	 public OrderController() {
		// TODO Auto-generated constructor stub
	 }
	 
	 @PostConstruct
	 public void init(){
		 order = new Order();
	 }
	
	
	 public void cretateOrder(ActionEvent e){
		 FacesMessage message = null;
		 Calendar cal = Calendar.getInstance();
		 order.setDate(cal.getTime());
		 ringController.getSelectedItem().addOrder(order);
		 userController.getUser().addOrder(order);
		 orderHome.persist(order);
		 message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Order", "Create OK");
		 FacesContext.getCurrentInstance().addMessage(null, message);
	 }


	public Order getOrder() {
		return order;
	}


	public void setOrder(Order order) {
		this.order = order;
	}
	
	

}
