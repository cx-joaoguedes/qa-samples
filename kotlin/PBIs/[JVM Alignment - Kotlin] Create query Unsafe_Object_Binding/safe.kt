package com.kotlinmvc.kotlingspringmvc

import com.kotlinmvc.kotlingspringmvc.BlogProperties
import com.kotlinmvc.kotlingspringmvc.Entities
import com.kotlinmvc.kotlingspringmvc.NewOrderRepository
import com.kotlinmvc.kotlingspringmvc.UserRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping


@Controller
class XController {
    @InitBinder
    fun setAllowedFields(dataBinder: WebDataBinder) {
        def fieldsWhitelist = "itemId address".split()
        binder.setAllowedFields(fieldsWhitelist)
    }

    @RequestMapping(value = ["/test"])
    fun test(@ModelAttribute order: Order?): String? {
        if(order == null) {
            return "Error"
        }
        orderRepository.save(order)
        return "orderUpdated"
    }
}