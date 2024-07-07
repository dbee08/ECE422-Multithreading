import java.util.Random;

public class TransferThread extends Thread{
    Bank bank;
    int account;
    int maxAmount;
    Random random = new Random();
    //constructor:
    public TransferThread(Bank b, int acc, int maxAmt){
        this.bank = b;
        this.account = acc;
        this.maxAmount = maxAmt;
    }
    //run for threads:
    public void run(){
       while(true){ //true-> thread not interrupted
           int to = random.nextInt(Bank.numAccounts); //random int from 0 to numAccounts - 1
           int amount = random.nextInt(maxAmount);
           bank.transfer(account, to, amount);
       }
    }
}
