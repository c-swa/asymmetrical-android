package com.christopherswayne.assymetrical

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.christopherswayne.assymetrical.Reminder.Reminder
import com.christopherswayne.assymetrical.ui.theme.AssymetricalTheme
import com.christopherswayne.assymetrical.Reminder.ReminderCardList
import java.time.LocalDateTime

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AssymetricalTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ReminderPage(reminders = SampleReminders.remindersSample)
                }
            }
        }
    }
}

@Composable
fun ReminderPage(reminders: List<Reminder>,modifier: Modifier = Modifier){
    Surface(
        modifier = modifier.fillMaxHeight(),
        color = MaterialTheme.colorScheme.inversePrimary
    ) {
        ReminderCardList(reminders = reminders)
    }
}

@Preview(showBackground = true)
@Composable
fun ReminderPagePreview() {
    AssymetricalTheme {
        ReminderPage(SampleReminders.remindersSample)
    }
}

@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun ReminderPagePreviewDark() {
    AssymetricalTheme {
        ReminderPage(SampleReminders.remindersSample)
    }
}

object SampleReminders {
    val remindersSample = listOf(
        Reminder(
            false, "Test", LocalDateTime.of(2023, 5, 20, 2, 57)
        ), Reminder(
            true, "Test enabled", LocalDateTime.of(2023, 6, 23, 2, 56)
        ), Reminder(
            true,
            "Really really long text to see how long it would take to overflow",
            LocalDateTime.of(2023, 6, 23, 3, 50)
        ), Reminder(
            true,
            "Really really long text to see how long it would take to overflow, but no time",
            null
        )
    )
}