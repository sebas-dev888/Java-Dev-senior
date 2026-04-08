package app;
import model.config.WeekDay;
import model.security.User;
import model.security.UserRole;

public class App {
        public static void main(String[] args) throws Exception {
        //demoWeekday(); 
        demoUser();
    
    }


        private static void demoUser(){
            var sebas = new User("sebas", "jslealp@ut.edu.co", "123456" , true , UserRole.ADMIN);
            var cesar = new User("cesar", "pepito@gmail.com", "123456");
            var userArray = new User[] {sebas, cesar};

            for (int i = 0; i < userArray.length; i++) {
                var user = userArray[i];
                switch (user.getRole()) {
                    case ADMIN:
                        System.out.printf("%s es el super usuario%n", user);
                        break;
                    case CLIENT:
                        System.out.printf("%s es el cliente preferido%n", user);
                        break;
                    case PROVIDER:
                        System.out.printf("%s es mi proveedor%n", user);
                        break;
                    case USER:
                        System.out.printf("%s echa pa alla bobo%n", user);
                        break;
                    case EMPLOYEE:
                        System.out.printf("%s trabaja bobo%n", user);
                        break;
                    default:
                        break;
                }
                }
              
        }

        private static void demoWeekday() {
            WeekDay day = null;
            day = WeekDay.MONDAY;
            System.out.println(day);
        }
}
