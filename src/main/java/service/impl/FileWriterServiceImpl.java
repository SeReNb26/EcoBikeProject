package service.impl;

import injection.Component;
import service.FileWriterService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

@Component
public class FileWriterServiceImpl implements FileWriterService {
    @Override
    public void write(String text, String path) {
        try {
            Files.writeString(Path.of(path), text, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file: " + path, e);
        }
    }
}
