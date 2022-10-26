package com.solvd.carinaproject;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.RequestTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;

@Endpoint(url = "${config.env.git_api_url}/repos/${owner}/${repo}/collaborators/${username}", methodType = HttpMethodType.PUT)
@ResponseTemplatePath(path = "api/collaborators.put/invitation-rs.json")
@RequestTemplatePath(path = "api/collaborators.put/invitation-rq.json")

public class PutCollaboratorMethod extends AbstractApiMethodV2 {

    public PutCollaboratorMethod(String owner, String repo, String userName) {
        replaceUrlPlaceholder("owner", owner);
        replaceUrlPlaceholder("repo", repo);
        replaceUrlPlaceholder("username", userName);
    }
}

