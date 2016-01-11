import com.jayway.restassured.RestAssured;
import util.HttpRequestHelper;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by order on 05.01.16.
 * The purpose is to test http requests
 */
public class MainTest {
    public static void main(String[] args){
        String dphApiUrl = "http://api.depositphotos.com";
        Map<String, String> params = new HashMap<>(5);
        params.put("dp_command", "login");
        params.put("dp_apikey", "d3be9edccb0822bdc1ec30467e91855b93ee120c");
        params.put("dp_login_user", "usefOne");
        params.put("dp_login_password", "1");
        int expectedStatusCode = 200;
        String response = HttpRequestHelper.sendPostWithParamsReturnContent(dphApiUrl, params, 200);
        System.out.println(response);
//        System.out.println(RestAssured.given().when().params(params).then().post(dphApiUrl).asString());
//        RestAssured.reset();
    }
}
