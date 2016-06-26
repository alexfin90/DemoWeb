package managedBean;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;
import javax.inject.Named;

import model.Country;
import model.Province;
import model.User;

@Named("userBean")
@RequestScoped
public class SiginUserController implements Serializable{
	
	@Inject 
	private beanDao.UserHome userHome;
	
	@Inject
	private services.ServiceInit serviceInit;
	
	private User user;
	private String name;
	private String surname;
	private String username;
	private String password;
	private Date birthday;
	private String city;
	
	private Country country;
	private List<Country> countries;
	
	private Province province;
	private List<Province> provinces;
	
	boolean countryset;
	
	private String prova;
	
	@PostConstruct
	public void init(){
		user = new User();
		this.countryset=false;
		// prendo la lista dei country
		this.countries = serviceInit.getCountries();
		this.provinces = serviceInit.getProvinces();
		
		
	}
	
	public void registerUser(ActionEvent e){
		user.setUsername(username);
		user.setSurname(surname);
		user.setPassword(password);
		user.setName(name);
		user.setCountry(country.getName());
		user.setProvince(province.getName());
		user.setCity(city);
		user.setBirthday(birthday);
		userHome.persist(user);
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registrato utente:", name);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	public void countrySelectionChanged(final AjaxBehaviorEvent event){
		this.countryset=true;
		this.provinces = country.getProvinces();
		//serviceInit.setProvinces(this.provinces);
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

	public Country getCountry() {
		return country;
	}

	public List<Country> getCountries() {
		return countries;
	}

	public Province getProvince() {
		return province;
	}

	public List<Province> getProvinces() {
		return provinces;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

	public void setProvinces(List<Province> provinces) {
		this.provinces = provinces;
	}

	public boolean isCountryset() {
		return countryset;
	}

	public void setCountryset(boolean countryset) {
		this.countryset = countryset;
	}

	public String getProva() {
		return prova;
	}
	public void setProva(String prova) {
		this.prova = prova;
	}
	
}
