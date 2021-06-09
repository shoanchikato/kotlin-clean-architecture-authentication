package zw.co.blu.useCases.roles

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import zw.co.blu.model.Role
import zw.co.blu.model.RoleEditDao
import zw.co.blu.model.RoleStatus
import zw.co.blu.requestResult.RequestResult
import zw.co.blu.service.roles.RoleService
import java.lang.Exception

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