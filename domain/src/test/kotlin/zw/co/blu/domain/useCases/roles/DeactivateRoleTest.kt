package zw.co.blu.domain.useCases.roles

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import zw.co.blu.domain.model.roles.Role
import zw.co.blu.domain.model.roles.RoleStatus
import zw.co.blu.domain.requestResult.RequestResult
import zw.co.blu.domain.service.roles.RoleService

internal class DeactivateRoleTest {
    private val roleServiceMock: RoleService = mockk()

    private val input: String = "1"

    private val output: Role = Role("", "", RoleStatus.INACTIVE, listOf())

    @Test
    fun `it should return successful response`() {

        val expected: RequestResult.Success<Role> = RequestResult.Success(output)

        coEvery { roleServiceMock.deactivateRole(any()) } returns expected

        val sut = DeactivateRole(roleServiceMock)

        runBlocking { assertEquals(expected, sut.invoke(input)) }

        coVerify { roleServiceMock.deactivateRole(any()) }
    }

    @Test
    fun `it should return error response`() {

        val expected: RequestResult.Error<Role> = RequestResult.Error(Exception("testing exception"))

        coEvery { roleServiceMock.deactivateRole(any()) } returns expected

        val sut = DeactivateRole(roleServiceMock)

        runBlocking { assertEquals(expected, sut.invoke(input)) }

        coVerify { roleServiceMock.deactivateRole(any()) }
    }
}