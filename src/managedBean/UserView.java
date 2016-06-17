package managedBean;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import org.primefaces.context.RequestContext;


@ManagedBean(name="userView")
@SessionScoped
public class UserView {

	private String username;
	private String password;
	
	@Inject
	private beanUtils.BeanLogin beanlogin;
	
	public UserView() {
		// TODO Auto-generated constructor stub
	}

	public void login(ActionEvent e){
		RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;
        boolean loggedIn = false; 
        System.out.println(username+password);
        loggedIn = beanlogin.login(username, password);
        if ( loggedIn == true ){
        	System.out.println("trovato");
        	message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", username);
        }
        else if (loggedIn == false){
        	System.out.println("non trovato");
        	message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Invalid credentials");
        }
        FacesContext.getCurrentInstance().addMessage(null, message);
        context.addCallbackParam("loggedIn", loggedIn);
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
	
	public String nextPage(){
		return "sigin";
	}

}
