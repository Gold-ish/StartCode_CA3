package fetcher;

import com.google.gson.Gson;
import dto.ICNDbDTO;
import dto.KanyeRestDTO;
import dto.OmdbApiDTO;
import dto.RandomCatDTO;
import dto.RandomDogDTO;
import java.io.IOException;
import utils.HttpUtils;

/**
 *
 * @author rando
 */
public class MasterFetcher {

    public static void main(String[] args) throws IOException {
        Gson gson = new Gson();
        String icndb = HttpUtils.fetchData("http://api.icndb.com/jokes/random");
        ICNDbDTO icndbDTO = gson.fromJson(icndb, ICNDbDTO.class);
        System.out.println(icndbDTO);
        //Next Fetcher
        String omdbAPI = HttpUtils.fetchData("http://www.omdbapi.com/?t=Game%20Of%20Thrones&Season1&apikey=6b10a5de");
        OmdbApiDTO omdbApiDTO = gson.fromJson(omdbAPI, OmdbApiDTO.class);
        System.out.println(omdbApiDTO);
        //Next Fetcher
        String catAPI = HttpUtils.fetchData("https://aws.random.cat/meow");
        RandomCatDTO randomCatDTO = gson.fromJson(catAPI, RandomCatDTO.class);
        System.out.println(randomCatDTO);
        //Next Fetcher
        String dogAPI = HttpUtils.fetchData("https://random.dog/woof.json");
        RandomDogDTO randomDogDTO = gson.fromJson(dogAPI, RandomDogDTO.class);
        System.out.println(randomDogDTO);
        //Next Fetcher
        String kanyeRestAPI = HttpUtils.fetchData("https://api.kanye.rest/");
        KanyeRestDTO kanyeRestDTO = gson.fromJson(kanyeRestAPI, KanyeRestDTO.class);
        System.out.println(kanyeRestDTO);
    }
}
