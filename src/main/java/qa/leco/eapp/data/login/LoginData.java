package qa.leco.eapp.data.login;

import com.univocity.parsers.annotations.Parsed;
import lombok.Getter;
import lombok.ToString;
import qa.leco.eapp.data.BaseData;

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
