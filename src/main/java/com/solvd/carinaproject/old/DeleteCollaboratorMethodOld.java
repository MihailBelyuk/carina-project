package com.solvd.carinaproject.old;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class DeleteCollaboratorMethodOld extends AbstractApiMethodV2 {

    public DeleteCollaboratorMethodOld(String owner, String repo, String userName) {
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("git_api_url"));
        replaceUrlPlaceholder("owner", owner);
        replaceUrlPlaceholder("repo", repo);
        replaceUrlPlaceholder("username", userName);
    }
}
