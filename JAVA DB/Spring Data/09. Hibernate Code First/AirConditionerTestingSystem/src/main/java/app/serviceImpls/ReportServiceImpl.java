package app.serviceImpls;

import app.repositories.AirConditionerRepository;
import app.repositories.ReportRepository;
import app.domains.dtos.AirConditionerDto;
import app.domains.dtos.ReportDto;
import app.domains.entities.airConditioners.AbstractAirConditioner;
import app.domains.entities.reports.Report;
import app.parsers.ModelParser;
import app.services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportServiceImpl implements ReportService {

    private final ReportRepository reportRepository;

    private final AirConditionerRepository airConditionerRepository;

    private final ModelParser modelParser;

    @Autowired
    public ReportServiceImpl(ReportRepository reportRepository, ModelParser modelParser, AirConditionerRepository airConditionerRepository) {
        this.reportRepository = reportRepository;
        this.modelParser = modelParser;
        this.airConditionerRepository = airConditionerRepository;
    }

    @Override
    public void persist(ReportDto reportDto) {
        AirConditionerDto airConditionerDto = reportDto.getAirConditionerDto();
        AbstractAirConditioner byAllParameters =
                this.airConditionerRepository.findByManufacturerAndModel(airConditionerDto.getManufacturer(), airConditionerDto.getModel());

        Report convert = this.modelParser.convert(reportDto, Report.class);
        byAllParameters.setReport(convert);
        convert.setAbstractAirConditioner(byAllParameters);


        this.reportRepository.saveAndFlush(convert);
    }
}
