package com.example.githubdata.closemr

import com.example.githubdata.closedmr.GithubRepository
import com.example.githubdata.closedmr.TestHelper
import com.example.githubdata.models.ClosedMr
import com.example.githubdata.network.GithubApi
import com.example.githubdomain.IGithubRepository
import com.example.githubdomain.common.IFailure
import com.nhaarman.mockitokotlin2.whenever
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import com.nhaarman.mockitokotlin2.doThrow
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@ExperimentalCoroutinesApi
@DisplayName("Github Repository Test Cases")
class GithubRepositoryTest {

    private lateinit var repo: IGithubRepository
    private val apiService by lazy { mock<GithubApi>() }


    @BeforeEach
    fun setUp() {
        repo = GithubRepository(apiService)
    }

    @Test
    @DisplayName("Testing GetAllClosedMR success case")
    fun `should fetch all closed mr successfully`() {
        val closedMrsList: List<ClosedMr> = listOf()
        runTest {
            whenever(apiService.getGithubClosedMr()).thenReturn(closedMrsList)
            val actualResult = repo.getAllClosedMR()

            assertEquals(closedMrsList,actualResult.successValue())
            verify(apiService, times(1)).getGithubClosedMr()
            verifyNoMoreInteractions(apiService)
        }
    }

    @Test
    @DisplayName("Testing GetAllClosedMR Failed Case")
    fun `should give error when  fetching all closed mr failed`() {
        val exception = TestHelper.getApiError<Unit>(TestHelper.NORMAL_ERROR_CODE)
        runTest {
            whenever(apiService.getGithubClosedMr()).doThrow(exception)
            val actualResult = repo.getAllClosedMR()

            assertEquals(exception.code(), TestHelper.NORMAL_ERROR_CODE)
            assertTrue(actualResult.errorValue() is IFailure)
            verify(apiService, times(1)).getGithubClosedMr()
            verifyNoMoreInteractions(apiService)
        }
    }
}