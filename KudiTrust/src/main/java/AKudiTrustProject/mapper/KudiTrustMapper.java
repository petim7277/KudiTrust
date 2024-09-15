package AKudiTrustProject.mapper;

import AKudiTrustProject.data.models.AppUser;
import AKudiTrustProject.dtos.requests.SignUpRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface KudiTrustMapper {
   AppUser toSignUpRequest(SignUpRequest signUpRequest);
}
