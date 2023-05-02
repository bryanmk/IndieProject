package service;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;
import java.util.logging.Logger;

import org.json.JSONObject;


/**
 * @author Afterimage
 * 		/ Earthfury
 * 		/ Mal'ganis
 *
 *	For this app to work, you need to download and include in your classpath
 *  json.jar which can be downloaded from https://github.com/stleary/JSON-java
 *  (direct link https://search.maven.org/remotecontent?filepath=org/json/json/20210307/json-20210307.jar)
 *
 *  You will also have to enter your own CLIENT_ID & CLIENT_SECRET obtained through
 *  blizzard OAuth service (https://develop.battle.net/documentation/guides/getting-started)
 *
 */
public class TokenGenerator {

    private static final Logger logger = Logger.getLogger(TokenGenerator.class.getSimpleName());

    private static final String CLIENT_ID = "6fbdc3911a264d2ea1e5b416d2e3c205";

    private static final String CLIENT_SECRET = "HUUrHE4n8TEGq7Y4YZ7w6DYPdN1oLJSp";

    private static final String TOKEN_URL = "https://us.battle.net/oauth/token";

    private static long TokenExpireTime = 0;

    private static JSONObject Token = null;

    private static String inputStreamToString(final InputStream in) throws IOException {
        final byte [] data = new byte [2046];
        final ByteArrayOutputStream out = new ByteArrayOutputStream();

        int numRead = in.read(data);
        while (numRead > -1) {
            out.write(data, 0, numRead);
            numRead = in.read(data);
        }

        return out.toString();
    }


    private static JSONObject createToken() throws IOException {

        logger.warning("Creating new authentication token");

        final String encoding = "utf-8";

        final String encodedCredentials = Base64.getEncoder().encodeToString(String.format("%s:%s", CLIENT_ID, CLIENT_SECRET).getBytes(encoding));

        final URL url = new URL(TOKEN_URL);
        final HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Authorization", String.format("Basic %s", encodedCredentials));
        connection.setDoOutput(true);
        connection.getOutputStream().write("grant_type=client_credentials".getBytes(encoding));

        int responseCode = connection.getResponseCode();

        final InputStream in = connection.getInputStream();

        if (responseCode != 200) {
            final String message = in == null ? "" : inputStreamToString(in);
            logger.severe("Failed to authenticate.  responseCode: " + responseCode + ", message=" + message);
            return null;
        }

        final String str = inputStreamToString(in);
        Token = new JSONObject(str);
        TokenExpireTime = System.currentTimeMillis() + Long.parseLong(Token.get("expires_in").toString()) - 5000L;

        return Token;
    }

    public static JSONObject getToken() throws IOException {

        logger.fine("get");

        if (TokenExpireTime > System.currentTimeMillis()) {
            return createToken();
        }

        if (Token == null) {
            return createToken();
        }
        else {
            return Token;
        }
    }


    public static String get(final String uri, final String namespace, final String locale) throws IOException {

        JSONObject token = getToken();


        if (token == null) {
            return null;
        }


        final StringBuffer buf = new StringBuffer();
        buf.append(uri);
        if (uri.contains("?")) {
            buf.append("&");
        }
        else {
            buf.append("?");
        }
        buf.append("namespace=").append(namespace);
        buf.append("&locale=").append(locale);
        buf.append("&access_token=").append(token.getString("access_token"));

        logger.info(buf.toString());
        final URL url = new URL(buf.toString());
        final HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        int responseCode = connection.getResponseCode();

        if (responseCode != 200) {
            logger.severe("Failed to request data."
                    + ", uri=" + uri
                    + ", responseCode=" + responseCode);
            return null;
        }

        final InputStream in = connection.getInputStream();
        return inputStreamToString(in);
    }


    public static void main(String [] args) {

        final String namespace = "static-classic-us";

        final String locale = "en_US";

        final String baseURL = "https://us.api.blizzard.com";

        final String [] testPaths = {
                "/data/wow/item-class/index",
                "/data/wow/media/item/19019",
                "/data/wow/creature/30"
        };

        try {

            for (final String path: testPaths) {
                final String uri = baseURL + path;
                final String result = get(uri, namespace, locale);
                final JSONObject object = new JSONObject(result);
                logger.info(uri + " ===> " + object.toString(2));
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}


