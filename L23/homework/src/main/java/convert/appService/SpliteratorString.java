package src.main.java.convert.appService;
import java.util.Queue;

public interface SpliteratorString<T,E> {
    public void spliterator (T t);
    public Queue<E> getListNumbers();
}

