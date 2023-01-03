package com.bora.lancamentos.exception

class NotFoundException(
    var errorCode: String,
    override var message: String
): Exception() {
}