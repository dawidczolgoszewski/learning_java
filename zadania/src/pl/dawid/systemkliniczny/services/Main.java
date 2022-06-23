package pl.dawid.systemkliniczny.services;

import pl.dawid.systemkliniczny.model.*;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ClinicalSystemController clinicalSystemController = new ClinicalSystemController();
        clinicalSystemController.start();
    }
}
