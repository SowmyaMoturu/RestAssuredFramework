package steps;

import base.Utils;
import io.cucumber.java8.En;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import payload.JiraProject;
import static io.restassured.RestAssured.given;

public class ProjectSteps extends Utils implements En {
    private RequestSpecification request;
    private Response response;

    JiraProject jiraProject;

    public ProjectSteps()  {

        Given("We build JIRA API Get Request", () -> {
            request = given().spec(getGetRequest());
        });

        Given("We build JIRA API POST Request", () -> {
            request = given().spec(getPostRequest());
        });

        When("We send get Request to get JIRA project by {string}", (String key) -> {
            response = request.pathParam("projectIdOrKey", key)
                    .when().get("project/{projectIdOrKey}").then().extract().response();
        });

        When("We send delete Request to JIRA to delete {string}", (String key) -> {
            response = request.pathParam("projectIdOrKey", key)
                    .when().delete("project/{projectIdOrKey}").then().extract().response();
        });

        When("Project Payload is created for key {string} and Description {string}",
                (String key, String description) -> {
                    jiraProject = new JiraProject();
                    jiraProject.setKey(key);
                    jiraProject.setName(description);
                    jiraProject.setDefaultValues();
                });
        And("We send post Request  to JIRA", () -> {
            response = request.body(jiraProject).when().post("project").then().extract().response();
        });

        Then("{string} in response body is {string}", (String param, String value) -> {
            JsonPath jsonPath = new JsonPath(response.asString());
            Assert.assertEquals(jsonPath.getString(param), value);
        });

        Then("assert status code is 204", () -> {
            Assert.assertEquals(response.statusCode(), 204);
        });

    }

}
