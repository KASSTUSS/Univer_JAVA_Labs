import by.gsu.pms.BusinessTripExpenses;
public class Runner {
    public static void main(String[] args) {


        BusinessTripExpenses[] employeeBusinessTrip = new BusinessTripExpenses[] {
                new BusinessTripExpenses(2.5f, "Nilolay Gerasenko", 25.0f,10 ),
                new BusinessTripExpenses(2.5f, "Alexey Voevoda", 37.5f,14 ),
                null,
                new BusinessTripExpenses(2.5f, "Bladislav Belous", 15.75f,7 ),
                new BusinessTripExpenses(2.5f, "Ilya Anikeenko", 51.3f,5 ),
                new BusinessTripExpenses(2.5f, "Kastus Chvalau", 10.1f,5 ),
                new BusinessTripExpenses()
        };

        for (BusinessTripExpenses trip: employeeBusinessTrip){
            if (trip == null) continue;
            trip.show();
            System.out.println("\n");
        }

        employeeBusinessTrip[6].setTransportExpenses(53.3f);

        System.out.printf("Duration = %d\n\n", (employeeBusinessTrip[1].getNumOfDays() + employeeBusinessTrip[3].getNumOfDays()) );

        for (BusinessTripExpenses trip: employeeBusinessTrip){
            if (trip == null) continue;
            System.out.println(trip.toString());
        }

        float sumOfTotalExpenses = 0.0f;
        for (BusinessTripExpenses trip: employeeBusinessTrip){
            if (trip == null) continue;
            sumOfTotalExpenses += trip.getTotal();
        }
        System.out.printf("\nSum of total expenses: %.2f\n\n", sumOfTotalExpenses );

        int indexEmployeeMaxTotal = 0;
        for (int i = 1; i < employeeBusinessTrip.length; i++){
            if (employeeBusinessTrip[i] == null) continue;
            indexEmployeeMaxTotal = (employeeBusinessTrip[i].getTotal() > employeeBusinessTrip[indexEmployeeMaxTotal].getTotal()) ? i : indexEmployeeMaxTotal;
        }
        System.out.printf("Employee with maximum  total expenses: %s\n\n", employeeBusinessTrip[indexEmployeeMaxTotal].getEmployeeAccount() );
    }
}