package io.msdousti;

import org.zalando.logbook.Logbook;
import org.zalando.logbook.jaxrs.LogbookClientFilter;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

public class Main {
    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();
        client.register(new LogbookClientFilter(Logbook.create()));

        //noinspection HttpUrlsUsage
        client.target("http://httpbin.org/get")
                .request(MediaType.APPLICATION_JSON)
                .get(String.class);
    }
}
