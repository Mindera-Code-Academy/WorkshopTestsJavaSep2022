package mindera.mindswap.aveiro.module2.springboot.myfirstapi.garbage;

import org.springframework.stereotype.Component;

@Component
public class ImJustAComponent {

    private int age = 10;

    public int getAge(int mutiplier) {
        return age * mutiplier;
    }
}
