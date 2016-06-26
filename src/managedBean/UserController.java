package managedBean;
import java.io.Serializable;


import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;


import model.Item;
import model.Order;
import model.User;

@Named("userView")
@SessionScoped
public class UserController implements Serializable {

	private String username;
	private String password;
	private boolean login;
	private User user;
	private String desc;
	
	@Inject
	private beanUtils.BeanLogin beanlogin;
	
	@Inject
	private beanDao.UserHome userHome;

	public UserController() {
		// TODO Auto-generated constructor stub	
	}
	
	@PostConstruct
	public void init(){
		this.login=false;
		
	}
	   

	public void login(ActionEvent e){
		RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;
        boolean loggedIn = false; 
        loggedIn = beanlogin.login(username, password);
        if ( loggedIn == true ){
        	message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", username);
        	setLogin(loggedIn);
        }
        else if (loggedIn == false){
        	message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Invalid credentials");
        	setLogin(loggedIn);
        }
        FacesContext.getCurrentInstance().addMessage(null, message);
        context.addCallbackParam("loggedIn", loggedIn);
        this.user = userHome.findByUsername(username); 
	}
	
	public void logout(ActionEvent e){
		System.out.println("LOGOUT");
        FacesMessage message = null;
        setLogin(false);
    	message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Ok Log-out", username);
    	FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setLogin(boolean login) {
		this.login = login;
	}
	
	public boolean isLogin() {
		return login;
	}
	
	public String nextPage(){
		return "sigin";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	

}
