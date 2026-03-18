package TP1;

import java.util.List;

public class Menu {
    private List<ItemMenu> items;

    public Menu(List<ItemMenu> items){
        this.items = items;
    }

    public List<ItemMenu> getItems(){
        return items;
    }
}
