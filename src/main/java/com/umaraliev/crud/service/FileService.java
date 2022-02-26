package com.umaraliev.crud.service;

import com.umaraliev.crud.model.File;
import com.umaraliev.crud.repository.FileRepository;
import com.umaraliev.crud.repository.impl.FileRepositoryImpl;

import java.util.List;

public class FileService {

    private FileRepository fileRepository = new FileRepositoryImpl();

    public File getById(Integer id) {
        return fileRepository.getById(id);
    }

    public List<File> getAll() {
        return fileRepository.getAll();
    }

    public File save(File file) {
        return fileRepository.save(file);
    }

    public File update(File file) {
        return fileRepository.update(file);
    }

    public boolean delete(Integer id) {
        fileRepository.delete(id);
        return true;
    }

}
