package strategy;

import app.App;
import injection.Component;
import injection.Inject;
import service.FileReaderService;
import java.io.BufferedReader;
import java.io.InputStreamReader;

@Component
public class FindFirstOperationHandler implements OperationHandler {
    private static final String path = "src/main/resources/ecobike.txt";
    @Inject
    FileReaderService fileReaderService;

    @Override
    public void apply() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String brand;
        try {
            System.out.println("Write brand:");
            brand = reader.readLine();
        } catch (Exception e) {
            throw new RuntimeException("Can't read from file: " + path, e);
        }
        System.out.println(fileReaderService.readAll(path).stream()
                .filter(x -> x.contains(brand))
                .findFirst()
                .orElseThrow(() -> new RuntimeException(
                        "Item with brand " + brand + "does not exist!")));
        App app = App.getApp();
        app.run();
    }
}
