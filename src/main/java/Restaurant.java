import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String name;
    private String location;
    public LocalTime openingTime;
    public LocalTime closingTime;
    private final List<Item> menu = new ArrayList<Item>();


    public Restaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        this.name = name;
        this.location = location;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }



    public boolean isRestaurantOpen() {

        // get current time
        LocalTime now=getCurrentTime();
        System.out.println("Current time : "+ now);

        //if current time is between opening and closing
        return now.isAfter(openingTime) && now.isBefore(closingTime);
    }


    public LocalTime getCurrentTime(){ return  LocalTime.now(); }

    public List<Item> getMenu() {

        Item i1 = new Item("Chicken Rice",10) ;
        menu.add(i1);
        Item i2 = new Item("Chicken soup",20) ;
        menu.add(i2);
        Item i3 = new Item("Lasagna",30) ;
        menu.add(i3);
        Item i4 = new Item("Spaghetti with meatballs",40) ;
        menu.add(i4);
        Item i5 = new Item("Chicken burger",50) ;
        menu.add(i5);
        Item i6 = new Item("Chicken parmesan",60) ;
        menu.add(i6);
        Item i7 = new Item("Chicken Pesto",70) ;
        menu.add(i7);
        Item i8 = new Item("Burger Sliders",80) ;
        menu.add(i8);
        Item i9 = new Item("Chicken Biryani",90) ;
        menu.add(i9);

    return menu;

    }

    Item findItemByName(String itemName){
        for(Item item: menu) {
            if(item.getName().equals(itemName))
                return item;
        }
        return null;
    }

    public void addToMenu(String name, int price) {
        Item newItem = new Item(name,price);
        menu.add(newItem);
    }
    
    public void removeFromMenu(String itemName) throws itemNotFoundException {

        Item itemToBeRemoved = findItemByName(itemName);
        if (itemToBeRemoved == null)
            throw new itemNotFoundException(itemName);

        menu.remove(itemToBeRemoved);
    }
    public void displayDetails(){
        System.out.println("Restaurant:"+ name + "\n"
                +"Location:"+ location + "\n"
                +"Opening time:"+ openingTime +"\n"
                +"Closing time:"+ closingTime +"\n"
                +"Menu:"+"\n"+getMenu());

    }

    public String getName() {
        return name;
    }

    //Method to compute Cost of all the Menu Items in a restaurant
    public int getTotalCostOfItems(List<Item> selectedItems){
        int totalCost = 0;
        for(Item item: selectedItems) {

            totalCost = totalCost + item.getPrice();
        }
        return  totalCost;


    }


}

