package com.ngockhuong.model.entity

import com.ngockhuong.model.dto.res.CategoryResDto
import io.quarkus.hibernate.orm.panache.PanacheEntityBase
import javax.persistence.*

@Entity
@Table(name = "categories")
class CategoryEntity : PanacheEntityBase() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    var categoryId: Int = 0

    @Column(name = "category_name")
    lateinit var categoryName: String

    fun transformToCategoryResDto(): CategoryResDto {
        val item = CategoryResDto()
        item.categoryId = this.categoryId
        item.categoryName = this.categoryName

        return item
    }
}
