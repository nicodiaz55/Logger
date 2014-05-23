package grupo12.Logger.format;

import grupo12.Logger.message.LogMessage;

public class LiteralFormat extends Format {
	
	public LiteralFormat() {
		//TODO: esto es feo
		super(""); // Para que no se queje (?)
		pattern = "%%";
	}
	
	@Override
	public void format(LogMessage message) {
		updateFormat(message, "%");
	}

}
