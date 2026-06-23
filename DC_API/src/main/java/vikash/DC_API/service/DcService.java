package vikash.DC_API.service;

import vikash.DC_API.binding.*;

import java.util.List;

public interface DcService {
    Long loadCaseNum(Integer appId);
    List<PlanDTO> getPlanNames();
    Long savePlanSelection(PlanSelection planSelection);
    Long saveIncomeData(Income income);
    Long saveEducationDate(Education education);
    Long saveChildrenData(ChildRequest request);
    DcSummary getSummary(Long caseNum);
}
