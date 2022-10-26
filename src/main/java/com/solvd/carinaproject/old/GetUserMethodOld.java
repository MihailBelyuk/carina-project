package com.solvd.carinaproject.old;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class GetUserMethodOld extends AbstractApiMethodV2 {

    public GetUserMethodOld(String userName) {
        super(null, "api/users/get/my-profile-response.json");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("git_api_url"));
        replaceUrlPlaceholder("user_name", userName);
    }
}
