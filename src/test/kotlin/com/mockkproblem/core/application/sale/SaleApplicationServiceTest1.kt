package com.mockkproblem.core.application.sale

import com.mockkproblem.core.domain.authorization.AuthorizationPort
import com.mockkproblem.fixtures.SaleFixture
import io.kotlintest.TestCase
import io.kotlintest.TestResult
import io.kotlintest.specs.DescribeSpec
import io.mockk.clearMocks
import io.mockk.confirmVerified
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify

class SaleApplicationServiceTest1 : DescribeSpec() {

    private val authorizationPort = mockk<AuthorizationPort>()
    private val saleApplicationService = SaleApplicationService(authorizationPort)

    override fun afterTest(testCase: TestCase, result: TestResult) =
        clearMocks(authorizationPort)

    init {
        describe("Authorize Sale") {
            context("Authorize valid Sale") {
                it("This case is supposed to succeed, but it isn't") {
                    every { authorizationPort.authorizeSaleExternally(any()) } returns Unit

                    saleApplicationService.authorizeSale()

                    verify { authorizationPort.authorizeSaleExternally(eq(SaleFixture.pendingSale())) }
                    confirmVerified(authorizationPort)
                }

                it("This case is supposed to fail, but it isn't") {
                    every { authorizationPort.authorizeSaleExternally(any()) } returns Unit

                    saleApplicationService.authorizeSale()

                    verify { authorizationPort.authorizeSaleExternally(eq(SaleFixture.authorized())) }
                    confirmVerified(authorizationPort)
                }
            }
        }
    }
}
