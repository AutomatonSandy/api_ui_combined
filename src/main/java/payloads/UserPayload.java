package payloads;

public class UserPayload {
	private String name;
	private String job;

	public UserPayload(String name, String job) {
		this.name = name;
		this.job = job;
	}

	public String getName() {
		return name;
	}

	public String getJob() {
		return job;
	}
}
