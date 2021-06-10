package zw.co.blu.useCases.users

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import zw.co.blu.model.users.User
import zw.co.blu.model.users.UserEditDao
import zw.co.blu.model.users.UserStatus
import zw.co.blu.requestResult.RequestResult
import zw.co.blu.service.users.UserService

internal class EditUserTest {
    private val userServiceMock: UserService = mockk()

    private val inputId: String = "1"
    private val role: String = "3"
    private val inputValue: UserEditDao = UserEditDao(null, "", "", UserStatus.ACTIVE, role)

    private val output: User = User("1", "", "", UserStatus.ACTIVE, role)

    @Test
    fun `it should return successful response`() {

        val expected: RequestResult.Success<User> = RequestResult.Success(output)

        coEvery { userServiceMock.editUser(any(), any()) } returns expected

        val sut = EditUser(userServiceMock)

        runBlocking { assertEquals(expected, sut.invoke(inputId, inputValue)) }

        coVerify { userServiceMock.editUser(any(), any()) }
    }

    @Test
    fun `it should return error response`() {

        val expected: RequestResult.Error<User> = RequestResult.Error(Exception("testing exception"))

        coEvery { userServiceMock.editUser(any(), any()) } returns expected

        val sut = EditUser(userServiceMock)

        runBlocking { assertEquals(expected, sut.invoke(inputId, inputValue)) }

        coVerify { userServiceMock.editUser(any(), any()) }
    }
}