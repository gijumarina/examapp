package com.csie.examapp.visitor;

import com.csie.examapp.entities.TestEntity;
import com.csie.examapp.dto.ExamReportDto;

public interface ExamReportVisitor {
    ExamReportDto visit(TestEntity testEntity);
}
