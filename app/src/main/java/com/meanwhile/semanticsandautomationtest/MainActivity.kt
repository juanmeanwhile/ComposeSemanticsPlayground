package com.meanwhile.semanticsandautomationtest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.meanwhile.semanticsandautomationtest.ui.compose.VoucherItemWithClearSemantics
import com.meanwhile.semanticsandautomationtest.ui.compose.VoucherItemWithContentDescription
import com.meanwhile.semanticsandautomationtest.ui.compose.VoucherItemWithMergeNodes
import com.meanwhile.semanticsandautomationtest.ui.theme.SemanticsAndAutomationTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SemanticsAndAutomationTestTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding)) {
                        VoucherItemWithContentDescription()
                        VoucherItemWithClearSemantics()
                        VoucherItemWithMergeNodes()
                    }

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SemanticsAndAutomationTestTheme {
        Greeting("Android")
    }
}
