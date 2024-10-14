package ru.Kuzevanov_Alexander.NauJava.data.repositories.schedulecell;

import ru.Kuzevanov_Alexander.NauJava.data.model.ScheduleCell;

import java.sql.Timestamp;
import java.util.List;

public interface ScheduleCellRepositoryCustom {

    List<ScheduleCell> findByStartTime(Timestamp startTime);

    List<ScheduleCell> findByTeacher(String teacherFullName);
}
