import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Client{
    private final String name;
    private final LinkedList<Account> accounts = new LinkedList<>();

    Client(String name) {
        this.name = name;
    }
    void addAccount(int numberAccount){
        accounts.add(new Account(numberAccount));
    }
    /*
    void removeAccount(int numberAccount){
        accounts.remove(numberAccount);
    }
     */
    String getName(){
        return name;
    }
    LinkedList<Account> getAccounts(){
        return accounts;
    }
}
