package util;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

import static com.jayway.restassured.RestAssured.given;

public class HttpRequestHelper {
    private static Map<String, String> headers = new HashMap<>();

    public static Map<String, String> setDefaultHeaders(){
        headers.put("Cache-Control", "no-cache");
        headers.put("User-Agent:", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.90 Safari/537.36");
        headers.put("Accept-Encoding", "gzip, deflate, sdch");
        headers.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
        return headers;
    }

    public static Map<String, String> setHeaders(Map<String, String> addHeaders){
        headers.putAll(addHeaders);
        return headers;
    }

    /**
     *
     * @param url
     * @param params
     * @param expectedStatusCode
     * @return http response body
     */

    public static Response sendGet(String url, Map<String, String> params, int expectedStatusCode){
        if(url.isEmpty()){
            Assert.fail("Can not execute request with empty URL");
        }
        setDefaultHeaders();
        Response response =  RestAssured.given().headers(headers).parameters(params).when().get(url);
        Assert.assertEquals(response.getStatusCode(), expectedStatusCode);
        RestAssured.reset();
        return response;
    }

    public static String sendGetReturnContent(String url, Map<String, String> params, int expectedStatusCode){
        Response response = sendGet(url, params, expectedStatusCode);
        return response.asString();
    }

    public static String sendGetReturnContent(String url, int expectedStatusCode) {
        return sendGetReturnContent(url, new HashMap<String, String>(), expectedStatusCode);
    }

    /**
     * @param url
     * @param params
     * @param body
     * @param expectedStatusCode
     * @return http response body
     */

    public static Response sendPost(String url, Map<String, String> params, String body,
                                    Map<String, String> additionalHeaders, int expectedStatusCode){
        if(url.isEmpty()){
            Assert.fail("Can not execute request with empty URL");
        }
        Response response;
        setDefaultHeaders();

        if (!body.isEmpty()){
            response = given().headers(headers).headers(additionalHeaders).body(body).when().post(url);
        }else {
            response = given().headers(headers).parameters(params).when().post(url);
        }

        Assert.assertEquals(response.getStatusCode(), expectedStatusCode);
        RestAssured.reset();
        return response;
    }

    public static String sendPostWithBodyReturnContent(String url,String body, Map<String, String> additionalHeaders, int expectedStatusCode){
        Response response = sendPost(url, new HashMap<String, String>(), body, additionalHeaders, expectedStatusCode);
        return response.asString();
    }

    public static String sendPostWithParamsReturnContent(String url, Map<String, String> params, int expectedStatusCode){
        Response response = sendPost(url, params, new String(), new HashMap<String, String>(), expectedStatusCode);
        return response.asString();
    }

    public static String sendPostWithParamsReturnContent(String url, int expectedStatusCode){
        return sendPostWithParamsReturnContent(url, new HashMap<String, String>(), expectedStatusCode);
    }
}
