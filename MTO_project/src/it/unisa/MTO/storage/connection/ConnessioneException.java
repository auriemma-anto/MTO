package it.unisa.MTO.storage.connection;

public class ConnessioneException extends Exception {
	
	private static final long serialVersionUID = 1997753363232807009L;

	public ConnessioneException()
	{
	}

	public ConnessioneException(String message)
	{
		super(message);
	}

	public ConnessioneException(Throwable cause)
	{
		super(cause);
	}

	public ConnessioneException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public ConnessioneException(String message, Throwable cause, 
			boolean enableSuppression, boolean writableStackTrace)
	{
		super(message, cause, enableSuppression, writableStackTrace);
	}


}
