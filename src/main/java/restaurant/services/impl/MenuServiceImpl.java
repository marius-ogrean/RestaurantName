package restaurant.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import restaurant.dataAccess.MenuRepository;
import restaurant.dtos.MenuDto;
import restaurant.services.MenuService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MenuServiceImpl implements MenuService {
    private MenuRepository menuRepository;

    @Override
    public List<MenuDto> getMenus() {
        return menuRepository.findAll().stream().map(Mappers::mapMenuToDto)
                .collect(Collectors.toList());
    }
}
