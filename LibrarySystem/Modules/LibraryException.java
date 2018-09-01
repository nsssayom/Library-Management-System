package LibrarySystem.Modules;
import java.lang.*;

public class LibraryException extends Exception {

	private static final long serialVersionUID = 7718828512143293558L;
	private final int code;

	public LibraryException(int code) {
		super();
		this.code = code;
	}

	public LibraryException(String message, Throwable cause, int code) {
		super(message, cause);
		this.code = code;
	}

	public LibraryException(String message, int code) {
		super(message);
		this.code = code;
	}

	public LibraryException(Throwable cause, int code) {
		super(cause);
		this.code = code;
	}

	public int getCode() {
		return this.code;
	}
}
