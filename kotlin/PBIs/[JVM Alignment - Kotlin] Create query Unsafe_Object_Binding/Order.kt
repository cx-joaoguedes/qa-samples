package com.kotlinmvc.kotlingspringmvc

import com.kotlinmvc.kotlingspringmvc.Extensions.toSlug
import com.sun.istack.NotNull
import org.springframework.lang.Nullable
import java.time.LocalDateTime
import javax.persistence.*

@Entity
class Order1{
    var inventory: Userr
        private set
    var itemId: String
	    private set
    var itemId2: String
}

@Entity
class Userr {
    var username: String
}

@Entity
class Order2(@JsonIgnore var user1: Userr, @JsonProperty(access=READ_ONLY) var user2: Userr){}

@Entity
class Order3{
    var itemId: String
    var itemId2: String
}