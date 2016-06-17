package managedBean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import model.Item;

@ManagedBean(name="ringView" , eager=true)
@ApplicationScoped
public class RingView {
	
	private List<Item> items;
	private Item selectedItem;
    
   @PostConstruct
    public void init() {
        items = new ArrayList<Item>();
         
        items.add(new Item(1,"a","b",2));
        items.add(new Item(1,"a","b",2));
        items.add(new Item(1,"a","b",2));
        items.add(new Item(1,"a","b",2));
        items.add(new Item(1,"a","b",2));
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

}
