package com.solvd.carinaproject;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;

@Endpoint(url = "${config.env.git_api_url}/repos/${owner}/${repo}/branches/${branch}", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/branches.get/branch-rs.json")
public class GetBranchMethod extends AbstractApiMethodV2 {

    public GetBranchMethod(String owner, String repo, String branch) {
        replaceUrlPlaceholder("owner", owner);
        replaceUrlPlaceholder("repo", repo);
        replaceUrlPlaceholder("branch", branch);
    }
}
