package bg.softuni.Pathfinder.service.impl;

import bg.softuni.Pathfinder.model.Picture;
import bg.softuni.Pathfinder.model.Route;
import bg.softuni.Pathfinder.model.dto.RouteShortInfoDTO;
import bg.softuni.Pathfinder.repository.RouteRepository;
import bg.softuni.Pathfinder.service.RouteService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class RouteServiceImpl implements RouteService {
    private RouteRepository routeRepository;
    private Random random;
    private ModelMapper modelMapper;

    public RouteServiceImpl(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
        this.modelMapper = new ModelMapper();
        this.random = new Random();
    }


    @Transactional
    @Override
    public RouteShortInfoDTO getRandomRoute() {
        long routeCount = routeRepository.count();
        long randomId = random.nextLong(routeCount) + 1;

        Optional<Route> route = routeRepository.findById(randomId);

        if (route.isEmpty()) {
            // throw exception; return empty
        }

        return mapToShortInfo(route.get());
    }

    @Transactional
    @Override
    public List<RouteShortInfoDTO> getAllRoutes() {
        return routeRepository.findAll().stream().map(this::mapToShortInfo).toList();
    }

    private RouteShortInfoDTO mapToShortInfo(Route route) {
        RouteShortInfoDTO dto = modelMapper.map(route, RouteShortInfoDTO.class);

//        Optional<Picture> first = route.getPictures().stream().findFirst();
//        dto.setImageUrl(first.get().getUrl());

        return dto;
    }
}