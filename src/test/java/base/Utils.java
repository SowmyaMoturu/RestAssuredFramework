package base;

import config.Config;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static config.Settings.*;

public class Utils {

    private RequestSpecification getRequest;
    private RequestSpecification postreq;
    private static  PrintStream log;

    public RequestSpecification getGetRequest() throws IOException {
        Config.populateSettings();

        if(log==null){
            log = new PrintStream(new FileOutputStream("logging.txt"), true);
        }

        getRequest = new RequestSpecBuilder().setBasePath(base_path).setBaseUri(base_uri)
                .addFilter(RequestLoggingFilter.logRequestTo(log))
                .addFilter(ResponseLoggingFilter.logResponseTo(log))
                .addHeader(authHeader, authKey).build();
        return getRequest;
    }



    public RequestSpecification getPostRequest() throws IOException {
        Config.populateSettings();

        if(log==null){
            log = new PrintStream(new FileOutputStream("logging.txt"), true);
        }

        postreq = new RequestSpecBuilder().setBasePath(base_path).setBaseUri(base_uri)
                .addFilter(RequestLoggingFilter.logRequestTo(log))
                .addFilter(ResponseLoggingFilter.logResponseTo(log))
                .addHeader(authHeader, authKey).setContentType("application/json").build();
        return postreq;
    }
}
