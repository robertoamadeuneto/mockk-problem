package com.mockkproblem.core.application.sale

import com.mockkproblem.core.domain.authorization.AuthorizationPort
import com.mockkproblem.fixtures.SaleFixture
import io.mockk.MockKAnnotations
import io.mockk.confirmVerified
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class SaleApplicationServiceTest2 {

    @MockK
    private lateinit var authorizationPort: AuthorizationPort

    private lateinit var saleApplicationService: SaleApplicationService

    @BeforeEach
    internal fun setUp() {
        MockKAnnotations.init(this)
        saleApplicationService = SaleApplicationService(authorizationPort)
    }

    @Test
    fun shouldSucceedAuthorizingSale() {
        every { authorizationPort.authorizeSaleExternally(any()) } returns Unit

        saleApplicationService.authorizeSale()

        verify { authorizationPort.authorizeSaleExternally(eq(SaleFixture.pendingSale())) }
        confirmVerified(authorizationPort)
    }

    @Test
    fun shouldFailAuthorizingSale() {
        every { authorizationPort.authorizeSaleExternally(any()) } returns Unit

        saleApplicationService.authorizeSale()

        verify { authorizationPort.authorizeSaleExternally(eq(SaleFixture.authorized())) }
        confirmVerified(authorizationPort)
    }
}
