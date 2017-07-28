package examples;

/**
 * Created by Cinthya on 27-7-2017.
 */
public class EnumExample {

        public enum BootCampDays{
            DAYONE,
            DAYTWO,
            DAYTHREE,
            DAYFOUR,
            DAYFIVE;
        }

        public static String checkBootCampDaysInfo(BootCampDays bootCampDays){
            switch (bootCampDays){
                case DAYONE:
                    return "Zin in!";
                case DAYTWO:
                    return "Spijt van!";
                case DAYTHREE:
                    return "Ik heb hoofdpijn!";
                case DAYFOUR:
                return "Vakantiegevoel!";
                case DAYFIVE:
                return "Java Programmeren!";
                default:
                    return"Welke dag bedoel je?";
            }
        }
}
