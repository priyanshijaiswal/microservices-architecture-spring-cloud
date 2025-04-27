package com.myproject.organization_service.mapper;

import com.myproject.organization_service.dto.OrganizationDto;
import com.myproject.organization_service.entity.Organization;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrganizationMapper {
    OrganizationDto toOrganizationDto(Organization organization);
    Organization toOrganization(OrganizationDto organizationDto);
}
