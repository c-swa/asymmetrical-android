package com.christopherswayne.assymetrical.Reminder

import androidx.compose.animation.animateContentSize
import androidx.compose.runtime.Composable

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.christopherswayne.assymetrical.ui.theme.AssymetricalTheme
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class Reminder(var text: String, var notifyTimeDate: LocalDateTime)

@Composable
fun ReminderCard(reminder: Reminder) {
    Surface(
        shape = MaterialTheme.shapes.large,
        shadowElevation = 1.dp,
        color = MaterialTheme.colorScheme.background,
    ) {
        Row(modifier = Modifier.padding(all = 8.dp)) {
            Text(
                text = reminder.text,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.width(8.dp))
            Surface(
                shape = MaterialTheme.shapes.small,
                shadowElevation = 1.dp,
                color = MaterialTheme.colorScheme.secondary,
            ) {
                Text(
                    text = reminder.notifyTimeDate.toString()
                )
            }
        }
    }
}


@Preview
@Composable
fun PreviewReminder() {
    AssymetricalTheme {
        ReminderCard(Reminder("reminder", notifyTimeDate = LocalDateTime.of(2023,5,20,12,55)))
    }
}