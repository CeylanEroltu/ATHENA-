public class project {

    public static void main(String[] args) {

    Course c = new Course("CSE", 102, "Programming 2", "Introduction to OOP", 6);
    System.out.println(c.courseCode() + " - " + c.getTitle());
    System.out.println(c);
    
    Teacher t = new Teacher("Joseph LEDET", "josephledet@akdeniz.edu.tr", 123L,
     "CSE", 1);
    System.out.println(t);
    
    Student s = new Student("Test STUDENT", "me@somewhere.com", 456L, "CSE");
    System.out.println(s);
    
    s.passCourse(c);
    System.out.println(s.getAKTS());
    
    System.out.println("------");
    
    Course course = new Course("CSE", 101, "Computer Programming 1",
     "Introduciton to Programming", 6);
    Student student = new Student("Can DO", "cando@akdeniz.edu.tr", 123L, "CSE");
    student.passCourse(course);

    course.setCourseNumber(course.getCourseNumber() + 10);
    System.out.println(student);
    System.out.println(course);

    course = new Course("CSE", 102, "Computer Programming 2",
     "Introduction to OOP", 4);
    student.passCourse(course);
    course.setCourseNumber(course.getCourseNumber() - 10);
    System.out.println(course);
    System.out.println(student);
    }
    
    }
    class Course{
    
    private String departmentCode;
    private int courseNumber;
    private String title;
    private String description;
    private int AKTS;
    
        public Course(String departmentCode, int number, String title,
        String description, int AKTS) {

        setDepartmentCode(departmentCode);
        setCourseNumber(number);
        this.title = title;
        this.description = description;
        setAKTS(AKTS);
        }
    
        public String getDepartmentCode() {
        return departmentCode;
        }

        public void setDepartmentCode(String departmentCode) {

        if (departmentCode.length() == 4 || departmentCode.length() == 3) {
        this.departmentCode = departmentCode;
        } 
        else {
        throw new IllegalArgumentException
        ("ERROR: Department code length is NOT VALID...");
    }
    }
        public int getCourseNumber() {
        return courseNumber;
        }
        public void setCourseNumber(int number) {

        if ((number >= 100 && number <= 999) || (number >= 5000 && number <= 5999) 
        || (number >= 7000 && number <= 7999)) {
        this.courseNumber = number;
        } 
        else {
        throw new IllegalArgumentException("ERROR: Course number is INVALID...");
    }
    }
        public String getTitle() {
        return title;
        }
        public void setTitle(String title) {
        this.title = title;
    }
    
        public String getDescription() {
        return description;
        }
        public void setDescription(String description) {
        this.description = description;
    }
        public int getAKTS() {
        return AKTS;
    }
        public void setAKTS(int AKTS) {
        if (AKTS > 0) {
        this.AKTS = AKTS;
    } 
        else {
        throw new IllegalArgumentException("ERROR: AKTS must be POSITIVE...");
    }
    }
    
        public String courseCode(){
        return getDepartmentCode() + getCourseNumber();
    }
    
        @Override
        public String toString() {
        return departmentCode + courseNumber + " - " + title + " (" + AKTS + ")";
    }
    }
    class Person{
    private String name;
    private String email;
    private long  id;
    private String departmentCode; 
    
        public Person(String name, String email, long number, String departmentCode) {

        this.name = name;
        setEmail(email);
        this.id = number;
        setDepartmentCode(departmentCode);
    }
        public String getName() {
        return name;
    }
        public void setName(String name) {
        this.name = name;
    }
        public String getEmail() {
        return email;
    }
        public void setEmail(String email) {
        String[] parts = email.split("@");
    
        if (parts.length != 2) {
        throw new IllegalArgumentException("INVALID email format");
    }
    
    String username = parts[0].trim();
    String[] domainParts = parts[1].split("\\...");
    
    if (domainParts.length < 2) {
    throw new IllegalArgumentException("Invalid email format");
    }
    
    String universityName = domainParts[0].trim();
    String domain = domainParts[1].trim();
    String extra = "";
    
    if (domainParts.length > 2) {
    extra = domainParts[2].trim();
    }
    
    if (username.isEmpty() || universityName.isEmpty() || domain.isEmpty()) {
    throw new IllegalArgumentException("INVALID email format");
    }
    this.email = email;
    }
    
        public long getID() {
        return id;
    }
        public void setID(long id) {
        this.id = id;
    }
        public String getDepartmentCode() {
        return departmentCode;
    }
        public void setDepartmentCode(String departmentCode) {

        if (departmentCode.length() == 4 || departmentCode.length() == 3) {
        this.departmentCode = departmentCode;
    } 
        else {
        throw new IllegalArgumentException
    ("ERROR: Department code length is NOT VALID.");
    }
    }
        public String toString() {
        return name + " (" + id + ") - " + email;
    }
    
    }

    class Teacher extends Person{
    private int rank;
    
        public Teacher(String name, String email, long number,
        String departmentCode, int rank) {

        super(name, email, number, departmentCode);
        setRank(rank);
    }
        public void setRank(int rank) {
        if (rank >= 1 && rank <= 4) {
        this.rank = rank;
    } 
        else {
        throw new IllegalArgumentException("ERROR: Rank is INVALID...");
    }
    }
        public String getTitle() {
    switch (rank) {
    case 1:
        return "Lecturer";
    case 2:
        return "Assistant Professor";
    case 3:
        return "Associate Professor";
    case 4:
        return "Professor";
    
    default:
        return "Unknown";
    }
    }
    
        public void promote(){
        if (rank < 4) {
        rank++;
        System.out.println(getName() + " has been promoted to " + getTitle());
    } 
    
    }
        public void demote(){
        if (rank > 1) {
        rank--;
        System.out.println(getName() + " has been demoted to " + getTitle());
    } 
    
    }

    @Override
    public String toString() {
    return getTitle() + " " + super.toString();
    }
    }
    
    class Student extends Person{
    private int AKTS;
    
        public Student(String name, String email, long number, String departmentCode){

        super(name, email, number, departmentCode);
        this.AKTS = 0;
    }
        public int getAKTS() {
        return AKTS;
    }
        public void passCourse(Course course){
        int courseAKTS = course.getAKTS();
    
        AKTS += courseAKTS;
    }

    @Override
    public String toString() {
    return super.toString();
    }
    
    }

    class GradStudent extends Student{

    private int rank;
    private String thesisTopic;

    public GradStudent(String name, String email, long number,
     String departmentCode, int rank, String thesisTopic) {

    super(name, email, number, departmentCode);
    setRank(rank);
    this.thesisTopic = thesisTopic;
    }
    public void setRank(int rank) {
    if (rank >= 1 && rank <= 3) {
    this.rank = rank;
    } 
    else {
    throw new IllegalArgumentException("ERROR: Rank is invalid.");
    }
    }
    public String getLevel() {
    switch (rank) {
    case 1:
        return "Master’s Student";
    case 2:
        return "Doctoral Student";
    case 3:
        return "Doctoral Candidate";
    default:
        return "Unknown";
    }
    }
    public String getThesisTopic() {
    return thesisTopic;
    }
    
    public void setThesisTopic(String thesisTopic) {
    this.thesisTopic = thesisTopic;
    }
    public String toString() {
    return getLevel() + " - " + super.toString() +
     ", Thesis Topic: " + thesisTopic;
    }
    }



