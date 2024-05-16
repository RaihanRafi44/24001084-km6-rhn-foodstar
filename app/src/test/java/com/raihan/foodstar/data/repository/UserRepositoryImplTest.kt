package com.raihan.foodstar.data.repository

import app.cash.turbine.test
import com.raihan.foodstar.data.datasource.auth.AuthDataSource
import com.raihan.foodstar.data.model.User
import com.raihan.foodstar.utils.ResultWrapper
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class UserRepositoryImplTest {
    @MockK
    lateinit var ds: AuthDataSource

    private lateinit var repo: UserRepository

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        repo = UserRepositoryImpl(ds)
    }

    @Test
    fun doLogin_Success() {
        val email = "hai@example.com"
        val password = "han123"
        coEvery { ds.doLogin(email, password) } returns true
        runTest {
            coEvery { ds.doLogin(email, password) } returns true
            repo.doLogin(email, password).map {
                delay(100)
                it
            }.test {
                delay(210)
                val actualData = expectMostRecentItem()
                Assert.assertTrue(actualData is ResultWrapper.Success)
                coVerify { ds.doLogin(email, password) }
            }
        }
    }

    @Test
    fun doLogin_Loading() {
        val email = "hai@example.com"
        val password = "han123"
        coEvery { ds.doLogin(email, password) } returns true
        runTest {
            coEvery { ds.doLogin(email, password) } returns true
            repo.doLogin(email, password).map {
                delay(100)
                it
            }.test {
                delay(110)
                val actualData = expectMostRecentItem()
                Assert.assertTrue(actualData is ResultWrapper.Loading)
                coVerify { ds.doLogin(email, password) }
            }
        }
    }

    @Test
    fun doLogin_Error() {
        val email = "hai@example.com"
        val password = "han123"
        coEvery { ds.doLogin(email, password) } returns true
        runTest {
            coEvery { ds.doLogin(email, password) } throws IllegalStateException("Mock Error")
            repo.doLogin(email, password).map {
                delay(100)
                it
            }.test {
                delay(210)
                val actualData = expectMostRecentItem()
                Assert.assertTrue(actualData is ResultWrapper.Error)
                coVerify { ds.doLogin(email, password) }
            }
        }
    }

    @Test
    fun doRegister_Success() {
        val email = "hai@example.com"
        val fullName = "human"
        val password = "han123"
        coEvery { ds.doRegister(email, fullName, password) } returns true
        runTest {
            coEvery { ds.doRegister(email, fullName, password) } returns true
            repo.doRegister(email, fullName, password).map {
                delay(100)
                it
            }.test {
                delay(210)
                val actualData = expectMostRecentItem()
                Assert.assertTrue(actualData is ResultWrapper.Success)
                coVerify { ds.doRegister(email, fullName, password) }
            }
        }
    }

    @Test
    fun doRegister_Loading() {
        val email = "hai@example.com"
        val fullName = "human"
        val password = "han123"
        coEvery { ds.doRegister(email, fullName, password) } returns true
        runTest {
            coEvery { ds.doRegister(email, fullName, password) } returns true
            repo.doRegister(email, fullName, password).map {
                delay(100)
                it
            }.test {
                delay(110)
                val actualData = expectMostRecentItem()
                Assert.assertTrue(actualData is ResultWrapper.Loading)
                coVerify { ds.doRegister(email, fullName, password) }
            }
        }
    }

    @Test
    fun doRegister_Error() {
        val email = "hai@example.com"
        val fullName = "human"
        val password = "han123"
        coEvery { ds.doRegister(email, fullName, password) } returns true
        runTest {
            coEvery { ds.doRegister(email, fullName, password) } throws IllegalStateException("Mock Error")
            repo.doRegister(email, fullName, password).map {
                delay(100)
                it
            }.test {
                delay(210)
                val actualData = expectMostRecentItem()
                Assert.assertTrue(actualData is ResultWrapper.Error)
                coVerify { ds.doRegister(email, fullName, password) }
            }
        }
    }

    @Test
    fun updateProfile_Success() {
        val fullName = "men"
        coEvery { ds.updateProfile(fullName) } returns true
        runTest {
            coEvery { ds.updateProfile(fullName) } returns true
            repo.updateProfile(fullName).map {
                delay(100)
                it
            }.test {
                delay(210)
                val actualData = expectMostRecentItem()
                Assert.assertTrue(actualData is ResultWrapper.Success)
                coVerify { ds.updateProfile(fullName) }
            }
        }
    }

    @Test
    fun updateProfile_Loading() {
        val fullName = "men"
        coEvery { ds.updateProfile(fullName) } returns true
        runTest {
            coEvery { ds.updateProfile(fullName) } returns true
            repo.updateProfile(fullName).map {
                delay(100)
                it
            }.test {
                delay(110)
                val actualData = expectMostRecentItem()
                Assert.assertTrue(actualData is ResultWrapper.Loading)
                coVerify { ds.updateProfile(fullName) }
            }
        }
    }

    @Test
    fun updateProfile_Error() {
        val fullName = "men"
        coEvery { ds.updateProfile(fullName) } returns true
        runTest {
            coEvery { ds.updateProfile(fullName) } throws IllegalStateException("Mock Error")
            repo.updateProfile(fullName).map {
                delay(100)
                it
            }.test {
                delay(210)
                val actualData = expectMostRecentItem()
                Assert.assertTrue(actualData is ResultWrapper.Error)
                coVerify { ds.updateProfile(fullName) }
            }
        }
    }

    @Test
    fun updateProfile_Empty() {
        coEvery { ds.updateProfile() } returns true
        runTest {
            coEvery { ds.updateProfile() } returns true
            repo.updateProfile().map {
                delay(100)
                it
            }.test {
                delay(210)
                val actualData = expectMostRecentItem()
                Assert.assertTrue(actualData is ResultWrapper.Success)
                coVerify { ds.updateProfile() }
            }
        }
    }

    @Test
    fun updatePassword_Success() {
        val password = "men123"
        coEvery { ds.updatePassword(password) } returns true
        runTest {
            coEvery { ds.updatePassword(password) } returns true
            repo.updatePassword(password).map {
                delay(100)
                it
            }.test {
                delay(210)
                val actualData = expectMostRecentItem()
                Assert.assertTrue(actualData is ResultWrapper.Success)
                coVerify { ds.updatePassword(password) }
            }
        }
    }

    @Test
    fun updatePassword_Loading() {
        val password = "men123"
        coEvery { ds.updatePassword(password) } returns true
        runTest {
            coEvery { ds.updatePassword(password) } returns true
            repo.updatePassword(password).map {
                delay(100)
                it
            }.test {
                delay(110)
                val actualData = expectMostRecentItem()
                Assert.assertTrue(actualData is ResultWrapper.Loading)
                coVerify { ds.updatePassword(password) }
            }
        }
    }

    @Test
    fun updatePassword_Error() {
        val password = "men123"
        coEvery { ds.updatePassword(password) } returns true
        runTest {
            coEvery { ds.updatePassword(password) } throws IllegalStateException("Mock Error")
            repo.updatePassword(password).map {
                delay(100)
                it
            }.test {
                delay(210)
                val actualData = expectMostRecentItem()
                Assert.assertTrue(actualData is ResultWrapper.Error)
                coVerify { ds.updatePassword(password) }
            }
        }
    }

    @Test
    fun updateEmail_Success() {
        val email = "men123@halo.com"
        coEvery { ds.updateEmail(email) } returns true
        runTest {
            coEvery { ds.updateEmail(email) } returns true
            repo.updateEmail(email).map {
                delay(100)
                it
            }.test {
                delay(210)
                val actualData = expectMostRecentItem()
                Assert.assertTrue(actualData is ResultWrapper.Success)
                coVerify { ds.updateEmail(email) }
            }
        }
    }

    @Test
    fun updateEmail_Loading() {
        val email = "men123"
        coEvery { ds.updateEmail(email) } returns true
        runTest {
            coEvery { ds.updateEmail(email) } returns true
            repo.updateEmail(email).map {
                delay(100)
                it
            }.test {
                delay(110)
                val actualData = expectMostRecentItem()
                Assert.assertTrue(actualData is ResultWrapper.Loading)
                coVerify { ds.updateEmail(email) }
            }
        }
    }

    @Test
    fun updateEmail_Error() {
        val email = "men123"
        coEvery { ds.updateEmail(email) } returns true
        runTest {
            coEvery { ds.updateEmail(email) } throws IllegalStateException("Mock Error")
            repo.updateEmail(email).map {
                delay(100)
                it
            }.test {
                delay(210)
                val actualData = expectMostRecentItem()
                Assert.assertTrue(actualData is ResultWrapper.Error)
                coVerify { ds.updateEmail(email) }
            }
        }
    }

    @Test
    fun requestChangePasswordByEmail() {
        every { ds.requestChangePasswordByEmail() } returns true
        val actualData = repo.requestChangePasswordByEmail()
        verify { ds.requestChangePasswordByEmail() }
        Assert.assertEquals(true, actualData)
    }

    @Test
    fun doLogout() {
        every { ds.doLogout() } returns true
        val actualData = repo.doLogout()
        verify { ds.doLogout() }
        Assert.assertEquals(true, actualData)
    }

    @Test
    fun isLoggedIn() {
        every { ds.isLoggedIn() } returns true
        val actualData = repo.isLoggedIn()
        verify { ds.isLoggedIn() }
        Assert.assertEquals(true, actualData)
    }

    @Test
    fun getCurrentUser() {
        val expectedUser = User("12", "han", "han@gmail.com")
        every { ds.getCurrentUser() } returns expectedUser
        val result = repo.getCurrentUser()
        Assert.assertEquals(expectedUser, result)
        verify { ds.getCurrentUser() }
    }
}
