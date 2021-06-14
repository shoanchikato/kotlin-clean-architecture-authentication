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

internal class GetAllRolesTest {
    private val roleServiceMock: RoleService = mockk()

    private val output: List<Role> = listOf(Role("1", "", RoleStatus.INACTIVE, listOf()))

    @Test
    fun `it should return successful response`() {

        val expected: RequestResult.Success<List<Role>> = RequestResult.Success(output)

        coEvery { roleServiceMock.getAllRoles() } returns expected

        val sut = GetAllRoles(roleServiceMock)

        runBlocking { assertEquals(expected, sut.invoke()) }

        coVerify { roleServiceMock.getAllRoles() }
    }

    @Test
    fun `it should return error response`() {

        val expected: RequestResult.Error<List<Role>> = RequestResult.Error(Exception("testing exception"))

        coEvery { roleServiceMock.getAllRoles() } returns expected

        val sut = GetAllRoles(roleServiceMock)

        runBlocking { assertEquals(expected, sut.invoke()) }

        coVerify { roleServiceMock.getAllRoles() }
    }
}