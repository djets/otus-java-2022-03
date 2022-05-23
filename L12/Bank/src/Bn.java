import java.util.*;

public class Bn {
    final static TreeMap<Cli, HashSet<Acc>> accountsClients = new TreeMap<>();

    public static void main(String[] args) {
        int numberOfClients = 500000;
        int numberOfClientsAccounts = 10;
        int lengthAccountNumber = 1000000000;
        //Создаем клиентов
        for (int i = 0; i < numberOfClients; i++){
            Cli clients = new Cli("client" + i, numberOfClientsAccounts, lengthAccountNumber);
            accountsClients.put(clients, clients.getAccounts());
        }

        //Кешируем в мапы данные
        TreeMap <Integer, String> tempAccount = new TreeMap<>();
        TreeMap <String, HashSet<Acc>> tempClient = new TreeMap<>();
        long start = System.nanoTime();
        //Java8 forEach
        accountsClients.forEach((k, v) -> v.forEach((a) -> {
            tempAccount.put(a.getNumberAcc(), k.getName());
            tempClient.put(k.getName(), v);
        }));
        long stop = System.nanoTime();
        System.out.println((stop - start)/1_000_000);
        //Поиск по имени клиента
        //Java8 forEach
        tempClient.get(inNameClient(numberOfClients)).forEach((a) -> System.out.println(a.numberAcc));
        //Поиск по номеру счета
        System.out.println(tempAccount.get(inNumberAccount()));
    }

    //Поиск по клиенту
    static String inNameClient(int c){
        Scanner inStr =  new Scanner(System.in);
        System.out.print("Введите имя клиента вида client*, где * число от 0 до " + c + ":\n");
        if (inStr.hasNextLine()){
                return inStr.nextLine();
            }
        return null;
    }

    //Поиск по номеру счета
    static int inNumberAccount(){
        Scanner inInt =  new Scanner(System.in);
        System.out.print("\nВведите номер счета: ");
        if (inInt.hasNextInt()){
            return inInt.nextInt();
        }
        inInt.close();
        return 0;
    }
}
