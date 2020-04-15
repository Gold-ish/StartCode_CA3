package rest;

import com.google.gson.Gson;
import dto.ICNDbDTO;
import dto.KanyeRestDTO;
import dto.OmdbApiDTO;
import dto.RandomCatDTO;
import dto.RandomDogDTO;
import java.io.IOException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import utils.HttpUtils;

/**
 * REST Web Service
 *
 * @author rando
 */
@Path("MasterFetcher")
public class MasterFetcherDemoResource {

    @Context
    private UriInfo context;

    @GET
    @Path("Joke")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJoke() throws IOException {
        Gson gson = new Gson();
        String icndb = HttpUtils.fetchData("http://api.icndb.com/jokes/random");
        ICNDbDTO icndbDTO = gson.fromJson(icndb, ICNDbDTO.class);
        return gson.toJson(icndbDTO);
    }
    
    @GET
    @Path("Movie")
    @Produces(MediaType.APPLICATION_JSON)
    public String getMovie() throws IOException {
        Gson gson = new Gson();
        String omdbAPI = HttpUtils.fetchData("http://www.omdbapi.com/?t=Game%20Of%20Thrones&Season1&apikey=6b10a5de");
        OmdbApiDTO omdbApiDTO = gson.fromJson(omdbAPI, OmdbApiDTO.class);
        return gson.toJson(omdbApiDTO);
    }
    
    @GET
    @Path("CatPic")
    @Produces(MediaType.APPLICATION_JSON)
    public String getCatPic() throws IOException {
        Gson gson = new Gson();
        String catAPI = HttpUtils.fetchData("https://aws.random.cat/meow");
        RandomCatDTO randomCatDTO = gson.fromJson(catAPI, RandomCatDTO.class);
        return gson.toJson(randomCatDTO);
    }
    
    @GET
    @Path("DogPic")
    @Produces(MediaType.APPLICATION_JSON)
    public String getDogPic() throws IOException {
        Gson gson = new Gson();
        String dogAPI = HttpUtils.fetchData("https://random.dog/woof.json");
        RandomDogDTO randomDogDTO = gson.fromJson(dogAPI, RandomDogDTO.class);
        return gson.toJson(randomDogDTO);
    }
    
    @GET
    @Path("KanyeRest")
    @Produces(MediaType.APPLICATION_JSON)
    public String getKanyeRest() throws IOException {
        Gson gson = new Gson();
        String kanyeRestAPI = HttpUtils.fetchData("https://api.kanye.rest/");
        KanyeRestDTO kanyeRestDTO = gson.fromJson(kanyeRestAPI, KanyeRestDTO.class);
        return gson.toJson(kanyeRestDTO);
    }
}
