package com.ngockhuong.route

import io.quarkus.vertx.http.runtime.filters.Filters
import io.vertx.ext.web.Router
import javax.enterprise.context.ApplicationScoped
import javax.enterprise.event.Observes

@ApplicationScoped
class MyRoute {
    fun filters(@Observes filters: Filters) {
        filters.register({
            routingContext ->
            routingContext.response().putHeader("X-Header", "intercepting the request")
            routingContext.next()
        }, 10)
    }

    fun routes(@Observes router: Router) {
        router.get("/").handler({rc -> rc.response().end("OK")})
    }
}