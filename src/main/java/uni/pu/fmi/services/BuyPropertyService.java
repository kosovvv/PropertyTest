package uni.pu.fmi.services;

import lombok.Getter;
import uni.pu.fmi.models.Property;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Getter
public class BuyPropertyService {
    private boolean isPaymentMethodChosen;
    private String email;
    private String message;
    private final List<Property> properties;
    public BuyPropertyService(){
        properties = new ArrayList<Property>();
        Property property = new Property();
        property.setName("Imot 1");
        property.setLocation("Plovdiv");
        property.setPrice(0d);
        properties.add(property);
    }
    public void choosePaymentMethod(boolean value) {
        this.isPaymentMethodChosen = value;
    }
    public void addEmail(String value) {
        this.email = value;
    }

    public void checkout(Property property) {
        boolean notValidEmail = email == null || email.isEmpty();
        if (notValidEmail || isPaymentMethodChosen == false) message = "Попълнете всички полета";
        else message = new BuyPropertyService().buyTicket(property, isPaymentMethodChosen, email);
    }

    public String buyTicket(Property currentProperty, boolean isPaySelected, String email){
        boolean validEmail = validate(email);
        boolean result = properties.stream().anyMatch(property -> property.getName()
                .equals(currentProperty.getName()) && validEmail);
        return result ? "Успешно закупен" : "Невалидни данни";

    }
    private static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    private static boolean validate(String emailStr) {
        return VALID_EMAIL_ADDRESS_REGEX .matcher(emailStr).find();
    }
}
