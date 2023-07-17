package collection;

public class LinkedList<T> implements List<T>, Queue<T> {
    /**
     * Queue의 사이즈
     */
    int size = 0;
    /**
     * Queue에 제일 앞에 있는 객체
     */
    Node<T> first;
    /**
     * Qeueue에 제일 뒤에 있는 객체
     */
    Node<T> last;

    /**
     * linked list 구성하는 node
     * @param <T> node를 구성할 객체
     */
    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        Node(Node<T> prev, T data, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    /**
     * 비어 있는 생성자
     */
    public LinkedList() {
    }

    /**
     * List의 size 반환
     *
     * @return q's size
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * List가 비어 있는지 확인
     *
     * @return 비어 있으면 true, 그렇지 않으면 false
     */
    @Override
    public boolean isEmpty() {
        return size <= 0;
    }

    /**
     * 객체가 List에 있는 지확인
     *
     * @param o 객체
     * @return List에 parameter로 넘어온 객체가 존재하면 true, 그렇지 않으면 false
     */
    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    /**
     * parameter로 넘어온 객체가 List index 값
     *
     * @param o 객체
     * @return 객체의 index, 존재 하지 않으면 -1 return
     */
    public int indexOf(Object o) {
        int index = 0;
        if (o == null) {
            for (Node<T> x = first; x != null; x = x.next) {
                if (x.data == null) {
                    return index;
                }
                index++;
            }
        } else {
            for (Node<T> x = first; x != null; x = x.next) {
                if (x.equals(o)) {
                    return index;
                }
                index++;
            }
        }
        return -1;
    }

    /**
     * queue에 객체 추가
     *
     * @param t generic type으로 처음 선언한 collection에 맞는 객체
     * @return 추가하면 true, 실패하면 false
     */
    @Override
    public boolean enqueue(T t) {
        Node<T> node = last;
        Node<T> newNode = new Node<>(node, t, null);
        last = newNode;
        if (node == null) {
            first = newNode;
        } else {
            node.next = newNode;
        }
        size++;
        return true;
    }

    /**
     * List에 parameter로 넘어온 객체 삭제
     *
     * @param o 객체
     * @return 객체 삭제했으면 true, 그렇지 않으면 false
     */
    @Override
    public boolean remove(Object o) {
        if (o == null) {
            for (Node<T> x = first; x != null; x = x.next) {
                if (x.data == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node<T> x = first; x != null; x = x.next) {
                if (x.equals(o)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 객체 node와 List의 연결을 끊는 함수
     *
     * @param x node
     * @return 끊은 객체 return
     */
    private T unlink(Node<T> x) {
        final T element = x.data;
        final Node<T> next = x.next;
        final Node<T> prev = x.prev;
        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }
        x.data = null;
        size--;
        return element;
    }

    /**
     * List에 담긴 객체들 전부 삭제
     *
     * @return 초기화에 성공하면 true, 그렇지 않으면 false
     */
    @Override
    public boolean clear() {

        for (Node<T> x = first; x != null; ) {
            Node<T> node = x.next;
            node.prev = null;
            node.data = null;
            node.next = null;
            x.prev = null;
            x = node;
        }
        last = null;
        size = 0;
        return true;
    }

    /**
     * queue에 제일 앞에 있는 객체 삭제
     *
     * @return 삭제한 객체 리턴
     * @throws NullPointerException queue가 비어있으면 예외처리
     */
    @Override
    public T dequeue() throws NullPointerException {
        if (size <= 0) {
            throw new NullPointerException();
        }
        T t = first.data;
        size--;
        if (first.next == null) {
            first = null;
            last = null;
            return t;
        }
        Node<T> next = first.next;
        first.data = null;
        first.prev = null;
        first.next = null;
        first = next;
        return t;
    }

    /**
     * 제일 앞에 있는 객체 리턴
     *
     * @return 제일 앞에 있는 객체 리턴
     */
    @Override
    public T front() {
        return first.data;
    }

    @Override
    public T rear() {
        return last.data;
    }

    /**
     * List에 담긴 객체 문자열에 담아 배열의 형태로 리턴
     *
     * @return List에 담긴 객체 문자열에 담아 배열의 형태로 리턴
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("[");
        Node<T> x;
        for (x = first; x.next != null; x = x.next) {
            str.append(x.data).append(", ");
        }
        str.append(x.data);
        str.append("]");
        return str.toString();
    }

    /**
     * linked list 구성하는 node
     *
     * @param <T> node를 구성할 객체
     */
    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        Node(Node<T> prev, T data, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }
}
