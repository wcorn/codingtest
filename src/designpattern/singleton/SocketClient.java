package designpattern.singleton;

public class SocketClient {
    //자기 자신을 생성자로 가짐
    private static SocketClient socketClient = null;

    //기본 생성자를 private으로 설정
    private SocketClient() {

    }

    //객체 접근 getter
    public static SocketClient getInstance() {
        // 객체가 없을 경우 생성
        if (socketClient == null) {
            socketClient = new SocketClient();
        }
        // 객체 리턴
        return socketClient;
    }
}
