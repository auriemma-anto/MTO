package it.unisa.MTO.storage.connection;

public interface ConstantsDB {
	
	public enum ConfigurazioneDB {

		SERVER("jdbc:mysql://localhost"),
		PORT("3306"),
		NOMEDB("MTO_DB"),
		USERNAME("MTO"),
		PASSWORD("progettomto");

		private String value;

		public void setValue(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}

		private ConfigurazioneDB(String value) {

			this.value = value;
		}
	}
	
}
