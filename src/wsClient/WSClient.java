package wsClient;

import wsClient.exceptions.*;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.*;
import java.util.Properties;

public class WSClient
{
	/////////////////////////////
	//      Static members
	/////////////////////////////
	private static Properties webServiceUrls;                  ///< Contains the web service URLs
	private static Properties webServiceCredentials;           ///< Contains the location and the secret used
	
	///////////////////////////////
	//      Static initializers
	///////////////////////////////
	static {
		
		
		try {
			// Load web service URLs
			webServiceUrls = new Properties();
			webServiceUrls.load(WSClient.class.getResourceAsStream("/webservices.properties"));
			
			// Load web service credentials
			webServiceCredentials = new Properties();
			webServiceCredentials.load(WSClient.class.getResourceAsStream("/credential.properties"));
		} catch (IOException e) {
			throw new RuntimeException("Unable to load property file", e);
		}
		
	}

	/////////////////////////
	//      Methods
	/////////////////////////
	private static
	HttpClient             setupWebServiceConnection()
	{

		CredentialsProvider provider = new BasicCredentialsProvider();
		provider.setCredentials(
				AuthScope.ANY,
				new UsernamePasswordCredentials(webServiceCredentials.getProperty("username"), webServiceCredentials.getProperty("password"))
		);

		return HttpClientBuilder.create()
				.setDefaultCredentialsProvider(provider)
				.build();

	}

	/**
	 * Return Server status
	 * @return
	 * @throws AppWebServiceException
	 */
	public static
	String                      getServerStatus()
			throws AppWebServiceException
	{
		// construct HttpPost
		HttpPost post = new HttpPost(webServiceUrls.getProperty("webservice.status.url"));
		// Set the POST body - TODO
		//set up connection
		HttpClient client = setupWebServiceConnection();

		InputStream in ;
		try {
			HttpResponse response = client.execute(post);
			in = response.getEntity().getContent();
			String body = IOUtils.toString(in,"UTF-8");
			return body;
		}
		catch (IOException e) {
			throw new AppWebServiceException("Unable to get product lines", e);
		}

	}

	/**
	 * Return Image
	 * @return
	 * @throws AppWebServiceException
	 */
	public static
	String                      getImage()
			throws AppWebServiceException
	{
		// construct HttpPost
		HttpPost post = new HttpPost(webServiceUrls.getProperty("webservice.images.url"));
		//Set the POST body - TODO
		//set up connection
		HttpClient client = setupWebServiceConnection();

		InputStream in ;
		try {
			HttpResponse response = client.execute(post);
			in = response.getEntity().getContent();
			String body = IOUtils.toString(in,"UTF-8");
			return body;
		}
		catch (IOException e) {
			throw new AppWebServiceException("Unable to get product lines", e);
		}

	}

	/**
	 * Return ranking
	 * @return
	 * @throws AppWebServiceException
	 */
	public static
	String                      getRanking()
			throws AppWebServiceException
	{
		// construct HttpPost
		HttpPost post = new HttpPost(webServiceUrls.getProperty("webservice.ranking.url"));
		// Set the POST body - TODO
		//set up connection
		HttpClient client = setupWebServiceConnection();

		InputStream in ;
		try {
			HttpResponse response = client.execute(post);
			in = response.getEntity().getContent();
			String body = IOUtils.toString(in,"UTF-8");
			return body;
		}
		catch (IOException e) {
			throw new AppWebServiceException("Unable to get product lines", e);
		}

	}

}