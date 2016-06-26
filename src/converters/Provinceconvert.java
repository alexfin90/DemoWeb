package converters;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;
import model.Province;
import services.ServiceInit;


@Named
@ApplicationScoped
public class Provinceconvert implements Converter {
	
	@Inject
	private ServiceInit servinit;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		// TODO Auto-generated method stub
		
		if (value != null && value.trim().length() > 0) {
			System.out.println("GetAsObject Province: " + value);
			Province p = servinit.getProvinces().get(Integer.parseInt(value)-1);
			System.out.println(p.getName());
			return p;
		} else {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		System.out.println("convert with value: " + value);
		if (value != null) {		
			return String.valueOf(((Province) value).getIdprovince());	
		} else {
			return null;
		}
	}

}
