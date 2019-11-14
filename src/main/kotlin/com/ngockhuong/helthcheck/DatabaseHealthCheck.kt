package com.ngockhuong.helthcheck

import com.ngockhuong.repository.CategoryRepository
import org.eclipse.microprofile.health.HealthCheck
import org.eclipse.microprofile.health.HealthCheckResponse
import org.eclipse.microprofile.health.HealthCheckResponseBuilder
import org.eclipse.microprofile.health.Readiness
import javax.inject.Inject

@Readiness
class DatabaseHealthCheck : HealthCheck {
    @Inject
    lateinit var repository: CategoryRepository

    override fun call(): HealthCheckResponse {
        val healthCheckBuilder: HealthCheckResponseBuilder = HealthCheckResponse.named("Database connection")
        try {
            repository.checkStatus()
            healthCheckBuilder.withData("connection", true)
            healthCheckBuilder.up()
        } catch (e: Exception) {
            healthCheckBuilder.withData("connection", false)
            healthCheckBuilder.down()
        }

        return healthCheckBuilder.build()
    }

}