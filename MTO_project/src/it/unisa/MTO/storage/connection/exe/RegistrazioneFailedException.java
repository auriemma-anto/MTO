package it.unisa.MTO.storage.connection.exe;

import java.sql.SQLException;

public class RegistrazioneFailedException extends SQLException {
	private static final long serialVersionUID = 1997753363232807009L;
	
	public RegistrazioneFailedException(String message)
	{
		super(message);
	}
	
	public RegistrazioneFailedException(String message, Throwable cause)
	{
		super(message, cause);
	}
}
