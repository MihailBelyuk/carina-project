package com.solvd.carinaproject;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;

@Endpoint(url = "${config.env.git_api_url}/users/${user}", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/users/get/my-profile-response.json")
public class GetUserMethod extends AbstractApiMethodV2 {

    public GetUserMethod(String userName) {
        replaceUrlPlaceholder("user", userName);
    }
}
