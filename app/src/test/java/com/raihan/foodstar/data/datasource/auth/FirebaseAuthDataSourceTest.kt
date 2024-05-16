package com.raihan.foodstar.data.datasource.auth

import com.google.firebase.auth.FirebaseUser
import com.raihan.foodstar.data.model.User
import com.raihan.foodstar.data.source.firebase.FirebaseService
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class FirebaseAuthDataSourceTest {
    private lateinit var firebaseAuthDataSource: AuthDataSource
    private lateinit var firebaseService: FirebaseService

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        firebaseService = mockk()
        firebaseAuthDataSource = FirebaseAuthDataSource(firebaseService)
    }

    @Test
    fun doLogin() {
        runTest {
            val email = "hai@example.com"
            val password = "han123"
            coEvery { firebaseService.doLogin(email, password) } returns true
            val result = firebaseAuthDataSource.doLogin(email, password)
            coVerify { firebaseService.doLogin(email, password) }
            assertEquals(true, result)
        }
    }

    @Test
    fun doRegister() {
        runTest {
            val email = "hai@example.com"
            val fullName = "Han"
            val password = "han123"
            coEvery { firebaseService.doRegister(email, fullName, password) } returns true
            val result = firebaseAuthDataSource.doRegister(email, fullName, password)
            coVerify { firebaseService.doRegister(email, fullName, password) }
            assertEquals(true, result)
        }
    }

    @Test
    fun updateProfile() {
        runTest {
            val name = "Halo"
            coEvery { firebaseService.updateProfile(name) } returns true
            val result = firebaseAuthDataSource.updateProfile(name)
            coVerify { firebaseService.updateProfile(name) }
            assertEquals(true, result)
        }
    }

    @Test
    fun `updateProfile null`() {
        runTest {
            coEvery { firebaseService.updateProfile() } returns true
            val result = firebaseAuthDataSource.updateProfile()
            coVerify { firebaseService.updateProfile() }
            assertEquals(true, result)
        }
    }

    @Test
    fun updatePassword() {
        runTest {
            val password = "Hai"
            coEvery { firebaseService.updatePassword(password) } returns true
            val result = firebaseAuthDataSource.updatePassword(password)
            coVerify { firebaseService.updatePassword(password) }
            assertEquals(true, result)
        }
    }

    @Test
    fun updateEmail() {
        runTest {
            val email = "Hai"
            coEvery { firebaseService.updateEmail(email) } returns true
            val result = firebaseAuthDataSource.updateEmail(email)
            coVerify { firebaseService.updateEmail(email) }
            assertEquals(true, result)
        }
    }

    @Test
    fun requestChangePasswordByEmail() {
        runTest {
            coEvery { firebaseService.requestChangePasswordByEmail() } returns true
            val result = firebaseAuthDataSource.requestChangePasswordByEmail()
            coVerify { firebaseService.requestChangePasswordByEmail() }
            assertEquals(true, result)
        }
    }

    @Test
    fun doLogout() {
        runTest {
            coEvery { firebaseService.doLogout() } returns true
            val result = firebaseAuthDataSource.doLogout()
            coVerify { firebaseService.doLogout() }
            assertEquals(true, result)
        }
    }

    @Test
    fun isLoggedIn() {
        runTest {
            coEvery { firebaseService.isLoggedIn() } returns true
            val result = firebaseAuthDataSource.isLoggedIn()
            coVerify { firebaseService.isLoggedIn() }
            assertEquals(true, result)
        }
    }

    @Test
    fun getCurrentUser() {
        val mockFirebaseUser = mockk<FirebaseUser>()
        runTest {
            val expectedUser = User("121", "Matt", "matt@gmail.com")

            coEvery { firebaseService.getCurrentUser() } returns mockFirebaseUser
            coEvery { mockFirebaseUser.uid } returns expectedUser.id
            coEvery { mockFirebaseUser.displayName } returns expectedUser.fullName
            coEvery { mockFirebaseUser.email } returns expectedUser.email

            val result = firebaseAuthDataSource.getCurrentUser()

            coVerify { firebaseService.getCurrentUser() }
            assertEquals(expectedUser.id, result?.id)
            assertEquals(expectedUser.fullName, result?.fullName)
            assertEquals(expectedUser.email, result?.email)
        }
    }
}
