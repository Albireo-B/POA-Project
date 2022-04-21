package operation;


public abstract class Operation {

  protected String operation = null;

  public void AppliquerOperation(){System.out.println(operation);};

  @Override
  public String toString() {
    return  operation;
  }
}
