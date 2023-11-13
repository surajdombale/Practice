package practice.list;

import java.util.List;
import java.util.ArrayList;

public class ArrayListPractice {

	public static void main(String[] args) {
		List<Student> list = new ArrayList<Student>();
		Student student = new Student(1, "suraj", "pune");
		Student student2 = new Student(5, "suraj", "pune");
		Student student1 = new Student(3, null, null);
		Student student3 = new Student(3, "vikas", null);

		list.add(student);
		list.add(student2);
		list.add(student2);
		list.add(student2);
		list.add(student1);
		list.add(student1);
		System.out.println(list.get(0).getId());
		System.out.println(student.getId());
		for (int i = 0; i < list.size(); i++) {
			if (student1.getId() == list.get(i).getId()) {
				System.out.println(student1.getId());
				System.out.println(i);
			}
		}

	}
}