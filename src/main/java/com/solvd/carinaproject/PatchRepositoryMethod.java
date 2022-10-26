package com.solvd.carinaproject;


import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.RequestTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;

@Endpoint(url = "${config.env.git_api_url}/repos/${owner}/${repo}", methodType = HttpMethodType.PATCH)
@RequestTemplatePath(path = "api/repositories/patch/rq.json")
@ResponseTemplatePath(path = "api/repositories/patch/repository-rs.json")
public class PatchRepositoryMethod extends AbstractApiMethodV2 {

    public PatchRepositoryMethod(String owner, String repo) {
        replaceUrlPlaceholder("owner", owner);
        replaceUrlPlaceholder("repo", repo);
    }
}
