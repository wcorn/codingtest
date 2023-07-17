package collection;

public interface Queue<T> extends Collection<T> {
    /**
     * queue에 객체 를 추가
     *
     * @param t generic type으로 처음 선언한 collection에 맞는 객체
     * @return 추가에 성공하면 true 반환, 실패하면 false
     */
    boolean enqueue(T t);

    /**
     * data structure 제일 앞에 저장된 element 삭제
     *
     * @return 삭제되면 true 삭제 실패하면 false
     */
    T dequeue();

    /**
     * data structure 제일 앞에 저장된 element 반환
     *
     * @return element 반환, 없으면 null
     */
    T front();

    /**
     * data structure 제일 뒤에 저장된 element 반환
     * @return element 반환, 없으면 null
     */
    T rear();
}
