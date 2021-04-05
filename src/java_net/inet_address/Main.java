package java_net.inet_address;

import java.io.IOException;
import java.net.InetAddress;

public class Main {

    public static void main(String[] args) {
        try {
            InetAddress []address = InetAddress.getAllByName("www.oreilly.com");
            for(InetAddress a: address) {
                System.out.println(a);

            }
        }catch (IOException e){}
    }
}
