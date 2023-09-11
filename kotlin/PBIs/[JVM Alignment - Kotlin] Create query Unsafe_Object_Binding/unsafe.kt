package com.kotlinmvc.kotlingspringmvc

import com.kotlinmvc.kotlingspringmvc.BlogProperties
import com.kotlinmvc.kotlingspringmvc.Order
import com.kotlinmvc.kotlingspringmvc.NewOrderRepository
import com.kotlinmvc.kotlingspringmvc.UserRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import java.util.*

@Controller
class ZController {
    @RequestMapping(value = ["/test"])
    fun test4(@RequestBody order1: Order4?): String? {
        if(order1 == null) {
            return "Error"
        }
        orderRepository.save(order1)
        return "orderUpdated"
    }

    @RequestMapping(value = ["/test"])
    fun test5(@ModelAttribute order2: Order5?): String? {
        if(order2 == null) {
            return "Error"
        }
        orderRepository.save(order2)
        return "orderUpdated"
    }

    @RequestMapping(value = ["/test"])
    fun test6(@RequestBody order3: Order6?): String? {
        if(order3 == null) {
            return "Error"
        }
        orderRepository.save(order3)
        return "orderUpdated"
    }
}