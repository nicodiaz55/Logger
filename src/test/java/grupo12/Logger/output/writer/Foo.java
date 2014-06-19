package grupo12.Logger.output.writer;

public class Foo implements Writer {

	private boolean canWrite;
	
	public Foo() {
		canWrite = false;
	}
	
	@Override
	public void write(String message) {
		if (canWrite()) {
			System.out.println(message);
		}
	}

	@Override
	public void init() throws NotInitializedException {
		canWrite = true;
	}

	@Override
	public void end() {
		canWrite = false;
	}

	@Override
	public boolean canWrite() {
		return canWrite;
	}

}
