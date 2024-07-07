// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class BankSimulation {
    public static void main(String[] args) {
        Bank b = new Bank();

        TransferThread[] threads = new TransferThread[Bank.numAccounts]; //max num of threads
        //for loop to create and start threads
        for(int i = 0; i < Bank.numAccounts; i++){
            threads[i] = new TransferThread(b, i, 10000); //assuming maxAmount 10000
            threads[i].start();
        }
        try{
            Thread.sleep(7000); //sleep for 7 seconds
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //interrupting threads
        for(TransferThread thread:threads){
            thread.interrupt();
        }

    }
}