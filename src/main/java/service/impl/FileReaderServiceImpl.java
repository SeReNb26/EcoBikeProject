package service.impl;

import injection.Component;
import service.FileReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Component
public class FileReaderServiceImpl implements FileReaderService {
    @Override
    public List<String> readAll(String path) {
        try {
            return Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file: " + path, e);
        }
    }
}
