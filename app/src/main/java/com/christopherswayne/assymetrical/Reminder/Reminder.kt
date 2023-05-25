package com.christopherswayne.assymetrical.Reminder

import android.content.res.Configuration
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import com.christopherswayne.assymetrical.Components.ReminderTimePicker
import com.christopherswayne.assymetrical.ui.theme.AssymetricalTheme

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

data class Reminder(var isEnabled: Boolean, var text: String, var notifyTimeDate: LocalDateTime?)
//val gradientReminderColors = listOf(Companion.Blue, Companion.Magenta /*...*/)

@OptIn(ExperimentalTextApi::class)
@Composable
fun ReminderCard(reminder: Reminder) {
    val mutableSwitchState = remember{ mutableStateOf(reminder.isEnabled)}

    val mutableTimePicker = ReminderTimePicker()

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 1.dp),
        shape = MaterialTheme.shapes.large,
        shadowElevation = 1.dp,
        color = MaterialTheme.colorScheme.background,
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 6.dp)
        ) {
            Switch(
                interactionSource = MutableInteractionSource(),
                checked = mutableSwitchState.value,
                onCheckedChange = {mutableSwitchState.value = it},
                modifier = Modifier
                    .weight(.5f)
                    .align(Alignment.CenterVertically)
            )
            Text(
                text = reminder.text,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .padding(vertical = 12.dp)
                    .weight(1.5f)
                    .align(Alignment.CenterVertically),
                color = MaterialTheme.colorScheme.primary,

                )
            Spacer(modifier = Modifier.width(8.dp))
            if (reminder.notifyTimeDate != null){
                Surface(
                    shape = MaterialTheme.shapes.extraSmall,
                    shadowElevation = 1.dp,
                    color = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier
                        .padding(all = 8.dp)
                        .weight(1f)
                        .align(Alignment.CenterVertically),
                ) {
                    Text(
                        modifier = Modifier.padding(all = 4.dp),
                        text = reminder.notifyTimeDate!!.format(
                            DateTimeFormatter.ofLocalizedTime(
                                FormatStyle.MEDIUM
                            )
                        )
                    )
                }
            } else {
                FilledIconButton(
                    onClick = {
                        mutableTimePicker.show()
                    },
                    modifier = Modifier.align(Alignment.CenterVertically)
                ) {
                    Icon(Icons.Default.Notifications, contentDescription = "Time")
                }
            }
        }
    }
}

@Composable
fun ReminderCardList(reminders: List<Reminder>) {
    LazyColumn {
        items(reminders) { reminder ->
            ReminderCard(reminder = reminder)
        }
    }
}


@Preview
@Composable
fun PreviewReminder() {
    AssymetricalTheme {
        ReminderCard(
            Reminder(
                isEnabled = true, "Take out", notifyTimeDate = LocalDateTime.of(2023, 5, 20, 12, 55)
            )
        )
    }
}

@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun ReviewReminderListDark() {
    AssymetricalTheme {
        ReminderCardList(SampleReminders.remindersSample)
    }
}

@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    showBackground = true,
    name = "Light Mode"
)
@Composable
fun ReviewReminderList() {
    AssymetricalTheme {
        ReminderCardList(SampleReminders.remindersSample)
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