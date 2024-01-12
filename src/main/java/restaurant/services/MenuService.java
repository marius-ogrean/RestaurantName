package restaurant.services;

import restaurant.dtos.MenuDto;

import java.util.List;

public interface MenuService {
    List<MenuDto> getMenus();
}
