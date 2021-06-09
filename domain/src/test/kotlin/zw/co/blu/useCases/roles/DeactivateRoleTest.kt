package zw.co.blu.useCases.roles

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import zw.co.blu.model.Role
import zw.co.blu.model.RoleStatus
import zw.co.blu.requestResult.RequestResult
import zw.co.blu.service.roles.RoleService
import java.lang.Exception

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