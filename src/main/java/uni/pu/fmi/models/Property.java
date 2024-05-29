package uni.pu.fmi.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Property {
    public Property(String name, String location, Double price) {
        this.name = name;
        this.location = location;
        this.price = price;
    }
    private String name;
    private LocalDateTime date;
    private String location;
    private Double price;
}