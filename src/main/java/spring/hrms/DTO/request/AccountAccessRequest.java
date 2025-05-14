package spring.hrms.DTO.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountAccessRequest {
    private String employeeId;
    private String emailAddress;
    private String skypeId;
    private String slackId;
    private String gitHubId;

}
