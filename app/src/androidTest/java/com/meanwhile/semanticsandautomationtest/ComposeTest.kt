package com.meanwhile.semanticsandautomationtest

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.printToLog
import com.meanwhile.semanticsandautomationtest.ui.compose.VoucherItemWithClearSemantics
import com.meanwhile.semanticsandautomationtest.ui.compose.VoucherItemWithContentDescription
import com.meanwhile.semanticsandautomationtest.ui.theme.SemanticsAndAutomationTestTheme
import org.junit.Rule
import org.junit.Test

class ComposeTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    // use createAndroidComposeRule<YourActivity>() if you need access to
    // an activity

    @Test
    fun myTest() {
        // Start the app
        composeTestRule.setContent {
            SemanticsAndAutomationTestTheme {
                Row(modifier = Modifier
                    .semantics(mergeDescendants = false) {
                        testTag = "myRow"
                    }) {
                    Text("One")
                    Column {
                        Text("Two")
                        Text("Three")
                    }
                }
            }
        }

        println("---- HEYA ----")
        composeTestRule.onRoot().printToLog("HEYA")
    }

    @Test
    fun myTestClearSemanticsAtRoot() {
        // Start the app
        composeTestRule.setContent {
            SemanticsAndAutomationTestTheme {
                Row(modifier = Modifier.clearAndSetSemantics {
                    contentDescription = "myRowWithClearedSemantics"
                }) {
                    Text("One")
                    Column {
                        Text("Two")
                        Text("Three")
                    }
                }
            }
        }

        println("---- HEYA ----")
        composeTestRule.onRoot().printToLog("HEYA")
    }

    @Test
    fun myTestClearSemanticsAtRootAndTestTagsInChildren() {
        // Start the app
        composeTestRule.setContent {
            SemanticsAndAutomationTestTheme {
                Row(
                    modifier = Modifier.clearAndSetSemantics {
                        contentDescription = "myRowWithClearedSemantics"
                    }) {
                    Text(
                        modifier = Modifier.semantics {
                            testTag = "FirstText"
                            testTagsAsResourceId = true
                        },
                        text = "One"
                    )
                    Column {
                        Text(
                            modifier = Modifier.semantics {
                                testTag = "SecondText"
                            },
                            text = "Two"
                        )
                        Text(
                            modifier = Modifier.semantics {
                                testTag = "ThirdText"
                            },
                            text = "Three"
                        )
                    }
                }
            }
        }

        println("---- HEYA ----")
        composeTestRule.onRoot().printToLog("HEYA")
    }

    @Test
    fun myVoucherItemWithClearTest() {
        // Start the app
        composeTestRule.setContent {
            SemanticsAndAutomationTestTheme {
                VoucherItemWithClearSemantics()
            }
        }

        println("---- HEYA ----")
        composeTestRule.onRoot().printToLog("HEYA")
    }

    @Test
    fun myVoucherItemWithHideTest() {
        // Start the app
        composeTestRule.setContent {
            SemanticsAndAutomationTestTheme {
                VoucherItemWithContentDescription()
            }
        }

        println("---- HEYA ----")
        composeTestRule.onRoot().printToLog("HEYA")
    }
}

private fun Modifier.myCustomClearAndSetSemantics() {
    this.semantics {  }
}
