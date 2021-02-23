import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Task {
  public static void main(String[] args){
      Task t = new Task();
      JsonObject doc = t.readJson("./resources/restaurant-data.json");
      Database db = new Database(doc);
      System.out.println(db.getRestaurant("Hometown BBQ"));
      System.out.println(db.getAvgReviews("Casa Enrique"));
  }

  public JsonObject readJson(String filename) {
      /* TODO: create a JSON object with the contents of  "filename". You can use the method below to help you read the file. */
    return Jsoner.deserialize(readFile(filename), new JsonObject());
  }

  public String readFile(String filename){
      String content = "";
      try(BufferedReader reader = new BufferedReader(new FileReader(filename)) /* Complete this using the parameter passed to this method. */){
          /* Put in code to read the file line by line. */
          StringBuilder input = new StringBuilder();
//          String line = reader.readLine();
//          while(line != null){
//              input.append(line);
//              line = reader.readLine();
//              System.out.println(input.length());
//          }
          reader.lines().forEach(input::append);
          System.out.println(input.length());
          content = input.toString();
      } catch(IOException e) {
          e.printStackTrace();
          System.exit(-1);
      }
    return new String(content.getBytes(StandardCharsets.UTF_8));
      //      return content; /* Put in the variable that should be returned. */
  }
}