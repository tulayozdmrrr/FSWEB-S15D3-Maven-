package org.example;

import org.example.entity.Employee;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {

    public static List<Employee> employees = new LinkedList<>();

    static {
        employees.add(new Employee(1, "Dogancan", "Kinik"));
        employees.add(new Employee(1, "Dogancan", "Kinik"));
        employees.add(new Employee(2, "Seyyit Battal", "Arvas"));
        employees.add(new Employee(2, "Seyyit Battal", "Arvas"));
        employees.add(new Employee(3, "Anil", "Ensari"));
        employees.add(new Employee(3, "Anil", "Ensari"));
        employees.add(new Employee(4, "Burak", "Cevizli"));
        employees.add(null);
    }

    public static List<Employee> findDuplicates(List<Employee> list) {
        List<Employee> duplicates = new LinkedList<>();
        Map<Integer, Integer> counts = new HashMap<>();

        for (Employee e : list) {
            if (e == null) continue; // null kontrol
            counts.put(e.getId(), counts.getOrDefault(e.getId(), 0) + 1);
        }

        for (Employee e : list) {
            if (e == null) continue;
            if (counts.get(e.getId()) > 1 && !duplicates.contains(e)) {
                duplicates.add(e);
            }
        }

        return duplicates;
    }

    // Tekil Employee'leri bul ve map ile dön
    public static Map<Integer, Employee> findUniques(List<Employee> list) {
        Map<Integer, Integer> counts = new HashMap<>();
        Map<Integer, Employee> uniques = new HashMap<>();

        for (Employee e : list) {
            if (e == null) continue;
            counts.put(e.getId(), counts.getOrDefault(e.getId(), 0) + 1);
        }

        for (Employee e : list) {
            if (e == null) continue;
            if (!uniques.containsKey(e.getId())) {
                uniques.put(e.getId(), e);
            }
        }

        return uniques;
    }

    // Tek geçen Employee'leri listele, tekrar edenleri sil
    public static List<Employee> removeDuplicates(List<Employee> list) {
        List<Employee> uniques = new LinkedList<>();
        Map<Integer, Integer> counts = new HashMap<>();

        // ID sayısı
        for (Employee e : list) {
            if (e == null) continue;
            counts.put(e.getId(), counts.getOrDefault(e.getId(), 0) + 1);
        }

        // Tek geçeni ekle
        for (Employee e : list) {
            if (e == null) continue;
            if (counts.get(e.getId()) == 1) {
                uniques.add(e);
            }
        }

        return uniques;
    }


}
