package RoyaumeDesBonbons.operation;


public abstract class Operation {

    protected String operation;

    public void AppliquerOperation() {
        System.out.println(operation);
    }


    @Override
    public String toString() {
        return operation;
    }
}
