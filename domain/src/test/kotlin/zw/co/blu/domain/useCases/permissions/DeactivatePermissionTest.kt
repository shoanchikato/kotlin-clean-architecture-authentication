package zw.co.blu.domain.useCases.permissions

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import zw.co.blu.domain.model.permissions.Permission
import zw.co.blu.domain.model.permissions.PermissionStatus
import zw.co.blu.domain.requestResult.RequestResult
import zw.co.blu.domain.service.permissions.PermissionService
import java.lang.Exception

internal class DeactivatePermissionTest {
    private val permissionServiceMock: PermissionService = mockk()

    private val input: String = "1"

    private val output: Permission = Permission("", PermissionStatus.INACTIVE, listOf())

    @Test
    fun `it should return successful response`() {

        val expected: RequestResult.Success<Permission> = RequestResult.Success(output)

        coEvery { permissionServiceMock.deactivatePermission(any()) } returns expected

        val sut = DeactivatePermission(permissionServiceMock)

        runBlocking { assertEquals(expected, sut.invoke(input)) }

        coVerify { permissionServiceMock.deactivatePermission(any()) }
    }

    @Test
    fun `it should return error response`() {

        val expected: RequestResult.Error<Permission> = RequestResult.Error(Exception("testing exception"))

        coEvery { permissionServiceMock.deactivatePermission(any()) } returns expected

        val sut = DeactivatePermission(permissionServiceMock)

        runBlocking { assertEquals(expected, sut.invoke(input)) }

        coVerify { permissionServiceMock.deactivatePermission(any()) }
    }
}