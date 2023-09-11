package com.bestbuy.sample.sampleapp.controller

import com.bestbuy.sample.sampleapp.core.model.*
import com.bestbuy.sample.sampleapp.core.service.UtilsService
import com.bestbuy.sample.sampleapp.core.utils.ValidationUtils
import org.springframework.util.StringUtils
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/utils")
class UtilsController(val utilsService: UtilsService,
                      val validationUtils: ValidationUtils) {
    @GetMapping("/context/list")
    fun findDistinctContext(@RequestHeader(value = "X-CLIENT-ID") clientId: String,
                            @RequestHeader(value = "X-REQUEST-ID") requestId: String,
                            @RequestParam(required = false) ownerId: String?) : List<String> {
        validationUtils.validateClientId(clientId)

        if (StringUtils.isEmpty(ownerId)) {
            return utilsService.getUniqueContextNames(requestId, "")
        } else {
            return utilsService.getUniqueContextNames(requestId, ownerId)
        }
    }
}