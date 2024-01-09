package com.csie.examapp.visitor;

import com.csie.examapp.dto.ExamReportDto;

public interface ExamVisitable {
    ExamReportDto accept(ExamReportVisitor visitor);
}
