class Course{

    String courseName;
    int duration;
    int fee;
    static String instituteName = "GLA University";

    Course(String courseName, int duration, int fee){
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    void displayCourseDetails(){
		System.out.println();
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " months");
        System.out.println("Fee: Rs." + fee);
        System.out.println("Institute: " + instituteName);
    }

    static void updateInstituteName(String newName){
        instituteName = newName;
    }

    public static void main(String[] args){
        Course c1 = new Course("Java Programming", 3, 1500);
        Course c2 = new Course("Web Development", 4, 1000);
        Course c3 = new Course("Machine Learning", 3, 1600);
        Course c4 = new Course("Cloud Computing", 2, 800);
        c1.displayCourseDetails();
        c2.displayCourseDetails();
        c3.displayCourseDetails();
        c4.displayCourseDetails();
        updateInstituteName("GL Bajaj University");
        c1.displayCourseDetails();
        c2.displayCourseDetails();
        c3.displayCourseDetails();
        c4.displayCourseDetails();
    }
	
}