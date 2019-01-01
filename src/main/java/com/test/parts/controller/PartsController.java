package com.test.parts.controller;

import com.test.parts.model.Part;
import com.test.parts.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class PartsController {
    private PartService partService;

    @Autowired
    public PartsController(PartService partService) {
        this.partService = partService;
    }

    @GetMapping("/parts")
    public String parts(
            @RequestParam(name = "page", required = false, defaultValue = "0") int page,
            @RequestParam(name = "filter", required = false, defaultValue = "") String filter,
            Model model
    ) {
        Page<Part> partPage;
        String uri = "/parts";
        if (filter.equals("required")) {
            partPage = partService.getPartsPage(page, true);
            uri += "?filter=required";
        } else if (filter.equals("not_required")) {
            partPage = partService.getPartsPage(page, false);
            uri += "?filter=not_required";
        } else {
            partPage = partService.getPartsPage(page);
        }

        model.addAttribute("parts", partPage);
        model.addAttribute("buildable", partService.getBuildableQuantity());
        model.addAttribute("uri", uri);
        return "parts";
    }

    @GetMapping("/parts/search")
    public String searchParts(
            @RequestParam(name = "page", required = false, defaultValue = "0") int page,
            @RequestParam(name = "name") String name,
            Model model
    ) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Invalid parameter name: " + name);
        }

        model.addAttribute("parts", partService.searchParts(name, page));
        model.addAttribute("buildable", partService.getBuildableQuantity());
        model.addAttribute("uri", "/parts/search?name=" + name);
        return "parts";
    }

    @GetMapping("/parts/add")
    public String addPartForm(Part part) {
        return "add_part";
    }

    @PostMapping("/parts/add")
    public String addPart(@Valid Part part, BindingResult result) {
        if (result.hasErrors()) {
            return "add_part";
        }

        partService.savePart(part);
        return "redirect:/parts";
    }

    @GetMapping("/parts/edit/{id}")
    public String updatePartForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("part", partService.getPartById(id));
        return "edit_part";
    }

    @PostMapping("/parts/edit/{id}")
    public String updatePart(@Valid Part part, BindingResult result) {
        if (result.hasErrors()) {
            return "edit_part";
        }

        partService.savePart(part);
        return "redirect:/parts";
    }

    @GetMapping("/parts/delete/{id}")
    public String deletePart(@PathVariable("id") Long id) {
        partService.deletePart(id);
        return "redirect:/parts";
    }
}
