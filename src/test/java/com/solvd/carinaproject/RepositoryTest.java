package com.solvd.carinaproject;

import com.qaprosoft.apitools.validation.JsonComparatorContext;
import com.solvd.carinaproject.old.PostRepositoryMethodOld;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Objects;

public class RepositoryTest {

    private String accept;
    private String token;

    @BeforeClass
    public void initialize() {
        accept = "Accept=application/vnd.github+json";
        token = "Authorization=Bearer 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";
    }

    @Test
    public void createRepositoryTest() {
        PostRepositoryMethod postRepositoryMethod = new PostRepositoryMethod();
        JsonComparatorContext jsonComparatorContext = JsonComparatorContext.context()
                .<String>withPredicate("createdAtPredicate", Objects::nonNull)
                .<Integer>withPredicate("idPredicate", id -> id > 0)
                .<String>withPredicate("nodeIdPredicate", Objects::nonNull)
                .<String>withPredicate("pushedAtPredicate", Objects::nonNull)
                .<Integer>withPredicate("subscribersCountPredicate", Objects::nonNull)
                .<String>withPredicate("updatedAtPredicate", Objects::nonNull);
        postRepositoryMethod.setHeaders(accept, token);
        postRepositoryMethod.addProperty("name", "Hello-Space2");
        postRepositoryMethod.addProperty("description", "Long-long ago, in the far-far galaxy...");
        postRepositoryMethod.callAPI();
        postRepositoryMethod.validateResponse(jsonComparatorContext);
    }

    @Test
    public void changeRepoDataTest() {
        String owner = "MihailBelyuk";
        String repo = "Hello-World-patched";
        PatchRepositoryMethod patchRepositoryMethod = new PatchRepositoryMethod(owner, repo);
        JsonComparatorContext jsonComparatorContext = JsonComparatorContext.context()
                .<String>withPredicate("createdAtPredicate", Objects::nonNull)
                .<Integer>withPredicate("idPredicate", id -> id > 0)
                .<String>withPredicate("nodeIdPredicate", Objects::nonNull)
                .<String>withPredicate("pushedAtPredicate", Objects::nonNull)
                .<Integer>withPredicate("subscribersCountPredicate", Objects::nonNull)
                .<String>withPredicate("updatedAtPredicate", Objects::nonNull)
                .<String>withPredicate("descriptionPredicate", descr -> descr != null && descr.length() > 5)
                .<Boolean>withPredicate("privatePredicate", pr -> pr != null && pr)
                .<String>withPredicate("visibilityPredicate", Objects::nonNull);
        patchRepositoryMethod.setHeaders(accept, token);
        patchRepositoryMethod.addProperty("name", "Hello-World-patched1");
        patchRepositoryMethod.addProperty("description", "Patched name and description");
        patchRepositoryMethod.callAPI();
        patchRepositoryMethod.validateResponse(jsonComparatorContext);
    }

    @Test
    public void createRepositoryOldMethodTest() {
        PostRepositoryMethodOld postRepositoryMethodOld = new PostRepositoryMethodOld();
        JsonComparatorContext jsonComparatorContext = JsonComparatorContext.context()
                .<String>withPredicate("createdAtPredicate", Objects::nonNull)
                .<Integer>withPredicate("idPredicate", id -> id > 0)
                .<String>withPredicate("nodeIdPredicate", Objects::nonNull)
                .<String>withPredicate("pushedAtPredicate", Objects::nonNull)
                .<Integer>withPredicate("subscribersCountPredicate", Objects::nonNull)
                .<String>withPredicate("updatedAtPredicate", Objects::nonNull);
        postRepositoryMethodOld.setHeaders(accept, token);
        postRepositoryMethodOld.addProperty("name", "Hello-World");
        postRepositoryMethodOld.addProperty("description", "Long-long ago, in the far-far galaxy...");
        postRepositoryMethodOld.callAPI();
        postRepositoryMethodOld.validateResponse(jsonComparatorContext);
    }
}
