package SC2002.Actualassignment;

import java.util.List;
import java.util.ArrayList;
import java.util.UUID;

public class file1{
    public abstract class User{
        public abstract boolean authenticate(String password);
    }
    
    public class Project{
        private String projectTitle;
        private int projectID;
        private String studentName;
        private String studentEmail;
        private String supervisorName;
        private String supervisorEmail;
        private String status;

        // contingency
        private String studentId;
        private String supervisorId;
        
        public Project(String projectTitle, int projectID)
        {
            this.projectID = projectID;
            this.projectTitle = projectTitle;
            this.status = "available";
            this.studentName = null;
            this.studentEmail = null;

            // contingency
            this.studentId = null;
            this.supervisorId = null;
        }

        // Variables
        public int getProjectID(){
            return projectID;
        }
        public String getProjectTitle() {
            return projectTitle;
        }
        /* public String getStudentName() {
            return studentName;
        }
        public String getStudentEmail() {
            return studentEmail;
        } */
        public String getSupervisorName() {
            return supervisorName;
        }
        public String getSupervisorEmail() {
            return supervisorEmail;
        }
        public String getStatus() {
            return status;
        }

        // Assignments
        public void assignStatus(String assignment)
        {
            if(assignment == "available" || assignment == "reserved" ||
               assignment == "unavailable" || assignment == "allocated")
            {
                status = assignment;  
            }
            else{
                System.out.println("Warning: failure to assign project status");
            }
        }

        
    }

    public class Request{
        private boolean approve;
        private boolean rejected;
        private String requestAuthor;
        private String requestRecipient;

        // contingency
        private UUID requestID;

        public Request(String requestAuthor, String requestRecipient){
            
            approve = false;
            rejected = false;
            this.requestAuthor = requestAuthor;
            this.requestRecipient = requestRecipient;

            // contingency
            requestID = UUID.randomUUID();
        }

        // variables
        public boolean getApprove() {
            return approve;
        }

        public String getRequestAuthor(){
            return requestAuthor;
        }
        
        public String getRequestRecipient() {
            return requestRecipient;
        }

        public boolean getRejected(){
            return rejected;
        }

        public UUID getRequestID() {
            return requestID;
        }

        // functions
        public void approveRequest(){
            approve = true;
        }
        public void rejectRequest(){
            rejected = true;
            approve = false;
        }

    }

    public class deregisterRequest extends Request{
        public deregisterRequest(String studentName, String supervisorName){
            super(studentName, supervisorName);
        }
    }

    public class nameChangeRequest extends Request{
        private String name;

        public nameChangeRequest(String studentName, String supervisorName, String name){
            super(studentName, supervisorName);
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public class transferRequest extends Request{
        private String studentName;
        private int projectId;

        public transferRequest(String supervisorName, String coordinatorName, String studentName, int projectId){
            super(supervisorName, coordinatorName);
            this.studentName = studentName;
            this.projectId = projectId;
        }

        public String getStudentName() {
            return studentName;
        }

        public int getProjectId() {
            return projectId;
        }
    }

    // project, project title, 
    public class Student extends User{
        
        private String password;
        private String userID;
        private List<Project> projects;
        private List<Request> requests;

        public Student(){
            
        }
        //Security measures
        public void changePassword(String password){
            this.password = password;
        }
        @Override
        public boolean authenticate(String inputPassword){
            return this.password.equals(inputPassword);
        }

        // variables
        public String getUserID() {
            return userID;
        }
        
        // viewing functions
        public void viewAvailableProjects(){
            // view available projects
        }

        public void viewOwnProject(){
            // view his/her own project
        }

        public void viewRequests(){
            // view request status and history
        }

        // request functions
        public void requestTitleChange(String titleInput, Project project){
            // request project title change
        }

        

// Note: develop request search system
       
    }
    public class Supervisor extends User{
        // password, 
        private String password;
        private String userID;
        private List<Project> projects;
        private List<Request> requests;

        public Supervisor(){
            
        }
        //Security measures
        public void changePassword(String password){
            this.password = password;
        }
        
        @Override
        public boolean authenticate(String inputPassword){
            return this.password.equals(inputPassword);
        }

         // variables
        public String getUserID() {
            return userID;
        }

    }
    public static void main(String[] args)
    {
        
    }
}