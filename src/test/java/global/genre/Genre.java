package global.genre;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public abstract class Genre {

    private final String configPath = "src/test/resources/lang/action.json";

    public void goToGenre(){

    }

    public String getActionName(String key){
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = null;
        try {
            root = mapper.readTree(new File(configPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return root.path(key).asText();
    }

}
