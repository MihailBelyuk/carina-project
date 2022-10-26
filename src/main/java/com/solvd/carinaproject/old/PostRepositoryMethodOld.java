package com.solvd.carinaproject.old;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class PostRepositoryMethodOld extends AbstractApiMethodV2 {

    public PostRepositoryMethodOld() {
        super("api/repositories/post/repository-rq.json", "api/repositories/post/repository-rs.json");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("git_api_url"));
    }
}
