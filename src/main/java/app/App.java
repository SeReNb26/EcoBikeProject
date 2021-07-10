package app;

import injection.Injector;
import strategy.AddEBikeOperationHandler;
import strategy.AddFoldingBikeOperationHandler;
import strategy.AddSpeedElecOperationHandler;
import strategy.ExitOperationHandler;
import strategy.FindFirstOperationHandler;
import strategy.OperationHandler;
import strategy.ShowCatalogOperationHandler;
import strategy.WriteOperationHandler;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class App {
    private static final App app = new App();
    OperationHandler operationHandler;

    public static App getApp() {
        return app;
    }

    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, OperationHandler> map = new HashMap<>();
        map.put(1, new ShowCatalogOperationHandler());
        map.put(2, new AddFoldingBikeOperationHandler());
        map.put(3, new AddSpeedElecOperationHandler());
        map.put(4, new AddEBikeOperationHandler());
        map.put(5, new FindFirstOperationHandler());
        map.put(6, new WriteOperationHandler());
        map.put(7, new ExitOperationHandler());

        System.out.println("Please make your choice:");
        System.out.println("1 - Show the entire EcoBike catalog");
        System.out.println("2 – Add a new folding bike");
        System.out.println("3 – Add a new speedelec");
        System.out.println("4 – Add a new e-bike");
        System.out.println("5 – Find the first item of a particular brand");
        System.out.println("6 – Write to file");
        System.out.println("7 – Stop the program");
        System.out.println();

        int num;
        try {
            num = Integer.parseInt(reader.readLine());
        } catch (Exception e) {
            throw new RuntimeException("Can't read from console!", e);
        }
        operationHandler = map.get(num);
        Injector injector = Injector.getInjector();
        operationHandler = (OperationHandler) injector.getInstance(operationHandler.getClass());
        operationHandler.apply();
    }
}
