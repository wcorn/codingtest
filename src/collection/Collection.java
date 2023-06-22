package collection;

public interface Collection<T> {
    /**
     * collection의 element 개수 리턴
     * @return collection의 element 개수
     */
    int size();

    /**
     * 만약 collection에 elemnrt가 존재하면 true 리턴 , 존재 하지 않다면 false
     * @return 만약 collection에 elemnrt가 존재하면 true, 존재 하지 않다면 false
     */
    boolean isEmpty();

    /**
     * collection에 element 추가
     * @param t generic type으로 처음 선언한 collection에 맞는 객체
     * @return collection에 element가 성공적으로 추가되었으면 true
     */
    boolean add(T t);

    /**
     * parameter로 받은 객체가 collection에 존재하는 지 확인
     * @param t 객체
     * @return 존재하면 true, 존재하지 않으면 false
     */

    boolean contains(T t);

    /**
     * data structure 저장된 element 삭제
     * @return 삭제되면 true 삭제 실패하면 false
     */
    boolean remove(T t);

    /**
     * data structure 모든 elecment 삭제
     * @return 삭제되면 true 삭제 실패하면 false
     */
    boolean clear();

}
