package practice.list;

public class Stud {
int id;
int roll;
String name;
String department;
int marks;

public Stud(int id, int roll, String name, String department, int marks) {
	super();
	this.id = id;
	this.roll = roll;
	this.name = name;
	this.department = department;
	this.marks = marks;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getRoll() {
	return roll;
}
public void setRoll(int roll) {
	this.roll = roll;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDepartment() {
	return department;
}
public void setDepartment(String department) {
	this.department = department;
}
public int getMarks() {
	return marks;
}
public void setMarks(int marks) {
	this.marks = marks;
}
}
