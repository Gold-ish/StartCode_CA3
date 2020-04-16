package fetcher;

import com.google.gson.Gson;
import dto.ICNDbDTO;
import java.io.IOException;
import utils.HttpUtils;

/**
 *
 * @author rando
 */
public class ICNDbFetcher implements FetcherInterface{
    private String url;
    private ICNDbDTO icndbDTO;

    public ICNDbFetcher(String url) {
        this.url = url;
    }
    
    @Override
    public void doWork() throws IOException {
        Gson gson = new Gson();
        String icndb = HttpUtils.fetchData(url);
        icndbDTO = gson.fromJson(icndb, ICNDbDTO.class);
        //System.out.println(icndbDTO);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ICNDbDTO getIcndbDTO() {
        return icndbDTO;
    }

    public void setIcndbDTO(ICNDbDTO icndbDTO) {
        this.icndbDTO = icndbDTO;
    }
    
}
