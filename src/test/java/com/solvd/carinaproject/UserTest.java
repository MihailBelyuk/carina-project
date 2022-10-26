package com.solvd.carinaproject;

import com.qaprosoft.apitools.validation.JsonComparatorContext;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.solvd.carinaproject.old.GetUserMethodOld;
import org.testng.annotations.Test;

import java.util.Objects;


public class UserTest {



    @Test
    public void retrieveMyProfileDataOldMethodTest() {
        GetUserMethodOld getUserMethodOld = new GetUserMethodOld("MihailBelyuk");
        getUserMethodOld.expectResponseStatus(HttpResponseStatusType.OK_200);
        getUserMethodOld.callAPI();
        getUserMethodOld.validateResponseAgainstSchema("api/users/get/user-schema.json");
    }

    @Test
    public void retrieveMyProfileDataTest() {
        GetUserMethod getUserMethod = new GetUserMethod("MihailBelyuk");
        JsonComparatorContext jsonComparatorContext = JsonComparatorContext.context()
                .<Integer>withPredicate("countPredicate", Objects::nonNull);
        getUserMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getUserMethod.callAPI();
        getUserMethod.validateResponse(jsonComparatorContext);
    }
}
