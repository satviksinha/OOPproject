import java.time.LocalDate;
import java.util.*;

public class Customer {
    private String Name;
    private String AadhaarNo;
    private int Age;
    private String Gender;
    private FlightFinder ff;
    public static ArrayList<City> Cities = new ArrayList<City>();
    private String Day;
    private int Ticketnos;
    private ArrayList<Passenger> psn = new ArrayList<Passenger>();
    private int optionSelected;

    static {
        Cities.add(new City("Mumbai", "Chhatrapati Shivaji Maharaj International Airport", 0));
        Cities.add(new City("Bengaluru", "Kempegowda International Airport", 100));
        Cities.add(new City("Pune", "Pune International Airport", 300));
        Cities.add(new City("Jaipur", "Jaipur International Airport", 500));
        Cities.add(new City("Chandigarh", "Shaheed-e-Azam Bhagat Singh Airport", 700));
        Cities.add(new City("Patna", "Jayprakash Narayan International Airport", 900));
        Cities.add(new City("Lucknow", "Chaudhary Charan Singh International Airport", 1100));
        Cities.add(new City("Nagpur", "Dr.Babasaheb Ambedkar International Airport", 130));
        Cities.add(new City("Amritsar", "Sri Guru Ram Das Ji International Airport", 1500));
        Cities.add(new City("Indore", "Devi Ahilya Bai Holkar Airport", 1000));
        Cities.add(new City("Chennai", "Chennai International Airport", 2000));
    }

    public Customer(){
        this.register();
        
       
    }

    public void register(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name: ");
        this.Name = sc.nextLine();
        System.out.println("Enter your Aadhar number: ");
        this.AadhaarNo = sc.nextLine();
        System.out.println("Enter your age: ");
        this.Age = Integer.parseInt(sc.nextLine());
        System.out.println("Enter your gender: ");
        this.Gender = sc.nextLine();
        System.out.println("Enter your source city: ");
        String sourceCity = sc.nextLine();
        City scy = null, dcy = null;
        for (int i = 0; i < Cities.size(); i++) {
            if (sourceCity.equals(Cities.get(i).getName()))
                scy = Cities.get(i);
        }
        System.out.println("Enter your destination city: ");
        String desCity = sc.nextLine();
        
        for (int i = 0; i < Cities.size(); i++) {
            if (desCity.equals(Cities.get(i).getName()))
                dcy = Cities.get(i);
        }

        System.out.println("Enter your travel date in the format YYYY_MM_DD ");
        String date = sc.nextLine();
        
        System.out.println("Enter the number of tickets you want to book");
        this.Ticketnos = Integer.parseInt(sc.nextLine());
        
        String[] date_par = date.split(" ");
        int year = Integer.parseInt(date_par[0]);
        int month = Integer.parseInt(date_par[1]);
        int d = Integer.parseInt(date_par[2]);

        LocalDate localDate = LocalDate.of(year, month, d);
        java.time.DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        int day_no = dayOfWeek.getValue();
        this.Day = dayOfWeek.toString();


        this.ff = new FlightFinder();
        try {
         ff.findFlights(dcy, scy,day_no,Ticketnos);
        } catch (CityNotFoundException e) {
            System.out.println(e);
        }
    }

    public FlightFinder getFlightFinder() {
        return ff;
    }
    public void setFlightFinder(FlightFinder ff){
        this.ff = ff;
    }

    public String getName() {
        return Name;
    }
    public void setName(String Name){
        this.Name = Name;
    }

    public String getAadhaarNo() {
        return AadhaarNo;
    }
    public void setAadhaarNo(String AadharNo){
        this.AadhaarNo = AadharNo;
    }

    public int getAge() {
        return Age;
    }
    public void setAge(int Age){
        this.Age = Age;
    }

    public String getGender() {
        return Gender;
    }
    public void setGender(String Gender){
        this.Gender = Gender;
    }

    @Override
    public String toString() {
        return "Passenger name: " + this.Name + "\n" + "Aadhaar No: " + this.AadhaarNo + "\n" + "Age: " + this.Age
                + "\n" + "Gender: " + this.Gender;
    }

    public String getDay() {
        return Day;
    }
    public void setDay(String Day){
        this.Day = Day;
    }

    public int getTicketnos() {
        return Ticketnos;
    }
    public void setTicketnos(int Ticketnos){
        this.Ticketnos = Ticketnos;

    }

    public ArrayList<Passenger> getpsn() {
        return psn;
    }
    public void setpsn(ArrayList<Passenger> psn){
        this.psn = psn;
    }
    public void setoptionSelected(int os){
        this.optionSelected = os;
    }
    public int getoptionSelected(){
        return optionSelected;
    }

}