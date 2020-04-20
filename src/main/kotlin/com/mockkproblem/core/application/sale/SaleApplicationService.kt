package com.mockkproblem.core.application.sale

import com.mockkproblem.core.domain.authorization.AuthorizationPort
import com.mockkproblem.core.domain.sale.Sale
import org.springframework.stereotype.Service

@Service
class SaleApplicationService(
    private val authorizationPort: AuthorizationPort
) {

    fun authorizeSale() {
        val sale = Sale.newPendingSale()

        authorizationPort.authorizeSaleExternally(sale)

        sale.authorize()
    }
}
