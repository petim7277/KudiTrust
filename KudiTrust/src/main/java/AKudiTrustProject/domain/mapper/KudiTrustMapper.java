package AKudiTrustProject.domain.mapper;

import AKudiTrustProject.domain.models.AppUserDomainObject;
import AKudiTrustProject.infrastucture.adapters.input.rest.data.requests.SignUpRequest;
import org.keycloak.representations.idm.UserRepresentation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface KudiTrustMapper {
   AppUserDomainObject toSignUpRequest(SignUpRequest signUpRequest);

   UserRepresentation toUserRepresentation(SignUpRequest signUpRequest);
   SignUpRequest toSignUpRequest(UserRepresentation userRepresentation);
}
