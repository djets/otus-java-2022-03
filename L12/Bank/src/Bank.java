import java.util.*;

public class Bank {
    final static TreeMap <String, Client> clientsName = new TreeMap<>();
    final static TreeMap <Integer, Client> accountsClients = new TreeMap<>();

    public static void main(String[] args) {
        createNewClientsAndAccounts(50, 10, 1000000000);
        try {
            listAccounts(getListAccounts(clientsName.get(inNameClient())));
        } catch (Exception e) {
            System.out.print("Нет такого клиента.");
        }
        int n;
        if(accountsClients.containsKey(n = inNumberAccount())){
            System.out.println(accountsClients.get(n).getName());
        } else {
            System.out.println("Нет такого счета.");
        }
    }
    static void createNewClientsAndAccounts(int c, int a, int r){
        for (int i = 0; i <= c; i++){
        newClient("client" + i);
        int numberOfAccounts = (int) (Math.random() * a);
        for (int n = 0; n <= numberOfAccounts; n++){
            int numAccount = (int) (Math.random()*r);
            clientsName.get("client" + i).addAccount(numAccount);
            accountsClients.put(numAccount, clientsName.get("client" + i));
        }
        }
    }
    static void newClient(String name){
        clientsName.put(name, new Client(name));
    }
    static void listAccounts(Collection<Account> accounts){
        for(Account account: accounts){
            System.out.println(account.getNumberAccount());
        }
    }
    static LinkedList<Account> getListAccounts(Client client){
        return client.getAccounts();
    }
    static String inNameClient(){
        Scanner inStr =  new Scanner(System.in);
        System.out.print("Введите имя клиента: ");
        if (inStr.hasNextLine()){
            String str = inStr.nextLine();
            if(clientsName.containsKey(str)){
                return str;
            }
        }
        return null;
    }
    static int inNumberAccount(){
        Scanner inInt =  new Scanner(System.in);
        System.out.print("\nВведите номер счета: ");
        if (inInt.hasNextInt()){
            int i = inInt.nextInt();
            return i;
        }
        inInt.close();
        return 0;
    }

}
