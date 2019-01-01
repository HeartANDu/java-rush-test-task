package com.test.parts.service;

import com.test.parts.model.Part;
import com.test.parts.repository.PartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartService {
    private final static int PAGE_SIZE = 10;

    private PartRepository partRepository;

    @Autowired
    public PartService(PartRepository partRepository) {
        this.partRepository = partRepository;
    }

    public Page<Part> getPartsPage(int page) {
        return partRepository.findAll(PageRequest.of(page, PAGE_SIZE));
    }

    public Page<Part> getPartsPage(int page, boolean isRequired) {
        return partRepository.findByRequired(isRequired, PageRequest.of(page, PAGE_SIZE));
    }

    public Page<Part> searchParts(String name, int page) {
        return partRepository.findByNameLike(String.format("%%%s%%", name), PageRequest.of(page, PAGE_SIZE));
    }

    public int getBuildableQuantity() {
        List<Part> list = partRepository.findByRequired(true);
        int minStock = Integer.MAX_VALUE;
        for (Part part : list) {
            if (minStock > part.getInStock()) {
                minStock = part.getInStock();
            }
        }

        return minStock;
    }

    public void savePart(Part part) {
        partRepository.save(part);
    }

    public Part getPartById(Long id) {
        return partRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid part id: " + id));
    }

    public void deletePart(Long id) {
        partRepository.deleteById(id);
    }
}
