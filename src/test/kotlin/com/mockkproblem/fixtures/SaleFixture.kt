package com.mockkproblem.fixtures

import com.mockkproblem.core.domain.sale.Sale

object SaleFixture {

    fun pendingSale() = Sale(
        status = "PENDING"
    )

    fun authorized() = Sale(
        status = "AUTHORIZED"
    )
}
