import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class RestaurantService {
    private static final List<Restaurant> restaurants = new ArrayList<>();

    //Select opening and closing time
    private static final LocalTime opening_time=LocalTime.parse( "10:00" );
    private static final LocalTime closing_time=LocalTime.parse( "21:30" );
    RestaurantService() {
        restaurants.add(new Restaurant("Haldiram", "CP",opening_time, closing_time));
        restaurants.add(new Restaurant("Amelie's cafe", "Lajpat Nagar",opening_time, closing_time));
        restaurants.add(new Restaurant("Naivedhyam", "Amar colony",opening_time, closing_time));
        restaurants.add(new Restaurant("Veeraswami", "CP",opening_time, closing_time));
        restaurants.add(new Restaurant("Barbecue Restaurant", "DLF",opening_time, closing_time));
        restaurants.add(new Restaurant("The Breakfast Story", "CP4",opening_time, closing_time));
        restaurants.add(new Restaurant("Ashoka Restaurant", "CP",opening_time, closing_time));
        restaurants.add(new Restaurant("Little Italy ", "DLF Phase 1",opening_time, closing_time));
        restaurants.add(new Restaurant("Engineers Hub", "CP",opening_time, closing_time));

    }
    public Restaurant findRestaurantByName(String restaurantName) throws  itemNotFoundException {
        for(Restaurant res:restaurants) {
            if(res.getName().contains(restaurantName)) {
                return res;
            }
        }
        throw new itemNotFoundException("Restaurant not found");
    }



    public Restaurant addRestaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        Restaurant newRestaurant = new Restaurant(name, location, openingTime, closingTime);
        restaurants.add(newRestaurant);
        return newRestaurant;
    }

    public Restaurant removeRestaurant(String restaurantName) throws restaurantNotFoundException, itemNotFoundException {
        Restaurant restaurantToBeRemoved = findRestaurantByName(restaurantName);
        restaurants.remove(restaurantToBeRemoved);
        return restaurantToBeRemoved;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }
}
