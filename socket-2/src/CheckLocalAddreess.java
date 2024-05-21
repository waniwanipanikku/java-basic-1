import java.net.InetAddress;
import java.net.UnknownHostException;

public class CheckLocalAddreess {
    public static void main(String[] args) throws UnknownHostException {

// IP Address
InetAddress addr= InetAddress.getByName("yuyah0224");
// Host name
System.out.println("Host name is: "+ addr.getHostName());
// Host Address
System.out.println("Ip address is: "+ addr.getHostAddress());
}
}
