package restaurant.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restaurant.dtos.MenuDto;
import restaurant.services.MenuService;

import java.util.List;

@RestController
@RequestMapping("menus")
@Slf4j
@AllArgsConstructor
public class MenuController {
    private MenuService menuService;

    @GetMapping
    public List<MenuDto> getMenus() {
        return menuService.getMenus();
    }
}
