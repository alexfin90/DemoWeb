package managedBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import model.Item;

@Named("ringView")
@SessionScoped
public class RingController implements Serializable{
	
	private List<Item> items;
	private Item selectedItem;
	
	@Inject 
	private beanDao.ItemHome itemHome;
	
	

    
   @PostConstruct
    public void init() {
        items = new ArrayList<Item>();
        items= itemHome.findAlItems(); 
    }
   
   public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Item getSelectedItem() {
		return selectedItem;
	}

	public void setSelectedItem(Item selectedItem) {
		this.selectedItem = selectedItem;
	}
	
	public String pageOrder() {
		return "order";
	}
    
	public void createOrder(ActionEvent e){
		
		
	}

}
