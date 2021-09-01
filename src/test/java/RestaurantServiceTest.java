import org.junit.jupiter.api.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class RestaurantServiceTest {

    RestaurantService service = new RestaurantService();
    public Restaurant restaurant;
    //REFACTOR ALL THE REPEATED LINES OF CODE


    //>>>>>>>>>>>>>>>>>>>>>>SEARCHING<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    @Test
    public void searching_for_existing_restaurant_should_return_expected_restaurant_object() throws itemNotFoundException {
        //WRITE UNIT TEST CASE HERE
        //Arrange
        Restaurant searchedRestaurant = service.findRestaurantByName("Amelie's cafe");

        //Arrange & Assert
        assertEquals(searchedRestaurant.getName(), restaurant.getName());

    }

    //You may watch the video by Muthukumaran on how to write exceptions in Course 3: Testing and Version control: Optional content
    @Test
    public void searching_for_non_existing_restaurant_should_throw_exception() throws restaurantNotFoundException {
        //WRITE UNIT TEST CASE HERE
        //Arrange & Assert
        assertThrows(restaurantNotFoundException.class,()->service.findRestaurantByName("Saifee Kabab's House"));

    }

    //<<<<<<<<<<<<<<<<<<<<SEARCHING>>>>>>>>>>>>>>>>>>>>>>>>>>




    //>>>>>>>>>>>>>>>>>>>>>>ADMIN: ADDING & REMOVING RESTAURANTS<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    @Test
    public void remove_restaurant_should_reduce_list_of_restaurants_size_by_1() throws restaurantNotFoundException, itemNotFoundException {

        int initialNumberOfRestaurants = service.getRestaurants().size();
        service.removeRestaurant("Amelie's cafe");
        assertEquals(initialNumberOfRestaurants-1, service.getRestaurants().size());
    }

    @Test
    public void removing_restaurant_that_does_not_exist_should_throw_exception() {


        assertThrows(restaurantNotFoundException.class,()->service.removeRestaurant("Pantry d'or"));
    }

    @Test
    public void add_restaurant_should_increase_list_of_restaurants_size_by_1(){

        int initialNumberOfRestaurants = service.getRestaurants().size();
        service.addRestaurant("Pumpkin Tales","Chennai",LocalTime.parse("12:00:00"),LocalTime.parse("23:00:00"));
        assertEquals(initialNumberOfRestaurants + 1,service.getRestaurants().size());
    }



    //New Test Case to check if the total cost of all the items in the menu is equal to sum of the price of all the items
    @Test
    public void selecting_items_from_menu_and_checking_if_the_total_cost_is_equal_to_the_sum_of_price_of_all_items_added_in_the_menu(){

        //Act
        List<Item> selectedItems = new ArrayList<>();
        Item temp = restaurant.findItemByName("Sweet corn soup");
        if (temp!=null)
            selectedItems.add(temp);
        temp = restaurant.findItemByName("Vegetable lasagne");
        if (temp!=null)
            selectedItems.add(temp);
        // Arrange
        int totalCost = restaurant.getTotalCostOfItems(selectedItems);

        // Assert
        assertEquals(totalCost,300);

        //Add more item and check the sum again
        restaurant.addToMenu("Indori Kabab", 300);
        temp = restaurant.findItemByName("Indori Kabab");
        if (temp!=null)
            selectedItems.add(temp);
        totalCost = restaurant.getTotalCostOfItems(selectedItems);
        assertEquals(totalCost,600);



    }
    //<<<<<<<<<<<<<<<<<<<<ADMIN: ADDING & REMOVING RESTAURANTS>>>>>>>>>>>>>>>>>>>>>>>>>>
}