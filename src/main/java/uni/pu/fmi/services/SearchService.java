package uni.pu.fmi.services;
import lombok.Getter;
import uni.pu.fmi.models.Property;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Getter
public class SearchService {
    private final List<Property> properties;
    private String input;
    private String message;
    public SearchService(){
        properties = new ArrayList<Property>();
        Property property = new Property();
        property.setName("Imot 1");
        property.setLocation("Plovdiv");
        property.setPrice(0d);
        properties.add(property);
    }
    public void addToInputBox(String value) {
        this.input = value;
    }
    public void clickSearchButton() {
        boolean isEmpty =  input == null || input.isEmpty();
        if (isEmpty) message = "Липса на входни данни";
        else message = new SearchService().search(input);
    }
    public String search(String input) {
        if (!legalKeyword(input) || input.length() > 30) return  "Невалидни входни данни";
        boolean propertyExists = properties.stream().anyMatch(property -> property.getName().contains(input));
        return propertyExists ? "Намерено" : "Няма намерени резултати";
    }
    public boolean legalKeyword(String input){
        return Pattern.compile("[A-Za-z]{2,30}.*").matcher(input).find();
    }

}
