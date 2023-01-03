package designpattern.adapter;

public class HairDryer implements Electronic110V{
    @Override
    public void powerOn() {
        System.out.println("드라이기 110v on");
    }
}
