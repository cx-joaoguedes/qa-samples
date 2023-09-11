package com.bestbuy.sample.sampleapp.core.service

import com.bestbuy.sample.sampleapp.core.model.*
import com.bestbuy.sample.sampleapp.core.repo.SampleRepo
import org.springframework.stereotype.Service

@Service
class UtilsService(val sampleRepo: SampleRepo) {
    /**
     * Method to get unique context names
     * @param ownerId String
     * @return Samplegroup
     */
    fun getUniqueContextNames(requestId: String, ownerId: String?): List<String> {
       return sampleRepo.getUniqueContextNames(requestId, ownerId)
    }
}