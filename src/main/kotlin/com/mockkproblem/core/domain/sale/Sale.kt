package com.mockkproblem.core.domain.sale

data class Sale(
    var status: String
) {
    companion object {
        fun newPendingSale() = Sale(status = "PENDING")
    }

    fun authorize() {
        status = "AUTHORIZED"
    }
}
