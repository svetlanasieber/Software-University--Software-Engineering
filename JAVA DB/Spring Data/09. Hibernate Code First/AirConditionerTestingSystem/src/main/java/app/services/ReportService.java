package app.services;

import app.domains.dtos.ReportDto;

public interface ReportService {

    void persist(ReportDto reportDto);
}
