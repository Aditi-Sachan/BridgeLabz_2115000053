
import java.util.ArrayList;
import java.util.List;

class Doctor {
    String name;
    List<Patient> patients = new ArrayList<>();

    Doctor(String name) {
        this.name = name;
    }

    void consult(Patient patient) {
        System.out.println("Dr. " + name + " is consulting with " + patient.name);
        patients.add(patient);
        patient.addDoctor(this);
    }
}

class Patient {
    String name;
    List<Doctor> doctors = new ArrayList<>();

    Patient(String name) {
        this.name = name;
    }

    void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    void displayDoctors() {
        System.out.println(name + " is consulting with the following doctors:");
        for (Doctor doctor : doctors) {
            System.out.println("Dr. " + doctor.name);
        }
    }
}

class Hospital {
    String hospitalName;
    List<Doctor> doctors = new ArrayList<>();
    List<Patient> patients = new ArrayList<>();

    Hospital(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    void addPatient(Patient patient) {
        patients.add(patient);
    }
}

class Main {
    public static void main(String[] args) {
        Hospital hospital = new Hospital("City Hospital");

        Doctor doctor1 = new Doctor("Smith");
        Doctor doctor2 = new Doctor("Jones");

        Patient patient1 = new Patient("Alice");
        Patient patient2 = new Patient("Bob");

        hospital.addDoctor(doctor1);
        hospital.addDoctor(doctor2);
        hospital.addPatient(patient1);
        hospital.addPatient(patient2);

        doctor1.consult(patient1);
        doctor1.consult(patient2);
        doctor2.consult(patient1);

        patient1.displayDoctors();
        patient2.displayDoctors();
    }
}

