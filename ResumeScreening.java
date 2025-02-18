import java.util.*;

abstract class JobRole {
    String candidateName;
    String experience;
    List<String> skills;
    
    JobRole(String candidateName, String experience, List<String> skills) {
        this.candidateName = candidateName;
        this.experience = experience;
        this.skills = skills;
    }
    
    abstract boolean isQualified();
}

class SoftwareEngineer extends JobRole {
    SoftwareEngineer(String candidateName, String experience, List<String> skills) {
        super(candidateName, experience, skills);
    }
    
    boolean isQualified() {
        return skills.contains("Java") || skills.contains("C++");
    }
}

class DataScientist extends JobRole {
    DataScientist(String candidateName, String experience, List<String> skills) {
        super(candidateName, experience, skills);
    }
    
    boolean isQualified() {
        return skills.contains("Python") && skills.contains("Machine Learning");
    }
}

class ProductManager extends JobRole {
    ProductManager(String candidateName, String experience, List<String> skills) {
        super(candidateName, experience, skills);
    }
    
    boolean isQualified() {
        return skills.contains("Leadership") && skills.contains("Strategy");
    }
}

class Resume<T extends JobRole> {
    T jobRole;
    
    Resume(T jobRole) {
        this.jobRole = jobRole;
    }
    
    boolean process() {
        return jobRole.isQualified();
    }
}

class ScreeningPipeline {
    static void processResumes(List<? extends JobRole> resumes) {
        for (JobRole resume : resumes) {
            System.out.println(resume.candidateName + " - " + (resume.isQualified() ? "Qualified" : "Not Qualified"));
        }
    }
}

class ResumeScreening {
    public static void main(String[] args) {
        List<JobRole> candidates = new ArrayList<>();
        candidates.add(new SoftwareEngineer("Alice", "5 years", Arrays.asList("Java", "Spring")));
        candidates.add(new DataScientist("Bob", "3 years", Arrays.asList("Python", "Machine Learning")));
        candidates.add(new ProductManager("Charlie", "7 years", Arrays.asList("Leadership", "Finance")));
        
        ScreeningPipeline.processResumes(candidates);
    }
}
