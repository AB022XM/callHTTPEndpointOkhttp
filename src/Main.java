import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import okhttp3.*;

import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class Main {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, KeyManagementException {
        //Response resp=new Main().callAPI();
        Response resp=new Main().callValidateAPI();
        System.out.println(resp.body().string());
    }

    public  Response callAPI() throws IOException, NoSuchAlgorithmException, KeyManagementException {

        OkHttpClient client =new TrustAllCertsClient().getTrustAllCertsClient();
                MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder()
                .url("http://ugpbhkmapp0002.corp.dsarena.com:8897/api/v1/Authenticate/GetAuthToken")
                .method("POST", body)
                .addHeader("Authorization", "Basic Q09QWUNBVFBPQzpWQ29weVRlc3QyNTYl")
                .build();
        Response response = client.newCall(request).execute();

        System.out.println(request.headers());
        System.out.println(request.isHttps());
        System.out.println(response.body().toString());

        return client.newCall(request).execute();
    }

    public  Response callValidateAPI() throws IOException, NoSuchAlgorithmException, KeyManagementException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\r\n  \"accountNumber\": \"6000086213\",\r\n  \"transactionID\": \"4567436543487\"\r\n}");
        Request request = new Request.Builder()
                .url("http://ugpbhkmapp0002.corp.dsarena.com:5565/api/v1/validate")
                .method("POST", body)
                .addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2Nzc2NjI1OTcsImlzcyI6Imh0dHBzOi8vbG9jYWxob3N0OjQ0MzE0LyIsImF1ZCI6Imh0dHBzOi8vbG9jYWxob3N0OjQ0MzE0LyJ9.op3FDo6B-g2EuXriZ-zbsSCLdJqPdusArPlXTYh7TME")
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = client.newCall(request).execute();
        return response;
    }


}