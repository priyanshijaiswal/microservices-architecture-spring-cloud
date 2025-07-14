package com.myproject.organization_service.mapper;

import com.myproject.organization_service.dto.OrganizationDto;
import com.myproject.organization_service.entity.Organization;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-14T19:17:47+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class OrganizationMapperImpl implements OrganizationMapper {

    @Override
    public OrganizationDto toOrganizationDto(Organization organization) {
        if ( organization == null ) {
            return null;
        }

        OrganizationDto organizationDto = new OrganizationDto();

        organizationDto.setId( organization.getId() );
        organizationDto.setOrganizationName( organization.getOrganizationName() );
        organizationDto.setOrganizationDescription( organization.getOrganizationDescription() );
        organizationDto.setOrganizationCode( organization.getOrganizationCode() );
        organizationDto.setCreatedDate( organization.getCreatedDate() );

        return organizationDto;
    }

    @Override
    public Organization toOrganization(OrganizationDto organizationDto) {
        if ( organizationDto == null ) {
            return null;
        }

        Organization organization = new Organization();

        organization.setId( organizationDto.getId() );
        organization.setOrganizationName( organizationDto.getOrganizationName() );
        organization.setOrganizationDescription( organizationDto.getOrganizationDescription() );
        organization.setOrganizationCode( organizationDto.getOrganizationCode() );
        organization.setCreatedDate( organizationDto.getCreatedDate() );

        return organization;
    }
}
