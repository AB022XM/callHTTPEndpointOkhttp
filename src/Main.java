import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import okhttp3.*;

import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class Main {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, KeyManagementException {
        Response resp=new Main().callAPI();
        System.out.println(resp.body().string());
    }

    public  Response callAPI() throws IOException, NoSuchAlgorithmException, KeyManagementException {
        OkHttpClient client =new TrustAllCertsClient().getTrustAllCertsClient();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder()
                .url("http://ugpbhkmapp0002.corp.dsarena.com:8897/api/v1/Authenticate/GetAuthToken")
                .method("POST", body)
                .addHeader("Authorization", "Basic VFJVRUFGUklDQVVTU0Q6VGVzdA==")
                .build();

        return client.newCall(request).execute();
    }
}