package com.solvd.carinaproject;

import com.qaprosoft.apitools.validation.JsonComparatorContext;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.solvd.carinaproject.old.DeleteCollaboratorMethodOld;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Objects;

public class CollaboratorTest {

    private String accept;
    private String token;
    private String owner;
    private String repo;
    private String userName;

    @BeforeClass
    public void initialize() {
        accept = "Accept=application/vnd.github+json";
        token = "Authorization=Bearer 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";
        owner = "MihailBelyuk";
        repo = "navigator";
        userName = "dbunkevich";
    }

    @Test
    public void sendInvitationToCollaborator() {
        PutCollaboratorMethod putCollaboratorMethod = new PutCollaboratorMethod(owner, repo, userName);
        putCollaboratorMethod.setHeaders(accept,token);
        JsonComparatorContext jsonComparatorContext = JsonComparatorContext.context()
                .<String>withPredicate("nodeIdPredicate", Objects::nonNull)
                .<String>withPredicate("createdAtPredicate", Objects::nonNull)
                .<Integer>withPredicate("idPredicate", Objects::nonNull)
                .<String>withPredicate("urlPredicate", Objects::nonNull);
        putCollaboratorMethod.callAPI();
        putCollaboratorMethod.validateResponse(jsonComparatorContext);
    }

    @Test
    public void deleteCollaboratorTest() {
        DeleteCollaboratorMethodOld deleteCollaboratorMethodOld = new DeleteCollaboratorMethodOld(owner, repo, userName);
        deleteCollaboratorMethodOld.setHeaders(accept,token);
        deleteCollaboratorMethodOld.expectResponseStatus(HttpResponseStatusType.NO_CONTENT_204);
        deleteCollaboratorMethodOld.callAPI();
    }
}
