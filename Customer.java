public class Customer implements CustomerService
{

    private String name;
    private double balance;

    public Customer (String name , double balance)
    {
        this.name = name;
        this.balance = balance;
    }


    @Override
    public boolean canBuy(double amount)
    {
        return balance >= amount;
    }

    @Override
    public void BalanceDeduction(double amount)
    {
        balance -= amount;
    }
}
