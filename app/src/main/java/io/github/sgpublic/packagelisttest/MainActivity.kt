package io.github.sgpublic.packagelisttest

import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import io.github.sgpublic.packagelisttest.ui.theme.PackageListTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PackageListTestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val activityList = remember {
                        packageManager.getInstalledPackages(
                            PackageManager.GET_ACTIVITIES or PackageManager.GET_META_DATA
                        )
                    }
                    LazyColumn {
                        items(activityList) {
                            Text(text = it.packageName)
                        }
                    }
                }
            }
        }
    }
}