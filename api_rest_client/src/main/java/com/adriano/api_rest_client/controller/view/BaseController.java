package com.adriano.api_rest_client.controller.view;

import com.adriano.api_rest_client.domain.dto.BaseDTO;
import com.adriano.api_rest_client.service.BaseService;
import com.adriano.api_rest_client.service.CrudHooks;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

public abstract class BaseController<T extends BaseDTO, ID> {

    protected final String entityName;
    protected final String basePath;
    private final BaseService<T, ID> service;

    protected BaseController(BaseService<T, ID> service, String entityName, String basePath) {
        this.service = service;
        this.entityName = entityName;
        this.basePath = basePath;
    }

    protected abstract T createNewInstance();

    protected abstract void populateFormModel(Model model, T entity);

    @GetMapping
    public String list(Model model) {
        model.addAttribute("entities", service.getAll());
        model.addAttribute("isList", true);
        model.addAttribute("basePath", basePath);
        model.addAttribute("entityName", entityName);
        return template("list");
    }

    @GetMapping("/{id}")
    public String view(@PathVariable ID id, Model model, RedirectAttributes redirectAttributes) {
        Optional<T> entity = service.findById(id);
        if (entity.isEmpty()) {
            redirectAttributes.addFlashAttribute("error", entityName + " not found");
            return "redirect:/" + basePath;
        }
        model.addAttribute("entity", entity.get());
        model.addAttribute("isReadOnly", true);
        model.addAttribute("isEdit", false);
        model.addAttribute("basePath", basePath);
        model.addAttribute("entityName", entityName);
        populateFormModel(model, entity.get());
        return template("form");
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        T instance = createNewInstance();
        model.addAttribute("entity", instance);
        model.addAttribute("isEdit", false);
        model.addAttribute("isReadOnly", false);
        model.addAttribute("basePath", basePath);
        model.addAttribute("entityName", entityName);
        populateFormModel(model, instance);
        return template("form");
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable ID id, Model model, RedirectAttributes redirectAttributes) {
        Optional<T> entity = service.findById(id);
        if (entity.isEmpty()) {
            redirectAttributes.addFlashAttribute("error", entityName + " not found");
            return "redirect:/" + basePath;
        }
        model.addAttribute("entity", entity.get());
        model.addAttribute("isEdit", true);
        model.addAttribute("isReadOnly", false);
        model.addAttribute("basePath", basePath);
        model.addAttribute("entityName", entityName);
        populateFormModel(model, entity.get());
        return template("form");
    }

    @PostMapping
    public String create(@ModelAttribute T entity, RedirectAttributes redirectAttributes) {
        service.create(entity);
        redirectAttributes.addFlashAttribute("success", entityName + " created");
        return "redirect:/" + basePath;
    }

    @PostMapping("/{id}")
    public String update(@PathVariable ID id, @ModelAttribute T entity, RedirectAttributes redirectAttributes) {
        service.update(id, entity);
        redirectAttributes.addFlashAttribute("success", entityName + " updated");
        return "redirect:/" + basePath;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable ID id, RedirectAttributes redirectAttributes) {
        service.delete(id);
        redirectAttributes.addFlashAttribute("success", entityName + " deleted");
        return "redirect:/" + basePath;
    }

    protected String template(String viewName) {
        return basePath + "/" + viewName;
    }
}
