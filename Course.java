class Course{

   String courseName;

	int duration;

	public Course(String courseName,int duration){

	    this.courseName=courseName;

		this.duration=duration;

   }

   public String getDetails(){

	    return "Course Name --> "+courseName+", Duration --> "+duration+" hours";

	}

}

class OnlineCourse extends Course{

   String platform;

	boolean isRecorded;

	public OnlineCourse(String courseName,int duration,String platform,boolean isRecorded){

	    super(courseName,duration);

		this.platform=platform;

		this.isRecorded=isRecorded;

	}

	@Override

	public String getDetails(){

	    return super.getDetails()+", Platform --> "+platform+", Recorded --> "+(isRecorded?"Yes":"No");

	}

}

class PaidOnlineCourse extends OnlineCourse{

   double fee;

	double discount;

	public PaidOnlineCourse(String courseName,int duration,String platform,boolean isRecorded,double fee,double discount){

       super(courseName,duration,platform,isRecorded);

		this.fee=fee;

		this.discount=discount;

	}

	@Override

	public String getDetails(){

	    return super.getDetails()+", Fee --> $"+fee+", Discount --> "+discount+"%";

	}

}

public class CourseHierarchy{

   public static void main(String[] args){

	    Course course1=new Course("Data Structures and Algorithm",50);

		OnlineCourse onlineCourse1=new OnlineCourse("Data Science",80,"Coursera",true);

		PaidOnlineCourse paidOnlineCourse1=new PaidOnlineCourse("Artificial Intelligence withMachine Learning",90,"Udemy",true,245.99,10);

		System.out.println(course1.getDetails());

		System.out.println(onlineCourse1.getDetails());

		System.out.println(paidOnlineCourse1.getDetails());

	}

}
