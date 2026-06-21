package vikash.DC_API.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import vikash.DC_API.binding.*;
import vikash.DC_API.entity.DcCaseEntity;
import vikash.DC_API.entity.DcChildrenEntity;
import vikash.DC_API.entity.DcEducationEntity;
import vikash.DC_API.entity.DcIncomeEntity;
import vikash.DC_API.repository.*;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DcServiceImpl implements DcService {

    private final PlanRepository planRepo;
    private final DcCaseRepository dcCaseRepo;
    private final DcIncomeRepository dcIncomeRepo;
    private final DcChildrenRepository dcChildrenRepo;
    private final DcEducationRepository dcEducationRepo;

    @Override
    public Long loadCaseNum(Integer appId) {
        DcCaseEntity foundDcCase = dcCaseRepo.findByAppId(appId);
        if (foundDcCase != null) {
            return foundDcCase.getCaseNum();
        }
        return null;
    }

    @Override
    public List<String> getPlanNames() {
        List<String> allPlanNames = planRepo.getAllPlanNames();
        return allPlanNames;
    }

    @Override
    public Long savePlanSelection(PlanSelection planSelection) {
        // Not Developed yet
        return 0L;
    }

    @Override
    public Long saveIncomeData(Income income) {
        DcIncomeEntity incomeEntity = new DcIncomeEntity();
        BeanUtils.copyProperties(income, incomeEntity);
        DcIncomeEntity savedIncome = dcIncomeRepo.save(incomeEntity);
        return 0L;
    }

    @Override
    public Long saveEducationDate(Education education) {
        // Not Developed yet
        return 0L;
    }

    @Override
    public Long saveChildrenData(Child child) {
        // Not Developed yet
        return 0L;
    }

    @Override
    public DcSummary getSummary(Long caseNum) {
        DcSummary dcSummary = new DcSummary();

        dcIncomeRepo.findByCaseNum(caseNum)
                .ifPresent(entity ->
                        dcSummary.setIncome(convertToIncomeDTO(entity)));

        dcEducationRepo.findByCaseNum(caseNum)
                .ifPresent(entity ->
                        dcSummary.setEducation(convertToEducationDTO(entity)));

        List<Child> childList = dcChildrenRepo.findByCaseNum(caseNum)
                .stream()
                .map(this::convertToChildDTO).toList();
        dcSummary.setChildren(childList);

        planRepo.getPlanName(caseNum).ifPresent(plan ->
                dcSummary.setPlanName(plan));

        return dcSummary;
    }

    private Child convertToChildDTO(DcChildrenEntity childEntity) {
        Child child = new Child();
        BeanUtils.copyProperties(childEntity, child);
        return child;
    }

    private Income convertToIncomeDTO(DcIncomeEntity incomeEntity) {
        Income income = new Income();
        BeanUtils.copyProperties(incomeEntity, income);
        return income;
    }

    private Education convertToEducationDTO(DcEducationEntity educationEntity) {
        Education education = new Education();
        BeanUtils.copyProperties(educationEntity, education);
        return education;
    }
}
