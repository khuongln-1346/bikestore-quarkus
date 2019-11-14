package com.ngockhuong.service.impl

import com.ngockhuong.model.dto.req.CategoryReqDto
import com.ngockhuong.model.dto.res.CategoryResDto
import com.ngockhuong.model.entity.CategoryEntity
import com.ngockhuong.repository.CategoryRepository
import com.ngockhuong.service.CategoryService
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject

@ApplicationScoped
class CategoryServiceImpl : CategoryService {

    @Inject
    internal lateinit var categoryRepository: CategoryRepository

    override fun list(): List<CategoryResDto>? {

        return categoryRepository.list().map { categoryEntity -> categoryEntity.transformToCategoryResDto() }
    }

    override fun findById(id: Long): CategoryResDto {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun create(item: CategoryReqDto): CategoryResDto {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun update(item: CategoryReqDto): CategoryResDto {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun delete(id: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
