package src.appService;
import java.util.List;

@FunctionalInterface
public interface ConvertService<I, S, W> {
    W convert(List<I> i, List<S> s);
}
