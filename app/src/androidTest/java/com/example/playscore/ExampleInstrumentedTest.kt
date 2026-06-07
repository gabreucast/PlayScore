package com.example.playscore

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.playscore", appContext.packageName)
    }

    @Test
    fun appName_isCorrect() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals(
            "PlayScore",
            appContext.getString(R.string.app_name)
        )
    }

    @Test
    fun playerOne_defaultName_exists() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        val language = appContext.resources.configuration.locales[0].language
        val expectedText = when (language) {
            "es" -> "Jugador 1"
            "pt" -> "Jogador 1"
            else -> "Player 1"
        }

        assertEquals(
            expectedText,
            appContext.getString(R.string.player_1)
        )
    }

    @Test
    fun playerTwo_defaultName_exists() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        val language = appContext.resources.configuration.locales[0].language
        val expectedText = when (language) {
            "es" -> "Jugador 2"
            "pt" -> "Jogador 2"
            else -> "Player 2"
        }

        assertEquals(
            expectedText,
            appContext.getString(R.string.player_2)
        )
    }

    @Test
    fun restartButtonText_exists() {

        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        val language = appContext.resources.configuration.locales[0].language
        val expectedText = when (language) {
            "es" -> "Reiniciar"
            "pt" -> "Reiniciar"
            else -> "Restart"
        }

        assertEquals(
            expectedText,
            appContext.getString(R.string.restart)
        )
    }

    @Test
    fun gameOverText_exists() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        val language = appContext.resources.configuration.locales[0].language
        val expectedText = when (language) {
            "es" -> "Fin de la partida"
            "pt" -> "Fim da partida"
            else -> "Game Over"
        }

        assertEquals(
            expectedText,
            appContext.getString(R.string.game_over)
        )
    }
}