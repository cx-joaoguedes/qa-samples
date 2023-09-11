package com.kotlinmvc.kotlingspringmvc

import com.kotlinmvc.kotlingspringmvc.BlogProperties
import com.kotlinmvc.kotlingspringmvc.Entities
import com.kotlinmvc.kotlingspringmvc.NewOrderRepository
import com.kotlinmvc.kotlingspringmvc.UserRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping


@Controller
class YController {
    @RequestMapping(value = ["/test"])
    fun test1(@RequestBody order1: Order1?): String? {
        if(order1 == null) {
            return "Error"
        }
        orderRepository.save(order1)
        return "orderUpdated"
    }

    @RequestMapping(value = ["/test"])
    fun test2(@ModelAttribute order2: Order2?): String? {
        if(order2 == null) {
            return "Error"
        }
        orderRepository.save(order2)
        return "orderUpdated"
    }

    @RequestMapping(value = ["/test"])
    fun test3(@ModelAttribute order3: Order3?): String? {
        if(order3 == null) {
            return "Error"
        }
        orderRepository.save(order3)
        return "orderUpdated"
    }
}