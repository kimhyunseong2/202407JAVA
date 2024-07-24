package iteratorex;

import java.util.Iterator;



public class StudentGroup implements Iterable<Student>{
	private Student[] students;
	private int last = 0;
	
	@Override
	public Iterator<Student> iterator() {
		return new StudentGroupIterator(this);
	}
	public StudentGroup(int maxsize) {         // 생성자
		this.students = new Student[maxsize];
	}
	 
	public Student getStduentAt(int index) {    
		return students[index];
	}
	
	public void appendStudent(Student student) {    
		this.students[last] = student;
		last++;
	}
	
	public int getLength() {               
		return last;
	}
}
