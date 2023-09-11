package com.kotlinmvc.kotlingspringmvc

import com.kotlinmvc.kotlingspringmvc.BlogProperties
import com.kotlinmvc.kotlingspringmvc.Entities
import com.kotlinmvc.kotlingspringmvc.NewOrderRepository
import com.kotlinmvc.kotlingspringmvc.UserRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import java.util.*

@Controller
class OrderController(private val userRepository: UserRepository,
                     private  val orderRepository: NewOrderRepository,
                     private val properties: BlogProperties
) {

    //Vulnerable to unsafe object binding
    @RequestMapping(value = ["/update"])
    fun updateShippingAddress(@RequestBody order: Entities.Order?): String? {
        if(order == null) {
            return "Error"
        }
        //when order is saved the associated user will also be updated
        orderRepository.save(order)
        return "orderUpdated"
    }
}
