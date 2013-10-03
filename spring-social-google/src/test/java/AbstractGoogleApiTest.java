import org.junit.Before;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.social.google.api.impl.GoogleTemplate;
import org.springframework.test.web.client.MockRestServiceServer;

public class AbstractGoogleApiTest {

    protected GoogleTemplate google;
    protected MockRestServiceServer mockServer;
    protected HttpHeaders responseHeaders;

    @Before
    public void setup(){
        google = new GoogleTemplate("ACCESS_TOKEN");
        mockServer = MockRestServiceServer.createServer(google.getRestTemplate());
       responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
    }
    protected Resource jsonResource(String filename){
        return new ClassPathResource(filename +".json",getClass());
    }
}
