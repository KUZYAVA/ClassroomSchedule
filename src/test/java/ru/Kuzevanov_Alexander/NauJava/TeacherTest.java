package ru.Kuzevanov_Alexander.NauJava;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.Kuzevanov_Alexander.NauJava.data.model.ScheduleCell;
import ru.Kuzevanov_Alexander.NauJava.data.model.Teacher;
import ru.Kuzevanov_Alexander.NauJava.data.repositories.schedulecell.ScheduleCellRepository;
import ru.Kuzevanov_Alexander.NauJava.data.repositories.TeacherRepository;
import ru.Kuzevanov_Alexander.NauJava.domain.TeacherService;

import java.util.Optional;

@SpringBootTest
public class TeacherTest {

    private final TeacherService teacherService;
    private final TeacherRepository teacherRepository;
    private final ScheduleCellRepository scheduleCellRepository;

    @Autowired
    public TeacherTest(
            TeacherService teacherService,
            TeacherRepository teacherRepository,
            ScheduleCellRepository scheduleCellRepository
    ) {
        this.teacherService = teacherService;
        this.teacherRepository = teacherRepository;
        this.scheduleCellRepository = scheduleCellRepository;
    }

    @Test
    void testDeleteTeacher() {

        Teacher teacher = new Teacher();
        teacher.setId(1L);

        ScheduleCell scheduleCell = new ScheduleCell();
        scheduleCell.setId(1L);
        scheduleCell.setTeacher(teacher);

        teacherService.deleteTeacher(teacher.getId());

        Optional<Teacher> foundTeacher = teacherRepository.findById(teacher.getId());
        Assertions.assertTrue(foundTeacher.isEmpty());

        Optional<ScheduleCell> foundScheduleCell = scheduleCellRepository.findById(scheduleCell.getId());
        Assertions.assertTrue(foundScheduleCell.isEmpty());
    }
}
