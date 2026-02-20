package tests.api;

import api_clients.RestClient;
import api_models.petstoremodels.Pet;
import api_utils.AuthManager;
import api_utils.Endpoints;
import base.BaseAPITest;
import data_utils.CSVReaderUtil;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;

public class PetGetOperations extends BaseAPITest {


    @DataProvider(name = "petGetDataProvider")
    public Object[][] readFromCsv(){
        String filePath ="src/test/resources/testdata/PetGetOperations.csv";
        return CSVReaderUtil.readCsv(filePath);
    }

    @Test(dataProvider = "petGetDataProvider" )
    public void getOperations(Map<String,String> dataMap){
        int id =Integer.parseInt(dataMap.get("id"));
        Response response = RestClient.get(AuthManager.getAuthSpec(), Endpoints.GET_PET, id );
        if(response.getStatusCode()==200) {
        Pet pet = response.as(Pet.class);
        Assert.assertTrue(pet.getId() == id);
        System.out.println("id is"+ id + "name found is "+pet.getName());
        }else{
            System.out.println("There might be some issues response code is " + response.getStatusCode());
        }
    }

}
