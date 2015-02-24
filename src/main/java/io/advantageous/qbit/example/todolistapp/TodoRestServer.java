package io.advantageous.qbit.example.todolistapp;


import io.advantageous.qbit.http.server.HttpServer;
import io.advantageous.qbit.server.ServiceServer;
import io.advantageous.qbit.system.QBitSystemManager;

import static io.advantageous.qbit.http.server.HttpServerBuilder.httpServerBuilder;
import static io.advantageous.qbit.server.ServiceServerBuilder.serviceServerBuilder;
import static org.boon.Boon.resource;

/**
 * Created by rhightower on 2/9/15.
 */
public class TodoRestServer {


    public static final String HTML_PAGE = "/ui/index.html";


    public static void main(String... args) {

        /* Create the system manager to manage the shutdown. */
        QBitSystemManager systemManager = new QBitSystemManager();

        HttpServer httpServer = httpServerBuilder()
                .setPort(9999).build();

        /* Register the Predicate using a Java 8 lambda expression. */
        httpServer.setShouldContinueHttpRequest(httpRequest -> {
            /* If not the page uri we want to then just continue by returning true. */
            if (!httpRequest.getUri().equals(HTML_PAGE)) {
                return true;
            }
            /* read the page from the file system or classpath. */
            final String todoWebPage = resource(HTML_PAGE);
            /* Send the HTML file out to the browser. */
            httpRequest.getResponse().response(200, "text/html", todoWebPage);
            return false;
        });


        /* Start the service. */
        final ServiceServer serviceServer = serviceServerBuilder().setSystemManager(systemManager)
                .setHttpServer(httpServer).build().initServices(new TodoService()).startServer();

        /* Wait for the service to shutdown. */
        systemManager.waitForShutdown();

    }


}
