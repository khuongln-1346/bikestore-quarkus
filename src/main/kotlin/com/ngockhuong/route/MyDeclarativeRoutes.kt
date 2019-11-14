package com.ngockhuong.route

import io.quarkus.vertx.web.Route
import io.vertx.core.http.HttpMethod
import io.vertx.ext.web.RoutingContext
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class MyDeclarativeRoutes {

    @Route(path = "/hello", methods = [HttpMethod.GET])
    fun greetings(routingContext: RoutingContext ) {
        var name = routingContext.request().getParam("name");
        routingContext.response().end("hello: " + name);
    }
}