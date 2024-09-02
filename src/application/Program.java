package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Room number: ");
		int numberRoom = sc.nextInt();
		System.out.print("Check-in date (dd/mm/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-out date (dd/mm/yyyy): ");
		Date checkOut = sdf.parse(sc.next());

		if (!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Check-Out date must be after check-in date");
		} else {
			Reservation res = new Reservation(numberRoom, checkIn, checkOut);
			System.out.println("Reservation: " + res);

			System.out.println();

			System.out.println("Enter a data to update the reservation: ");
			System.out.print("Check-in date (dd/mm/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/mm/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			Date now = new Date();
			if (checkIn.before(now) && checkOut.before(now) ) {
				System.out.println("Error in reservation: Reservation dates for update must be future dates");
			} else  if (!checkOut.after(checkIn)) {
				System.out.println("Error in reservation: Check-Out date must be after check-in date");
			} else {
				res.updateDates(checkIn, checkOut);
				System.out.println("Reservation: " + res);
			}
		}

		sc.close();

	}

}
