package vikash.DC_API.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import vikash.DC_API.binding.*;
import vikash.DC_API.entity.*;
import vikash.DC_API.repository.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DcServiceImpl implements DcService {

    private final PlanRepository planRepo;
    private final DcCaseRepository dcCaseRepo;
    private final CitizenAppRepository citizenAppRepo;
    private final DcIncomeRepository dcIncomeRepo;
    private final DcChildrenRepository dcChildrenRepo;
    private final DcEducationRepository dcEducationRepo;

    @Override
    public Long loadCaseNum(Integer appId) {
        Optional<CitizenAppsEntity> appEntity = citizenAppRepo.findById(appId);
        if (appEntity.isPresent()) {
            DcCaseEntity dcCase = new DcCaseEntity();
            dcCase.setAppId(appId);
            DcCaseEntity savedCase = dcCaseRepo.save(dcCase);
            return savedCase.getCaseNum();
        }
        return 0L;
    }

    @Override
    public List<PlanDTO> getPlanNames() {
        List<PlanDTO> allPlan = planRepo.getAllPlanNames();
        return allPlan;
    }

    @Override
    public Long savePlanSelection(PlanSelection planSelection) {
        Optional<DcCaseEntity> opCaseEntity = dcCaseRepo.findById(planSelection.getCaseNum());
        if (opCaseEntity.isPresent()) {
            DcCaseEntity caseEntity = opCaseEntity.get();
            caseEntity.setPlanId(planSelection.getPlanId());
            DcCaseEntity savedCase = dcCaseRepo.save(caseEntity);
            return savedCase.getCaseNum();
        }
        return null;
    }

    @Override
    public Long saveIncomeData(Income income) {
        DcIncomeEntity incomeEntity = new DcIncomeEntity();
        BeanUtils.copyProperties(income, incomeEntity);
        DcIncomeEntity savedIncome = dcIncomeRepo.save(incomeEntity);
        return savedIncome.getCaseNum();
    }

    @Override
    public Long saveEducationDate(Education education) {
        DcEducationEntity educationEntity = new DcEducationEntity();
        BeanUtils.copyProperties(education, educationEntity);
        DcEducationEntity savedEducation = dcEducationRepo.save(educationEntity);
        return savedEducation.getCaseNum();
    }

    @Override
    public Long saveChildrenData(ChildRequest request) {
        List<Child> children = request.getChildren();
        Long caseNum = request.getCaseNum();
        if (children == null || children.isEmpty()) {
            return null;
        }
        List<DcChildrenEntity> entities = new ArrayList<>();
        for (Child child: children) {
            DcChildrenEntity childrenEntity = new DcChildrenEntity();
            BeanUtils.copyProperties(child, childrenEntity);
            childrenEntity.setCaseNum(caseNum);
            entities.add(childrenEntity);
        }
        dcChildrenRepo.saveAll(entities);
        return caseNum;
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
