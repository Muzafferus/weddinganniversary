package com.muzafferus.weddinganniversary.presentation.screens.home

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import com.muzafferus.weddinganniversary.domain.model.CoupleData
import junit.framework.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class HomeScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun openCoupleItem_addFakeDataForWhite_assertBackgroundColor() {
        val fakeData = CoupleData("CoupleName", "123456798", "2022-07-10 18:00:25")
        composeTestRule.setContent {
            CoupleItem(fakeData)
        }

        composeTestRule.onNodeWithContentDescription("MainRow").assertBackgroundColor(Color.White)
    }

    @Test
    fun openCoupleItem_addFakeDataForGray_assertBackgroundColor() {
        val fakeData = CoupleData("CoupleName", "123456798", "2017-02-01 18:00:25")
        composeTestRule.setContent {
            CoupleItem(fakeData)
        }

        composeTestRule.onNodeWithContentDescription("MainRow").assertBackgroundColor(Color.Gray)
    }

    @Test
    fun openCoupleItem_addFakeDataForYellow_assertBackgroundColor() {
        val fakeData = CoupleData("CoupleName", "123456798", "2010-02-20 18:00:25")
        composeTestRule.setContent {
            CoupleItem(fakeData)
        }

        composeTestRule.onNodeWithContentDescription("MainRow").assertBackgroundColor(Color.Yellow)
    }


    @Test
    fun openCoupleItem_addFakeDataForNote_assertIsVisible(){
        //NoteColumn
        val fakeData = CoupleData("CoupleName", "123456798", "2019-03-02 18:00:25")
        composeTestRule.setContent {
            CoupleItem(fakeData)
        }

        composeTestRule.onNodeWithContentDescription("NoteColumn").assertIsDisplayed()
    }

    @Test
    fun openCoupleItem_addFakeDataForNote_assertDoesNotExist(){
        //NoteColumn
        val fakeData = CoupleData("CoupleName", "123456798", "2010-02-20 18:00:25")
        composeTestRule.setContent {
            CoupleItem(fakeData)
        }

        composeTestRule.onNodeWithContentDescription("NoteColumn").assertDoesNotExist()
    }
}

fun SemanticsNodeInteraction.assertBackgroundColor(expectedBackground: Color) {
    val capturedName = captureToImage().colorSpace.name
    assertEquals(expectedBackground.colorSpace.name, capturedName)
}