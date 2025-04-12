package com.insportfolio.portfolio.admin.exception

import org.springframework.http.HttpStatus

abstract class AdminException(
    httpStatus: HttpStatus,
    message: String,
) : RuntimeException(message) {
    val httpStatus: HttpStatus = httpStatus
}

class AdminBadRequestException(message: String) :
    AdminException(httpStatus = HttpStatus.BAD_REQUEST, message = message) {

}

class AdminInternalServerException(message: String) :
    AdminException(httpStatus = HttpStatus.INTERNAL_SERVER_ERROR, message = message) {

}