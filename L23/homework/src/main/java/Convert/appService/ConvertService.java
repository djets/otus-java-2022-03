package Convert.appService;

@FunctionalInterface
public interface ConvertService<T, K> {
    K convert(T t);
}
