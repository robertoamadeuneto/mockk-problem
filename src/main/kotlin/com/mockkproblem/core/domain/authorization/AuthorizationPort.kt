package com.mockkproblem.core.domain.authorization

import com.mockkproblem.core.domain.sale.Sale

interface AuthorizationPort {

    fun authorizeSaleExternally(sale: Sale)
}
