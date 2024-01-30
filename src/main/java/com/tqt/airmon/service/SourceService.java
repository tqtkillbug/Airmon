package com.tqt.airmon.service;

import com.tqt.airmon.model.Source;
import com.tqt.airmon.repository.SourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SourceService {

    @Autowired
    private SourceRepository repository;

    public Source insert(Source source){
        return repository.save(source);
    }

    public List<Source> getAll(){
        return repository.findAll();
    }

    public Source getById(Long id) {
        return repository.findById(id).get();
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

    public Source updateSource(Long id, Source updatedSource) {
        Source existingSource = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Source not found"));
        existingSource.setName(updatedSource.getName());
        existingSource.setLink(updatedSource.getLink());
        return repository.save(existingSource);
    }
}
