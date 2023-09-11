package com.kotlinmvc.kotlingspringmvc

import com.kotlinmvc.kotlingspringmvc.Extensions.toSlug
import com.sun.istack.NotNull
import org.springframework.lang.Nullable
import java.time.LocalDateTime
import javax.persistence.*

@Entity
class Order4{
    var inventory: User
    var itemId: String
}

@Entity
class Order5(@JsonIgnore var user1: Userr, var user2: Userr){}

@Entity
class Order6(var user1: Userr, @JsonProperty(access=READ_ONLY) var user2: Userr){}