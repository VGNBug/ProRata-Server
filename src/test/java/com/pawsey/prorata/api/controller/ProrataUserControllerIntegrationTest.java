package com.pawsey.prorata.api.controller;

import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.pawsey.api.rest.controller.BaseControllerIntegrationTest;
import com.pawsey.prorata.api.ProRataApiApplication;
import com.pawsey.prorata.model.ProrataUserEntity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.persistence.EntityNotFoundException;


import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ProRataApiApplication.class)
@WebAppConfiguration
public class ProrataUserControllerIntegrationTest extends BaseControllerIntegrationTest {

    private final String SAD_PATH_EMAIL = "sadPathEmail@test.com";
    private final String SAD_PATH_PASSWORD = "sadPathPassword";

    private ProrataUserEntity expected;

    @Before
    private void setup() {
        expected = new ProrataUserEntity();
        expected.setEmail("bob@test.com");
        expected.setPassword("password");
    }

    /*
    POST: Happy path
     */
    @Test
    public void testCreate() {
        ProrataUserEntity response = requestCreateProrataUserEntity(expected);

        assertNotNull(response);
        assertEquals(expected.getEmail(), response.getEmail());
        assertEquals(expected.getPassword(), response.getPassword());
    }

    /*
    POST: Sad paths
    */
    @Test(expected = Exception.class)
    public void testCreate_NoDataShouldFail() {
        ProrataUserEntity response = requestCreateProrataUserEntity(null);

        assertNull(response);
    }

    @Test(expected = UnrecognizedPropertyException.class)
    public void testCreate_MalformattedDataShouldFail() {
        MalformedProrataUserEntity malformed = makeMalformedProrataUserEntity();

        ProrataUserEntity response = this.requestCreateProrataUserEntity(malformed);

        assertNull(response);
    }

    /*
     GET: Happy path
     */
    @Test
    public void testRead() {
        ProrataUserEntity response = requestGetProrataUserEntity(expected.getEmail(), expected.getPassword());

        assertNotNull(response);
        assertEquals(response.getEmail(), expected.getEmail());
        assertEquals(response.getPassword(), expected.getPassword());
    }

    /*
    GET: Sad paths
     */
    @Test(expected = EntityNotFoundException.class)
    public void testRead_FailsWithWrongEmailRightPassword() {
        ProrataUserEntity response = requestGetProrataUserEntity(SAD_PATH_EMAIL, expected.getPassword());

        assertNull(response);
    }

    @Test(expected = EntityNotFoundException.class)
    public void testRead_FailsWithRightEmailWrongPassword() {
        ProrataUserEntity response = requestGetProrataUserEntity(expected.getEmail(), SAD_PATH_PASSWORD);

        assertNull(response);
    }

    @Test(expected = EntityNotFoundException.class)
    public void testRead_FailsWithWrongEmailWrongPassword() {
        ProrataUserEntity response = requestGetProrataUserEntity(SAD_PATH_EMAIL, SAD_PATH_PASSWORD);
    }

    private ProrataUserEntity requestCreateProrataUserEntity(ProrataUserEntity entity) {
        Map<String, String> vars = new HashMap<String, String>();
        vars.put("prorata_user_id", entity.getProrataUserId().toString());
        vars.put("email", entity.getEmail());
        vars.put("password", entity.getPassword());

        final String createUrl = API_URL + "/user";
        ProrataUserEntity response = restTemplate.postForObject(createUrl, entity, ProrataUserEntity.class, vars);
        LOGGER.info("POST of a ProrataUserEntity made at " + createUrl);
        return response;
    }

    private ProrataUserEntity requestCreateProrataUserEntity(MalformedProrataUserEntity entity) {
        Map<String, String> vars = new HashMap<String, String>();
        vars.put("prorata_user_id", entity.getBadId().toString());
        vars.put("email", entity.getBadEmail());
        vars.put("password", entity.getBadPassword());

        final String createUrl = API_URL + "/user";
        ProrataUserEntity response = restTemplate.postForObject(createUrl, entity, ProrataUserEntity.class, vars);
        LOGGER.info("POST of a ProrataUserEntity made at " + createUrl);
        return response;
    }

    private ProrataUserEntity requestGetProrataUserEntity(String email, String password) {
        final String signInUrl = API_URL + "/user/" + email + "/" + password;
        ProrataUserEntity response = restTemplate.getForObject(signInUrl, ProrataUserEntity.class);
        LOGGER.info("GET for a ProrataUserEntity made at " + signInUrl);
        return response;
    }

    private MalformedProrataUserEntity makeMalformedProrataUserEntity() {
        MalformedProrataUserEntity malformed = new MalformedProrataUserEntity();
        malformed.setBadId(1);
        malformed.setBadEmail("bob@test.com");
        malformed.setBadPassword("password");
        return malformed;
    }

    private class MalformedProrataUserEntity {

        private Integer badId;
        private String badEmail;
        private String badPassword;

        public Integer getBadId() {
            return badId;
        }

        public void setBadId(Integer badId) {
            this.badId = badId;
        }

        public String getBadPassword() {
            return badPassword;
        }

        public void setBadPassword(String badPassword) {
            this.badPassword = badPassword;
        }

        public String getBadEmail() {
            return badEmail;
        }

        public void setBadEmail(String badEmail) {
            this.badEmail = badEmail;
        }

    }

}
