package zw.co.blu.useCases.roles

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import zw.co.blu.model.abilities.Ability
import zw.co.blu.model.permissions.Permission
import zw.co.blu.model.permissions.PermissionStatus
import zw.co.blu.model.roles.Role
import zw.co.blu.model.roles.RoleDao
import zw.co.blu.model.roles.RoleStatus
import zw.co.blu.requestResult.RequestResult
import zw.co.blu.service.roles.RoleService

internal class CreateRoleTest {
    private val roleServiceMock: RoleService = mockk()

    private val abilities: List<Ability> = listOf(Ability.CREATE, Ability.EDIT)
    private val permissions: List<Permission> = listOf(Permission("BOOKS", PermissionStatus.ACTIVE, abilities))

    private val input: RoleDao = RoleDao("", "", RoleStatus.ACTIVE, permissions)

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