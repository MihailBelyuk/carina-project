package com.solvd.carinaproject;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.RequestTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;

@Endpoint(url = "${config.env.git_api_url}/user/repos", methodType = HttpMethodType.POST)
@RequestTemplatePath(path = "api/repositories/post/repository-rq.json")
@ResponseTemplatePath(path = "api/repositories/post/repository-rs.json")
public class PostRepositoryMethod extends AbstractApiMethodV2 {
}
