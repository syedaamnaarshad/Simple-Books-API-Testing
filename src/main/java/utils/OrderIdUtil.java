package utils;

public class OrderIdUtil {
    private String orderId;
    private static OrderIdUtil instance;

    //private constructor for singleton pattern
    private OrderIdUtil() {
    }

    public static synchronized OrderIdUtil getInstance() {
        if (instance == null) {
            instance = new OrderIdUtil();
        }
        return instance;
    }

    public String getOrderId() {

        System.out.println("Getting order id:" +orderId);
        return  this.orderId;
    }


    public void setOrderId(String orderId) {

        System.out.println("Setting order id:" + orderId);
        this.orderId = orderId;
    }

}

