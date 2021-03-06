package ss_case_study_furama_resort.models.services.impl;

import ss_case_study_furama_resort.models.model.Booking;
import ss_case_study_furama_resort.models.services.IPromotionManagement;
import ss_case_study_furama_resort.utils.BookingComparator;
import ss_case_study_furama_resort.utils.ReadAndWriteFileCSV;

import java.text.SimpleDateFormat;
import java.util.*;

public class PromotionManagementServiceImpl implements IPromotionManagement {
    Scanner scanner = new Scanner(System.in);
    Set<Booking> bookingSet = ReadAndWriteFileCSV.readBookingToCSV(ReadAndWriteFileCSV.BOOKING_FILE_COPY);

    @Override
    public void displayCustomersUseService() {
        System.out.print("Nhập năm cần hiển thị danh sách Booking: ");
        int yearBooking = Integer.parseInt(scanner.nextLine());
        String year = Integer.toString(yearBooking);
        for (Booking booking : bookingSet) {
            if (booking.getStartDate().indexOf(year) > 0 || booking.getEndDate().indexOf(year) > 0) {
                System.out.println(booking);
            }
        }
    }

    @Override
    public void displayCustomersGetVoucher() {
        Stack<Booking> bookingStack = new Stack<>();
        Map<String, Integer> voucher = new HashMap<>();
        List<Booking> bookingList = new ArrayList<>(bookingSet);
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dateNow = sdf.format(date);
        dateNow = dateNow.substring(3);
        System.out.println("Nhập số lượng voucher khuyến mãi 50%: ");
        int voucher50 = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập số lượng voucher khuyến mãi 20%: ");
        int voucher20 = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập số lượng voucher khuyến mãi 10%: ");
//        int voucher10 = bookingStack.size() - voucher20 - voucher50;
        int voucher10 = Integer.parseInt(scanner.nextLine());
        voucher.put("voucher10", voucher10);
        voucher.put("voucher20", voucher20);
        voucher.put("voucher50", voucher50);
        Collections.sort(bookingList, new BookingComparator());
        for (Booking booking : bookingList) {
            if (booking.getStartDate().substring(3).equals(dateNow) && !booking.getServiceType().equals("Room") || booking.getEndDate().substring(3).equals(dateNow) && !booking.getServiceType().equals("Room")) {
                bookingStack.add(booking);
            }
        }
        while (true) {
            if (bookingStack.isEmpty()) {
                break;
            } else {
                if (voucher.get("voucher10") > 0) {
                    System.out.println(bookingStack.pop() + " : Nhận được voucher 10%");
                    voucher.put("voucher10", voucher.get("voucher10") - 1);
                } else if (voucher.get("voucher20") > 0) {
                    System.out.println(bookingStack.pop() + " : Nhận được voucher 20%");
                    voucher.put("voucher20", voucher.get("voucher20") - 1);
                } else {
                    System.out.println(bookingStack.pop() + " : Nhận được voucher 50%");
                    voucher.put("voucher50", voucher.get("voucher50") - 1);
                }
            }
        }
    }
}
