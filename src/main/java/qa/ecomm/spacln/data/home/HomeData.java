package qa.ecomm.spacln.data.home;

import com.univocity.parsers.annotations.Parsed;
import lombok.Getter;
import lombok.ToString;
import qa.ecomm.spacln.data.BaseData;

@Getter
@ToString(callSuper = true)
public class HomeData extends BaseData {

    @Parsed(field = "Error Message", defaultNullRead = "")
    private String errorMessage;

    @Parsed(field = "Search Input", defaultNullRead = "")
    private String searchInput;

}
