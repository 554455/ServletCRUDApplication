package com.umaraliev.crud.service;

import com.umaraliev.crud.model.File;
import com.umaraliev.crud.repository.FileRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
@RunWith(MockitoJUnitRunner.class)
public class FileServiceTest {

    @Mock
    private FileService fileService;

    @InjectMocks
    private FileRepository fileRepository = mock(FileRepository.class);
    private File oneFile;
    private File twoFile;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getById() {
        List<File> fileList = new ArrayList<>();
        fileList.add(oneFile);
        fileList.add(twoFile);

        when(fileService.getAll()).thenReturn(fileList);
        when(fileService.getById(1)).thenReturn(oneFile);
    }

    @Test
    public void getAll() {
        oneFile = new File();
        oneFile.setId(1);
        oneFile.setName("One file");

        twoFile = new File();
        twoFile.setId(2);
        twoFile.setName("Two file");

        List<File> fileList = new ArrayList<>();

        fileList.add(oneFile);
        fileList.add(twoFile);

        when(fileService.getAll()).thenReturn(fileList);
        assertNotNull(fileList);
    }

    @Test
    public void save() {
        oneFile = new File();
        oneFile.setId(1);
        oneFile.setName("One file");

        when(fileService.save(any(File.class))).thenReturn(oneFile);

        twoFile = new File();
        twoFile.setId(2);
        twoFile.setName("Two file");

        File file = fileService.save(twoFile);
        assertNotNull(twoFile);
        assertEquals("Two file", file.getName());
    }

    @Test
    public void update() {
        oneFile = new File();
        oneFile.setId(1);
        oneFile.setName("One file");

        when(fileService.update(oneFile)).thenReturn(oneFile);
        assertEquals("One file", oneFile.getName());

    }

    @Test
    public void delete() {
        fileService.delete(anyInt());

        verify(fileService).delete(anyInt());
    }
}