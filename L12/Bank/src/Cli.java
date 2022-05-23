import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Cli implements Comparable<Cli>, Arbitrary {

    String name;
    Set<Acc> accountsSet = new HashSet<>();

    Cli(String name) {
        this.name = name;
    }

    Cli(String name, int numberLength, int numberOfAccount){
        this(name);
        Set<Acc> accounts = new HashSet<>();
        for(int i = 0; i < numberLength; i++){
            Acc acc = new Acc(random(numberOfAccount));
            accounts.add(acc);
        }
        this.accountsSet = accounts;
    }

    Cli(String name, Set<Acc> accSet){
        this(name);
        this.accountsSet = accSet;
    }

    @Override
    public int compareTo(Cli o) {
        int result = this.name.compareTo(o.name);
        return result;
    }

    @Override
    public boolean equals(Object obj) {

        if(this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Cli client = (Cli) obj;
        return name == client.name;
    }

    @Override
    public int hashCode() {
        int result = name == null ? 0 : name.hashCode() ;
        result = 31 * result;
        return result;
    }

    String getName(){
        return name;
    }
    HashSet<Acc> getAccounts(){
        return (HashSet<Acc>) accountsSet;
    }

}
