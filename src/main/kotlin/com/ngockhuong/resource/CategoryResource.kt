package com.ngockhuong.resource

import com.ngockhuong.model.dto.res.CategoryResDto
import com.ngockhuong.service.CategoryService
import javax.inject.Inject
import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/categories")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class CategoryResource {

    @Inject
    internal lateinit var categoryService: CategoryService;

    @GET
    fun getCategories(): List<CategoryResDto>? {
        return categoryService.list()
    }
}
