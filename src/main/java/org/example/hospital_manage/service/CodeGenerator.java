package org.example.hospital_manage.service;

public final class CodeGenerator {

    private CodeGenerator() {
    }

    public static String patientCode(Long id) {
        return String.format("PAT%06d", id);
    }

    public static String doctorCode(Long id) {
        return String.format("DOC%06d", id);
    }

    public static String receptionistCode(Long id) {
        return String.format("REC%06d", id);
    }

    public static String adminCode(Long id) {
        return String.format("ADM%06d", id);
    }

    public static String appointmentCode(Long id) {
        return String.format("APT%06d", id);
    }

    public static String medicalRecordCode(Long id) {
        return String.format("EMR%06d", id);
    }

    public static String prescriptionCode(Long id) {
        return String.format("PRE%06d", id);
    }

    public static String billCode(Long id) {
        return String.format("BIL%06d", id);
    }

    public static String paymentCode(Long id) {
        return String.format("PAY%06d", id);
    }
}