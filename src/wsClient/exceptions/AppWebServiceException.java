package wsClient.exceptions;

/**
 * Exception thrown when web service fails
 */
public class AppWebServiceException extends Exception
{
	public AppWebServiceException(final String msg, final Throwable t)
	{
		super(msg, t);
	}
}