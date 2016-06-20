package managedBean;
import java.io.Serializable;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import model.*;

@Named("userBean")
@RequestScoped
public class SiginUserController implements Serializable{
	
	@Inject 
	private beanDao.UserHome userHome;
	
	private User user;
	private String name;
	private String surname;
	private String username;
	private String password;
	private Date birthday;
	private String city;
//	private String country;
//	private String province;
	private Country country;
	private Province province;
	
	@PostConstruct
	public void init(){
		user = new User();
	}
	
	public void updateData(ActionEvent e){
		System.out.println("updateData");
		user.setUsername(username);
		user.setSurname(surname);
		user.setPassword(password);
		user.setProvince(province.getName());
		user.setName(name);
		user.setCountry(country.getName());
		user.setCity(city);
		user.setBirthday(birthday);
		userHome.persist(user);
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registrato utente:", name);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
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

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}


	public void setCountry(Country country) {
		this.country = country;
	}

	public void setProvince(Province province) {
		this.province = province;
	}
	
	public Country getCountry() {
		return country;
	}
	
	public Province getProvince() {
		return province;
	}

}
