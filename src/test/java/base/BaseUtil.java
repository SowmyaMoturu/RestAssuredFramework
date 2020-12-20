package steps;

import config.Config;
import io.cucumber.java.Before;
import io.cucumber.java8.En;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static config.Settings.*;
import static io.restassured.RestAssured.given;

public class BaseUtil {

    private RequestSpecification getRequest;
    private RequestSpecification postreq;
    private static  PrintStream log;
    protected RequestSpecification request;



    public RequestSpecification getGetRequest() {

        if(log==null){
            try{
                Config.populateSettings();
                log = new PrintStream(new FileOutputStream("logging.txt"), true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        getRequest = new RequestSpecBuilder().setBasePath(base_path).setBaseUri(base_uri)
                .addFilter(RequestLoggingFilter.logRequestTo(log))
                .addFilter(ResponseLoggingFilter.logResponseTo(log))
                .addHeader(authHeader, authKey).build();
        return getRequest;
    }

    public RequestSpecification getPostRequest() {

        if(log==null){
            try{
                Config.populateSettings();
                log = new PrintStream(new FileOutputStream("logging.txt"), true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        postreq = new RequestSpecBuilder().setBasePath(base_path).setBaseUri(base_uri)
                .addFilter(RequestLoggingFilter.logRequestTo(log))
                .addFilter(ResponseLoggingFilter.logResponseTo(log))
                .addHeader(authHeader, authKey).setContentType("application/json").build();
        return postreq;
    }


}
