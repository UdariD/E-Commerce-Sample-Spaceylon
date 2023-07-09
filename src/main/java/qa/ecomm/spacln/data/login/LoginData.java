package qa.ecomm.spacln.data.login;

import com.univocity.parsers.annotations.Parsed;
import lombok.Getter;
import lombok.ToString;
import qa.ecomm.spacln.data.BaseData;

/*
This class captures all the test data properties required for the login page.
 */

@Getter
@ToString(callSuper = true)
public class LoginData extends BaseData {
    @Parsed(field = "User Name", defaultNullRead = "")
    private String userName;

    @Parsed(field = "Password", defaultNullRead = "")
    private String password;

    @Parsed(field = "Error Message", defaultNullRead = "")
    private String errorMessage;
}
