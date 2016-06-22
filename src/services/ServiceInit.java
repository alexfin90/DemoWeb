package services;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.Eager;

import model.Province;
import model.Country;

@Named("serviceInit")
@ApplicationScoped
@Eager
public class ServiceInit implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Country> countries;
	private List<Province> provinces;
	
	@Inject
	private beanUtils.BeanStartup beanStartup;
	
	
	public ServiceInit() {
		// TODO Auto-generated constructor stub
		
		
	}
	
	@PostConstruct
	public void init()
    {
		System.out.println("Init-DemoWeb-Application");
		countries = beanStartup.getCoutries();
		provinces = beanStartup.getProvinces();
    }

	public List<Country> getCountries() {
		return countries;
	}

	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}

	public List<Province> getProvinces() {
		return provinces;
	}

	public void setProvinces(List<Province> provinces) {
		this.provinces = provinces;
	}

}
