package qa.ecomm.spacln.data.login;

import com.univocity.parsers.annotations.Parsed;
import lombok.Getter;
import lombok.ToString;
import qa.ecomm.spacln.data.BaseData;

@Getter
@ToString(callSuper = true)
public class RegData extends BaseData {

    //,Last name,Phone ,Username ,Email address,Password,Is Subscribe,Error Message
    @Parsed(field = "First name", defaultNullRead = "")
    private String firstName;


    @Parsed(field = "Last name", defaultNullRead = "")
    private String lastName;

    @Parsed(field = "Phone", defaultNullRead = "")
    private String phone;

    @Parsed(field = "Username", defaultNullRead = "")
    private String userName;

    @Parsed(field = "Email address", defaultNullRead = "")
    private String emailAddress;

    @Parsed(field = "Password", defaultNullRead = "")
    private String password;

    @Parsed(field = "Is Subscribe", defaultNullRead = "")
    private String isSubscribe;

    @Parsed(field = "Error Message", defaultNullRead = "")
    private String errorMessage;
}
