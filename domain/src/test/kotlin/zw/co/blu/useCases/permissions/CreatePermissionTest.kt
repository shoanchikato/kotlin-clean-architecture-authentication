package zw.co.blu.useCases.permissions

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import zw.co.blu.model.permissions.Permission
import zw.co.blu.model.permissions.PermissionStatus
import zw.co.blu.requestResult.RequestResult
import zw.co.blu.service.permissions.PermissionService
import java.lang.Exception
import kotlin.test.assertEquals

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class CreatePermissionTest {

    private val permissionServiceMock: PermissionService = mockk()

    private val input: Permission = Permission("", PermissionStatus.ACTIVE, listOf())

    @Test
    fun `it should return successful response`() {

        val expected: RequestResult.Success<Permission> = RequestResult.Success(input)

        coEvery { permissionServiceMock.createPermission(any()) } returns expected

        val sut = CreatePermission(permissionServiceMock)

        runBlocking { assertEquals(expected, sut.invoke(input)) }

        coVerify { permissionServiceMock.createPermission(any()) }
    }

    @Test
    fun `it should return error response`() {

        val expected: RequestResult.Error<Permission> = RequestResult.Error(Exception("testing exception"))

        coEvery { permissionServiceMock.createPermission(any()) } returns expected

        val sut = CreatePermission(permissionServiceMock)

        runBlocking { assertEquals(expected, sut.invoke(input)) }

        coVerify { permissionServiceMock.createPermission(any()) }
    }
}