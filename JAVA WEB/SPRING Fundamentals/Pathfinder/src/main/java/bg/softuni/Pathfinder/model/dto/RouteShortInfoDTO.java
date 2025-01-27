package bg.softuni.Pathfinder.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class RouteShortInfoDTO {
    private long id;
    private String name;
    private String description;
    private String imageUrl;
}
