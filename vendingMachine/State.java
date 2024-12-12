package vendingMachine;

public interface State {
    public void insertMoney(VendingMachine machine, double amount);
    public void pressButton(VendingMachine machine, int rackNumber);
    public void returnChange(double amount);
    public void updateInventory(VendingMachine machine, int rackNumber);
    public void dispenseProduct(VendingMachine machine, int rackNumber);
}
