package zw.co.blu.domain.useCases.roles

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import zw.co.blu.domain.model.privileges.Privileges
import zw.co.blu.domain.model.roles.Role
import zw.co.blu.domain.model.roles.RoleDao
import zw.co.blu.domain.model.roles.RoleStatus
import zw.co.blu.domain.requestResult.RequestResult
import zw.co.blu.domain.service.roles.RoleService

internal class CreateRoleTest {
    private val roleServiceMock: RoleService = mockk()

    private val privileges: List<Privileges> = listOf(Privileges.CREATE, Privileges.EDIT)
    private val permissions: List<String> = listOf("1")

    private val input: RoleDao = RoleDao("", permissions)

    private val output: Role = Role("", "", RoleStatus.ACTIVE, listOf())

    @Test
    fun `it should return successful response`() {

        val expected: RequestResult.Success<Role> = RequestResult.Success(output)

        coEvery { roleServiceMock.createRole(any()) } returns expected

        val sut = CreateRole(roleServiceMock)

        runBlocking { assertEquals(expected, sut.invoke(input)) }

        coVerify { roleServiceMock.createRole(any()) }
    }

    @Test
    fun `it should return error response`() {

        val expected: RequestResult.Error<Role> = RequestResult.Error(Exception("testing exception"))

        coEvery { roleServiceMock.createRole(any()) } returns expected

        val sut = CreateRole(roleServiceMock)

        runBlocking { assertEquals(expected, sut.invoke(input)) }

        coVerify { roleServiceMock.createRole(any()) }
    }
}