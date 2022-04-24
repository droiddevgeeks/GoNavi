package com.example.githubdomain.usecases

import com.example.githubdomain.IClosedMr
import com.example.githubdomain.IGithubRepository
import com.example.githubdomain.common.IFailure
import com.example.githubdomain.common.Result
import com.example.githubdomain.usecase.GetGithubClosedMrUseCase
import com.nhaarman.mockitokotlin2.whenever
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test


@ExperimentalCoroutinesApi
@DisplayName("Get GithubClosedMr UseCase tests")
class GetGithubClosedMrUseCaseTest {

    private lateinit var useCase: GetGithubClosedMrUseCase
    private val repo by lazy { mock<IGithubRepository>() }

    @BeforeEach
    fun setUp() {
        useCase = GetGithubClosedMrUseCase(repo)
    }

    @Test
    @DisplayName("Testing Get All Closed MR success case")
    fun `should give success for get all closed MR Api`() {
        val data = mock<List<IClosedMr>>()
        val successVal = Result.Success(data)
        runTest {
            // Assemble
            whenever(repo.getAllClosedMR()).thenReturn(successVal)

            // Act
            val actualResult = useCase.run(Unit)

            // Assert
            assertEquals(data, actualResult.successValue())
            verify(repo, times(1)).getAllClosedMR()
            verifyNoMoreInteractions(repo)
        }
    }

    @Test
    @DisplayName("Testing GetAllClosedMR fail case")
    fun `should give error when all closed mr api is called`() {
        val error = mock<IFailure>()
        runTest {
            whenever(repo.getAllClosedMR()).thenReturn(Result.Error(error))

            val actualResult = useCase.run(Unit)

            assertTrue(actualResult.errorValue() is IFailure)
            assertEquals(error, actualResult.errorValue())
            verify(repo, times(1)).getAllClosedMR()
            verifyNoMoreInteractions(repo)
        }
    }
}