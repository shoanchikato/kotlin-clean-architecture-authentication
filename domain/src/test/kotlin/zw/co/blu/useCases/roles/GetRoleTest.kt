package zw.co.blu.useCases.roles

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import zw.co.blu.model.roles.Role
import zw.co.blu.model.roles.RoleStatus
import zw.co.blu.requestResult.RequestResult
import zw.co.blu.service.roles.RoleService
import java.lang.Exception

internal class GetRoleTest {
    private val roleServiceMock: RoleService = mockk()

    private val inputId: String = "1"

    private val output: Role = Role("1", "", RoleStatus.INACTIVE, listOf())

    @Test
    fun `it should return successful response`() {

        val expected: RequestResult.Success<Role> = RequestResult.Success(output)

        coEvery { roleServiceMock.getRole(any()) } returns expected

        val sut = GetRole(roleServiceMock)

        runBlocking { assertEquals(expected, sut.invoke(inputId)) }

        coVerify { roleServiceMock.getRole(any()) }
    }

    @Test
    fun `it should return error response`() {

        val expected: RequestResult.Error<Role> = RequestResult.Error(Exception("testing exception"))

        coEvery { roleServiceMock.getRole(any()) } returns expected

        val sut = GetRole(roleServiceMock)

        runBlocking { assertEquals(expected, sut.invoke(inputId)) }

        coVerify { roleServiceMock.getRole(any()) }
    }
}