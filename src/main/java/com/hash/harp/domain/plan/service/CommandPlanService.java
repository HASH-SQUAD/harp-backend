package com.hash.harp.domain.plan.service;

import com.hash.harp.domain.plan.controller.dto.request.DetailRequestDto;
import com.hash.harp.domain.plan.controller.dto.request.HeaderRequestDto;
import com.hash.harp.domain.plan.controller.dto.request.PlanRequestDto;
import com.hash.harp.domain.plan.domain.Detail;
import com.hash.harp.domain.plan.domain.Header;
import com.hash.harp.domain.plan.repository.DetailRepository;
import com.hash.harp.domain.plan.repository.HeaderRepository;
import com.hash.harp.domain.plan.service.implementation.PlanCreator;
import com.hash.harp.domain.plan.service.implementation.PlanUpdater;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CommandPlanService {

    private final PlanCreator planCreator;

    private final PlanUpdater planUpdater;

    private final HeaderRepository headerRepository;

    private final DetailRepository detailRepository;

    public void createPlanHeader(HeaderRequestDto headerRequestDto) {
        Header header = Header.builder()
                .title(headerRequestDto.title())
                .d_day(headerRequestDto.d_day())
                .startDay(headerRequestDto.startDate())
                .endDay(headerRequestDto.endDate())
                .duration(headerRequestDto.duration())
                .build();

        headerRepository.save(header);
    }

    public void creatPlan(PlanRequestDto planRequestDto) {
        planCreator.createPlan(planRequestDto);
    }

    public void createDetail(DetailRequestDto detailRequestDto) {
        planCreator.createDetail(detailRequestDto);
    }

    public void updateDetail(DetailRequestDto detailRequestDto, Long id) {
        planUpdater.update(detailRequestDto, id);
    }
}