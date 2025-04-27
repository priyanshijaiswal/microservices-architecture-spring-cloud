package com.myproject.organization_service.service;

import com.myproject.organization_service.dto.OrganizationDto;

public interface OrganizationService {
    public OrganizationDto saveOrganization(OrganizationDto organizationDto);
    public  OrganizationDto getOrganizationByCode(String organizationCode);

}
