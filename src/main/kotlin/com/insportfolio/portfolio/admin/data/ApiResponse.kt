package com.insportfolio.portfolio.admin.data

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

class ApiResponse<T>(status: HttpStatus) : ResponseEntity<T>(status) {
    companion object {
        fun successCreate(): ResponseEntity<Any> {
            return ok("The data has been saved.")
        }

        fun successUpdate(): ResponseEntity<Any> {
            return ok("The data has been updated.")
        }

        fun successDelete(): ResponseEntity<Any> {
            return ok("The data has been deleted.")
        }
    }
}