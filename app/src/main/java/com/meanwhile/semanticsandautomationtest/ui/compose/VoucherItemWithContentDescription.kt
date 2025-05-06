package com.meanwhile.semanticsandautomationtest.ui.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.hideFromAccessibility
import androidx.compose.ui.semantics.invisibleToUser
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.unit.dp

@Composable
fun VoucherItemWithContentDescription(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(32.dp)
            .background(color = Color.LightGray)
            .padding(12.dp)
            .semantics {
                contentDescription = "Header and description"
            },
    ) {
        Text(
            modifier = modifier.semantics {
                hideFromAccessibility()
            },
            text = "Header"
        )

        Text(
            modifier = modifier
                .semantics {
                    hideFromAccessibility()
                },
            text = "Description"
        )
    }
}

@Composable
fun VoucherItemWithClearSemantics(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(32.dp)
            .background(color = Color.LightGray)
            .padding(12.dp)
            .clearAndSetSemantics {
                contentDescription = "Header and description"
            },
    ) {
        Text(
            modifier = modifier.semantics {
                testTag = "Headertag"
            },
            text = "Header"
        )

        Text(
            modifier = modifier.semantics {
                testTag = "DescriptionTag"
            },
            text = "Description"
        )
    }
}

@Composable
fun VoucherItemWithMergeNodes(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(32.dp)
            .background(color = Color.LightGray)
            .padding(12.dp)
            .semantics(mergeDescendants = true){
            }
    ) {
        Text(
            modifier = modifier.semantics {
                testTag = "Headertag"
            },
            text = "Header"
        )

        Text(
            modifier = modifier.semantics {
                testTag = "DescriptionTag"
            },
            text = "Description"
        )
    }
}
