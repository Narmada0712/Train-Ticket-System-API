package com.trainticket.system.ticketseat;

//SeatAllocator.java
public class TrainSeatAllocator {
 private static int availableSeatsSectionA = 50;
 private static int availableSeatsSectionB = 50;

 public static synchronized char allocateSeat() {
     if (availableSeatsSectionA > 0) {
         availableSeatsSectionA--;
         return 'A';
     } else if (availableSeatsSectionB > 0) {
         availableSeatsSectionB--;
         return 'B';
     } else {
         throw new RuntimeException("No seats available.");
     }
 }

 public static synchronized void deallocateSeat(char section) {
     if (section == 'A') {
         availableSeatsSectionA++;
     } else if (section == 'B') {
         availableSeatsSectionB++;
     } else {
         throw new IllegalArgumentException("Invalid section: " + section);
     }
 }
}

