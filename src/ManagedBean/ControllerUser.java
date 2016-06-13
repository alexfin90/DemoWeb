package ManagedBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;


import bean.EJB_provaLocal;



@ManagedBean(name="userBean", eager=true)
@SessionScoped
public class ControllerUser {
	
	
	@Inject
	private EJB_provaLocal ejb_provaLocal;
	
	
	private String name;
	
	
	public void updateData(ActionEvent e){
		   System.out.println("UPADATEEEEEE");
		  ejb_provaLocal.ciao();
		 //  this.name=ejb_user.manipolate("Ciao");
		}
	
	public String getName() {
		return name;
	}
	
	 public void setName(String name) {
		this.name = name;
	};
	
	

}
