class User {
    private String email;
    private String passWord;
    
    public User(String email, String passWord) {
        this.email = email;
        this.passWord = passWord;
    }

    public void toggleMicroPhone() {
        System.out.println("Microphone Toggeled");  
    }

    public void toggleCamera() {
        System.out.println("Camera Toggeled"); 
    }

    public void endCall() {
        System.out.println("Call ended");  
    }

    public void presentScreen() {
        System.out.println("Presenting....");  
    }

    public String getMail() {
        return email;
    }
}

class Admin extends User {
    String meetingID;
    private Admin(String email, String passWord) {
        super(email, passWord);
    }

    public static Admin createMeeting(String email , String passWord) {
       Admin admin = new Admin(email, passWord);
       admin.meetingID = admin.toString();
       return admin;   
    }
    
    public void toggleParticipantMicrophone(Participant participant) {
        participant.toggleMicroPhone();
        System.out.println(participant.getMail() + " has been Muted"); 
    }
    
    public void removeParticipant(Participant participant) {
        System.out.println((participant.getMail() + " has been Removed from the Call"));
        participant.setMeetingID(null);
    }

    public String getMeetingID() {
        return meetingID;
    } 

}



class Participant extends User {
    String onGoingMeeting;
    private Participant(String email, String passWord) {
        super(email, passWord);
    }
    
    public static Participant joinMeeting(String email, String passWord, String meetingID) {
        Participant user = new Participant(email, passWord);
        user.setMeetingID(meetingID);
        return user;
    }

    public void setMeetingID(String id) {
        this.onGoingMeeting = id;
    }
}



public class HangOuts {


    public static void main(String[] args) {
          Admin internetProgramming = Admin.createMeeting("lawrance.1802052@srit.org", "*********");
          Participant p1 = Participant.joinMeeting("karthick.1802046@srit.org", "*******", internetProgramming.getMeetingID());
          Participant p2 = Participant.joinMeeting("kailas.1802040@srit.org", "*********", internetProgramming.getMeetingID());
          
          internetProgramming.toggleMicroPhone();
          internetProgramming.toggleCamera();
          
          p1.toggleCamera();
          p2.toggleCamera();

          internetProgramming.toggleParticipantMicrophone(p1);

          internetProgramming.removeParticipant(p2);

    } 
}
