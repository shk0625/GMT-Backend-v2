package com.pmn.gmt.domain.teacher.util;

import com.pmn.gmt.domain.teacher.presentation.data.dto.FilterDto;
import com.pmn.gmt.domain.teacher.presentation.data.dto.NameDto;
import com.pmn.gmt.domain.teacher.presentation.data.dto.TeacherDto;
import com.pmn.gmt.domain.teacher.presentation.data.requestDto.FilterRequestDto;
import com.pmn.gmt.domain.teacher.presentation.data.requestDto.NameRequestDto;
import com.pmn.gmt.domain.teacher.presentation.data.responseDto.TeacherResponseDto;
import com.pmn.gmt.domain.teacher.domain.entity.Teacher;

public interface TeacherConverter {
    TeacherDto toDto(Teacher teacher);
    NameDto toDto(String name);
    TeacherResponseDto toResponseDto(TeacherDto teacherDto);
    FilterDto toDto(FilterRequestDto filterRequestDto);
    NameDto toDto(NameRequestDto nameRequestDto);

}
