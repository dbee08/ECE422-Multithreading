import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Bank {
    static int numAccounts = 10; //total number of accounts
    static int initialBalance = 10000; //initial balance of each account
    int[] accounts; //declare array of ints for accounts
    Random random = new Random(); //for random ints

    public Bank() { //constructor
        accounts = new int[numAccounts];
        //for loop to populate each account with initial balance
        for (int i = 0; i < numAccounts; i++) {
            accounts[i] = initialBalance;
        }
    }

    public void transfer(int from, int to, int amount){

        //insert time-consuming innocous operations for context switching
        //using math.cosine for context switching using random numbers generated
        for(int i = 0; i < 10000; i++){
            Math.cos(random.nextInt());
        }
        accounts[from]-=amount;
        accounts[to]+=amount;
        //TODO:
        //audit bank periodically
        //every 100 transfers
        if(numTransfers() % 100 == 0){
            Audit();
        }

    }

    public void Audit(){
        int total = 0;
        for(int balanace : accounts){
            total+=balanace; //total money in bank
        }
    }

    public int numTransfers(){
        int num = 0;
        for (int balance:accounts){
            num+= balance/1000; //counting each of 1000 as one transfer
        }
        return num;
    }

    public int[] getAccounts() {
        return accounts;
    }


}
