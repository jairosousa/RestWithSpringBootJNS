package br.com.erudio;

public class Greeating {

	private final long id;
	private final String content;

	public Greeating(long id, String content) {
		this.id = id;
		this.content = content;
	}

	public long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}

}
