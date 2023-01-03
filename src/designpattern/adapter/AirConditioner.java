package designpattern.adapter;

public class AirConditioner implements Electronic220V{
    @Override
    public void powerOn() {
        System.out.println("에어컨 220v on");
    }
}
