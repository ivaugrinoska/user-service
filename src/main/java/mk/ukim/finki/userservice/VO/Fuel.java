package mk.ukim.finki.userservice.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fuel {

    private Long id;

    private String name;

    private Float latitude;

    private Float longitude;
    private String imageUrl;
    private String pageLink;
}
