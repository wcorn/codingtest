package designpattern.singleton;
/*
- 생성자의 호출이 반복적으로 이뤄져도 실제로 생성되는 객체는 최초 생성된 객체를 반환해주는 것
- 오직 하나만 생성하고 그 인스턴스를 사용하도록 하는 것이 패턴의 목적
- 자원 공유
 */
public class Main {
    public static void main(String[] args) {
        Aclazz aclazz = new Aclazz();
        BClazz bClazz = new BClazz();
        SocketClient aClient = aclazz.getSocketClient();
        SocketClient bClient = bClazz.getSocketClient();
        //aClient와 bClient는 모두 SocketClient를 할당 받은 aclazz와 bclazz를 각각 생성하였지만
        //SocketClient는 static으로 생성되어 data 영역에 할당되어 프로그램 시작과 동시에 생성되고 시작하여 자원을 공유한다.
        //따라서 객체를 여러개 만들어도 각 객체가 가지고 있는 SocketClient는 공유되는 객체이다.
        System.out.println(aClient.equals(bClient));
    }
}