package strategy;

import app.App;
import injection.Component;
import injection.Inject;
import model.Vehicle;
import service.FileReaderService;
import service.ParserService;
import java.util.List;

@Component
public class ShowCatalogOperationHandler implements OperationHandler {
    private static final String path = "src/main/resources/ecobike.txt";
    @Inject
    FileReaderService fileReaderService;
    @Inject
    ParserService parserService;

    @Override
    public void apply() {
        List<String> list = fileReaderService.readAll(path);
        for (int i = 0; i < list.size(); i++) {
            Vehicle bike = parserService.parse(list.get(i));
            System.out.println(i + 1 + ": " +bike.toString());
        }
        App app = App.getApp();
        app.run();
    }
}
