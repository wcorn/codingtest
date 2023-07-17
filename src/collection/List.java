package collection;

public interface List<T> extends Collection<T> {
    /**
     * list의 사이즈 return
     * @return list의 사이즈
     */
    @Override
    int size();

    /**
     * list가 비어있는지 확인
     * @return 비어있으면 true, 그렇지 않으면 false
     */
    @Override
    boolean isEmpty();
    /**
     * 객체가 list에 존재하는지 확인
     * @param o 객체
     * @return queue에 parameter로 넘어온 객체가 존재하면 true, 그렇지 않으면 false
     */
    @Override
    boolean contains(Object o);
}
