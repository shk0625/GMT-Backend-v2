package com.pmn.gmt.domain.teacher.presentation.controller;

import com.pmn.gmt.domain.teacher.presentation.data.requestDto.FilterRequestDto;
import com.pmn.gmt.domain.teacher.presentation.data.responseDto.TeacherResponseDto;
import com.pmn.gmt.domain.teacher.service.FindAllTeacherService;
import com.pmn.gmt.domain.teacher.service.FindTeachersByFilterService;
import com.pmn.gmt.domain.teacher.service.FindTeachersByNameService;
import com.pmn.gmt.domain.teacher.util.TeacherConverter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/teachers")
@CrossOrigin(origins = {"https://gmt-pmn.shop", "https://gmt-pmn.store"})
public class TeacherController {

    private final FindAllTeacherService findAllTeacherService;
    private final TeacherConverter teacherConverter;
    private final FindTeachersByFilterService findTeachersByFilterService;

    private final FindTeachersByNameService findTeachersByNameService;

    public TeacherController(FindAllTeacherService findAllTeacherService, FindTeachersByFilterService findTeachersByFilterService, TeacherConverter teacherConverter, FindTeachersByNameService findTeachersByNameService) {
        this.findAllTeacherService = findAllTeacherService;
        this.teacherConverter = teacherConverter;
        this.findTeachersByFilterService =  findTeachersByFilterService;
        this.findTeachersByNameService = findTeachersByNameService;
    }

    @GetMapping("/filter")
    public ResponseEntity<List<TeacherResponseDto>> findTeachersByFilterService(FilterRequestDto filterRequestDto) {
        return ResponseEntity.ok(findTeachersByFilterService.execute(teacherConverter.toDto(filterRequestDto)).stream()
                .map(teacherConverter::toResponseDto)
                .collect(Collectors.toList()));
    }

    @GetMapping()
    public ResponseEntity<List<TeacherResponseDto>> findTeachersByNameService(@RequestParam("name") String name) {
        return ResponseEntity.ok(findTeachersByNameService.execute(teacherConverter.toDto(name)).stream()
                .map(teacherConverter::toResponseDto)
                .collect(Collectors.toList()));
    }


}
