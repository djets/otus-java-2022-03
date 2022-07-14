package src.main.java.convert.appService;

@FunctionalInterface
public interface ConvertService<T, K> {
    K convert(T t);
}
