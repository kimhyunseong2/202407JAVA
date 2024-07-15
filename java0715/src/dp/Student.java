package dp;

import java.util.Vector;

public class Student {
	private Professor advisor;
	private String name;
	private Vector<Course> courses;
	
	public Student() {}
	public Student(String name) {
		super();
		this.name = name;
		this.courses = new Vector<Course>();
	}
	
	public void registerCourse(Course course) {
		courses.add(course);
	}
	
	public void dropCourse(Course course) {
		if (courses.contains(course)) {
			courses.remove(course);
		}
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	public void setAdvisor(Professor advisor) {
		this.advisor = advisor;
	}


	public void advise(String msg) {
		System.out.println(msg);
		
	}
	
	
}
