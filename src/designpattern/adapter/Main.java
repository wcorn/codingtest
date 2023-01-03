package designpattern.adapter;
/*
- 특정 인터페이스를 지원하지 않는 대상 객체를 인터페이스를 지원하는 Adapter에 집어넣어서 사용하는 방법
- 클래스의 인터페이스를 사용자가 기대하는 인터페이스 형태로 적응(변환) 시킵니다. 서로 일치하지 않는 인터페이스를 갖는 클래스들을 함께 동작
- 기능상 문제없이 동작하는 코드가 단지 인터페이스 차이 때문에 사용할 수 없는 경우 많이 응용되는 패턴
 */
public class Main {
    public static void main(String[] args) {
        HairDryer hairDryer = new HairDryer();
        connect(hairDryer);
        Cleaner cleaner = new Cleaner();
        //connect 는 110V를 상속받은 객체만 실행할 수 있기에
        //220V의 객체를 110V interface를 상속받은 SocketAdapter로 110V 객체에 넣어 connect에 맞춘것이다.
        //즉 220V 객체를 110V interface를 상속받은 객체를 만들어 거기에 넣고 기능을 override하여 110v 기능을 할 수 있게끔 한것
        Electronic110V adapter1 = new SocketAdapter(cleaner);
        connect(adapter1);
        AirConditioner airConditioner = new AirConditioner();
        Electronic110V adapter2 = new SocketAdapter(airConditioner);
        connect(adapter2);
    }

    //connect 는 110V를 상속받은 객체만 실행할 수 있습니다.
    public static void connect(Electronic110V electronic110V) {
        electronic110V.powerOn();
    }
}
