package zw.co.blu.domain.useCases.roles

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import zw.co.blu.domain.model.roles.Role
import zw.co.blu.domain.model.roles.RoleEditDao
import zw.co.blu.domain.model.roles.RoleStatus
import zw.co.blu.domain.requestResult.RequestResult
import zw.co.blu.domain.service.roles.RoleService

internal class EditRoleTest {
    private val roleServiceMock: RoleService = mockk()

    private val inputId: String = "1"
    private val inputValue: RoleEditDao = RoleEditDao("", "", RoleStatus.ACTIVE, listOf())

    private val output: Role = Role("", "", RoleStatus.INACTIVE, listOf())

    @Test
    fun `it should return successful response`() {

        val expected: RequestResult.Success<Role> = RequestResult.Success(output)

        coEvery { roleServiceMock.editRole(any(), any()) } returns expected

        val sut = EditRole(roleServiceMock)

        runBlocking { assertEquals(expected, sut.invoke(inputId, inputValue)) }

        coVerify { roleServiceMock.editRole(any(), any()) }
    }

    @Test
    fun `it should return error response`() {

        val expected: RequestResult.Error<Role> = RequestResult.Error(Exception("testing exception"))

        coEvery { roleServiceMock.editRole(any(), any()) } returns expected

        val sut = EditRole(roleServiceMock)

        runBlocking { assertEquals(expected, sut.invoke(inputId, inputValue)) }

        coVerify { roleServiceMock.editRole(any(), any()) }
    }
}