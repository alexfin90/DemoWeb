package converters;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;
import model.Country;
import services.ServiceInit;


@Named
@ApplicationScoped
public class Countryconvert implements Converter {

	@Inject
	private ServiceInit servinit;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		// TODO Auto-generated method stub
		if (value != null && value.trim().length() > 0) {
			System.out.println("GetAsObject: " + value);
			Country c = servinit.getCountries().get(Integer.parseInt(value)-1);
			return c;
		} else {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		// TODO Auto-generated method stub
		System.out.println("convert with value: " + value);
		if (value != null) {		
			return String.valueOf(((Country) value).getIdCountry());		
		} else {
			return null;
		}
	}

}
