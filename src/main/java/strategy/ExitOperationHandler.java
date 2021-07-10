package strategy;

import injection.Component;

@Component
public class ExitOperationHandler implements OperationHandler {
    @Override
    public void apply() {
        System.exit(0);
    }
}
