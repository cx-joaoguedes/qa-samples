package com.kotlinmvc.kotlingspringmvc

import com.kotlinmvc.kotlingspringmvc.Extensions.toSlug
import com.sun.istack.NotNull
import org.springframework.lang.Nullable
import java.time.LocalDateTime
import javax.persistence.*

class Entities {
    @Entity
    class Article(
        var title: String,
        var headline: String,
        var content: String,
        @ManyToOne var author: User,

        //The following line uses the "toSlug()" from the "Extensions" class
        var slug: String = title.toSlug(),
        var addedAt: LocalDateTime = LocalDateTime.now(),
        @Id @GeneratedValue var id: Long? = null)

    @Entity
    class User(
        var login: String,
        var firstname: String,
        @Id @GeneratedValue var id: Long? = null)

    @Entity
    class Order(
        var itemId: String,
        var price: Long,
        var address: String,
        @ManyToOne(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
        var userBuyer : User?,
        @Id @GeneratedValue var id: Long? = null)
}
