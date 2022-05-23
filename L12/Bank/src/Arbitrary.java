import java.util.HashSet;
import java.util.Set;


public interface Arbitrary {
    
    public default int random (int i) {
        return (int) (Math.random() * i);
    }
}