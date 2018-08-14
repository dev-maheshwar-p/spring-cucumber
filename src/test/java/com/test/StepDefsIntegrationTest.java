package com.test;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;
import cucumber.api.java.en.Given;
import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.IMongodConfig;
import de.flapdoodle.embed.mongo.config.MongodConfigBuilder;
import de.flapdoodle.embed.mongo.config.Net;
import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.process.runtime.Network;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class StepDefsIntegrationTest extends SpringIntegration {

    private MongodExecutable mongodExecutable;

    @Autowired
    private MongoTemplate mongoTemplate;


    @When("^the client calls /baeldung$")
    public void the_client_issues_POST_hello() throws Throwable {
        executePost();
    }

    @Given("^the client calls /hello$")
    public void the_client_issues_GET_hello() throws Throwable {
        executeGet("http://localhost:8082/hello");
    }

    @When("^the client calls /version$")
    public void the_client_issues_GET_version() throws Throwable {
        executeGet("http://localhost:8082/version");
    }

    @Then("^the client receives status code of (\\d+)$")
    public void the_client_receives_status_code_of(int statusCode) throws Throwable {
        final HttpStatus currentStatusCode = latestResponse.getTheResponse().getStatusCode();
        assertThat("status code is incorrect : " + latestResponse.getBody(), currentStatusCode.value(), is(statusCode));
    }

    @And("^the client receives server version (.+)$")
    public void the_client_receives_server_version_body(String version) throws Throwable {
        assertThat(latestResponse.getBody(), is(version));
    }

    @Given("^the client calls get allocations$")
    public void theClientCallsGetAllocations() throws Throwable {
        executeGet("http://jsonplaceholder.typicode.com/posts");
    }

    @And("^Print the response contents to stdout$")
    public void printTheResponseContentsToStdout() throws Throwable {
        System.out.println(latestResponse.getBody().toString());
    }


    @Given("^Start the InMemory MongoDB\\.$")
    public void startTheInMemoryMongoDB() throws Throwable {
        String ip = "127.0.0.1";
        int port = 27018;

        IMongodConfig mongodConfig = new MongodConfigBuilder().version(Version.Main.PRODUCTION)
                .net(new Net(ip, port, Network.localhostIsIPv6()))
                .build();

        MongodStarter starter = MongodStarter.getDefaultInstance();
        mongodExecutable = starter.prepare(mongodConfig);
        mongodExecutable.start();
    }

    @Then("^Perform a basic insert into the sample collection\\.$")
    public void performABasicInsertIntoTheSampleCollection() throws Throwable {
        DBObject objectToSave = BasicDBObjectBuilder.start()
                .add("key", "value")
                .get();

        mongoTemplate.save(objectToSave, "collection");

        List<DBObject> collection = mongoTemplate.findAll(DBObject.class, "collection");
        String value = ((Document) collection.get(0)).get("key").toString();
        assertThat(value, is("value"));

    }
}