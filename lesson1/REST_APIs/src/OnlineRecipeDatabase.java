import json_simple.JsonArray;
import json_simple.JsonObject;
import json_simple.Jsoner;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class OnlineRecipeDatabase {

    String baseUrl = "http://www.recipepuppy.com/api/?";

    public JsonObject getRecipesByIngredients(String ingredients) throws Exception
    {
        //Getting the things ready to connect to the web
        URL url = new URL(baseUrl+"i="+ingredients);
        StringBuilder input = new StringBuilder();
/* TODO 
You have to use the url to retrieve the contents of the website. 
This will be a String, but in JSON format. */
//        try(Scanner scanner = new Scanner(url.openStream())) {
//            while(scanner.hasNext()){
//                input.append(scanner.nextLine());
//            }
//
//        } catch(MalformedURLException ex){
//            System.out.println("Check the URL. Error: " + ex.getMessage());
//        } catch (IOException ex) {
//            System.out.println("Could not read from the URL. Error: " + ex.getMessage());
//        }
        return Jsoner.deserialize(readFromUri(url), new JsonObject()) /* TODO
Remember to return a JSON object.*/;
    }

    public JsonObject getRecipesByDish(String dish) throws Exception
    {
        //Getting the things ready to connect to the web
        /* TODO 
Fill in this data type (Object) */ URL url = new URL /* TODO
Fill in this datatype (Object) */(baseUrl+"q="+dish);

       /* TODO
Read the information coming from the web
 */

        return Jsoner.deserialize(readFromUri(url), new JsonObject()); /* TODO
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
        JsonObject singleRecipe;
        JsonArray recipies = (JsonArray) doc.get("results");
        StringBuilder recipe = new StringBuilder();
        for (Object recipy : recipies) {
            singleRecipe = (JsonObject) recipy;
            recipe.append("title:").append(singleRecipe.get("title")).append("\n")
                    .append("href:").append(singleRecipe.get("href")).append("\n")
                    .append("ingredients:").append(singleRecipe.get("ingredients")).append("\n")
                    .append("thumbnail:").append(singleRecipe.get("thumbnail")).append("\n");
        }
        return recipe.toString();
    }

    public void saveRecipes(String text, String outfile){
        /* TODO
Given a String with some text in it, write that text to a file. 
The name of the file is given in outfile */
        try (FileWriter fileOutput = new FileWriter(outfile)) {
            fileOutput.write(text);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private String readFromUri (URL url) {
        StringBuilder input = new StringBuilder();
        try(Scanner scanner = new Scanner(url.openStream())) {
            while(scanner.hasNext()){
                input.append(scanner.nextLine());
            }

        } catch(MalformedURLException ex){
            System.out.println("Check the URL. Error: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Could not read from the URL. Error: " + ex.getMessage());
        }
        return input.toString();
    }

}
