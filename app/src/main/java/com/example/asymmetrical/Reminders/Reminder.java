package com.example.asymmetrical.Reminders;

import java.time.LocalDateTime;

public class Reminder {
    private String reminderText;
    private LocalDateTime reminderTime;

    public Reminder(){
        reminderTime = null;
        reminderText = null;
    }
    public Reminder(String reminder, LocalDateTime time){
        reminderText = reminder;
        reminderTime = time;
    }

    public String getReminderText() {
        return reminderText;
    }

    public LocalDateTime getReminderTime(){
        return reminderTime;
    }

    public void setReminderText(String reminderText) {
        this.reminderText = reminderText;
    }
    public void setReminderTime(LocalDateTime time) {
        reminderTime = time;
    }
}
