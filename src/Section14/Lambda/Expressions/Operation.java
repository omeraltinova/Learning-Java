package Section14.Lambda.Expressions;


@FunctionalInterface
public interface Operation<T>{

    T operate(T value1,T value2);
}
