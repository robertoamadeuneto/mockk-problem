package com.mockkproblem.adapters.authorization

import com.mockkproblem.core.domain.authorization.AuthorizationPort
import com.mockkproblem.core.domain.sale.Sale

class AuthorizationAdapter : AuthorizationPort {

    override fun authorizeSaleExternally(sale: Sale) {
        println("Sale authorized externally.")
    }
}
