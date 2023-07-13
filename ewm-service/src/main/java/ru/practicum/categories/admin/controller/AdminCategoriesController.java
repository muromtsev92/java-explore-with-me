package ru.practicum.categories.admin.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.practicum.categories.admin.service.AdminCategoriesService;
import ru.practicum.categories.dto.CategoryDto;
import ru.practicum.categories.dto.NewCategoryDto;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/admin")
@RequiredArgsConstructor
@Slf4j
public class AdminCategoriesController {
    @Autowired
    private AdminCategoriesService service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/categories")
    public CategoryDto createCategories(@RequestBody @Valid NewCategoryDto newCategoryDto) {
        log.debug("POST: /categories");
        return service.createCategories(newCategoryDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "/categories/{catId}")
    public void deleteCategories(@PathVariable(name = "catId") int catId) {
        log.debug("DELETE: /categories/{}", catId);
        service.deleteCategories(catId);
    }

    @PatchMapping(path = "/categories/{catId}")
    public CategoryDto changeCategories(@PathVariable(name = "catId") int catId,
                                        @RequestBody @Valid CategoryDto categoryDto) {
        log.debug("PATCH: /categories/{}", catId);
        return service.changeCategories(catId, categoryDto);
    }
}
