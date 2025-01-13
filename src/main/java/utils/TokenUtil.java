package utils;

public class TokenUtil {

    private String accessToken;
    private static TokenUtil instance;


    private TokenUtil() {
    }

    public static synchronized TokenUtil getInstance() {
        if (instance == null) {
            instance = new TokenUtil();
        }
        return instance;
    }

    public String getAccessToken() {

        System.out.println("Getting Access Token: " + accessToken);
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        System.out.println("Setting Access Token: " + accessToken);
        this.accessToken = accessToken;
    }
}
