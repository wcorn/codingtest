package designpattern.adapter;

public class Cleaner implements Electronic220V{
    @Override
    public void powerOn() {
        System.out.println("청소기 220v on");
    }
}
