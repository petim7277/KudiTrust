package AKudiTrustProject.domain.mapper;

import AKudiTrustProject.domain.models.AppUserDomainObject;
import AKudiTrustProject.infrastucture.adapters.input.rest.data.requests.SignUpRequest;
import AKudiTrustProject.infrastucture.adapters.output.persistence.entity.AppUserEntity;
import org.keycloak.representations.idm.UserRepresentation;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;


@Mapper(componentModel = "spring")
public interface KudiTrustMapper {
   AppUserEntity toSignUpRequest(SignUpRequest signUpRequest);

   UserRepresentation toUserRepresentation(SignUpRequest signUpRequest);
   SignUpRequest toSignUpRequest(UserRepresentation userRepresentation);
}
