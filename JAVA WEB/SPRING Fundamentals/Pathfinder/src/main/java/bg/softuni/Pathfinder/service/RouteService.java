package bg.softuni.Pathfinder.service;

import bg.softuni.Pathfinder.model.dto.RouteShortInfoDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RouteService {
    RouteShortInfoDTO getRandomRoute();
    List<RouteShortInfoDTO> getAllRoutes();
}