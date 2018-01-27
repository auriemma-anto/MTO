package it.unisa.MTO.storage.connection.exe;

import java.sql.SQLException;

public class LoginFailedException extends SQLException{
	private static final long serialVersionUID = 1997753363232807009L;
	
	public LoginFailedException(String message)
	{
		super(message);
	}
	
	public LoginFailedException(String message, Throwable cause)
	{
		super(message, cause);
	}
}
