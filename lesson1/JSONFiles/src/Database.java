import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;
import jdk.nashorn.internal.parser.JSONParser;

import java.util.Arrays;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Database {
    /* TODO 
Declare a member variable that can 
be EASILY set from the constructor. */
    private final JsonArray restaurants;
    public Database(JsonObject data){
        /* TODO 
set the memebr variable declared above.*/
        this.restaurants = (JsonArray) data.get("restaurants");
    }

    public JsonObject getRestaurant(String name){
        /* TODO 
Complete this method as specified. */
        JsonObject result = null;
        JsonObject restaurant;
        for (Object o : this.restaurants) {
            restaurant = (JsonObject) o;
            if (restaurant.get("name").equals(name)) {
                return restaurant;
            }
        }

        return null;
    }

    public double getAvgReviews(String name){
        /* TODO 
Complete this method as specified.
 The previous method may be of help. 
*/
        JsonArray reviews = (JsonArray) getRestaurant(name).get("reviews");
        int reviewsSize = reviews.size();
        double sum = 0;
        JsonObject review;
        for (Object o : reviews) {
            review = (JsonObject) o;
            sum += Integer.parseInt(review.get("rating").toString());
        }
        System.out.println(((JsonArray) getRestaurant(name).get("reviews")).size());
        return sum/reviewsSize;
    }
}
