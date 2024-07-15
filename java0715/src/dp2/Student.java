package dp2;

import java.util.Vector;

public class Student {
	private Vector<Transcript> transcripts;
	private String name;
	
	public Student(String name) {
		super();
		this.transcripts = new Vector<Transcript>();
		this.name = name;
	}
	
	public void addTranscript(Transcript transcript) {
			transcripts.add(transcript);
			
		}
	 
	 @Override
	public String toString() {
		return "Student [transcripts=" + transcripts + ", name=" + name + "]";
	}

	public Vector<Transcript> getTranscripts() {
	        return transcripts;
	    }

	

	public String getName() {
		return name;
	}

	
	
	
	
}
