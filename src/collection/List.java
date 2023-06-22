package collection;

public interface List<T> extends Collection<T> {
    @Override
    int size();
    @Override
    boolean isEmpty();
    @Override
    boolean contains(Object o);
    @Override
    boolean add(T t);
    @Override
    boolean remove(Object o);
}
