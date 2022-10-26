package com.solvd.carinaproject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BranchTest {

    private String accept;
    private String token;
    private String owner;
    private String repo;
    private String branch;

    @BeforeClass
    public void initialize() {
        accept = "Accept=application/vnd.github+json";
        token = "Authorization=Bearer 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";
        owner = "MihailBelyuk";
        repo = "navigator";
        branch = "db-connectivity";
    }

    @Test
    public void retrieveBranchTest() {
        GetBranchMethod getBranchMethod = new GetBranchMethod(owner, repo, branch);
        getBranchMethod.setHeaders(accept,token);
        getBranchMethod.callAPI();
        getBranchMethod.validateResponse();
    }
}
