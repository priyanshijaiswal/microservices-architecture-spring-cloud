package com.myproject.organization_service.service.impl;

import com.myproject.organization_service.OrganizationServiceApplication;
import com.myproject.organization_service.dto.OrganizationDto;
import com.myproject.organization_service.entity.Organization;
import com.myproject.organization_service.mapper.OrganizationMapper;
import com.myproject.organization_service.repository.OrganizationRepository;
import com.myproject.organization_service.service.OrganizationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;



@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

   OrganizationRepository organizationRepository;
   OrganizationMapper organizationMapper;

    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {
        Organization organization= organizationMapper.toOrganization(organizationDto);
        Organization savedOrganization=organizationRepository.save(organization);
        return organizationMapper.toOrganizationDto(savedOrganization);
    }

    @Override
    public OrganizationDto getOrganizationByCode(String organizationCode) {
        Organization organization=organizationRepository.findByOrganizationCode(organizationCode);
        return organizationMapper.toOrganizationDto(organization);
    }
}
