import json_simple.JsonArray;
import json_simple.JsonObject;
import json_simple.Jsoner;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class OnlineRecipeDatabase {

    String baseUrl = "http://www.recipepuppy.com/api/?";

    public JsonObject getRecipesByIngredients(String ingredients) throws Exception
    {
        //Getting the things ready to connect to the web
        URL url = new URL(baseUrl+"i="+ingredients);
/* TODO 
You have to use the url to retrieve the contents of the website. 
This will be a String, but in JSON format. */
        return /* TODO 
Remember to return a JSON object.*/;
    }

    public JsonObject getRecipesByDish(String dish) throws Exception
    {
        //Getting the things ready to connect to the web
        /* TODO 
Fill in this data type (Object) */ url = new /* TODO
Fill in this datatype (Object) */(baseUrl+"q="+dish);

       /* TODO
Read the information coming from the web
 */
        return /* TODO 
return the appropriate result.
*/
    }


    public String formatRecipeAsString(JsonObject doc){
        String results = "";
        /* TODO 
This should return a String with each recipe in three lines:
Title:the title of the recipe
Link:the link to the recipe
Ingredients:The ingredients of teh recipe.*/
        return results;
    }

    public void saveRecipes(String text, String outfile){
        /* TODO
Given a String with some text in it, write that text to a file. 
The name of the file is given in outfile */
    }

}
