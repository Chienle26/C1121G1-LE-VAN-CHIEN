package ss_case_study_furama_resort.models.services.impl;

import ss_case_study_furama_resort.models.model.Booking;
import ss_case_study_furama_resort.models.model.Contract;
import ss_case_study_furama_resort.models.services.IContractService;
import ss_case_study_furama_resort.utils.BookingComparator;
import ss_case_study_furama_resort.utils.ReadAndWriteFileCSV;

import java.util.*;

public class ContractServiceImpl implements IContractService {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void add() {
        Set<Booking> bookingSet = ReadAndWriteFileCSV.readBookingToCSV(ReadAndWriteFileCSV.BOOKING_FILE);
        List<Booking> bookingList = new ArrayList<>(bookingSet);
        Queue<Contract> contractQueue = new LinkedList<>();
        Collections.sort(bookingList, new BookingComparator());
        for (int i = 0; i < bookingList.size(); i++) {
            if (!bookingList.get(i).getServiceType().equals("Room")) {
                System.out.println("Nhập vào tiền đặt cọc của hợp đồng có mã booking là " + bookingList.get(i).getBookingCode() + ": ");
                double deposit = Double.parseDouble(scanner.nextLine());
                System.out.println("Nhập vào tổng tiền thanh toán của hợp đồng có mã booking là " + bookingList.get(i).getBookingCode() + ": ");
                double totalPayment = Double.parseDouble(scanner.nextLine());
                contractQueue = new LinkedList<>();
                Contract contract = new Contract(bookingList.get(i), deposit, totalPayment, bookingList.get(i));
                contractQueue.add(contract);
                ReadAndWriteFileCSV.writeContractToCSV(contractQueue, ReadAndWriteFileCSV.CONTRACT_FILE, true);
            }
        }
        bookingSet = new TreeSet<>();
        ReadAndWriteFileCSV.writeBookingToCSV(bookingSet,ReadAndWriteFileCSV.BOOKING_FILE,false);
    }

    @Override
    public void display() {
        Queue<Contract> contractQueue = ReadAndWriteFileCSV.readContractToCSV(ReadAndWriteFileCSV.CONTRACT_FILE);
        for (Contract contract : contractQueue) {
            System.out.println(contract);
        }
    }

    @Override
    public void edit() {
        display();
        Queue<Contract> contractQueue = ReadAndWriteFileCSV.readContractToCSV(ReadAndWriteFileCSV.CONTRACT_FILE);
        System.out.println("Nhập mã hợp đồng muốn sửa: ");
        int contractCode = Integer.parseInt(scanner.nextLine());
        for (Contract contract : contractQueue) {
            if (contractCode == contract.getContractNumber()) {
                System.out.println("Nhập vào tiền đặt cọc: ");
                double deposit = Double.parseDouble(scanner.nextLine());
                System.out.println("Nhập vào tổng tiền thanh toán: ");
                double totalPayment = Double.parseDouble(scanner.nextLine());
                contract.setDeposit(deposit);
                contract.setTotalPayment(totalPayment);
            }
        }
        ReadAndWriteFileCSV.writeContractToCSV(contractQueue,ReadAndWriteFileCSV.CONTRACT_FILE,false);
    }

    @Override
    public void returnMainMenu() {

    }
}
