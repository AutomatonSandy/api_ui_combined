package tests.api;

import api_clients.RestClient;
import api_models.petstoremodels.Category;
import api_models.petstoremodels.Pet;
import api_models.petstoremodels.Status;
import api_models.petstoremodels.Tag;
import api_utils.AuthManager;
import api_utils.Endpoints;
import base.BaseAPITest;
import data_utils.CSVReaderUtil;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PetPostOperations extends BaseAPITest {

    List<String> photoUrlList = new ArrayList<>();
    List<Tag> tagList = new ArrayList<>();
    Pet pet;

    @Test(dataProvider = "pet_PostOpertions_Data")
    public void postANewPet(Map<String , String> dataMap){
        int id = Integer.parseInt(dataMap.get("id"));
        int categoryid = Integer.parseInt(dataMap.get("category_id"));
        String categoryName=dataMap.get("category_name");
        String name=dataMap.get("name");
        int tagid= Integer.parseInt(dataMap.get("tag_id"));
        String tagName=dataMap.get("tag_name");
        String photoUrl=dataMap.get("photoUrl");
        String statusValue=dataMap.get("status");

        Response response = RestClient.post(AuthManager.getAuthSpec(), Endpoints.POST_PET,createPostBody(id,categoryid,categoryName,name,tagid,tagName,
                photoUrl, Status.valueOf(statusValue)));
        response.prettyPrint();
        Assert.assertTrue(response.getStatusCode()==200);
        Assert.assertTrue(response.jsonPath().get("status").equals("available"));
        Assert.assertTrue(response.jsonPath().get("category.name").equals(categoryName));
    }

    @Test
    public void postANewPet_AutoBinding(){
        Pet bindingPet = RestClient.post(AuthManager.getAuthSpec(), Endpoints.POST_PET,createPostBody(12, 11, "Cat",
                "TestCatName_12",102, "Test Tag","test photo url", Status.available)).as(Pet.class);
        Assert.assertTrue(bindingPet.getCategory().getId()==11);
    }

    private Pet createPostBody(int petId, int categoryId, String categoryName, String petName, int tagId, String tagName, String photoUrlValue, Status statusValue) {
        Category category = new Category(categoryId,categoryName);
        Tag tag= new Tag(tagId, tagName);
        photoUrlList.add(photoUrlValue);
        tagList.add(tag);
        pet = new Pet(petId,
                category,
                petName,
                photoUrlList,
                tagList,
                statusValue);
        return pet;
    }

    @DataProvider(name="pet_PostOpertions_Data")
    public Object[][] getCSVData(){
        String filePath ="src/test/resources/testdata/pet_post.csv";
        return CSVReaderUtil.readCsv(filePath);

    }

}
